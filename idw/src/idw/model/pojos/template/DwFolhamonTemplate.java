package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.DwFolhamon;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.OmProduto;


public abstract class DwFolhamonTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwFolhamon itemGet = (DwFolhamon) this;
		
		DwFolhamon itemSet = new DwFolhamon();
		itemSet.setIdFolhamon(itemGet.getIdFolhamon());
		itemSet.setIsEnviarembalagem(itemGet.getIsEnviarembalagem());
		itemSet.setOmProduto((OmProduto)itemGet.getOmProduto().clone());
		
		itemSet.setDwFolhamoncomps(new HashSet<DwFolhamoncomp>());
		if (itemGet.getDwFolhamoncomps() != null) {
			for (DwFolhamoncomp comp : itemGet.getDwFolhamoncomps()) {
				itemSet.getDwFolhamoncomps().add((DwFolhamoncomp)comp.clone());
			}
		}
		
		return itemSet;

	  }
	
	public void copy(DwFolhamon itemGet,boolean copiarFK){
		DwFolhamon itemSet = (DwFolhamon) this;
		itemSet.setIdFolhamon(itemGet.getIdFolhamon());
		itemSet.setIsEnviarembalagem(itemGet.getIsEnviarembalagem());
		
		if (copiarFK){
			itemSet.setOmProduto(itemGet.getOmProduto());			
		}
		
	}
}
