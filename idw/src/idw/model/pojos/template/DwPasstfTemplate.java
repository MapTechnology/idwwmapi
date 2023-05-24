package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwPasstf;
import idw.model.pojos.DwPasstfse;


public abstract class DwPasstfTemplate extends AbstractTemplate<DwPasstf> {
	
	@Override
	protected DwPasstf atribuir(DwPasstf itemGet, DwPasstf itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwPasstf();
		
		itemSet.setIdPasstf(itemGet.getIdPasstf());
		itemSet.setDthrFetapa(itemGet.getDthrFetapa());
		itemSet.setDthrIetapa(itemGet.getDthrIetapa());
		itemSet.setMsDthrfetapa(itemGet.getMsDthrfetapa());
		itemSet.setMsDthrietapa(itemGet.getMsDthrietapa());
		itemSet.setStEtapa(itemGet.getStEtapa());
		itemSet.setOrdemetapa(itemGet.getOrdemetapa());
		
		if (isCopiarFK){
			itemSet.setDwFtEtapa((DwFtEtapa)itemGet.getDwFtEtapa().clone());
			//itemSet.setDwPasscau((DwPasscau)itemGet.getDwPasscau().clone());			

			if (itemGet.getDwPasstfses() != null){
				itemSet.setDwPasstfses(new HashSet<DwPasstfse>());
				for (DwPasstfse dwpasstfse : itemGet.getDwPasstfses()){
					DwPasstfse dwpasstfseClone = dwpasstfse.clone();
					itemSet.getDwPasstfses().add(dwpasstfseClone);
				}
			}
		}				
				
		return itemSet;
	}	
}
