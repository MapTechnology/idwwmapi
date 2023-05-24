package idw.model.pojos.template;

import org.hibernate.SessionException;

import idw.model.pojos.DwDetativ;
import idw.model.pojos.DwProcativ;

public class DwDetativTemplate extends AbstractTemplate<DwDetativ>{
	
	@Override
	protected DwDetativ atribuir(DwDetativ itemGet, DwDetativ itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwDetativ();
		
		itemSet.setIdDetativ(itemGet.getIdDetativ());
		itemSet.setTexto(itemGet.getTexto());
		itemSet.setFoto(itemGet.getFoto());
		itemSet.setOrdem(itemGet.getOrdem());
		itemSet.setTpDetativ(itemGet.getTpDetativ());
		
		if (isCopiarFK ==true) {
			if (itemGet.getDwProcativ() != null){
				try {
					itemSet.setDwProcativ((DwProcativ)itemGet.getDwProcativ().clone(false));
				}catch(SessionException e) {
					itemSet.setDwProcativ(null);
				}
			}
		}
		
		return itemSet;
	}
}
 