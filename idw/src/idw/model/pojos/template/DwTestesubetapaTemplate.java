package idw.model.pojos.template;

import idw.model.pojos.DwFtSubparam;
import idw.model.pojos.DwTestesubetapa;


public abstract class DwTestesubetapaTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwTestesubetapa itemGet = (DwTestesubetapa) this;
		
		DwTestesubetapa itemSet = new DwTestesubetapa();
		itemSet.setIdTestesubetapa(itemGet.getIdTestesubetapa());
		itemSet.setMaximo(itemGet.getMaximo());
		itemSet.setMeta(itemGet.getMeta());
		itemSet.setMinimo(itemGet.getMinimo());
		itemSet.setSt(itemGet.getSt());
		
		itemSet.setDwFtSubparam((DwFtSubparam)itemGet.getDwFtSubparam().clone());		
		
		return itemSet;

	  }
	
	public void copy(DwTestesubetapa itemGet,boolean copiarFK){
		DwTestesubetapa itemSet = (DwTestesubetapa) this;
		itemSet.setIdTestesubetapa(itemGet.getIdTestesubetapa());

		if (copiarFK){
			itemSet.setDwFtSubparam(itemGet.getDwFtSubparam());
		}		
	}
}
