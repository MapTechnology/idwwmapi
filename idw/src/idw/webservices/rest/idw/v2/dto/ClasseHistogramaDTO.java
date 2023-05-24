package idw.webservices.rest.idw.v2.dto;

import java.math.BigDecimal;

public class ClasseHistogramaDTO {
	private Long numero;
	private BigDecimal lie;
	private BigDecimal lse;
	private BigDecimal pontoMedio;
	private Long frequencia;
	private BigDecimal amplitude;
	private BigDecimal amplitudeClasse;
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public BigDecimal getLie() {
		return lie;
	}
	public void setLie(BigDecimal lie) {
		this.lie = lie;
	}
	public BigDecimal getLse() {
		return lse;
	}
	public void setLse(BigDecimal lse) {
		this.lse = lse;
	}
	public BigDecimal getPontoMedio() {
		return pontoMedio;
	}
	public void setPontoMedio(BigDecimal pontoMedio) {
		this.pontoMedio = pontoMedio;
	}
	public Long getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Long frequencia) {
		this.frequencia = frequencia;
	}
	public BigDecimal getAmplitude() {
		return amplitude;
	}
	public void setAmplitude(BigDecimal amplitude) {
		this.amplitude = amplitude;
	}
	public BigDecimal getAmplitudeClasse() {
		return amplitudeClasse;
	}
	public void setAmplitudeClasse(BigDecimal amplitudeClasse) {
		this.amplitudeClasse = amplitudeClasse;
	}
}
