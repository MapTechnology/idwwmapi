package idw.model.pojos.template;

import idw.model.pojos.DwFolha;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;


public abstract class OmMapaTemplate implements Cloneable{
	
	public OmMapa clone(boolean isCopiarFK) {
		if (isCopiarFK) {
			return (OmMapa) clone();
		} else {
			OmMapa omMapa = (OmMapa) this;
			OmMapa clone = new OmMapa();
			clone.copy(omMapa, false);
			return clone;
		}
	}
	
	@Override
	public Object clone() {
		OmMapa omMapa = (OmMapa) this;
	    
	    OmMapa clone = new OmMapa();
	    
	    clone.copy(omMapa, false);
	    
	    OmPt omPt = new OmPt();
		try {
			omPt.setIdPt(omMapa.getOmPt().getIdPt());
			omPt.setCdPt(omMapa.getOmPt().getCdPt());
			omPt.setDsPt(omMapa.getOmPt().getDsPt());
		} catch (Exception e) {
			
		}				
		clone.setOmPt(omPt);
		
		OmProduto omProduto = new OmProduto();
		try {
			omProduto.setCdProduto(omMapa.getOmProduto().getCdProduto());
			omProduto.setDsProduto(omMapa.getOmProduto().getDsProduto());
		} catch (Exception e) {
			
		}				
		clone.setOmProduto(omProduto);
		
		OmPrg omPrg = new OmPrg();
		try {
			omPrg.setCdPrg(omMapa.getOmPrg().getCdPrg());
			omPrg.setDsPrg(omMapa.getOmPrg().getDsPrg());
		} catch (Exception e) {
			
		}				
		clone.setOmPrg(omPrg);
		
		DwFolha dwfolha = new DwFolha();
		try {
			dwfolha.setCdFolha(omMapa.getDwFolha().getCdFolha());
		} catch (Exception e) {
			
		}
		clone.setDwFolha(dwfolha);

		OmUsr omUsrRev = new OmUsr();
		try {
			omUsrRev.setCdUsr(omMapa.getOmUsrByIdUsrrevisao().getCdUsr());
			omUsrRev.setDsNome(omMapa.getOmUsrByIdUsrrevisao().getDsNome());
		} catch (Exception e) {
			
		}		
		clone.setOmUsrByIdUsrrevisao(omUsrRev);

		OmUsr omUsrSt = new OmUsr();
		try {
			omUsrSt.setCdUsr(omMapa.getOmUsrByIdUsrstativo().getCdUsr());
			omUsrSt.setDsNome(omMapa.getOmUsrByIdUsrstativo().getDsNome());
		} catch (Exception e) {
			
		}		
		clone.setOmUsrByIdUsrstativo(omUsrSt);

		return clone;

    }
	
	public void copy(OmMapa omFrom, boolean copiarFK){
		OmMapa omTo = (OmMapa) this;

		omTo.setCdMapa(omFrom.getCdMapa());
		omTo.setDsMapa(omFrom.getDsMapa());
		omTo.setDtRevisao(omFrom.getDtRevisao());
		omTo.setDtStativo(omFrom.getDtStativo());
		omTo.setIdMapa(omFrom.getIdMapa());
		omTo.setRevisao(omFrom.getRevisao());
		omTo.setStAtivo(omFrom.getStAtivo());

		if (copiarFK){
			omTo.setOmPrg(omFrom.getOmPrg());
			omTo.setOmProduto(omFrom.getOmProduto());
			omTo.setOmPt(omFrom.getOmPt());
			omTo.setDwFolha(omFrom.getDwFolha());
		}

	}
}
