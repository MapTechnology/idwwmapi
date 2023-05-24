package idw.model.pojos.template;

import idw.model.pojos.MsEvtcep;
import ms.model.APojoMs;

public class MsEvtcepTemplate extends APojoMs<MsEvtcep>{
	@Override
	protected MsEvtcep atribuir(MsEvtcep from, MsEvtcep to, boolean isCopiarFK) {
		
		if (to == null)
			to = new MsEvtcep();
		
		to.setCorrente(from.getCorrente());
		to.setCorrente1(from.getCorrente1());
		to.setCorrente2(from.getCorrente2());
		to.setCorrente3(from.getCorrente3());
		
		to.setEnergiaconsumida(from.getEnergiaconsumida());
		to.setFatorpotencia(from.getFatorpotencia());
		
		to.setIdMsevtcep(from.getIdMsevtcep());
		
		to.setTemperatura(from.getTemperatura());
		
		to.setTensao(from.getTensao());
		to.setTensao1(from.getTensao1());
		to.setTensao2(from.getTensao2());
		to.setTensao3(from.getTensao3());
		
		to.setTensao1e2(from.getTensao1e2());
		to.setTensao2e3(from.getTensao2e3());
		to.setTensao1e3(from.getTensao1e3());
		
		return to;
	}

}
