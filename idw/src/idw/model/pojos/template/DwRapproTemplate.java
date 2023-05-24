package idw.model.pojos.template;

import idw.model.pojos.DwRappro;

public abstract class DwRapproTemplate extends AbstractTemplate<DwRappro> {

	@Override
	protected DwRappro atribuir(DwRappro from, DwRappro to, boolean isCopiarFK) {
		if (to == null)
			to = new DwRappro();
		
		to.setIdRappro(from.getIdRappro());
		
		if (isCopiarFK) {
			if (from.getOmProduto() != null)
				to.setOmProduto(from.getOmProduto().clone(false));
		}
		
		return to;
	}

}
