package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.PpCm;
import idw.model.pojos.PpCmcom;


public abstract class PpCmTemplate implements Cloneable{

	@Override
	public Object clone() {
		PpCm itemGet = (PpCm) this;
		PpCm itemSet = new PpCm();
		
		itemSet.setIdCm(itemGet.getIdCm());
		itemSet.setCdCm(itemGet.getCdCm());
		itemSet.setDsCm(itemGet.getDsCm());
		itemSet.setDthrVigor(itemGet.getDthrVigor());
		itemSet.setIsConsumirmp(itemGet.getIsConsumirmp());
		
		
		itemSet.setStAtivo(itemGet.getStAtivo());
		itemSet.setRevisao(itemGet.getRevisao());
		itemSet.setDtRevisao(itemGet.getDtRevisao());
		itemSet.setDtStativo(itemGet.getDtStativo());
		
		itemSet.setOmUsrByIdUsrrevisao(itemGet.getOmUsrByIdUsrrevisao().clone());
		itemSet.setOmUsrByIdUsrstativo(itemGet.getOmUsrByIdUsrstativo().clone());
		
		itemSet.setPpCmcoms(new HashSet<PpCmcom>());
		
		itemSet.setDthrSai(itemGet.getDthrSai());
		
		for (PpCmcom ppCmcom: itemGet.getPpCmcoms()){
			itemSet.getPpCmcoms().add((PpCmcom) ppCmcom.clone());
		}
		
		
		
		return itemSet;
	}

	
}
