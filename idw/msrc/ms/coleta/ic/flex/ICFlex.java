package ms.coleta.ic.flex;

import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import idw.model.pojos.OmCfg;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.util.Util;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.excessao.SemComunicacaoICException;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;


/* ATENCAO o driver coleta ic.flex ainda não estão operacionais, ainda
 * estamos usando a coleta vinda de ms.coleta.ic.drivercoleta.DriverColetaListener
 * ativada no web.xml
 */
public abstract class ICFlex  implements IIC {
	protected final IcDTO icdto;
	private Map<String, WatcherDiretoriosFlex> watcherLogsProducao = new HashMap<>();
//	private Map<String, ThreadScriptPadrao> threadScriptPadrao = new HashMap<>();

	private final AbstractWatcherTrigger rn;
	protected IdwLogger log;
	protected int idLog;
	protected ParadaAutomatica parada;
	private EventosColetados eventos = new EventosColetados();
	private Date dthrUltimoHeartbeat = null;
	private Date dthrUltimoScriptPadrao = null;
	
	private final boolean isWatcherNosSubdiretorios;
	
	public ICFlex(IcDTO icdto, AbstractWatcherTrigger rn, boolean isWatcherNosSubdiretorios) {
		super();
		this.icdto = icdto;
		this.rn = rn;
		this.isWatcherNosSubdiretorios = isWatcherNosSubdiretorios;
	}
	
	public AbstractWatcherTrigger getTrigger() {
		return this.rn;
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		// Esse metodo deve garantir que o watcher seja reiniciado caso pare ou nao tenha sido inicializado
		inicializarOuFinalizarWatcher();
		
//		if(parada.getParada() != null){
//			parada.getRefreshParada(eventos);
//		}
		
		
		// No momento nenhum evento é retornado, pois os TrataArquivo estao chamando as RNs
		// Mas em algum momento deveremos nao enviar os eventos diretamenta mas retorna-los por aqui
		return eventos;
	}
	
	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		this.log = log;
		this.idLog = log.getIdAleatorio();
		inicializarOuFinalizarWatcher();
		//parada = new ParadaAutomatica(log,idLog, icdto.getMsIcUpDTOLocais().get(0));
		//parada.start();
	}

	// Metodo chamado pela inicializacao do IC ou a cada soliciitacao de eventos
	// com o objetivo de parar ou iniciar o watcher
	protected void inicializarOuFinalizarWatcher() {
		eventos = new EventosColetados();
		
		try {

			// Inicializa watchers para cada UP do IC. Em geral teremos apenas uma UP por IC, pois o PC coleta para um UP apenas
			for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
				WatcherDiretoriosFlex w = null;
				
				// Verifica se o watcher dos logs de producao foram iniciados
				if (watcherLogsProducao.containsKey(icup.getUrlConexao()) == false) {
					try {
						w = new WatcherDiretoriosFlex(icup, Paths.get(icup.getUrlConexao()), isWatcherNosSubdiretorios, rn, log, idLog);
						w.start();
						log.info(idLog, 0, "Watcher INICIADO para UP " + icup.getUpDTO().getCd_up() + " no diretorio " + icup.getUrlConexao());
					} catch (ServicoFalhouException e) {
						log.info(idLog, 0, "Watcher FALHOU para UP " + icup.getUpDTO().getCd_up() + " no diretorio " + icup.getUrlConexao(), e);
						UtilsThreads.pausaNaThread(10000);
						continue;
					}
					watcherLogsProducao.put(icup.getUrlConexao(), w);
				}
				
				// Alessandre comentei pois nao quero criar outra thread
				// Verifica se os logs do script padrao estao de acordo com o NPI
//				ThreadScriptPadrao tSP = null;
//				if (icup.getUrlAuxiliar() != null && icup.getUrlAuxiliar().trim().equals("") == false && threadScriptPadrao.containsKey(icup.getUrlAuxiliar()) == false) {
//					try {
//						tSP = new ThreadScriptPadrao(log, idLog, icup);
//						tSP.start();
//						log.info(idLog, 0, "ThreadScriptPadrao INICIADO para a UP " + icup.getUpDTO().getCd_up());
//						threadScriptPadrao.put(icup.getUrlAuxiliar(), tSP);
//					} catch (Exception e) {
//						log.info(idLog, 0, "ThreadScriptPadrao falhou para UP " + icup.getUpDTO().getCd_up());
//						UtilsThreads.pausaNaThread(10000);
//					}
//				}

			}
			
			// Finaliza os watcher dos diretorios que foram removidos do cadastro do MS
			for (String url : watcherLogsProducao.keySet()) {
				boolean isExiste = false;
				for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
					if (icup.getUrlConexao().equals(url))
						isExiste = true;
				}
				if (isExiste == false) {
					WatcherDiretoriosFlex w = watcherLogsProducao.get(url);
					w.finalizarWatcher();
					watcherLogsProducao.remove(url);
				}
			}
		
			// Alessandre comentei pois nao quero criar outra thread
			// Finaliza as threads que foram removidas
//			for (String url : threadScriptPadrao.keySet()) {
//				boolean isExiste = false;
//				for (IcUpDTO icupdto : icdto.getMsIcUpDTOLocais()) {
//					if (icupdto.getUrlAuxiliar().equals(url)) {
//						isExiste = true;
//					}
//				}
//				if (isExiste == false) {
//					ThreadScriptPadrao tSP = threadScriptPadrao.get(url);
//					tSP.finalizar();
//					threadScriptPadrao.remove(url);
//				}
//			}

			/* Verificar o intervalo de tempo do ultimo heartbeat e enviar um novo a cada 10s */
			if (dthrUltimoHeartbeat == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrUltimoHeartbeat, DataHoraRN.getDataHoraAtual()) > 60) {
				for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
					EventoColetado ev = new EventoColetado();
					ev.setTipoEvento(MsTpevtTemplate.Type.HEART_BEAT.getId());
					ev.setIcUpDTO(icup);
					ev.setDthrEvento(DataHoraRN.getDataHoraAtual());
					eventos.addEventoColetado(ev);
					
					/* Alem disso tentaremos acessar a urlConexao para manter a conexão de rede sempre aberta para o watcher não parar
					 *  essa verificação será feita através da existencia ou nao do diretorio
					 */
					try{
						if(ArquivosDiretorios.isDiretorio(icup.getUrlConexao())){
							log.info("O diretório do watcher está acessível: " + icup.getUrlConexao());
					}else {
						log.info("O diretório do watcher NÃO está acessível: " + icup.getUrlConexao());}
					} catch (Exception e){
						log.info("Excessão ao verificar o diretório do Watcher");
					}
				}
				dthrUltimoHeartbeat = DataHoraRN.getDataHoraAtual();
			}
			
			/* Avaliar o script padrão a cada hora */
			if (dthrUltimoScriptPadrao == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrUltimoScriptPadrao, DataHoraRN.getDataHoraAtual()) > 3600) {
				for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
					ThreadScriptPadrao tSP = null;
					if (icup.getUrlAuxiliar() != null && icup.getUrlAuxiliar().trim().equals("") == false) {
						try {
							log.info(idLog, 0, "ThreadScriptPadrao INICIADO para a UP " + icup.getUpDTO().getCd_up());
							tSP = new ThreadScriptPadrao(log, idLog, icup);
							tSP.avaliarScriptPadrao();
						} catch (Exception e) {
							log.info(idLog, 0, "ThreadScriptPadrao falhou para UP " + icup.getUpDTO().getCd_up());
//							UtilsThreads.pausaNaThread(10000);
						}
					}
				}
				dthrUltimoScriptPadrao = DataHoraRN.getDataHoraAtual();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("icflex", e);
		}
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		// Finaliza os watchers criados
		for (WatcherDiretoriosFlex w : watcherLogsProducao.values()) {
			w.finalizarWatcher();
		}
		watcherLogsProducao.clear();
		
		// Alessandre comentei pois o script padrao nao eh mais via thread
//		for (ThreadScriptPadrao w : threadScriptPadrao.values()) {
//			w.finalizar();
//		}
//		threadScriptPadrao.clear();
		//fim da thread de parada automática
		//parada.finaliza();
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
}
