package ms.coleta.ic.flex.spicyber;

import java.util.List;

import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ICFlex;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;


//Fabrício Valério: Coleta do posto de teste Spi Cyber Optics (IAC-FLEX) - 17/05/2018

public class ICSpiCyber extends ICFlex {

	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICSpiCyber(IcDTO icdto) {
		super(icdto, new WatcherTriggerSpiCyber(), true);
		WatcherTriggerSpiCyber trigger = (WatcherTriggerSpiCyber) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		
		/*List<EventoColetado> lista = bufferEventos.getEventos().getEventosColetados();
		
		for (EventoColetado ev:lista){
						
			if (ev.getCdop() != null && !ev.getCdop().equals("")){
				parada.setOpParadaECiclo(ev.getCdop());
				
			}
			
			if (ev.getTipoEvento() != 18 && ev.getTipoEvento() != 3 && ev.getTipoEvento() != 4){
				parada.fimParada();
			}
			
		}*/
		
		return bufferEventos.obtemEventos();
	}
	
}

