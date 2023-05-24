package ms.coleta.ic.flex.finaltest;

import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ICFlex;
import ms.coleta.ic.flex.finaltest.WatcherTriggerFinalTest;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;

//Fabrício Valério: Coleta do posto de teste final (IM-FLEX) - 21/12/2018

public class ICFinalTest extends ICFlex {
	
	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICFinalTest(IcDTO icdto) {
		super(icdto, new WatcherTriggerFinalTest(), false);
		WatcherTriggerFinalTest trigger = (WatcherTriggerFinalTest) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		return bufferEventos.obtemEventos();
	}}

