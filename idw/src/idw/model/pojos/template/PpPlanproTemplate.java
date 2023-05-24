package idw.model.pojos.template;

import idw.model.pojos.PpPlanpro;

public class PpPlanproTemplate extends AbstractTemplate<PpPlanpro> {

	@Override
	protected PpPlanpro atribuir(PpPlanpro from, PpPlanpro to, boolean isCopiarFK) {
		if(to == null) {
			to = new PpPlanpro();
		}

		to.setIdPlanpro(from.getIdPlanpro());
		to.setPcsProducaobruta(from.getPcsProducaobruta());
		to.setPcsProducaoestoque(from.getPcsProducaoestoque());
		to.setPcsProducaoliquida(from.getPcsProducaoliquida());
		
		if(isCopiarFK) {
			to.setPpPlano(from.getPpPlano().clone(false));
			to.setOmProduto(from.getOmProduto().clone(false));
		}
		
		return to;
	}

}
