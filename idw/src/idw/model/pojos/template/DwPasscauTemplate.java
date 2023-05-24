package idw.model.pojos.template;

import idw.model.pojos.DwPasscau;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTDefeito;


public abstract class DwPasscauTemplate extends AbstractTemplate<DwPasscau> {
	
	@Override
	protected DwPasscau atribuir(DwPasscau itemGet, DwPasscau itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwPasscau();
		
		itemSet.setIdPasscau(itemGet.getIdPasscau());
		
		if (isCopiarFK){
			//itemSet.setDwPasscau((DwPasscau)itemGet.getDwPasscau().clone());
			itemSet.setDwTDefeito((DwTDefeito)itemGet.getDwTDefeito().clone());			
			itemSet.setDwTAcao((DwTAcao)itemGet.getDwTAcao().clone());
		}				
				
		return itemSet;
	}	
}
