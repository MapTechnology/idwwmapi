package idw.model.pojos.template;

import java.util.HashSet;
import java.util.Set;

import idw.model.pojos.DwFolhateste;
import idw.model.pojos.DwTestesub;
import idw.model.pojos.OmProduto;


public abstract class DwFolhatesteTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwFolhateste itemGet = (DwFolhateste) this;
		
		DwFolhateste itemSet = new DwFolhateste();
		itemSet.setIdFolhateste(itemGet.getIdFolhateste());
		itemSet.setFrequenciaHz(itemGet.getFrequenciaHz());
		itemSet.setTensaoMax(itemGet.getTensaoMax());
		itemSet.setTensaoMin(itemGet.getTensaoMin());
		itemSet.setTensaoNom(itemGet.getTensaoNom());
		
		itemSet.setOmGt(itemGet.getOmGt().clone());
		itemSet.setOmProduto((OmProduto)itemGet.getOmProduto().clone());
		
		if (itemGet.getDwTestesubs() != null){
			Set<DwTestesub> ld = new HashSet<DwTestesub>();
			for (DwTestesub d : itemGet.getDwTestesubs()){
				ld.add((DwTestesub) d.clone());
			}
			itemSet.setDwTestesubs(ld);
		}
		
		return itemSet;

	  }
	
	public void copy(DwFolhateste itemGet,boolean copiarFK){
		DwFolhateste itemSet = (DwFolhateste) this;
		itemSet.setIdFolhateste(itemGet.getIdFolhateste());
		itemSet.setFrequenciaHz(itemGet.getFrequenciaHz());
		itemSet.setTensaoMax(itemGet.getTensaoMax());
		itemSet.setTensaoMin(itemGet.getTensaoMin());
		itemSet.setTensaoNom(itemGet.getTensaoNom());

		if (copiarFK){
			itemSet.setOmGt(itemGet.getOmGt());
			itemSet.setOmProduto(itemGet.getOmProduto());
		}
		
	}
}
