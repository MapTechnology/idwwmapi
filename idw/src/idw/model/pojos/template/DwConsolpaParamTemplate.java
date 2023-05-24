package idw.model.pojos.template;

import idw.model.pojos.DwConsolpaParam;


public abstract class DwConsolpaParamTemplate extends AbstractTemplate<DwConsolpaParam> {
	
	
	@Override
	protected DwConsolpaParam atribuir(DwConsolpaParam itemGet, DwConsolpaParam itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwConsolpaParam();
		
		itemSet.setIdConsolpaParam(itemGet.getIdConsolpaParam());
		itemSet.setQtMedicoes(itemGet.getQtMedicoes());
		itemSet.setVlMaximo(itemGet.getVlMaximo());
		itemSet.setVlMinimo(itemGet.getVlMinimo());
		itemSet.setVlSomado(itemGet.getVlSomado());
		itemSet.setVlmedio(itemGet.getVlmedio());
		itemSet.setVlMonetario(itemGet.getVlMonetario());
		if(isCopiarFK == true){
			itemSet.setDwFtParam(itemGet.getDwFtParam().clone(false));
		}
				
		return itemSet;
	}	
}
