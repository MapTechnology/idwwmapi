package idw.webservices.dto;

import java.io.Serializable;
@SuppressWarnings("serial")

public class PassmonDTO implements Serializable{

	private String cb;
	private ProdutoDTO produto;
	private Boolean isAlternativo;
	private String dsMon;

	public String getCb() {
		return cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public Boolean getIsAlternativo() {
		return isAlternativo;
	}

	public void setIsAlternativo(Boolean isAlternativo) {
		this.isAlternativo = isAlternativo;
	}

	public String getDsMon() {
		return dsMon;
	}

	public void setDsMon(String dsMon) {
		this.dsMon = dsMon;
	}

}
