package idw.model.pojos.template;

import java.util.HashSet;

import org.hibernate.SessionException;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRotapassoPt;

public abstract class DwRotapassoTemplate extends AbstractTemplate<DwRotapasso>{
	
	@Override
	protected DwRotapasso atribuir(DwRotapasso itemGet, DwRotapasso itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new DwRotapasso();
		
		itemSet.setIdRotapasso(itemGet.getIdRotapasso());
		itemSet.setIsLiberacao(itemGet.getIsLiberacao());
		itemSet.setObs(itemGet.getObs());
		itemSet.setPasso(itemGet.getPasso());
		itemSet.setQtMovimentacao(itemGet.getQtMovimentacao());
		itemSet.setTpMovimentacao(itemGet.getTpMovimentacao());

		if (isCopiarFK ==true) {
			if (itemGet.getDwEst() != null){
				try {
					itemSet.setDwEst((DwEst)itemGet.getDwEst().clone());
				}catch(SessionException e) {
					itemSet.setDwEst(null);
				}
			}
			if (itemGet.getDwFolha() != null){
				try {
					itemSet.setDwFolha((DwFolha)itemGet.getDwFolha().clone());
				}catch(SessionException e) {
					itemSet.setDwFolha(null);
				}
			}
			
			if((itemGet.getDwRotapassoPts() != null) && (!itemGet.getDwRotapassoPts().isEmpty())) {
				try {
					itemSet.setDwRotapassoPts(new HashSet<DwRotapassoPt>());
					
					for (DwRotapassoPt dwRotapassoPt : itemGet.getDwRotapassoPts()){
						itemSet.getDwRotapassoPts().add((DwRotapassoPt) dwRotapassoPt.clone());
					}
				}catch(SessionException e) {
					itemSet.setDwRotapassoPts(null);
				}
			}
		}
		
		return itemSet;
	}
}
