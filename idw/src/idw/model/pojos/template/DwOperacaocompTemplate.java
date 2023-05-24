package idw.model.pojos.template;

import idw.model.pojos.DwOperacaocomp;

public class DwOperacaocompTemplate extends AbstractTemplate<DwOperacaocomp>{

	@Override
	protected DwOperacaocomp atribuir(DwOperacaocomp from, DwOperacaocomp to,
			boolean isCopiarFK) {

		if(to == null) {
			to = new DwOperacaocomp();
		}
		
		to.setIdOperacaocomp(from.getIdOperacaocomp());
		
		if (from.getOmProduto() != null) {
			to.setOmProduto(from.getOmProduto().clone(false));
		}
		if(from.getDwOperacao() != null){
			to.setDwOperacao(from.getDwOperacao().clone(false));
		}
		
		return to;
	}

	
}
