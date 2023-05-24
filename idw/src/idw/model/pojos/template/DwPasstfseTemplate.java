package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.DwFtSub;
import idw.model.pojos.DwPasstfse;
import idw.model.pojos.DwPasstfsepm;


public abstract class DwPasstfseTemplate extends AbstractTemplate<DwPasstfse> {
	
	@Override
	protected DwPasstfse atribuir(DwPasstfse itemGet, DwPasstfse itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwPasstfse();
		
		itemSet.setIdPasstfse(itemGet.getIdPasstfse());
		itemSet.setStSubetapa(itemGet.getStSubetapa());
		itemSet.setOrdemsubetapa(itemGet.getOrdemsubetapa());
		itemSet.setDthrIsubetapa(itemGet.getDthrIsubetapa());
		itemSet.setMsDthrisubetapa(itemGet.getMsDthrisubetapa());
		itemSet.setDthrFsubetapa(itemGet.getDthrFsubetapa());
		itemSet.setMsDthrfsubetapa(itemGet.getMsDthrfsubetapa());
		itemSet.setDthrIposfalha(itemGet.getDthrIposfalha());
		itemSet.setMsDthriposfalha(itemGet.getMsDthriposfalha());
		itemSet.setDthrFposfalha(itemGet.getDthrFposfalha());
		itemSet.setMsDthrfposfalha(itemGet.getMsDthrfposfalha());
		
		if (isCopiarFK){
			itemSet.setDwFtSub((DwFtSub)itemGet.getDwFtSub().clone());

			if (itemGet.getDwPasstfsepms() != null){
				itemSet.setDwPasstfsepms(new HashSet<DwPasstfsepm>());
				for (DwPasstfsepm dwpasstfsepm : itemGet.getDwPasstfsepms()){
					DwPasstfsepm dwpasstfsepmClone = dwpasstfsepm.clone();
					itemSet.getDwPasstfsepms().add(dwpasstfsepmClone);
				}
			}
		}				
				
		return itemSet;
	}	
}
