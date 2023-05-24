package idw.model.pojos.template;

import java.util.Date;
import java.util.HashSet;

import idw.model.pojos.OmObj;
import idw.model.pojos.OmWebcam;


public abstract class OmWebcamTemplate extends AbstractTemplate<OmWebcam> {

	@Override
	protected OmWebcam atribuir(OmWebcam from, OmWebcam to, boolean isCopiarFK) {
		if(to == null){
			to = new OmWebcam();
		}

		to.setIdWebcam(from.getIdWebcam());
		to.setCdWebcam(from.getCdWebcam());
		to.setDsCurta(from.getDsCurta());
		to.setDsWebcam(from.getDsWebcam());
		
		if(from.getDtRevisao() != null){
			to.setDtRevisao((Date) from.getDtRevisao().clone());
		}
		if(from.getDtStativo() != null){
			to.setDtStativo((Date) from.getDtStativo().clone());
		}
		
		if(isCopiarFK){
			if(from.getOmObjs() != null){
				to.setOmObjs(new HashSet<OmObj>());
				
				for(OmObj omObj: from.getOmObjs() ){
					to.getOmObjs().add(omObj.clone());
				}			
				
			}
		}
		
		to.setRevisao(from.getRevisao());
		to.setStAtivo(from.getStAtivo());
		to.setUrl(from.getUrl());
		
		return to;
		
	}

}
