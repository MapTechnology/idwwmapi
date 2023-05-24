package ms.coleta.ic.flex.ssidzte;

import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;
import ms.coleta.ic.flex.ICFlex;

//Fabrício Valério: Coleta do posto SSID da linha ZTE (IM-FLEX) - 04/01/2019

public class ICSsidZte extends ICFlex {

	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICSsidZte(IcDTO icdto) {
		super(icdto, new WatcherTriggerSsidZte(), false);
		WatcherTriggerSsidZte trigger = (WatcherTriggerSsidZte) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		return bufferEventos.obtemEventos();
	}
	
}



