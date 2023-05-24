package idw.model.pojos.template;

import idw.model.pojos.DwProreausr;

public abstract class DwProreausrTemplate extends AbstractTemplate<DwProreausr>{
	
	@Override
	protected DwProreausr atribuir(DwProreausr itemGet, DwProreausr itemSet, boolean isCopiarFK) {
		if (itemSet == null) {
			itemSet = new DwProreausr();
		}

		itemSet.setIdProreausr(itemGet.getIdProreausr());
		
		if(isCopiarFK){
			itemSet.setOmUsr(itemGet.getOmUsr().clone(false));
			itemSet.setDwProrea(itemGet.getDwProrea().clone(false));
		}
		return itemSet;
		
	}
}