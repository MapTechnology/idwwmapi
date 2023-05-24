package idw.model.pojos.template;

import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwFtSub;
import idw.model.pojos.OmUsr;


public abstract class DwFtEtapaTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwFtEtapa itemGet = (DwFtEtapa) this;
		
		DwFtEtapa itemSet = new DwFtEtapa();
		itemSet.setIdFtEtapa(itemGet.getIdFtEtapa());
		itemSet.setCdEtapa(itemGet.getCdEtapa());
		itemSet.setDsEtapa(itemGet.getDsEtapa());
		itemSet.setDsMensagemnok(itemGet.getDsMensagemnok());
		itemSet.setDsMensagemok(itemGet.getDsMensagemok());
		itemSet.setDtRevisao(itemGet.getDtRevisao());
		itemSet.setDtStativo(itemGet.getDtStativo());
		
		
		OmUsr omUsrRev = new OmUsr();
		try {
			omUsrRev.setCdUsr(itemGet.getOmUsrByIdUsrrevisao().getCdUsr());
			omUsrRev.setDsNome(itemGet.getOmUsrByIdUsrrevisao().getDsNome());
		} catch (Exception e) {
			
		}		
		itemSet.setOmUsrByIdUsrrevisao(omUsrRev);

		OmUsr omUsrSt = new OmUsr();
		try {
			omUsrSt.setCdUsr(itemGet.getOmUsrByIdUsrstativo().getCdUsr());
			omUsrSt.setDsNome(itemGet.getOmUsrByIdUsrstativo().getDsNome());
		} catch (Exception e) {
			
		}		
		itemSet.setOmUsrByIdUsrstativo(omUsrSt);		
				
		itemSet.setRevisao(itemGet.getRevisao());
		itemSet.setStAtivo(itemGet.getStAtivo());
		
		return itemSet;

	  }
	
	public void copy(DwFtEtapa itemGet,boolean copiarFK){
		DwFtEtapa itemSet = (DwFtEtapa) this;
		itemSet.setIdFtEtapa(itemGet.getIdFtEtapa());
		itemSet.setCdEtapa(itemGet.getCdEtapa());
		itemSet.setDsEtapa(itemGet.getDsEtapa());
		itemSet.setDsMensagemnok(itemGet.getDsMensagemnok());
		itemSet.setDsMensagemok(itemGet.getDsMensagemok());
		itemSet.setDtRevisao(itemGet.getDtRevisao());
		itemSet.setDtStativo(itemGet.getDtStativo());
		itemSet.setRevisao(itemGet.getRevisao());
		itemSet.setStAtivo(itemGet.getStAtivo().byteValue());
		
		
		if (copiarFK){
			itemSet.setOmUsrByIdUsrrevisao(itemGet.getOmUsrByIdUsrrevisao());
			itemSet.setOmUsrByIdUsrstativo(itemGet.getOmUsrByIdUsrstativo());
			for (DwFtSub sub : itemGet.getDwFtSubs()){
				itemSet.getDwFtSubs().add((DwFtSub) sub.clone());
			}
		}
		
	}
}
