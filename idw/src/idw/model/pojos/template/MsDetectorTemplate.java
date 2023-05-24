package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import idw.model.AbstractPojoMs;
import idw.model.pojos.MsDetector;
import idw.model.pojos.MsTrigger;
import idw.model.pojos.OmUsrgrp;

public class MsDetectorTemplate extends AbstractPojoMs<MsDetector>{
	
	
	@Override
	protected MsDetector atribuir(MsDetector from, MsDetector to,
			boolean isCopiarFK) {
		
		if (to == null)
			to = new MsDetector();
		
		
		to.setCdDetector(from.getCdDetector());
		to.setDsDetector(from.getDsDetector());
		if(from.getDthrRevisao() != null){
			to.setDthrRevisao((Date) from.getDthrRevisao().clone());
		}
		if(from.getDthrStativo()  != null){
			to.setDthrStativo((Date) from.getDthrStativo().clone());
		}		
		
		if(from.getIdDetector() != null){
			to.setIdDetector(from.getIdDetector());
		}
		
		if(from.getIsEmail() != null){
			to.setIsEmail(from.getIsEmail());
		}
		
		if(from.getIsSms() != null){
			to.setIsSms(from.getIsSms());
		}		

		if(from.getRevisao() != null){
			to.setRevisao(new BigDecimal(from.getRevisao().longValue()));
		}
		
		if(from.getStAtivo() != null){
			to.setStAtivo(new BigDecimal(from.getStAtivo().byteValue()));
		}
		
		if(isCopiarFK){
			
			if(from.getOmUsrByIdUsrrevisao() != null){
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			}
			
			if(from.getOmUsrByIdUsrstativo() != null){
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			}
			
			if (from .getOmUsrgrp() != null){
				to.setOmUsrgrp((OmUsrgrp) from.getOmUsrgrp().clone());
			}
			
			if(from.getMsTriggers() != null){
				Set<MsTrigger> listaMsTriggers = new HashSet<MsTrigger>();
				for(MsTrigger msTrigger: from.getMsTriggers()){
					listaMsTriggers.add(msTrigger.clone());
				}			
				to.setMsTriggers(listaMsTriggers);
			}			
		}
		
		return to;
	}

}
