package idw.model.pojos.template;

import idw.model.pojos.DwExpcvspf;
import idw.model.pojos.OmProgrp;


public abstract class DwExpcvspfTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwExpcvspf itemGet = (DwExpcvspf) this;
		
		DwExpcvspf itemSet = new DwExpcvspf();
		itemSet.setIdExpcfvpf(itemGet.getIdExpcfvpf());
		
		if (itemGet.getOmProgrp() != null)
			itemSet.setOmProgrp((OmProgrp)itemGet.getOmProgrp().clone());
		
		return itemSet;

	  }
	
	public void copy(DwExpcvspf itemGet,boolean copiarFK){
		DwExpcvspf itemSet = (DwExpcvspf) this;
		
		itemSet.setIdExpcfvpf(itemGet.getIdExpcfvpf());
		
		
		if (copiarFK){
			itemSet.setOmProgrp(itemGet.getOmProgrp());
		}
		
	}
}
