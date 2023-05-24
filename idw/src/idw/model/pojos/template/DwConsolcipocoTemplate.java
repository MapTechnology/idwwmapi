package idw.model.pojos.template;

import idw.model.pojos.DwConsolcipoco;


public abstract class DwConsolcipocoTemplate extends AbstractTemplate<DwConsolcipoco> {
	
	@Override
	protected DwConsolcipoco atribuir(DwConsolcipoco itemGet, DwConsolcipoco itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwConsolcipoco();

		itemSet.setDthrFcip(itemGet.getDthrFcip());
		itemSet.setDthrIcip(itemGet.getDthrIcip());
		itemSet.setIdConsolcipoco(itemGet.getIdConsolcipoco());
		
		if(isCopiarFK == true){
			
		}
				
		return itemSet;
	}	
}
