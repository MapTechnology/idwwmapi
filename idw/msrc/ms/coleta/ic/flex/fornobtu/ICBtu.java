package ms.coleta.ic.flex.fornobtu;

import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
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
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.coleta.ic.flex.WatcherDiretoriosFlex;
import ms.excessao.SemComunicacaoICException;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
//import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;


//Fabrício Valério: Coleta do Forno BTU - 13/05/2019

public class ICBtu implements IIC {
	
	private BufferedEventos bufferEventos = new BufferedEventos();
	private Map<String, WatcherDiretoriosFlex> watcherLogsProducao = new HashMap<>();
	
	private IdwLogger log;
	private int idLog;
	private EventosColetados eventos = new EventosColetados();
	private Date dthrUltimoHeartbeat = null;
	private IcDTO icdto;
	private final AbstractWatcherTrigger rn;
	private final boolean isWatcherNosSubdiretorios;
	
	public ICBtu(IcDTO icdto ){
		super();
		this.icdto = icdto;
		this.rn = new WatcherTriggerBtu();
		this.isWatcherNosSubdiretorios = false;	
		((WatcherTriggerBtu) rn).setBufferedEventos(this.bufferEventos);
	}
	
	public AbstractWatcherTrigger getTrigger() {
		return this.rn;
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		// Esse metodo deve garantir que o watcher seja reiniciado caso pare ou nao tenha sido inicializado
		inicializarOuFinalizarWatcher();				
		return bufferEventos.obtemEventos();
		
	}
	
	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		this.log = log;
		this.idLog = log.getIdAleatorio();
		inicializarOuFinalizarWatcher();
		
	}
	
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
					}else {log.info("O diretório do watcher NÃO está acessível: " + icup.getUrlConexao());}
						
					} catch (Exception e){
						log.info("Excessão ao verificar o diretório do Watcher");
				}
				}
				dthrUltimoHeartbeat = DataHoraRN.getDataHoraAtual();
				bufferEventos.addEventos(eventos.getEventosColetados());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		// Finaliza os watchers criados
		for (WatcherDiretoriosFlex w : watcherLogsProducao.values()) {
			w.finalizarWatcher();
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