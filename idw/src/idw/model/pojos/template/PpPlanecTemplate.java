package idw.model.pojos.template;

import idw.model.pojos.PpPlanec;

public class PpPlanecTemplate extends AbstractTemplate<PpPlanec>{

	@Override
	protected PpPlanec atribuir(PpPlanec from, PpPlanec to, boolean isCopiarFK) {
		if (to == null)
			to = new PpPlanec();

		to.setIdPlanec(from.getIdPlanec());
		to.setPrioridade(from.getPrioridade());
		
		if(isCopiarFK) {
			if(from.getPpNec() != null) {
				to.setPpNec(from.getPpNec().clone(false));
			}
		}
		
		return to;
	}

}
