package idw.model.pojos.template;

import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.OmProduto;


public abstract class DwFolhamoncompTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwFolhamoncomp itemGet = (DwFolhamoncomp) this;
		
		DwFolhamoncomp itemSet = new DwFolhamoncomp();
		itemSet.setIdFolhamoncomp(itemGet.getIdFolhamoncomp());
		itemSet.setDsMon(itemGet.getDsMon());
		itemSet.setIsAceitarAlter(itemGet.getIsAceitarAlter());
		itemSet.setOrdem(itemGet.getOrdem());
		itemSet.setQtAmontar(itemGet.getQtAmontar());
		itemSet.setIsAvaliarlimites(itemGet.getIsAvaliarlimites());
		itemSet.setLimiteMinCb(itemGet.getLimiteMinCb());
		itemSet.setLimiteMaxCb(itemGet.getLimiteMaxCb());
		itemSet.setTpValidacao(itemGet.getTpValidacao());
		itemSet.setIsAceitarAlter(itemGet.getIsAceitarAlter());
		itemSet.setIsAceitarNsDesconhecido(itemGet.getIsAceitarNsDesconhecido());
		itemSet.setIsAvaliarlimites(itemGet.getIsAvaliarlimites());
		itemSet.setMascara(itemGet.getMascara());
		
		itemSet.setOmProduto((OmProduto)itemGet.getOmProduto().clone());
		
		return itemSet;

	}
	
	public void copy(DwFolhamoncomp itemGet,boolean copiarFK){
		DwFolhamoncomp itemSet = (DwFolhamoncomp) this;
		itemSet.setIdFolhamoncomp(itemGet.getIdFolhamoncomp());
		itemSet.setDsMon(itemGet.getDsMon());
		itemSet.setOrdem(itemGet.getOrdem());
		itemSet.setQtAmontar(itemGet.getQtAmontar());

		itemSet.setIsAvaliarlimites(itemGet.getIsAvaliarlimites());
		itemSet.setIsAceitarAlter(itemGet.getIsAceitarAlter());
		itemSet.setIsAceitarNsDesconhecido(itemGet.getIsAceitarNsDesconhecido());
		
		itemSet.setLimiteMinCb(itemGet.getLimiteMinCb());
		itemSet.setLimiteMaxCb(itemGet.getLimiteMaxCb());
		itemSet.setTpValidacao(itemGet.getTpValidacao());
		itemSet.setMascara(itemGet.getMascara());
		
		
		if (copiarFK){
			itemSet.setOmProduto(itemGet.getOmProduto());
		}	
	}
}
