package idw.model.pojos.template;

import idw.model.pojos.OmProduto;
import idw.model.pojos.PpPlaneccron;

public class PpPlaneccronTemplate extends AbstractTemplate<PpPlaneccron>{

	@Override
	protected PpPlaneccron atribuir(PpPlaneccron from, PpPlaneccron to, boolean isCopiarFK) {
		if (to == null)
			to = new PpPlaneccron();

		to.setIdPlaneccron(from.getIdPlaneccron());
		to.setDthrNecessaria(from.getDthrNecessaria());
		to.setQtEstoque(from.getQtEstoque());
		to.setQtNecessaria(from.getQtNecessaria());
		
		if (isCopiarFK == true){
			if (from.getOmProduto() != null){
				to.setOmProduto((OmProduto) from.getOmProduto().clone());
			}
			if (from.getPpNeccron() != null){
				to.setPpNeccron(from.getPpNeccron().clone());
			}
		}
		return to;
	}

}
