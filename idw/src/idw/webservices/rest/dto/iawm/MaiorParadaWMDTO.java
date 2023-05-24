package idw.webservices.rest.dto.iawm;

import java.math.BigDecimal;

public class MaiorParadaWMDTO {
	private String cdParada;
	private String dsParada;
	private BigDecimal tempoParCP;
	private String tempoCPFormatado;
	private boolean isTendenciaAlta;
	
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
	public BigDecimal getTempoParCP() {
		return tempoParCP;
	}
	public void setTempoParCP(BigDecimal tempoParCP) {
		this.tempoParCP = tempoParCP;
	}
	public String getTempoCPFormatado() {
		return tempoCPFormatado;
	}
	public void setTempoCPFormatado(String tempoCPFormatado) {
		this.tempoCPFormatado = tempoCPFormatado;
	}
	public boolean isTendenciaAlta() {
		return isTendenciaAlta;
	}
	public void setTendenciaAlta(boolean isTendenciaAlta) {
		this.isTendenciaAlta = isTendenciaAlta;
	}
	
	
}
