package idw.model.pojos.template;

import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwFtParam;
import idw.model.pojos.DwFtSub;
import idw.model.pojos.DwFtSubparam;
import idw.model.pojos.OmProduto;


public abstract class DwFtSubTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwFtSub itemGet = (DwFtSub) this;
		
		DwFtSub itemSet = new DwFtSub();
		itemSet.setIdFtSub(itemGet.getIdFtSub());
		itemSet.setDsSub(itemGet.getDsSub());
		itemSet.setMs(itemGet.getMs());
		itemSet.setStFtParam(itemGet.getStFtParam());
		itemSet.setTpFtParam(itemGet.getTpFtParam());
		itemSet.setTpFtSub(itemGet.getTpFtSub());
		itemSet.setTpStatus(itemGet.getTpStatus());
		itemSet.setVlFtParam(itemGet.getVlFtParam());
		itemSet.setX41(itemGet.getX41());
		itemSet.setX42(itemGet.getX42());
		itemSet.setX45(itemGet.getX45());
		itemSet.setX46(itemGet.getX46());
		itemSet.setX47(itemGet.getX47());
		itemSet.setX48(itemGet.getX48());
		itemSet.setX49(itemGet.getX49());
		itemSet.setY81(itemGet.getY81());
		itemSet.setY82(itemGet.getY82());
		itemSet.setY83(itemGet.getY83());
		itemSet.setY84(itemGet.getY84());	
		
		if (itemGet.getOmProduto() != null)
			itemSet.setOmProduto((OmProduto)itemGet.getOmProduto().clone());
			
		if (itemGet.getDwFtParam() != null)
			itemSet.setDwFtParam((DwFtParam)itemGet.getDwFtParam().clone());	

		if (itemGet.getDwFtEtapa() != null)
			itemSet.setDwFtEtapa((DwFtEtapa)itemGet.getDwFtEtapa().clone());	

		if (itemGet.getDwFtSubparams() != null){
			for (DwFtSubparam p : itemGet.getDwFtSubparams()){
				itemSet.getDwFtSubparams().add((DwFtSubparam) p.clone());
			}
		}
		return itemSet;

	  }
	
	public void copy(DwFtSub itemGet,boolean copiarFK){
		DwFtSub itemSet = (DwFtSub) this;
		itemSet.setIdFtSub(itemGet.getIdFtSub());
		itemSet.setDsSub(itemGet.getDsSub());
		itemSet.setMs(itemGet.getMs());
		itemSet.setStFtParam(itemGet.getStFtParam());
		itemSet.setTpFtParam(itemGet.getTpFtParam());
		itemSet.setTpFtSub(itemGet.getTpFtSub());
		itemSet.setTpStatus(itemGet.getTpStatus());
		itemSet.setVlFtParam(itemGet.getVlFtParam());
		itemSet.setX41(itemGet.getX41());
		itemSet.setX42(itemGet.getX42());
		itemSet.setX45(itemGet.getX45());
		itemSet.setX46(itemGet.getX46());
		itemSet.setX47(itemGet.getX47());
		itemSet.setX48(itemGet.getX48());
		itemSet.setX49(itemGet.getX49());
		itemSet.setY81(itemGet.getY81());
		itemSet.setY82(itemGet.getY82());
		itemSet.setY83(itemGet.getY83());
		itemSet.setY84(itemGet.getY84());	
		
		
		if (copiarFK){
			itemSet.setOmProduto(itemGet.getOmProduto());			
			itemSet.setDwFtParam(itemGet.getDwFtParam());
		}
		
	}
}
