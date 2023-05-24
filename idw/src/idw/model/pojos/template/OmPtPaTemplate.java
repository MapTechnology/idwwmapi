package idw.model.pojos.template;

import idw.model.pojos.OmPtPa;

public abstract class OmPtPaTemplate extends AbstractTemplate<OmPtPa> {

	@Override
	protected OmPtPa atribuir(OmPtPa from, OmPtPa to, boolean isCopiarFK) {
		if(to == null){
			to = new OmPtPa();
		}
		
		to.setCdMesa(from.getCdMesa());
		to.setDsEspelho(from.getDsEspelho());
		to.setIdPt(from.getIdPt());
		to.setOrdemInicial(from.getOrdemInicial());

		return to;
	}
}
