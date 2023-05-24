package idw.model.pojos.template;

import idw.model.pojos.DwPassmon;
import idw.model.pojos.OmProduto;


public abstract class DwPassmonTemplate extends AbstractTemplate<DwPassmon> {
	
	@Override
	protected DwPassmon atribuir(DwPassmon itemGet, DwPassmon itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwPassmon();
		
		itemSet.setIdPassmon(itemGet.getIdPassmon());
		itemSet.setDsMon(itemGet.getDsMon());
		itemSet.setCb(itemGet.getCb());
		itemSet.setIsAlternativo(itemGet.getIsAlternativo());
		itemSet.setOrdem(itemGet.getOrdem());
		
		if (isCopiarFK){
			itemSet.setOmProduto((OmProduto)itemGet.getOmProduto().clone());
		}				
				
		return itemSet;
	}	
}
