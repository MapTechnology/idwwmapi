package idw.model.pojos.template;

import idw.model.pojos.OmPtPaMapa;

public abstract class OmPtPaMapaTemplate extends AbstractTemplate<OmPtPaMapa> {

	@Override
	protected OmPtPaMapa atribuir(OmPtPaMapa from, OmPtPaMapa to, boolean isCopiarFK) {
		if(to == null){
			to = new OmPtPaMapa();
		}

		to.setIdPtPaMapa(from.getIdPtPaMapa());
		to.setOrdemInicial(from.getOrdemInicial());
		
		if (isCopiarFK) {
			to.setOmMapa(from.getOmMapa().clone(false));
		}

		return to;
	}
}
