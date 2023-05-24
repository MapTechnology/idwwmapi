package idw.webservices.dto;

import java.math.BigDecimal;



public class RelatorioCausasParadasDTO {
	
	private String parada;	
	private String causa;
    private BigDecimal duracao;
    private Integer numeroLinhaRel;
    private BigDecimal tempoTotalCausa;
	
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public BigDecimal getDuracao() {
		return duracao;
	}
	public void setDuracao(BigDecimal duracao) {
		this.duracao = duracao;
	}
	public Integer getNumeroLinhaRel() {
		return numeroLinhaRel;	
	}
	public void setNumeroLinhaRel(Integer numeroLinhaRel) {
		this.numeroLinhaRel = numeroLinhaRel;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public BigDecimal getTempoTotalCausa() {
		return tempoTotalCausa;
	}
	public void setTempoTotalCausa(BigDecimal tempoTotalCausa) {
		this.tempoTotalCausa = tempoTotalCausa;
	}
    
}
