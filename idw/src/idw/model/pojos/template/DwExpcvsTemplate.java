package idw.model.pojos.template;

import idw.model.pojos.DwExpcvs;
import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.OmProduto;


public abstract class DwExpcvsTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwExpcvs itemGet = (DwExpcvs) this;
		
		DwExpcvs itemSet = new DwExpcvs();
		itemSet.setIdExpcvs(itemGet.getIdExpcvs());
		itemSet.setCdExpcvs(itemGet.getCdExpcvs());
		itemSet.setDsExpcvs(itemGet.getDsExpcvs());
		itemSet.setComplemento(itemGet.getComplemento());
		itemSet.setCorrentemaxima(itemGet.getCorrentemaxima());
		itemSet.setCorrenteminima(itemGet.getCorrenteminima());
		itemSet.setDthrFentrada(itemGet.getDthrFentrada());
		itemSet.setDthrFreprocesso(itemGet.getDthrFreprocesso());
		itemSet.setDthrIentrada(itemGet.getDthrIentrada());
		itemSet.setDthrIreprocesso(itemGet.getDthrIreprocesso());
		itemSet.setIsApenascomfalha(itemGet.getIsApenascomfalha());
		itemSet.setIsApenascomfalhareprocesso(itemGet.getIsApenascomfalhareprocesso());
		itemSet.setIsApenassucessoreprocesso(itemGet.getIsApenassucessoreprocesso());
		itemSet.setNseriefinal(itemGet.getNseriefinal());
		itemSet.setNserieincial(itemGet.getNserieincial());
		itemSet.setQtLinhasporarquivo(itemGet.getQtLinhasporarquivo());
		itemSet.setQtTotallinhas(itemGet.getQtTotallinhas());
		itemSet.setSku(itemGet.getSku());
		itemSet.setStFluxoentrada(itemGet.getStFluxoentrada());
		itemSet.setStFluxosaida(itemGet.getStFluxosaida());
		itemSet.setTensaomaxima(itemGet.getTensaomaxima());
		itemSet.setTensaominima(itemGet.getTensaominima());
		itemSet.setTpExportacao(itemGet.getTpExportacao());
		
		if (itemGet.getDwFtEtapa() != null){
			itemSet.setDwFtEtapa((DwFtEtapa)itemGet.getDwFtEtapa().clone());
		}
		if (itemGet.getDwTAcao() != null){
			itemSet.setDwTAcao((DwTAcao)itemGet.getDwTAcao().clone());
		}
		if (itemGet.getDwTDefeitoByIdTdefeito() != null){
			itemSet.setDwTDefeitoByIdTdefeito((DwTDefeito)itemGet.getDwTDefeitoByIdTdefeito().clone());
		}
		if (itemGet.getDwTDefeitoByIdTdefeitoreprocesso() != null){
			itemSet.setDwTDefeitoByIdTdefeitoreprocesso((DwTDefeito)itemGet.getDwTDefeitoByIdTdefeitoreprocesso().clone());
		}
		if (itemGet.getOmProduto() != null){
			itemSet.setOmProduto((OmProduto)itemGet.getOmProduto().clone());
		}
		if (itemGet.getOmPt() != null){
			itemSet.setOmPt(itemGet.getOmPt().clone());
		}
		if (itemGet.getOmUsrByIdUsroperador() != null){
			itemSet.setOmUsrByIdUsroperador(itemGet.getOmUsrByIdUsroperador().clone());
		}
		if (itemGet.getOmUsrByIdUsrsupervisor() != null){
			itemSet.setOmUsrByIdUsrsupervisor(itemGet.getOmUsrByIdUsrsupervisor().clone());
		}
		
		return itemSet;

	  }
	
	public void copy(DwExpcvs itemGet,boolean copiarFK){
		DwExpcvs itemSet = (DwExpcvs) this;
		
		itemSet.setCdExpcvs(itemGet.getCdExpcvs());
		itemSet.setDsExpcvs(itemGet.getDsExpcvs());
		itemSet.setComplemento(itemGet.getComplemento());
		itemSet.setCorrentemaxima(itemGet.getCorrentemaxima());
		itemSet.setCorrenteminima(itemGet.getCorrenteminima());
		itemSet.setDthrFentrada(itemGet.getDthrFentrada());
		itemSet.setDthrFreprocesso(itemGet.getDthrFreprocesso());
		itemSet.setDthrIentrada(itemGet.getDthrIentrada());
		itemSet.setDthrIreprocesso(itemGet.getDthrIreprocesso());
		itemSet.setIsApenascomfalha(itemGet.getIsApenascomfalha());
		itemSet.setIsApenascomfalhareprocesso(itemGet.getIsApenascomfalhareprocesso());
		itemSet.setIsApenassucessoreprocesso(itemGet.getIsApenassucessoreprocesso());
		itemSet.setNseriefinal(itemGet.getNseriefinal());
		itemSet.setNserieincial(itemGet.getNserieincial());
		itemSet.setQtLinhasporarquivo(itemGet.getQtLinhasporarquivo());
		itemSet.setQtTotallinhas(itemGet.getQtTotallinhas());
		itemSet.setSku(itemGet.getSku());
		itemSet.setStFluxoentrada(itemGet.getStFluxoentrada());
		itemSet.setStFluxosaida(itemGet.getStFluxosaida());
		itemSet.setTensaomaxima(itemGet.getTensaomaxima());
		itemSet.setTensaominima(itemGet.getTensaominima());
		itemSet.setTpExportacao(itemGet.getTpExportacao());
		
		if (copiarFK){
		}
		
	}
}
