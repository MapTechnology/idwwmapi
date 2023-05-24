package idw.model.pojos.template;

import idw.model.pojos.DwConsolreoco;

public abstract class DwConsolreocoTemplate extends AbstractTemplate<DwConsolreoco>{

	@Override
	protected DwConsolreoco atribuir(DwConsolreoco itemGet, DwConsolreoco itemSet, boolean isCopiarFK) {

		if (itemSet == null)
			itemSet = new DwConsolreoco();
		
		itemSet.setIdConsolreoco(itemGet.getIdConsolreoco());
		
		if (isCopiarFK){
			if (itemGet.getDwConsolrelog() != null)
				itemSet.setDwConsolrelog(itemGet.getDwConsolrelog().clone(false));
		}

		return itemSet;
	}
}
