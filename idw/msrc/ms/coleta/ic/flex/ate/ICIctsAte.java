package ms.coleta.ic.flex.ate;

import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ICFlex;
import ms.coleta.ic.flex.ate.WatcherTriggerIctsAte;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;

//Fabrício Valério: Coleta do posto de teste ATE do ICTS (IM-FLEX) - 21/12/2018

public class ICIctsAte extends ICFlex {
	
	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICIctsAte(IcDTO icdto) {
		super(icdto, new WatcherTriggerIctsAte(), false);
		WatcherTriggerIctsAte trigger = (WatcherTriggerIctsAte) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		return bufferEventos.obtemEventos();
	}}

