package idw.model.pojos.template;

import idw.model.pojos.DwPassdef;
import idw.model.pojos.DwTDefeito;

public abstract class DwPassdefTemplate extends AbstractTemplate<DwPassdef> {
	
	@Override
	protected DwPassdef atribuir(DwPassdef itemGet, DwPassdef itemSet, boolean isCopiarFK) {
		
		if (itemSet == null)
			itemSet = new DwPassdef();
		
		itemSet.setIdPassdef(itemGet.getIdPassdef());
		itemSet.setDsPosicaomecanica(itemGet.getDsPosicaomecanica());
		itemSet.setCdComponente(itemGet.getCdComponente());
		
		if (isCopiarFK){
			//itemSet.setDwPasscau((DwPasscau)itemGet.getDwPasscau().clone());
			itemSet.setDwTDefeito((DwTDefeito)itemGet.getDwTDefeito().clone());
			
			if (itemGet.getDwTArea() != null)
				itemSet.setDwTArea(itemGet.getDwTArea().clone());
			
			if (itemGet.getDwTOrigem() != null)
				itemSet.setDwTOrigem(itemGet.getDwTOrigem().clone());
			
		}				
				
		return itemSet;
	
	}	

}