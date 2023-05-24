package idw.model.pojos.template;

import idw.model.pojos.OmMapapaproalt;

public abstract class OmMapapaproaltTemplate extends AbstractTemplate<OmMapapaproalt>{

	@Override
	protected OmMapapaproalt atribuir(OmMapapaproalt from, OmMapapaproalt to, boolean isCopiarFK) {
		if (to == null)
			to = new OmMapapaproalt();
		
		to.setIdMapapaproalt(from.getIdMapapaproalt());
		
		if (isCopiarFK) {
			to.setOmProduto(from.getOmProduto().clone(false));
		}
		
		return to;
	}

}
