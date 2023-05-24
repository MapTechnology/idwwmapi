package ms.coleta.ic.flex.assign;

import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ICFlex;
import ms.coleta.ic.flex.ICFlexADWatcher;
import ms.coleta.ic.flex.assign.WatcherTriggerAssign;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;



//Fabrício Valério: Coleta do posto Assign (IM-FLEX) - 03/01/2019

public class ICAssign extends ICFlexADWatcher {
	
	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICAssign(IcDTO icdto) {
		super(icdto, new WatcherTriggerAssign(), false);
		WatcherTriggerAssign trigger = (WatcherTriggerAssign) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		return bufferEventos.obtemEventos();
	}
}

