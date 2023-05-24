package idw.model.pojos.template;

import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCmcom;


public abstract class PpCmcomTemplate implements Cloneable{

	@Override
	public Object clone() {
		PpCmcom itemGet = (PpCmcom) this;
		PpCmcom itemSet = new PpCmcom();
		
		itemSet.setIdCmcom(itemGet.getIdCmcom());
		itemSet.setDthrVigor(itemGet.getDthrVigor());
		itemSet.setIsConsumirmp(itemGet.getIsConsumirmp());
		itemSet.setObs(itemGet.getObs());
		itemSet.setPosicao(itemGet.getPosicao());
		itemSet.setQtEntra(itemGet.getQtEntra());
		itemSet.setQtSai(itemGet.getQtSai());
		itemSet.setDthrSai(itemGet.getDthrSai());
		
		if (itemGet.getOmProdutoByFinal() != null){
			itemSet.setOmProdutoByFinal((OmProduto) itemGet.getOmProdutoByFinal().clone(false));	
		}

		if (itemGet.getOmProdutoByIdProdutoentra() != null){
			itemSet.setOmProdutoByIdProdutoentra((OmProduto) itemGet.getOmProdutoByIdProdutoentra().clone(false));
		}
		
		if (itemGet.getOmProdutoByIdProdutosai() != null){
			itemSet.setOmProdutoByIdProdutosai((OmProduto) itemGet.getOmProdutoByIdProdutosai().clone());

		}
										
		return itemSet;
	}

	
}
