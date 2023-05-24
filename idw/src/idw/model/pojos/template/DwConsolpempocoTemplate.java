package idw.model.pojos.template;

import idw.model.pojos.DwConsolpempoco;

public class DwConsolpempocoTemplate extends AbstractTemplate<DwConsolpempoco> {

	@Override
	protected DwConsolpempoco atribuir(DwConsolpempoco itemGet,
			DwConsolpempoco itemSet, boolean isCopiarFK) {
		// TODO Auto-generated method stub
		if(itemSet == null)
			itemSet = new DwConsolpempoco();
		
		itemSet.setIdConsolpempoco(itemGet.getIdConsolpempoco());
		
		
		if(isCopiarFK){
			itemSet.setDwConsolpemp(itemGet.getDwConsolpemp().clone(false));
			itemSet.setDwConsolperdamplog(itemGet.getDwConsolperdamplog().clone(true));
		}
		
		
		return itemSet;
	}

}
