package idw.model.pojos.template;

import idw.model.pojos.OmPtPaEspelho;

public abstract class OmPtPaEspelhoTemplate extends AbstractTemplate<OmPtPaEspelho> {

	@Override
	protected OmPtPaEspelho atribuir(OmPtPaEspelho from, OmPtPaEspelho to, boolean isCopiarFK) {
		if(to == null){
			to = new OmPtPaEspelho();
		}
		
		to.setIdPtPaEspelho(from.getIdPtPaEspelho());
		to.setOrdem(from.getOrdem());
		
		if (isCopiarFK) {
			if (from.getOmPa() != null)
				to.setOmPa(from.getOmPa().clone(false));
		}

		return to;
	}
}
