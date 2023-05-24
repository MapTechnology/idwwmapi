package idw.webservices.dto;

import idw.model.pojos.OmProcomest;

public class IntegracaoEstruturaDTO {

	private OmProcomest produto;
	int nivel;
	
	public OmProcomest getProduto() {
		return produto;
	}
	public void setProduto(OmProcomest produto) {
		this.produto = produto;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
}
