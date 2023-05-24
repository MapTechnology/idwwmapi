package ms.coleta.ic.flex.fornoheller1809;

import java.util.HashMap;
import java.util.Map;

import idw.model.pojos.OmCfg;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.flex.ICFlex;
import ms.coleta.ic.flex.fornoheller1809.WatcherTriggerForno1809;
import ms.coleta.ic.fornos.LinhaArquivoData;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;


//Fabr�cio Val�rio: Coleta da Forno Heller 1809 - 22/11/2018

public class ICForno1809 extends ICFlex {
	
	private Map<String, LinhaArquivoData> ultimasLinhasProcessadasData = new HashMap<>();
	private BufferedEventos bufferEventos = new BufferedEventos();

	public ICForno1809(IcDTO icdto) {
		super(icdto, new WatcherTriggerForno1809(), false);
		WatcherTriggerForno1809 trigger = (WatcherTriggerForno1809) getTrigger();
		trigger.setBufferedEventos(this.bufferEventos);
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		bufferEventos.addEventos(super.getEventos(omcfg).getEventosColetados());
		return bufferEventos.obtemEventos();
	}
	
	public Map<String, LinhaArquivoData> getUltimasLinhasProcessadasData() {
		return ultimasLinhasProcessadasData;
	}

}