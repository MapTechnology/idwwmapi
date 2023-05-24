package idw.model.pojos.template;

import idw.model.pojos.DwOperacaorap;

public class DwOperacaorapTemplate extends AbstractTemplate<DwOperacaorap>{

	@Override
	protected DwOperacaorap atribuir(DwOperacaorap from, DwOperacaorap to,
			boolean isCopiarFK) {

		if (to == null) {
			to = new DwOperacaorap();
		}

		to.setIdOperacaorap(from.getIdOperacaorap());

		if (from.getDwRap() != null) {
			to.setDwRap(from.getDwRap().clone(false));
		}
		if (from.getDwOperacao() != null) {
			to.setDwOperacao(from.getDwOperacao().clone(false));
		}

		return to;
	}
	
	

}
