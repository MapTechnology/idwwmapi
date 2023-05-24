package idw.model.pojos.template;

import idw.model.pojos.DwNserieobs;


public abstract class DwNserieobsTemplate extends AbstractTemplate<DwNserieobs> {
	
	@Override
	protected DwNserieobs atribuir(DwNserieobs itemGet, DwNserieobs itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwNserieobs();
		
		itemSet.setIdNserieobs(itemGet.getIdNserieobs());
		itemSet.setDsObs(itemGet.getDsObs());
		itemSet.setDthrObs(itemGet.getDthrObs());
		
		if (isCopiarFK){
			if (itemGet.getOmPt() != null)
				itemSet.setOmPt(itemGet.getOmPt().clone(false));
			if (itemGet.getOmUsr() != null)
				itemSet.setOmUsr(itemGet.getOmUsr().clone(false));
		}
		
		return itemSet;
	}	
}
