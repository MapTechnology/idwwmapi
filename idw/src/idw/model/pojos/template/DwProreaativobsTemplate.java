package idw.model.pojos.template;

import org.hibernate.SessionException;

import idw.model.pojos.DwProreaativ;
import idw.model.pojos.DwProreaativobs;

public abstract class DwProreaativobsTemplate extends AbstractTemplate<DwProreaativobs>{
	
	@Override
	protected DwProreaativobs atribuir(DwProreaativobs itemGet, DwProreaativobs itemSet,
			boolean isCopiarFK) {
		if (itemSet == null) {
			itemSet = new DwProreaativobs();
		}

		itemSet.setIdProreaativobs(itemGet.getIdProreaativobs());
		itemSet.setDsObs(itemGet.getDsObs());
		itemSet.setFoto(itemGet.getFoto());
		itemSet.setAudio(itemGet.getAudio());
		itemSet.setDthrObs(itemGet.getDthrObs());
		itemSet.setIsFoto(itemGet.getIsFoto());
		itemSet.setIsTexto(itemGet.getIsTexto());
		itemSet.setIsAudio(itemGet.getIsAudio());
		
		if (isCopiarFK ==true) {
			if (itemGet.getDwProreaativ() != null){
				try {
					itemSet.setDwProreaativ((DwProreaativ)itemGet.getDwProreaativ().clone(false));
				}catch(SessionException e) {
					itemSet.setDwProreaativ(null);
				}
			}
		}
		return itemSet;
		
	}
}