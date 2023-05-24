package idw.model.pojos.template;

import java.util.HashSet;

import org.hibernate.SessionException;

import idw.model.pojos.DwDetativ;
import idw.model.pojos.DwGrpativ;
import idw.model.pojos.DwProcativ;

public class DwProcativTemplate extends AbstractTemplate<DwProcativ>{
	
	@Override
	protected DwProcativ atribuir(DwProcativ itemGet, DwProcativ itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwProcativ();
		
		itemSet.setIdProcativ(itemGet.getIdProcativ());
		itemSet.setDsProcativ(itemGet.getDsProcativ());
		itemSet.setOrdemGrupo(itemGet.getOrdemGrupo());
		itemSet.setOrdemProcativ(itemGet.getOrdemProcativ());
		itemSet.setSegTempopadrao(itemGet.getSegTempopadrao());
		
		if (isCopiarFK ==true) {
			if (itemGet.getDwGrpativ() != null){
				try {
					itemSet.setDwGrpativ((DwGrpativ)itemGet.getDwGrpativ().clone(false));
				}catch(SessionException e) {
					itemSet.setDwGrpativ(null);
				}
			}
			if((itemGet.getDwDetativs() != null) && (!itemGet.getDwDetativs().isEmpty())) {
				try {
					itemSet.setDwDetativs(new HashSet<DwDetativ>());
					
					for (DwDetativ dwDetativ : itemGet.getDwDetativs()){
						itemSet.getDwDetativs().add((DwDetativ) dwDetativ.clone());
					}
				}catch(SessionException e) {
					itemSet.setDwDetativs(null);
				}
			}
		}
		
		return itemSet;
	}
}
 