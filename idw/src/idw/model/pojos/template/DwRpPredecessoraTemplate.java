package idw.model.pojos.template;

import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRpPredecessora;


public abstract class DwRpPredecessoraTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwRpPredecessora itemGet = (DwRpPredecessora) this;
		
		DwRpPredecessora itemSet = new DwRpPredecessora();
		itemSet.setIdRpPredecessora(itemGet.getIdRpPredecessora());
		itemSet.setIsAceitaSeC(itemGet.getIsAceitaSeC());
		itemSet.setIsAceitaSeNc(itemGet.getIsAceitaSeNc());
		itemSet.setDwRotapassoByIdRotapassoFilho((DwRotapasso)itemGet.getDwRotapassoByIdRotapassoFilho().clone());
		itemSet.setIsEspelho(itemGet.getIsEspelho());
		return itemSet;

	  }
	
	public void copy(DwRpPredecessora itemGet,boolean copiarFK){
		DwRpPredecessora itemSet = (DwRpPredecessora) this;
		itemSet.setIdRpPredecessora(itemGet.getIdRpPredecessora());
		itemSet.setIsAceitaSeC(itemGet.getIsAceitaSeC());
		itemSet.setIsAceitaSeNc(itemGet.getIsAceitaSeNc());				
		
	}
}
