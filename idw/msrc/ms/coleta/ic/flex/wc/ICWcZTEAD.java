package ms.coleta.ic.flex.wc;

import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ICFlexADWatcher;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;

public class ICWcZTEAD extends ICFlexADWatcher{
	
	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICWcZTEAD(IcDTO icdto) {
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
