package idw.model.pojos.template;

import idw.model.pojos.OmCfgind;

public abstract class OmCfgindTemplate extends AbstractTemplate<OmCfgind> {
		
		@Override
		protected OmCfgind atribuir(OmCfgind itemGet, OmCfgind itemSet, boolean isCopiarFK) {
			if (itemSet == null)
				itemSet = new OmCfgind();
			
			itemSet.setIdCfgind(itemGet.getIdCfgind());
			itemSet.setIndInferior(itemGet.getIndInferior());
			itemSet.setIndMeta(itemGet.getIndMeta());
			itemSet.setIndSuperior(itemGet.getIndSuperior());
			
			if (isCopiarFK){
				if (itemGet.getOmInd() != null)
					itemSet.setOmInd(itemGet.getOmInd().clone(false));
			}				
			
			return itemSet;
		}	
}
