package idw.model.pojos.template;

import org.hibernate.SessionException;

import idw.model.pojos.DwProcarhom;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.OmCargo;

public class DwProcarhomTemplate extends AbstractTemplate<DwProcarhom>{
	
	@Override
	protected DwProcarhom atribuir(DwProcarhom itemGet, DwProcarhom itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwProcarhom();
		
		itemSet.setIdProcarhom(itemGet.getIdProcarhom());
		itemSet.setTpHomologacao(itemGet.getTpHomologacao());
		
		if (isCopiarFK ==true) {
			if (itemGet.getOmCargo() != null){
				try {
					itemSet.setOmCargo((OmCargo)itemGet.getOmCargo().clone());
				}catch(SessionException e) {
					itemSet.setOmCargo(null);
				}
			}
			if (itemGet.getDwProcedimento() != null){
				try {
					itemSet.setDwProcedimento((DwProcedimento)itemGet.getDwProcedimento().clone());
				}catch(SessionException e) {
					itemSet.setDwProcedimento(null);
				}
			}
			
		}
		
		return itemSet;
	}
}
 