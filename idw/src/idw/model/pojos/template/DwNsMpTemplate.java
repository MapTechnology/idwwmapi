package idw.model.pojos.template;

import idw.model.pojos.DwNsMp;
public class DwNsMpTemplate extends AbstractTemplate<DwNsMp>  {

	@Override
	protected DwNsMp atribuir(DwNsMp from, DwNsMp to, boolean isCopiarFK) {
		if (to == null) {
			to = new DwNsMp();
		}
		to.setIdNsmp(from.getIdNsmp());
		to.setNrop(from.getNrop());
		to.setDthrCadastro(from.getDthrCadastro());
		
		if (isCopiarFK) {
			if (from.getDwNserie() != null)
				to.setDwNserie(from.getDwNserie().clone(false));
			if (from.getOmGt() != null)
				to.setOmGt(from.getOmGt().clone(false));
			if (from.getOmProduto() != null)
				to.setOmProduto(from.getOmProduto().clone(false));
			if (from.getOmPt() != null)
				to.setOmPt(from.getOmPt().clone(false));
		}
		
		return to;
	}

}
