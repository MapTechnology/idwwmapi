package ms.coleta.ic.flex.refmac;

import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;
import ms.coleta.ic.flex.ICFlex;
import ms.coleta.ic.flex.ICFlexADWatcher;

//Fabrício Valério: Coleta do posto REF MAC da linha ZTE (IM-FLEX) - 09/01/2019

public class ICRefMac extends ICFlexADWatcher {

	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICRefMac(IcDTO icdto) {
		super(icdto, new WatcherTriggerRefMac(), false);
		WatcherTriggerRefMac trigger = (WatcherTriggerRefMac) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		return bufferEventos.obtemEventos();
	}
	
}



