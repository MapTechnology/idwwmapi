package idw.model.pojos.template;

import idw.model.pojos.DwPasstfsepm;


public abstract class DwPasstfsepmTemplate extends AbstractTemplate<DwPasstfsepm> {
	
	@Override
	protected DwPasstfsepm atribuir(DwPasstfsepm itemGet, DwPasstfsepm itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwPasstfsepm();
		
		itemSet.setIdPasstfsepm(itemGet.getIdPasstfsepm());
		itemSet.setDthrMedicao(itemGet.getDthrMedicao());
		itemSet.setMsDthrmedicao(itemGet.getMsDthrmedicao());
		itemSet.setFluxoe(itemGet.getFluxoe());
		itemSet.setFluxos(itemGet.getFluxos());
		itemSet.setTensao(itemGet.getTensao());
		itemSet.setVlcorrente(itemGet.getVlcorrente());
		itemSet.setStFase(itemGet.getStFase());
		
		if (isCopiarFK){
			//itemSet.setDwFtEtapa((DwFtEtapa)itemGet.getDwFtEtapa().clone());
			//itemSet.setDwPasscau((DwPasscau)itemGet.getDwPasscau().clone());			
		}				
				
		return itemSet;
	}	
}
