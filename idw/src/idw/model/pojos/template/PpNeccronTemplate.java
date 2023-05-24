package idw.model.pojos.template;

import idw.model.pojos.PpNeccron;

public class PpNeccronTemplate extends AbstractTemplate<PpNeccron>{

	@Override
	protected PpNeccron atribuir(PpNeccron from, PpNeccron to, boolean isCopiarFK) {
		if (to == null)
			to = new PpNeccron();

		to.setIdNeccron(from.getIdNeccron());

		to.setDtDesejada(from.getDtDesejada());
		to.setQtDesejada(from.getQtDesejada());
		to.setDtEstimada(from.getDtEstimada());
		
		return to;
	}

}
