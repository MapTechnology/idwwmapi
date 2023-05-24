package idw.model.pojos.template;

import idw.model.pojos.DwOperacaopredecessora;

public class DwOperacaopredecessoraTemplate extends AbstractTemplate<DwOperacaopredecessora>{

	@Override
	protected DwOperacaopredecessora atribuir(DwOperacaopredecessora from,
			DwOperacaopredecessora to, boolean isCopiarFK) {

		if (to == null) {
			to = new DwOperacaopredecessora();
		}

		to.setIdOperacaopredecessora(from.getIdOperacaopredecessora());

		if (from.getDwOperacaoByIdOperacao() != null) {
			to.setDwOperacaoByIdOperacao(from.getDwOperacaoByIdOperacao().clone(false));
		}
		if (from.getDwOperacaoByIdOperacaoanterior() != null) {
			to.setDwOperacaoByIdOperacaoanterior(from.getDwOperacaoByIdOperacaoanterior().clone(false));
		}

		return to;
	}

}
