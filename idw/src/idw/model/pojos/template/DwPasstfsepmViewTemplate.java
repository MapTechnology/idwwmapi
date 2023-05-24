package idw.model.pojos.template;

import idw.model.pojos.DwPasstfsepmView;


public abstract class DwPasstfsepmViewTemplate extends AbstractTemplate<DwPasstfsepmView> {
	
	@Override
	protected DwPasstfsepmView atribuir(DwPasstfsepmView itemGet, DwPasstfsepmView itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwPasstfsepmView();
		
		itemSet.setIdPasstfsepm(itemGet.getIdPasstfsepm());
		itemSet.setDthrMedicao(itemGet.getDthrMedicao());
		itemSet.setMsDthrmedicao(itemGet.getMsDthrmedicao());
		itemSet.setFluxoe(itemGet.getFluxoe());
		itemSet.setFluxos(itemGet.getFluxos());
		itemSet.setVlcorrente(itemGet.getVlcorrente());
		itemSet.setTensao(itemGet.getTensao());

		
		if (isCopiarFK){
			itemSet.setDwPasstfse(itemGet.getDwPasstfse().clone(false));	
		}				
				
		return itemSet;
	}	
}
