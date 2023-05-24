package idw.model.pojos.template;

import idw.model.pojos.DwFtParam;
import idw.model.pojos.DwFtSubparam;


public abstract class DwFtSubparamTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwFtSubparam itemGet = (DwFtSubparam) this;
		
		DwFtSubparam itemSet = new DwFtSubparam();
		itemSet.setIdSubparam(itemGet.getIdSubparam());		
		
		itemSet.setDwFtParam((DwFtParam)itemGet.getDwFtParam().clone());
		
		return itemSet;

	  }
	
	public void copy(DwFtSubparam itemGet,boolean copiarFK){
		DwFtSubparam itemSet = (DwFtSubparam) this;
		itemSet.setIdSubparam(itemGet.getIdSubparam());		
		
		if (copiarFK){
			itemSet.setDwFtParam(itemGet.getDwFtParam());
		}
		
	}
}
