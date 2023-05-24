package ms.coleta.ic.flex.fornoheller;


import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ICFlex;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;

public class ICFlexForno extends ICFlex{
	
	private BufferedEventos bufferEventos = new BufferedEventos();
	
	public ICFlexForno(IcDTO icdto) {
		super(icdto, new WatcherTriggerFornoHeller(), false);
		WatcherTriggerFornoHeller trigger = (WatcherTriggerFornoHeller) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		return bufferEventos.obtemEventos();
	}
}
