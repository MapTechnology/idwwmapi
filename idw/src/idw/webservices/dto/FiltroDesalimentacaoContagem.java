package idw.webservices.dto;

import idw.model.pojos.DwEstlocal;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;

public class FiltroDesalimentacaoContagem {
	
	private DwEstlocal dwEstlocal;
	private OmProduto omProduto;
	private OmPt omPt;
	
	
	public DwEstlocal getDwEstlocal() {
		return dwEstlocal;
	}
	public void setDwEstlocal(DwEstlocal dwEstlocal) {
		this.dwEstlocal = dwEstlocal;
	}
	public OmProduto getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	
}
