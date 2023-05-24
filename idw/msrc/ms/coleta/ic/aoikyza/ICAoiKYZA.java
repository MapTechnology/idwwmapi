package ms.coleta.ic.aoikyza;

import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.pojos.OmCfg;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;


public class ICAoiKYZA implements IIC {
	
	private IdwLogger log;
	private int idLog;
	
	private final IcDTO icdto;

	private BufferedEventos bufferEventos = new BufferedEventos(); 

	private Date dthrUltimaColeta = null;
	private Date dthrUltimoHeartbeat = null;
	
	private Map<String, WatcherAoiKYZA> threadColetaLogs = new HashMap<>();
	
	public ICAoiKYZA (IcDTO icdto) {
		super();
		this.icdto = icdto;
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		// Esse metodo deve garantir que o watcher seja reiniciado caso pare ou nao tenha sido inicializado
		inicializarOuFinalizarWatcher();
		EventosColetados retorno = bufferEventos.obtemEventos();
		for (EventoColetado ev : retorno.getEventosColetados()) {
			log.info(idLog, 0, "getEventos: " + ev.toString());
		}
		return retorno;
	}

	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		
		this.log = log;
		this.idLog = log.getIdAleatorio();
		
		log.info(idLog, 0, "Inicializando IC " + this.icdto.getCd_ic());
		inicializarOuFinalizarWatcher();
	}

	
	// Metodo principal para inicilaizar e atualizar o watcher, heartbeat
	private void inicializarOuFinalizarWatcher() {
		// Alessandre trecho abaixo comentado e substituido pelo seguinte. Objetivo é reduzir a qtde de threds em execucao
		// Inicializa watchers para cada UP do IC. Em geral teremos apenas uma UP por IC, pois o PC coleta para um UP apenas
		for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
			WatcherAoiKYZA  w = null;
			if (threadColetaLogs.containsKey(icup.getUrlConexao()) == false) {
				try {
					TratadorArquivos tratador = new TrataArquivosAoiKYZAGerandoEventos(log, icdto.getMsIcUpDTOLocais(), this);
					w = new WatcherAoiKYZA(icup, Paths.get(icup.getUrlConexao()), log, idLog, tratador);
					log.info(idLog, 0, "ThreadDiretoriosFlex INICIADO para UP " + icup.getUpDTO().getCd_up() + " no diretorio " + icup.getUrlConexao());
					threadColetaLogs.put(icup.getUrlConexao(), w);
				} catch (Exception e) {
					log.info(idLog, 0, "Watcher FALHOU para UP " + icup.getUpDTO().getCd_up() + " no diretorio " + icup.getUrlConexao(), e);
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
				WatcherAoiKYZA w = threadColetaLogs.get(url);
				w.finalizar();
				threadColetaLogs.remove(url);
			}
		}
		
		// Verifica os arquivos de logs
		if (dthrUltimaColeta == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrUltimaColeta, DataHoraRN.getDataHoraAtual()) > 5) {
			for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
				WatcherAoiKYZA w = null;
				log.info(idLog, 0, "ICAoiKYZA de " + icup.getUpDTO().getCd_up() + " no dir " + icup.getUrlConexao());
				if (threadColetaLogs.containsKey(icup.getUrlConexao())) {
					w = threadColetaLogs.get(icup.getUrlConexao());
					w.avaliarDiretorios();
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
				bufferEventos.getEventos().addEventoColetado(ev);
				log.info(idLog, 0, "heartbeat");
			}
			dthrUltimoHeartbeat = DataHoraRN.getDataHoraAtual();
		}
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		
		log.info(idLog, 0, "Finalizando IC " + this.icdto.getCd_ic());
	}
	
	public BufferedEventos getBufferEventos() {
		return this.bufferEventos;
	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return "v1.0";
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		return "v1.0";
	}

	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParametro(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}



	public IcDTO getIcdto() {
		return icdto;
	}

}
