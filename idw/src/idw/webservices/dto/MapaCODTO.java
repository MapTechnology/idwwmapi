package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import idw.model.rn.alimentacao.RealimentacaoDTO;

public class MapaCODTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cdMapa;
	private String mascaraQtd;	
	private long idMapa;
	private Boolean isControlarNivelAlimentacao;
	private Boolean isAlimentacaoCorrenteExclusiva = false;
	
	private List<RealimentacaoDTO> pas;

	
	public Boolean getIsAlimentacaoCorrenteExclusiva() {
		return isAlimentacaoCorrenteExclusiva;
	}
	public void setIsAlimentacaoCorrenteExclusiva(
			Boolean isAlimentacaoCorrenteExclusiva) {
		this.isAlimentacaoCorrenteExclusiva = isAlimentacaoCorrenteExclusiva;
	}
	
	public String getCdMapa() {
		return cdMapa;
	}
	public void setCdMapa(String cdMapa) {
		this.cdMapa = cdMapa;
	}
	public long getIdMapa() {
		return idMapa;
	}
	public void setIdMapa(long idMapa) {
		this.idMapa = idMapa;
	}
	public Boolean getIsControlarNivelAlimentacao() {
		return isControlarNivelAlimentacao;
	}
	public void setIsControlarNivelAlimentacao(Boolean isControlarNivelAlimentacao) {
		this.isControlarNivelAlimentacao = isControlarNivelAlimentacao;
	}	
	public String getMascaraQtd() {
		return mascaraQtd;
	}
	public void setMascaraQtd(String mascaraQtd) {
		this.mascaraQtd = mascaraQtd;
	}
	public List<RealimentacaoDTO> getPas() {
		return pas;
	}
	public void setPas(List<RealimentacaoDTO> pas) {
		this.pas = pas;
	}

}
