package ms.coleta.ic.aoiqx500;

import idw.model.pojos.OmCfg;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import java.util.Date;
import java.util.List;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ParadaAutomatica;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class ICAoiQX500 implements IIC {

	private IdwLogger log;
	private int idLog;
	private EventosColetados eventos = new EventosColetados();
	private Date dthrUltimoHeartbeat = null;
	private IcDTO icdto;
	private BufferedEventos bufferEventos = new BufferedEventos();
	private WatcherScanAoi watcher;
	//protected ParadaAutomatica parada;
	
	public ICAoiQX500(IcDTO icdto ){
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
						
			dthrUltimoHeartbeat = DataHoraRN.getDataHoraAtual();			
			
			return eventos;
		}
		
		
		/*Baguncinha 20-19-02 comenteiif(parada.getParada() != null){
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
		*/
		
		
		return bufferEventos.obtemEventos();
		
		
	}

	
	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		this.log = log;
		this.idLog = log.getIdAleatorio();
		watcher = new WatcherScanAoi(log,idLog, icdto.getMsIcUpDTOLocais().get(0),  icdto.getMsIcUpDTOLocais().get(0).getUrlConexao());
		watcher.setBufferedEventos(this.bufferEventos);
		watcher.start();
		//parada = new ParadaAutomatica(log,idLog, icdto.getMsIcUpDTOLocais().get(0));
		//parada.start();
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		watcher.finalizaWatcher();
		//parada.finaliza();
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
