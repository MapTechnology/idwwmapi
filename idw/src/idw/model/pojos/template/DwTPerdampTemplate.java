package idw.model.pojos.template;

import idw.model.pojos.DwTPerdamp;

public class DwTPerdampTemplate extends AbstractTemplate<DwTPerdamp> {

	@Override
	protected DwTPerdamp atribuir(DwTPerdamp itemGet, DwTPerdamp itemSet,
			boolean isCopiarFK) {
	
		if(itemSet == null)
			itemSet = new DwTPerdamp();
		
		itemSet.setIdTperdamp(itemGet.getIdTperdamp());
		
		itemSet.setDsPerdamp(itemGet.getDsPerdamp());
		
//		itemSet.setDwConsolpemps(new HashSet<DwConsolpemp>());
//		if(itemGet.getDwConsolpemps() != null){
//			for(DwConsolpemp Consolpemp: itemGet.getDwConsolpemps()){
//				itemSet.getDwConsolpemps().add(Consolpemp.clone(true));
//			}
//		}
//		
//		itemSet.setDwConsolperdamplogs(new HashSet<DwConsolperdamplog>());
//		if(itemGet.getDwConsolperdamplogs() != null){
//			for(DwConsolperdamplog consolperdamplog: itemGet.getDwConsolperdamplogs()){
//				itemSet.getDwConsolperdamplogs().add(consolperdamplog.clone(true));
//			}
//		}
		return itemSet;
	}

}
