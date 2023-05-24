package idw.model.pojos.template;

import idw.model.pojos.MsMonitor;
import ms.model.APojoMs;

public class MsMonitorTemplate extends APojoMs<MsMonitor>{

	@Override
	protected MsMonitor atribuir(MsMonitor from, MsMonitor to,
			boolean isCopiarFK) {
		
		if (to == null)
			to = new MsMonitor();
		
		to.setDsItemMonitorado(from.getDsItemMonitorado());
		to.setDthrFim(from.getDthrFim());
		to.setDthrInicio(from.getDthrInicio());
		to.setIdMonitor(from.getIdMonitor());
		to.setMemConsumida(from.getMemConsumida());
		to.setMemfFreeEmbyte(from.getMemfFreeEmbyte());
		to.setMemiFreeEmbyte(from.getMemiFreeEmbyte());
		to.setMiliDuracao(from.getMiliDuracao());
		
		if (isCopiarFK){
			to.setMsEvt(from.getMsEvt().clone(false));
		}
		
		return to;
	}

}
