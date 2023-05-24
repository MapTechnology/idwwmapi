package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;

import idw.model.pojos.MsMsihm;
import ms.model.APojoMs;

public class MsMsihmTemplate extends APojoMs<MsMsihm>{
	

	@Override
	protected MsMsihm atribuir(MsMsihm from, MsMsihm to,
			boolean isCopiarFK) {
		
		if (to == null)
			to = new MsMsihm();
		
		if(from.getDthrRegistro() != null){
			to.setDthrRegistro((Date) from.getDthrRegistro().clone());
		}
		
		if(from.getIdMsihm() != null){
			to.setIdMsihm(new BigDecimal(from.getIdMsihm().doubleValue()));
		}
		
		
		if(isCopiarFK){

			if(from.getMsIhm() != null){
				to.setMsIhm(from.getMsIhm().clone(false));
			}
			
			if(from.getMsMs() != null){
				to.setMsMs(from.getMsMs().clone(false));
			}
			
		}
		
		return to;
	}

}
