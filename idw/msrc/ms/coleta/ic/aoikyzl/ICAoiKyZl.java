package ms.coleta.ic.aoikyzl;

import java.util.Date;
import java.util.List;

import idw.model.dao.aoikyzl.DAOGenericoAoiKyZl;
import idw.model.pojos.OmCfg;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ParadaAutomatica;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class ICAoiKyZl implements IIC {

	private IdwLogger log;
	private int idLog;
	private EventosColetados eventos = new EventosColetados();
	private Date dthrUltimoHeartbeat = null;
	private int qtHeartBeat = 0;
	private IcDTO icdto;
	private BufferedEventos bufferEventos = new BufferedEventos();
	private WatcherTriggerAoiKyZl watcher;
//	private AoiKyZlSqlRN rn;
	protected ParadaAutomatica parada;
	
	public ICAoiKyZl(IcDTO icdto ){
		super();
		this.icdto = icdto;
				
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		eventos = new EventosColetados();
		
		/* Verificar o intervalo de tempo do ultimo heartbeat e enviar um novo a cada 10s */
		
		if (dthrUltimoHeartbeat == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrUltimoHeartbeat, DataHoraRN.getDataHoraAtual()) > 60) {
			for (IcUpDTO icup : icdto.getMsIcUpDTOLocais()) {
				EventoColetado ev = new EventoColetado();
				ev.setTipoEvento(MsTpevtTemplate.Type.HEART_BEAT.getId());
				ev.setIcUpDTO(icup);
				ev.setDthrEvento(DataHoraRN.getDataHoraAtual());
				eventos.addEventoColetado(ev);
				
			}
			
			qtHeartBeat = qtHeartBeat + 1; 
			dthrUltimoHeartbeat = DataHoraRN.getDataHoraAtual();
			
			if (qtHeartBeat >= 5){
				
				try{
					watcher.tratador.finalizaConexaoBanco();
					log.info("Foi possível finalizar uma sessão - método no IC AOI");
				}catch(Exception e){
					e.printStackTrace();
					log.info("Conexão com o banco já finalizada - método no IC AOI");
					
				}
				qtHeartBeat = 0;
			}
			
			
			
			
			return eventos;
		}
		
		
		if(parada.getParada() != null){
			parada.getRefreshParada(eventos);
			bufferEventos.addEventos(eventos.getEventosColetados());
		}
		
		
		
		// Etapa de verificação de parada automática
		List<EventoColetado> lista = bufferEventos.getEventos().getEventosColetados();
		
		for (EventoColetado ev:lista){
						
			if (ev.getCdop() != null && !ev.getCdop().equals("")){
				parada.setOpParadaECiclo(ev.getCdop());
			}
			
			if (ev.getTipoEvento() != 18 && ev.getTipoEvento() != 3 && ev.getTipoEvento() != 4){
				parada.fimParada();
			}
			
		}
		
		
		
		return bufferEventos.obtemEventos();
		
		
	}

	
	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		this.log = log;
		this.idLog = log.getIdAleatorio();
		AoiKyZlSqlRN rn = new AoiKyZlSqlRN(new DAOGenericoAoiKyZl(icdto.getMsIcUpDTOLocais().get(0).getUrlConexao()));
		watcher = new WatcherTriggerAoiKyZl(log,idLog, icdto.getMsIcUpDTOLocais().get(0), rn);
		watcher.setBufferedEventos(this.bufferEventos);
		watcher.start();
		parada = new ParadaAutomatica(log,idLog, icdto.getMsIcUpDTOLocais().get(0));
		parada.start();
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		watcher.finalizaWatcher();
		parada.finaliza();
	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return "v.1.0";
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		return "desconhecido";
	}

	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {
	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParametro(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}

	
}
