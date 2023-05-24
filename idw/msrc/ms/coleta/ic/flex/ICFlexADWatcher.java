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

// 2019-10-21 Ailton IC Preparado para trabalha com AD ou sem AD
public abstract class ICFlexADWatcher  implements IIC {
	private final IcDTO icdto;
	//private Map<String, WatcherDiretoriosFlex> watcherLogsProducao = new HashMap<>();
	private Map<String, IWatcherDiretoriosFlex> watcherLogsProducao = new HashMap<>();
//	private Map<String, ThreadScriptPadrao> threadScriptPadrao = new HashMap<>();

	private final AbstractWatcherTrigger rn;
	private IdwLogger log;
	private int idLog;
	protected ParadaAutomatica parada;
	private EventosColetados eventos = new EventosColetados();
	private Date dthrUltimoHeartbeat = null;
	private Date dthrUltimoScriptPadrao = null;
	
	private final boolean isWatcherNosSubdiretorios;
	
	public ICFlexADWatcher(IcDTO icdto, AbstractWatcherTrigger rn, boolean isWatcherNosSubdiretorios) {
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

	// Metodo chamado pela inicializacao do IC ou a cada soliciitacao de eventos
	// com o objetivo de parar ou iniciar o watcher
	protected void inicializarOuFinalizarWatcher() {
		eventos = new EventosColetados();
		
		try {

			// Inicializa watchers para cada UP do IC. Em geral teremos apenas uma UP por IC, pois o PC coleta para um UP apenas
			for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
				IWatcherDiretoriosFlex w = null;
				
				// Verifica se o watcher dos logs de producao foram iniciados
				if (watcherLogsProducao.containsKey(icup.getUrlConexao()) == false) {
					try {
						if (ArquivosDiretorios.isICUsaAD(icup)) {
							w = new WatcherADFlex(icup, icup.getUrlConexao(), isWatcherNosSubdiretorios, rn, log, idLog);
							if (((WatcherADFlex) w).isConectado() == false) {
								// houve falha na criacao de whatcher, tentar criar de novo
								log.error(idLog, 0, "Devido a falha na criacao do wathcer, ele nao sera inserido agora em: watcherLogsProducao");
								Thread.sleep(10000);
								continue;
							}
						}
						else {
							w = new WatcherDiretoriosFlex(icup, Paths.get(icup.getUrlConexao()), isWatcherNosSubdiretorios, rn, log, idLog);
						}
						w.start();
						log.info(idLog, 0, "Watcher INICIADO para UP " + icup.getUpDTO().getCd_up() + " no diretorio " + icup.getUrlConexao());
					} catch (ServicoFalhouException e) {
						log.info(idLog, 0, "Watcher FALHOU para UP " + icup.getUpDTO().getCd_up() + " no diretorio " + icup.getUrlConexao(), e);
						UtilsThreads.pausaNaThread(10000);
						continue;
					}
					watcherLogsProducao.put(icup.getUrlConexao(), w);
				}

			}
			
			// Finaliza os watcher dos diretorios que foram removidos do cadastro do MS
			for (String url : watcherLogsProducao.keySet()) {
				boolean isExiste = false;
				for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
					if (icup.getUrlConexao().equals(url))
						isExiste = true;
				}
				if (isExiste == false) {
					IWatcherDiretoriosFlex w = watcherLogsProducao.get(url);	
					w.finalizarWatcher();
					watcherLogsProducao.remove(url);
				}
			}

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
					try {
						boolean isDiretorioAcessivel = false;
						if (isICUsaAD(icup)) {
							isDiretorioAcessivel = ArquivosDiretorios.isDiretorio(ArquivosDiretorios.ajustaPathSMB(icup.getUrlConexao()), icup.getIc().getLoginAD(), icup.getIc().getSernhaAD());
							// Verifica se o watcher esta ativo, por padrao, se nao houver modificacao 
							// em 30 minutos da pasta monitorada, o watcher e desativado
							String url = icup.getUrlConexao();
							WatcherADFlex w = (WatcherADFlex) watcherLogsProducao.get(url);	
							if (!w.isConectado()) {
								log.error(String.format("Watcher da URL %s esta com isConectado = false e isAlive = %b"
										, url, w.isAlive()));
								w.finalizarWatcher();
								watcherLogsProducao.remove(url);
								Thread.sleep(1000);
							}
							
						} else {
							isDiretorioAcessivel = ArquivosDiretorios.isDiretorio(icup.getUrlConexao());
						}

						if (isDiretorioAcessivel) {
							log.info("O diretório do watcher está acessível: " + icup.getUrlConexao());
						} else {
							log.info("O diretório do watcher NÃO está acessível: " + icup.getUrlConexao());
						}
					} catch (Exception e) {
						log.info("Excessão ao verificar o diretório do Watcher");
					}
				}
				dthrUltimoHeartbeat = DataHoraRN.getDataHoraAtual();
			}
			
//			/* Avaliar o script padrão a cada hora */
//			if (dthrUltimoScriptPadrao == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrUltimoScriptPadrao, DataHoraRN.getDataHoraAtual()) > 3600) {
//				for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
//					ThreadScriptPadrao tSP = null;
//					if (icup.getUrlAuxiliar() != null && icup.getUrlAuxiliar().trim().equals("") == false) {
//						try {
//							log.info(idLog, 0, "ThreadScriptPadrao INICIADO para a UP " + icup.getUpDTO().getCd_up());
//							tSP = new ThreadScriptPadrao(log, idLog, icup);
//							tSP.avaliarScriptPadrao();
//						} catch (Exception e) {
//							log.info(idLog, 0, "ThreadScriptPadrao falhou para UP " + icup.getUpDTO().getCd_up());
////							UtilsThreads.pausaNaThread(10000);
//						}
//					}
//				}
//				dthrUltimoScriptPadrao = DataHoraRN.getDataHoraAtual();
//			}
		} catch (Exception e) {
			Date date = new Date();
			System.out.println(String.format("%s - Excecao no inicializarOuFinalizarWatcher do icdto %s", date.toLocaleString(), icdto.getCd_ic()));
			e.printStackTrace();
			log.info("Excecao icflex", e);
		}
	}

	private boolean isICUsaAD(IcUpDTO icup) {
		if ( icup!=null && icup.getIc()!=null
				&& icup.getIc().getIsAutenticacao() != null && icup.getIc().getIsAutenticacao()
				&& icup.getIc().getLoginAD()!=null
				&& icup.getIc().getSernhaAD() !=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		// Finaliza os watchers criados
		for (IWatcherDiretoriosFlex t : watcherLogsProducao.values()) {
				try {					
					t.finalizarWatcher();
				} catch (Exception e) {
					log.error("Excecao ao finalizarIC(): " + icdto.getCd_ic() + " " + e.getMessage());
				}
		}
		watcherLogsProducao.clear();
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
