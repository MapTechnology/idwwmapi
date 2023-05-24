package idw.model.pojos.template;

import idw.model.pojos.PpCpfaltamp;

public class PpCpfaltampTemplate extends AbstractTemplate<PpCpfaltamp>{

	@Override
	protected PpCpfaltamp atribuir(PpCpfaltamp itemGet, PpCpfaltamp itemSet, boolean isCopiarFK) {
		if (itemSet == null)
			itemSet = new PpCpfaltamp();
		
		itemSet.setIdCpfaltamp(itemGet.getIdCpfaltamp());
		itemSet.setQtde(itemGet.getQtde());
		itemSet.setStMp(itemGet.getStMp());
		
		if (isCopiarFK){
			
			if (itemGet.getOmProduto() != null){
				itemSet.setOmProduto(itemGet.getOmProduto().clone(false));
			}
		}
		return itemSet;
	}
	
}
