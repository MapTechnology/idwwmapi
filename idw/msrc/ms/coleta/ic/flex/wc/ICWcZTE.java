package ms.coleta.ic.flex.wc;

import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;
import ms.coleta.ic.flex.ICFlex;
import ms.coleta.ic.flex.ICFlexADWatcher;
import ms.coleta.ic.flex.wc.WatcherTriggerWcZTE;


//Fabrício Valério: Coleta do posto de teste Wifi Calibration (IM-FLEX) - 07/12/2018

public class ICWcZTE extends ICFlexADWatcher {
	
	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICWcZTE(IcDTO icdto) {
		super(icdto, new WatcherTriggerWcZTE(), false);
		WatcherTriggerWcZTE trigger = (WatcherTriggerWcZTE) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		return bufferEventos.obtemEventos();
	}
}


