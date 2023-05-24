package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import idw.model.pojos.MsEvt;
import idw.model.pojos.MsUpihm;
import ms.model.APojoMs;

public class MsUpihmTemplate extends APojoMs<MsUpihm>{
	

	@Override
	protected MsUpihm atribuir(MsUpihm from, MsUpihm to,
			boolean isCopiarFK) {
		
		if (to == null)
			to = new MsUpihm();
		
		if(from.getDthrCadastro() != null){
			to.setDthrCadastro((Date) from.getDthrCadastro().clone());
		}
				
		if(from.getIdUpihm() != null){
			to.setIdUpihm(new BigDecimal(from.getIdUpihm().doubleValue()));
		}

		to.setUrlConexao(from.getUrlConexao());
		
		if(isCopiarFK){
			
			if(from.getMsIhm() != null){
				to.setMsIhm(from.getMsIhm().clone(false));
			}
			
			if(from.getMsUp() != null){
				to.setMsUp(from.getMsUp().clone(false));
			}
			
			if(from.getMsEvts() != null){
				Set<MsEvt> listaMsEvt = new HashSet<MsEvt>();
				for(MsEvt msEvt: from.getMsEvts()){
					listaMsEvt.add(msEvt.clone(false));
				}
				to.setMsEvts(listaMsEvt);				
			}
				
		}
		
			
		return to;
	}

}
