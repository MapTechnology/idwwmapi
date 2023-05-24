package idw.model.pojos.template;

import idw.model.pojos.DwConsolParammed;
import idw.util.CloneUtil;


public abstract class DwConsolParammedTemplate extends AbstractTemplate<DwConsolParammed> {
	
	
	@Override
	protected DwConsolParammed atribuir(DwConsolParammed itemGet, DwConsolParammed itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwConsolParammed();
		
		itemSet.setIdConsolparammed(itemGet.getIdConsolparammed());
		
		if(isCopiarFK == true){
			itemSet.setDwConsolmedparamlog(CloneUtil.clone(itemGet.getDwConsolmedparamlog(), false));
			itemSet.setDwConsolpaParam(CloneUtil.clone(itemGet.getDwConsolpaParam(), false));
			itemSet.setDwConsolParam(CloneUtil.clone(itemGet.getDwConsolParam(), false));
		}
				
		return itemSet;
	}	
}
