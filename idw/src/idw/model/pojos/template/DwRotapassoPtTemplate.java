package idw.model.pojos.template;

import idw.model.pojos.DwRotapassoPt;


public abstract class DwRotapassoPtTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwRotapassoPt itemGet = (DwRotapassoPt) this;
		
		DwRotapassoPt itemSet = new DwRotapassoPt();
		
		itemSet.setIdRotapassoPt(itemGet.getIdRotapassoPt());
		itemSet.setOmPt(itemGet.getOmPt().clone());
		itemSet.setOrdem(itemGet.getOrdem());
		itemSet.setIsMostrargt(itemGet.getIsMostrargt());
		
		return itemSet;

	  }
	
	public void copy(DwRotapassoPt itemGet,boolean copiarFK){
		DwRotapassoPt itemSet = (DwRotapassoPt) this;
		
		
		
		
	}
}
