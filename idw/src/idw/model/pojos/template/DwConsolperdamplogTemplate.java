package idw.model.pojos.template;

import idw.model.pojos.DwConsolperdamplog;
import idw.model.pojos.OmMapapa;

public abstract class DwConsolperdamplogTemplate extends AbstractTemplate<DwConsolperdamplog>{

	@Override
	protected DwConsolperdamplog atribuir(DwConsolperdamplog itemGet,
			DwConsolperdamplog itemSet, boolean isCopiarFK) {
		// TODO Auto-generated method stub
		if(itemSet == null)
			itemSet = new DwConsolperdamplog();
		
		itemSet.setIdConsolpemplog(itemGet.getIdConsolpemplog());
		
		itemSet.setDthrPerdamp(itemGet.getDthrPerdamp());
		itemSet.setMsDthrperdamp(itemGet.getMsDthrperdamp());
		itemSet.setQtAutoPerdamp(itemGet.getQtAutoPerdamp());
		itemSet.setQtManuPerdamp(itemGet.getQtManuPerdamp());
		
		if(isCopiarFK){
//			itemSet.setDwConsolpempocos(new HashSet<DwConsolpempoco>());
//			
//			if(itemGet.getDwConsolpempocos() != null){
//				for(DwConsolpempoco consolpempoco : itemGet.getDwConsolpempocos() ){
//					itemSet.getDwConsolpempocos().add(consolpempoco.clone(true));
//				}
//					
//			}
			
			itemSet.setDwTPerdamp(itemGet.getDwTPerdamp().clone(false));
			itemSet.setOmProduto(itemGet.getOmProduto().clone(false));
			itemSet.setDwRap(itemGet.getDwRap().clone(false));
			if (itemGet.getOmPt() != null)
				itemSet.setOmPt(itemGet.getOmPt().clone(false));
			if (itemGet.getPpCp() != null)
				itemSet.setPpCp(itemGet.getPpCp().clone(false));
			if (itemGet.getOmMapapa() != null)
				itemSet.setOmMapapa((OmMapapa)itemGet.getOmMapapa().clone());
		}
		

		
		
		
		return itemSet;
	}

	
	
	
	

}
