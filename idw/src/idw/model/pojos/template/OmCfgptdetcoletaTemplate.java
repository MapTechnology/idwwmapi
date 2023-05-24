package idw.model.pojos.template;

import idw.model.pojos.OmCfgptdetcoleta;


public abstract class OmCfgptdetcoletaTemplate extends AbstractTemplate<OmCfgptdetcoleta> {
	
	@Override
	protected OmCfgptdetcoleta atribuir(OmCfgptdetcoleta itemGet, OmCfgptdetcoleta itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new OmCfgptdetcoleta();
		
		itemSet.setIdCfgptdetcoleta(itemGet.getIdCfgptdetcoleta());
		
		if (isCopiarFK){
			if (itemGet.getOmCfg() != null)
				itemSet.setOmCfg(itemGet.getOmCfg().clone());
			if (itemGet.getOmPt() != null)
				itemSet.setOmPt(itemGet.getOmPt().clone());
		}				
		
		return itemSet;
	}	
}
