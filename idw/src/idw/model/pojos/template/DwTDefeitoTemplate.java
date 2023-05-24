package idw.model.pojos.template;

import idw.model.pojos.DwTDefeito;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;


public abstract class DwTDefeitoTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		DwTDefeito dwTDefeito = (DwTDefeito) this;
		
		DwTDefeito clone = new DwTDefeito();
		clone.setIdTdefeito(dwTDefeito.getIdTdefeito());
		clone.setCdTdefeito(dwTDefeito.getCdTdefeito());
		clone.setDsTdefeito(dwTDefeito.getDsTdefeito());
		clone.setDtRevisao(dwTDefeito.getDtRevisao());
		clone.setDtStativo(dwTDefeito.getDtStativo());
		
		clone.setIsRequeracao(dwTDefeito.getIsRequeracao());
		clone.setIsLancarperdamp(dwTDefeito.getIsLancarperdamp());
		clone.setIsAutomatico(dwTDefeito.getIsAutomatico());
		
		if (dwTDefeito.getOmTppt() != null)
			clone.setOmTppt(dwTDefeito.getOmTppt().clone());
		
		if (dwTDefeito.getOmProduto() != null)
			clone.setOmProduto((OmProduto) dwTDefeito.getOmProduto().clone());
		
		OmUsr omUsrRev = new OmUsr();
		try {
			omUsrRev.setCdUsr(dwTDefeito.getOmUsrByIdUsrrevisao().getCdUsr());
			omUsrRev.setDsNome(dwTDefeito.getOmUsrByIdUsrrevisao().getDsNome());
		} catch (Exception e) {
			
		}		
		clone.setOmUsrByIdUsrrevisao(omUsrRev);

		OmUsr omUsrSt = new OmUsr();
		try {
			omUsrSt.setCdUsr(dwTDefeito.getOmUsrByIdUsrstativo().getCdUsr());
			omUsrSt.setDsNome(dwTDefeito.getOmUsrByIdUsrstativo().getDsNome());
		} catch (Exception e) {
			
		}		
		clone.setOmUsrByIdUsrstativo(omUsrSt);		
				
		clone.setRevisao(dwTDefeito.getRevisao());
		clone.setStAtivo(dwTDefeito.getStAtivo());
		
		return clone;

	  }
	
	public void copy(DwTDefeito omFrom,boolean copiarFK){
		DwTDefeito omTo = (DwTDefeito) this;
		omTo.setIdTdefeito(omFrom.getIdTdefeito());
		omTo.setCdTdefeito(omFrom.getCdTdefeito());
		omTo.setDsTdefeito(omFrom.getDsTdefeito());
		omTo.setDtRevisao(omFrom.getDtRevisao());
		omTo.setDtStativo(omFrom.getDtStativo());
		omTo.setRevisao(omFrom.getRevisao());
		omTo.setStAtivo(omFrom.getStAtivo().byteValue());
		
		omTo.setIsRequeracao(omFrom.getIsRequeracao());
		
		if (copiarFK){
			omTo.setOmTppt(omFrom.getOmTppt());
			omTo.setOmProduto(omFrom.getOmProduto());
			omTo.setOmUsrByIdUsrrevisao(omFrom.getOmUsrByIdUsrrevisao());			
			omTo.setOmUsrByIdUsrstativo(omFrom.getOmUsrByIdUsrstativo());
		}
		
	}
}
