package idw.model.pojos.template;

import idw.model.pojos.DwRtcic;


public abstract class DwRtCicTemplate extends AbstractTemplate<DwRtcic>{
	
	@Override
	protected DwRtcic atribuir(DwRtcic from, DwRtcic to, boolean isCopiarFK) {

		if(to == null){
			to = new DwRtcic();
		}
		
		to.setIdRtcic(from.getIdRtcic());
		to.setMsDthriciclo(from.getMsDthriciclo());
		to.setMsDthrfciclo(from.getMsDthrfciclo());
		to.setDthrIciclo(from.getDthrIciclo());
		to.setDthrFciclo(from.getDthrFciclo());
		to.setSegDuracao(from.getSegDuracao());
		to.setIsRegulagem(from.getIsRegulagem());
		
		return to;
	}

	

}