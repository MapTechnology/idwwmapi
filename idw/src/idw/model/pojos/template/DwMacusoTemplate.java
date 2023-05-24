package idw.model.pojos.template;

import idw.model.pojos.DwMacuso;
import idw.util.CloneUtil;

public abstract class DwMacusoTemplate extends AbstractTemplate<DwMacuso> {
	
	@Override
	protected DwMacuso atribuir(DwMacuso itemGet, DwMacuso itemSet, boolean isCopiarFK) {

		if(itemSet == null){
			itemSet = new DwMacuso();
		}
		
		itemSet.setCdMac(itemGet.getCdMac());
		itemSet.setDthrUso(itemGet.getDthrUso());
		itemSet.setGrupo(itemGet.getGrupo());
		itemSet.setIdMacuso(itemGet.getIdMacuso());
		
		if(isCopiarFK) {
			itemSet.setDwMacrange(CloneUtil.clone(itemGet.getDwMacrange(), false));
		}
		
		return itemSet;
	}
}
