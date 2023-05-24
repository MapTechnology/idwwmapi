package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class RelatorioGraficoLinhaBalanceadaOperacaoDTO implements Serializable {

	private String fase;
	private String corFase;
	private Object iconeFase;
	private String posto;
	private String operacao;
	private String tempoOperacao;
	private BigDecimal segTempoOperacao;
	
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getCorFase() {
		return corFase;
	}
	public void setCorFase(String corFase) {
		this.corFase = corFase;
	}
	public Object getIconeFase() {
		return iconeFase;
	}
	public void setIconeFase(Object iconeFase) {
		this.iconeFase = iconeFase;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public String getTempoOperacao() {
		return tempoOperacao;
	}
	public void setTempoOperacao(String tempoOperacao) {
		this.tempoOperacao = tempoOperacao;
	}
	public BigDecimal getSegTempoOperacao() {
		return segTempoOperacao;
	}
	public void setSegTempoOperacao(BigDecimal segTempoOperacao) {
		this.segTempoOperacao = segTempoOperacao;
	}
}
