package idw.model.pojos.template;

import idw.model.pojos.OmPtcnc;

public abstract class OmPtcncTemplate extends AbstractTemplate<OmPtcnc> {

	@Override
	protected OmPtcnc atribuir(OmPtcnc from, OmPtcnc to, boolean isCopiarFK) {
		if(to == null){
			to = new OmPtcnc();
		}
		to.setIdPtcnc(from.getIdPtcnc());
		
		if (isCopiarFK == true){
			if(from.getOmPtByIdPt() != null){
				to.setOmPtByIdPt(from.getOmPtByIdPt().clone(false));
			}
			
			if(from.getOmPtByIdPtFilho() != null){
				to.setOmPtByIdPtFilho(from.getOmPtByIdPtFilho().clone(false));
			}

		}
		return to;
	}

}
