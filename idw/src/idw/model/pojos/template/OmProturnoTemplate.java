package idw.model.pojos.template;

import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProturno;

public abstract class OmProturnoTemplate implements Cloneable {
    
	
	@Override
	public Object clone() {
		
		OmProturno itemSet = new OmProturno();
		OmProturno itemGet = (OmProturno) this;
		
		itemSet.setIdOmproturno(itemGet.getIdOmproturno());
		itemSet.setTpRelacao(itemGet.getTpRelacao());
		itemSet.setOmProduto((OmProduto) itemGet.getOmProduto().clone());
		
		return itemSet;
		
	}
}
