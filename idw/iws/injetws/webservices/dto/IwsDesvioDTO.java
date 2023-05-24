package injetws.webservices.dto;

import java.io.Serializable;

public class IwsDesvioDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idDesvio;
	private String cdDesvio;
	private Integer idRevisao;

	public String getCdDesvio() {
		return cdDesvio;
	}

	public void setCdDesvio(String cdDesvio) {
		this.cdDesvio = cdDesvio;
	}

	public Integer getIdDesvio() {
		return idDesvio;
	}

	public void setIdDesvio(Integer idDesvio) {
		this.idDesvio = idDesvio;
	}

	public Integer getIdRevisao() {
		return idRevisao;
	}

	public void setIdRevisao(Integer idRevisao) {
		this.idRevisao = idRevisao;
	}

}
