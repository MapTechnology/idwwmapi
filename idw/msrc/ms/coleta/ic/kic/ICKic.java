package ms.coleta.ic.kic;	

import java.util.HashMap;
import java.util.Map;
import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ICFlex;
import ms.coleta.ic.kic.WatcherTriggerKic;
import ms.coleta.ic.fornos.LinhaArquivoData;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;


//Fabr�cio Val�rio: Coleta da Forno Heller 1809 - 22/11/2018

public class ICKic extends ICFlex {
	
	private Map<String, LinhaArquivoData> ultimasLinhasProcessadasData = new HashMap<>();
	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICKic(IcDTO icdto) {
		super(icdto, new WatcherTriggerKic(), false);
		WatcherTriggerKic trigger = (WatcherTriggerKic) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		
		//List<EventoColetado> lista = bufferEventos.getEventos().getEventosColetados();
		
		/*for (EventoColetado ev:lista){
						
			if (ev.getCdop() != null && !ev.getCdop().equals("")){
				parada.setOpParadaECiclo(ev.getCdop());
				
			}
			
			if(ev.getTipoEvento() == 18){
				parada.refresh();
			}
			
			if (ev.getTipoEvento() != 3 && ev.getTipoEvento() != 4){
				parada.fimParada();
			}
			
		}*/
		
		return bufferEventos.obtemEventos();
	}
	
	public Map<String, LinhaArquivoData> getUltimasLinhasProcessadasData() {
		return ultimasLinhasProcessadasData;
	}

}