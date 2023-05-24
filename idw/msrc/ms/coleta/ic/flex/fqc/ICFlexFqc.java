package ms.coleta.ic.flex.fqc;

import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ICFlex;
import ms.coleta.ic.flex.ICFlexADWatcher;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;


//Fabrício Valério: Coleta do posto de teste Fqc (IM-FLEX) - 17/12/2018

public class ICFlexFqc extends ICFlexADWatcher{

	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICFlexFqc(IcDTO icdto) {
		super(icdto, new WatcherTriggerFqc(), false);
		WatcherTriggerFqc trigger = (WatcherTriggerFqc) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		return bufferEventos.obtemEventos();
	}
	
}

