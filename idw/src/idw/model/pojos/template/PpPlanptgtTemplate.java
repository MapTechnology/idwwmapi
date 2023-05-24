package idw.model.pojos.template;

import org.hibernate.LazyInitializationException;
import org.hibernate.SessionException;

import idw.model.pojos.PpPlanptgt;

public class PpPlanptgtTemplate extends AbstractTemplate<PpPlanptgt> {

	@Override
	protected PpPlanptgt atribuir(PpPlanptgt from, PpPlanptgt to,
			boolean isCopiarFK) {
		if(to == null) {
			to = new PpPlanptgt();
		}
		
		to.setIdPlanptgt(from.getIdPlanptgt());
		to.setLinha(from.getLinha());
		to.setColuna(from.getColuna());
		to.setIsCoordenadarelativa(from.getIsCoordenadarelativa());
		to.setAba(from.getAba());
		
		if(isCopiarFK) {
			if(from.getOmPt() != null) {
				try {
					to.setOmPt(from.getOmPt().clone(false));
				}catch(SessionException e) {
					to.setOmPt(null);
				}catch(LazyInitializationException e) {
					to.setOmPt(null);
				}
			}
			if(from.getOmGt() != null) {
				try {
					to.setOmGt(from.getOmGt().clone(false));
				}catch(SessionException e) {
					to.setOmGt(null);
				}catch(LazyInitializationException e) {
					to.setOmGt(null);
				}
			}
		}
		
		return to;
	}

}
