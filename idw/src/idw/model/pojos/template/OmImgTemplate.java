package idw.model.pojos.template;

import java.util.Date;
import java.util.HashSet;

import idw.model.pojos.OmGt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmObj;


public abstract class OmImgTemplate extends AbstractTemplate<OmImg>{


	@Override
	protected OmImg atribuir(OmImg from, OmImg to, boolean isCopiarFK) {
		if(to == null) 
			to = new OmImg();
		
		to.setIdImg(from.getIdImg());		
		to.setCdImg(from.getCdImg());
		to.setDsImg(from.getDsImg());
		
		if(from.getOmUsrByIdUsrrevisao() != null){
			to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone());
		}
		
		if(from.getOmUsrByIdUsrstativo() != null){
			to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone());
		}
		
		if(from.getRevisao() != null){
			to.setRevisao(from.getRevisao().longValue());
		}
		if(from.getStAtivo() != null){
			to.setStAtivo(from.getStAtivo().byteValue());	
		}
		
		
		to.setUrlImg(from.getUrlImg());

		if(from.getDtRevisao() != null){
			to.setDtRevisao((Date) from.getDtRevisao().clone());	
		}
		
		if(from.getDtStativo() != null){
			to.setDtStativo((Date) from.getDtStativo().clone());
		}

		if(isCopiarFK){
			if(from.getOmGts() != null){
				to.setOmGts(new HashSet<OmGt>());
				OmGt gtNovo = null;
				for(OmGt omGt: from.getOmGts() ){
					gtNovo = new OmGt();
					gtNovo.setIdGt(omGt.getIdGt());
					to.getOmGts().add(gtNovo);
				}			
			}
			
			if(from.getOmObjs() != null){
				to.setOmObjs(new HashSet<OmObj>());
				OmObj objNovo = null;
				for(OmObj omObj: from.getOmObjs() ){
					objNovo = new OmObj();
					objNovo.setIdObj(omObj.getIdObj());
					to.getOmObjs().add(objNovo);
				}						
			}
		}
		
		return to;

	}

}
