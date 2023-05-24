package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.DwConsolpemp;
import idw.model.pojos.DwConsolpempoco;

public abstract  class DwConsolpempTemplate  extends AbstractTemplate<DwConsolpemp> {

	@Override
	protected DwConsolpemp atribuir(DwConsolpemp itemGet, DwConsolpemp itemSet,
			boolean isCopiarFK) {
		// TODO Auto-generated method stub
		if (itemSet == null)
			itemSet = new DwConsolpemp();
		
		itemSet.setIdConsolpemp(itemGet.getIdConsolpemp());	
		itemSet.setQtAutoPerdamp(itemGet.getQtAutoPerdamp());
		itemSet.setQtManuPerdamp(itemGet.getQtManuPerdamp());
		
		if(isCopiarFK){
			itemSet.setDwConsolpempocos(new HashSet<DwConsolpempoco>());
			if(itemGet.getDwConsolpempocos() != null){
				for(DwConsolpempoco consolpempoco: itemGet.getDwConsolpempocos()){
					itemSet.getDwConsolpempocos().add(consolpempoco.clone(true));
				}
			}
				
			itemSet.setDwTPerdamp(itemGet.getDwTPerdamp().clone(false));
		
		}
		
		return itemSet;
	}
/*
	@Override
	public Object clone(){
		
		DwConsolpemp item = (DwConsolpemp) this;
		
		DwConsolpemp clone = new DwConsolpemp();
		
		clone.setIdConsolpemp(item.getIdConsolpemp());
		clone.setDwConsol(item.getDwConsol());
		clone.setDwTPerdamp(item.getDwTPerdamp());
		clone.setQtAutoPerdamp(item.getQtAutoPerdamp());
		clone.setQtManuPerdamp(item.getQtManuPerdamp());
		
		clone.setDwConsolpempocos(new HashSet<DwConsolpempoco>());
		
		for(DwConsolpempoco consolpempoco: item.getDwConsolpempocos()){
			clone.getDwConsolpempocos().add((DwConsolpempoco) consolpempoco);
		}
		
		
		return clone;
	}
	*/
}
