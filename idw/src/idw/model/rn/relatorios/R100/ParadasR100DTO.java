package idw.model.rn.relatorios.R100;

import java.io.Serializable;

public class ParadasR100DTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private String cdParada;
	private String dsParada;
	private String tempoParadaFormatada;
	private Double tempoParada;
	
	
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
	public String getTempoParadaFormatada() {
		return tempoParadaFormatada;
	}
	public void setTempoParadaFormatada(String tempoParadaFormatada) {
		this.tempoParadaFormatada = tempoParadaFormatada;
	}
	public Double getTempoParada() {
		return tempoParada;
	}
	public void setTempoParada(Double tempoParada) {
		this.tempoParada = tempoParada;
	}
}
