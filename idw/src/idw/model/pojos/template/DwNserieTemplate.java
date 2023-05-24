package idw.model.pojos.template;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwNserie;
import idw.model.pojos.OmProduto;


public abstract class DwNserieTemplate extends AbstractTemplate<DwNserie> {
	
	@Override
	protected DwNserie atribuir(DwNserie itemGet, DwNserie itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwNserie();
		
		itemSet.setIdNserie(itemGet.getIdNserie());
		itemSet.setCb(itemGet.getCb());
		itemSet.setNs(itemGet.getNs());
		itemSet.setSequencial(itemGet.getSequencial());
		itemSet.setCbserial(itemGet.getCbserial());
		itemSet.setIsConsumido(itemGet.getIsConsumido());
		itemSet.setDthrBatismobc(itemGet.getDthrBatismobc());
		itemSet.setIdBatismobc(itemGet.getIdBatismobc());
		
		if (isCopiarFK){
			if (itemGet.getDwEst() != null)
				itemSet.setDwEst((DwEst)itemGet.getDwEst().clone(false));
			
			try {
				itemSet.setDwPassagem(itemGet.getDwPassagem().clone(false));
			} catch (Exception e) {				
			}	
			try {
				itemSet.setOmProduto((OmProduto)itemGet.getOmProduto().clone(false));
			} catch (Exception e) {				
			}
		}
		
		return itemSet;
	}	
}
