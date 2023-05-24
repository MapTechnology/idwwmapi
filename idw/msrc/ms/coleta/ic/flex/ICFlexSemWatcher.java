package ms.coleta.ic.flex;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.pojos.OmCfg;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.util.Util;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.flex.ThreadDiretoriosFlex._TP_AVALIACAO_ARQUIVOS;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;


/* ATENCAO o driver coleta ic.flex ainda não estão operacionais, ainda
 * estamos usando a coleta vinda de ms.coleta.ic.drivercoleta.DriverColetaListener
 * ativada no web.xml
 */
public abstract class ICFlexSemWatcher  implements IIC {
	private final IcDTO icdto;
	
	private final _TP_AVALIACAO_ARQUIVOS tipoAvaliacao;
	

	// Apesar de estarmos usando um map abaixo, um IC com a coleta da flex fara a monitorizacao de apenas
	// um diretorio
	private Map<String, ThreadDiretoriosFlex> threadColetaLogs = new HashMap<>();
	
	// O AbstractWatcherTrigger é a RN que será executada quando ocorrer uma alteração no arquivo
	private final AbstractWatcherTrigger rn;
	
	private IdwLogger log;
	private int idLog;
	
	// O Evento coletado é usado apenas para retorno do heartbeat
	private EventosColetados eventos = new EventosColetados();
	private Date dthrUltimoHeartbeat = null;
	private Date dthrUltimoScriptPadrao = null;
	private Date dthrUltimaColeta = null;
	
	/*
	 * isApenasDiretorios == true significa que serão verificados apenas os arquivos dentro dos subdiretorios indicados
	 * ou seja, os arquivos dentro do diretorio indicado não serão verificados.
	 * Isso foi feito para os postos 5G que possuem mais de 60mil arquivo para verificacao
	 */
	public ICFlexSemWatcher(IcDTO icdto, AbstractWatcherTrigger rn, _TP_AVALIACAO_ARQUIVOS tpAval) {
		super();
		this.icdto = icdto;
		this.rn = rn;
		this.tipoAvaliacao = tpAval;
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		// Esse metodo deve garantir que o watcher seja reiniciado caso pare ou nao tenha sido inicializado
		inicializarOuFinalizarWatcher();
		
		
		// No momento nenhum evento é retornado, pois os TrataArquivo estao chamando as RNs
		// Mas em algum momento deveremos nao enviar os eventos diretamenta mas retorna-los por aqui
		return eventos;
	}
	
	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		this.log = log;
		this.idLog = log.getIdAleatorio();
		inicializarOuFinalizarWatcher();
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		// Finaliza os watchers criados
		for (ThreadDiretoriosFlex w : threadColetaLogs.values()) {
			w.finalizar();
		}
		threadColetaLogs.clear();
	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return Util.getVersao();
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		return getVersaoDriver();
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
	
	
	// Metodo chamado pela inicializacao do IC ou a cada soliciitacao de eventos
	// com o objetivo de parar ou iniciar o watcher
	private void inicializarOuFinalizarWatcher() {
		eventos = new EventosColetados();

		// Alessandre trecho abaixo comentado e substituido pelo seguinte. Objetivo é reduzir a qtde de threds em execucao
		// Inicializa watchers para cada UP do IC. Em geral teremos apenas uma UP por IC, pois o PC coleta para um UP apenas
		for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
			ThreadDiretoriosFlex w = null;
			if (threadColetaLogs.containsKey(icup.getUrlConexao()) == false) {
				try {
					w = new ThreadDiretoriosFlex(icup, Paths.get(icup.getUrlConexao()), tipoAvaliacao, rn, log, idLog);
					// Alessandre nao inicializa pois eh chaado mais abaixo
					//w.start();
					log.info(idLog, 0, "ThreadDiretoriosFlex INICIADO para UP " + icup.getUpDTO().getCd_up() + " no diretorio " + icup.getUrlConexao());
					threadColetaLogs.put(icup.getUrlConexao(), w);
				} catch (IOException e) {
					log.info(idLog, 0, "Watcher FALHOU para UP " + icup.getUpDTO().getCd_up() + " no diretorio " + icup.getUrlConexao(), e);
//					UtilsThreads.pausaNaThread(10000);
				}
			}
		}
		
		// Finaliza os watcher dos diretorios que foram removidos do cadastro do MS
		for (String url : threadColetaLogs.keySet()) {
			boolean isExiste = false;
			for (IcUpDTO icupdto : icdto.getMsIcUpDTOLocais()) {
				if (icupdto.getUrlConexao().equals(url))
					isExiste = true;
			}
			if (isExiste == false) {
				ThreadDiretoriosFlex w = threadColetaLogs.get(url);
				w.finalizar();
				threadColetaLogs.remove(url);
			}
		}
		
		// Verifica os arquivos de logs
		int segColeta = 0;
		if (dthrUltimaColeta != null)
			segColeta = DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrUltimaColeta, DataHoraRN.getDataHoraAtual());
		if (dthrUltimaColeta == null || segColeta >= 5) {
			for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
				ThreadDiretoriosFlex w = null;
				log.info(idLog, 0, "avaliarDiretorios da up " + icup.getUpDTO().getCd_up() + " url " + icup.getUrlConexao() + " intervalo(s): " + segColeta );
				if (threadColetaLogs.containsKey(icup.getUrlConexao())) {
					w = threadColetaLogs.get(icup.getUrlConexao());
					w.avaliarDiretorios(Paths.get(icup.getUrlConexao()));
				}
			}
			dthrUltimaColeta = DataHoraRN.getDataHoraAtual();
		}
		
		/* Verificar o intervalo de tempo do ultimo heartbeat e enviar um novo a cada 10s */
		if (dthrUltimoHeartbeat == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrUltimoHeartbeat, DataHoraRN.getDataHoraAtual()) > 60) {
			for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
				EventoColetado ev = new EventoColetado();
				ev.setTipoEvento(MsTpevtTemplate.Type.HEART_BEAT.getId());
				ev.setIcUpDTO(icup);
				ev.setDthrEvento(DataHoraRN.getDataHoraAtual());
				eventos.addEventoColetado(ev);
			}
			dthrUltimoHeartbeat = DataHoraRN.getDataHoraAtual();
		}
		
		
		/* Avaliar o script padrão a cada hora */
		if (dthrUltimoScriptPadrao == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrUltimoScriptPadrao, DataHoraRN.getDataHoraAtual()) > 3600) {
			for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
				ThreadScriptPadrao tSP = null;
				if (icup.getUrlAuxiliar() != null && icup.getUrlAuxiliar().trim().equals("") == false) {
					try {
						tSP = new ThreadScriptPadrao(log, idLog, icup);
						tSP.avaliarScriptPadrao();
						log.info(idLog, 0, "ThreadScriptPadrao INICIADO para a UP " + icup.getUpDTO().getCd_up());
					} catch (Exception e) {
						log.info(idLog, 0, "ThreadScriptPadrao falhou para UP " + icup.getUpDTO().getCd_up());
					}
				}
			}
			dthrUltimoScriptPadrao = DataHoraRN.getDataHoraAtual();
		}

	}


}
