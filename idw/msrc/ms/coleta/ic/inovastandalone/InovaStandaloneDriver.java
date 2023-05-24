package ms.coleta.ic.inovastandalone;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import idw.idwws.IcUpDTO;
import idw.model.pojos.OmCfg;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.util.Unzip;
import injetws.model.IwsFacade;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class InovaStandaloneDriver implements IIC, FilenameFilter {

	private String versaoDriver = "v1.0";
	private IdwLogger log;
	private int idLog = 0;
	private IcDTO icdto;
	private String arqNameStarts;
	private String arqNameEnds;

	public InovaStandaloneDriver(IcDTO icdto) {
		this.icdto = icdto;
	}
	
	/*
	 * Esse metodo dever� retornar os eventos disponiveis no momento para o gerenciado MSThread
	 * Para o inova standalone esses eventos vir�o de arquivos textos
	 * (non-Javadoc)
	 * @see ms.coleta.ic.IIC#getEventos()
	 */
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException{
		EventosColetados retorno = new EventosColetados();
		String dirDestino = IwsFacade.getRealRootPath();
		if(dirDestino==null){
			return retorno;
		}
		File dir = new File(dirDestino);

		FilenameFilter tmpFilter = new FilenameFilter() {
			public boolean accept(File file, String name) {
				if (name.endsWith(icdto.getUrl_conexao()+"-eventos.zip")) {
					// filtro para tmp
					return true;
				} else {
					return false;
				}
			}
		};
		File[] arqZipList = dir.listFiles(tmpFilter);
		for(int i=0;i<arqZipList.length;i++) {

			String arqZip = arqZipList[i].getName();
			String patharquivo = (dirDestino + "/" + arqZip).replace(".zip", "");
			String patharquivoFULL = dirDestino + "/" + arqZip;
			File dirArquivo = new File(patharquivo);
			boolean respmkdir = dirArquivo.mkdir();

			String dispLog = patharquivo + "/displog.ini";
			String heartbeat = patharquivo + "/heartbeat.ini";
			String loginout = patharquivo + "/loginout.ini";
			String listaEventos = patharquivo + "/listaEventos";
			String passagem = patharquivo + "/passagem.ini";

			if (ArquivosDiretorios.isExisteArquivo(patharquivoFULL) == true) {
				//System.out.println(patharquivo);
				// Descompactar o arquivo URLCONEXAO-eventos.zip
				Unzip.unzip(patharquivoFULL, patharquivo + "/", log);
				// Processar arquivo displog.ini SE EXISTIR
				if (ArquivosDiretorios.isExisteArquivo(dispLog) == true) {
					log.info(idLog, 0, "Processando arquivo " + dispLog);
					retorno.getEventosColetados().addAll(processarArquivoDisplog(dispLog, log));
				}

				// Processar arquivo heartbeat.ini SE EXISTIR
				//System.out.println("Tem heartbeat?"+ArquivosDiretorios.isExisteArquivo(heartbeat));
				if (ArquivosDiretorios.isExisteArquivo(heartbeat) == true) {
					//System.out.println("TEM HEARTBEAT");
					log.info(idLog, 0, "Processando arquivo " + heartbeat);
					retorno.getEventosColetados().addAll(processarArquivoHeartbeat(heartbeat, log , icdto.getMsIcUpDTOLocais().get(0)));
				}

				// Processar arquivo loginout.ini SE EXISTIR
				if (ArquivosDiretorios.isExisteArquivo(loginout) == true) {
					//System.out.println("TEMLOGIN");
					log.info(idLog, 0, "Processando arquivo " + loginout);
					retorno.getEventosColetados().addAll(processarArquivoLoginout(loginout, log));
				}

				// Processar arquivo listaEventos.ini SE EXISTIR
				if (ArquivosDiretorios.isExisteArquivo(listaEventos) == true) {
					log.info(idLog, 0, "Processando arquivo " + listaEventos);
					retorno.getEventosColetados().addAll(processarListaEvento(listaEventos, log, omcfg ));
				}

				if (ArquivosDiretorios.isExisteArquivo(passagem) == true) {
					//System.out.println("PASSAGEM");
					log.info(idLog, 0, "Processando arquivo " + passagem);
					retorno.getEventosColetados().addAll(processarArquivoTestefuncional(passagem, log, omcfg) );
				}
				
				// Apagar arquivo ZIP
				while(!ArquivosDiretorios.delete(patharquivoFULL));

				// Apagar diretorio descompactado
				while(!ArquivosDiretorios.delete(patharquivo + "/"));
			}
		}
		// Ordenar eventos pela dt e hr que ocorreram
		if(retorno != null && retorno.getEventosColetados() !=null && retorno.getEventosColetados().size() > 1 ){
			Collections.sort(retorno.getEventosColetados(), new Comparator<EventoColetado>() {
				@Override
				public int compare(EventoColetado o1, EventoColetado o2) {
					if(o1.getDthrEvento() == null || o2.getDthrEvento() == null){
						return 0;
					}
					return o1.getDthrEvento().compareTo(o2.getDthrEvento());
				}
			});
		}
		return retorno;
	}

	/*
	 * Metodo chamado uma unica vez quando o driver eh carregado
	 * (non-Javadoc)
	 * @see ms.coleta.ic.IIC#inicializaIC(idw.util.IdwLogger)
	 */
	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		this.log = log;
	}

	/*
	 * Esse metodo dever� fechar qualquer porta de comunicacao entre o driver e o IC
	 * Para o inova standalone aparentemente n�o tem nenhum recurso a ser fechado.
	 * O metodo � executado n momento em que o driver sofre um shutdown
	 * (non-Javadoc)
	 * @see ms.coleta.ic.IIC#finalizaIC()
	 */
	@Override
	public void finalizaIC() throws SemComunicacaoICException {

	}

	/*
	 * Esse metodo deve trazer a vers�o desse driver do inova Standalone em java
	 * (non-Javadoc)
	 * @see ms.coleta.ic.IIC#getVersaoDriver()
	 */
	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return this.versaoDriver;
	}

	/*
	 * Esse metodo deve trazer a vers�o do programa que est� rodando no inova
	 * (non-Javadoc)
	 * @see ms.coleta.ic.IIC#getVersaoDriver()
	 */
	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		return "faltaImplementar";
	}

	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {

	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {

	}

	@Override
	public void setParametro(ParametroDTO parametro) {

	}


	private List<EventoColetado> processarArquivoDisplog(String dispLog, IdwLogger log) {
		ProcessaDisplog rn = new ProcessaDisplog();
		return rn.processar(dispLog, log);
	}
	private List<EventoColetado> processarArquivoHeartbeat(String heartbeat, IdwLogger log , IcUpDTO icupdto) {
		ProcessaHeartbeat rn = new ProcessaHeartbeat();
		return rn.processar(heartbeat, log , icupdto);
	}
	private List<EventoColetado> processarArquivoLoginout(String loginout, IdwLogger log) {
		ProcessaLoginout rn = new ProcessaLoginout();
		return rn.processar(loginout, log);
	}

	private List<EventoColetado> processarListaEvento(String listaEvento, IdwLogger log, OmCfg omcfg ) {
		return ProcessaArquivoListaEvento.processar(listaEvento, log, omcfg );
	}

	private List<EventoColetado> processarArquivoTestefuncional(String arquivo, IdwLogger log, OmCfg omcfg) {
		ProcessaPassagem rn = new ProcessaPassagem();
		return rn.processar(arquivo, log, omcfg);
	}


	@Override
	public boolean accept(File dir, String name) {
		arqNameStarts = "Evento-" + icdto.getUrl_conexao();
		arqNameEnds = ".zip";
		return name.startsWith(arqNameStarts) && name.endsWith(arqNameEnds);
	}

}
