package idw.webservices.rest.wm.dto;

import java.io.Serializable;

public class ParadaDetalheDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idParada;
	private String cdParada;
	private String dsParada;
	private Long tempoParada;
	private String tempoParadaFormatado;

	public Long getIdParada() {
		return idParada;
	}
	public void setIdParada(Long idParada) {
		this.idParada = idParada;
	}
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	public String getDsParada() {
		return dsParada;
	}
	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
	}
	public Long getTempoParada() {
		return tempoParada;
	}
	public void setTempoParada(Long tempoParada) {
		this.tempoParada = tempoParada;
	}
	public String getTempoParadaFormatado() {
		return tempoParadaFormatado;
	}
	public void setTempoParadaFormatado(String tempoParadaFormatado) {
		this.tempoParadaFormatado = tempoParadaFormatado;
	}
	
	
}