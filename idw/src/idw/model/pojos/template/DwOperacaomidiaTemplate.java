package idw.model.pojos.template;

import idw.model.pojos.DwOperacaomidia;

public class DwOperacaomidiaTemplate extends AbstractTemplate<DwOperacaomidia>{

	@Override
	protected DwOperacaomidia atribuir(DwOperacaomidia from,
			DwOperacaomidia to, boolean isCopiarFK) {
		
		if (to == null) {
			to = new DwOperacaomidia();
		}

		to.setIdOperacaomidia(from.getIdOperacaomidia());
		to.setDsOperacaomidia(from.getDsOperacaomidia());
		to.setMidia(from.getMidia());
		to.setOrdem(from.getOrdem());

		if (from.getDwOperacao() != null) {
			to.setDwOperacao(from.getDwOperacao().clone(false));
		}

		return to;
	}

}
