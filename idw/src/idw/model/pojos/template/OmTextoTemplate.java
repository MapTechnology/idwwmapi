package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.OmObj;
import idw.model.pojos.OmTexto;


public abstract class OmTextoTemplate extends AbstractTemplate<OmTexto> {


	@Override
	protected OmTexto atribuir(OmTexto from, OmTexto to, boolean isCopiarFK) {
		if(to == null){
			to = new OmTexto();
		}
		
//		to.setCdTexto(from.getCdTexto());
//		to.setRevisao(from.getRevisao());
		to.setDsTexto(from.getDsTexto());
		to.setFonte(from.getFonte());
		to.setIdTexto(from.getIdTexto());
		to.setIsRetangulo(from.getIsRetangulo());
		to.setTamanhofonte(from.getTamanhofonte());
		
		if(isCopiarFK){
			if(from.getOmObjs() != null){
				to.setOmObjs(new HashSet<OmObj>());
				
				for(OmObj omObj: from.getOmObjs() ){
					to.getOmObjs().add(omObj.clone(false));
				}			
			}
		}
		
		return to;
	}

	
}
