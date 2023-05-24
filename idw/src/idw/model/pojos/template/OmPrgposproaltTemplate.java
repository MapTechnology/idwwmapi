package idw.model.pojos.template;

import idw.model.pojos.OmPrgposproalt;

public abstract class OmPrgposproaltTemplate extends AbstractTemplate<OmPrgposproalt> {

	@Override
	protected OmPrgposproalt atribuir(OmPrgposproalt from, OmPrgposproalt to, boolean isCopiarFK) {
		if (to == null)
			to = new OmPrgposproalt();
		
		to.setIdPrgposproalt(from.getIdPrgposproalt());
		
		if (isCopiarFK) {
			to.setOmProduto(from.getOmProduto().clone(false));
		}
		return to;
	}

}
