package idw.model.pojos.template;

import idw.model.pojos.DwConsolmedparamlog;

public class DwConsolmedparamlogTemplate  extends AbstractTemplate<DwConsolmedparamlog>{

	@Override
	protected DwConsolmedparamlog atribuir(DwConsolmedparamlog itemGet,
			DwConsolmedparamlog itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwConsolmedparamlog();
		
		itemSet.setIdConsolmedparamlog(itemGet.getIdConsolmedparamlog());
		itemSet.setDthrMedicao(itemGet.getDthrMedicao());
		itemSet.setVlMonetario(itemGet.getVlMonetario());
		itemSet.setMsDthrmedicao(itemGet.getMsDthrmedicao());
		itemSet.setVlrLido(itemGet.getVlrLido());
		itemSet.setZona(itemGet.getZona());
		itemSet.setIdValorLido(itemGet.getIdValorLido());
		
		if(isCopiarFK){
			itemSet.setDwFtParam(itemGet.getDwFtParam().clone(false));
		}
		
		return itemSet;
	}

}
