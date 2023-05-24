package idw.webservices.dto;

import java.math.BigDecimal;



public class RelatorioQuantidadeParadasDTO {
	
	private String parada;	
	private String areaResp;
	private String quantidade;
    private BigDecimal duracao;
    private Integer numeroLinhaRel;
	
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
	public String getAreaResp() {
		return areaResp;
	}
	public void setAreaResp(String areaResp) {
		this.areaResp = areaResp;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public void setNumeroLinhaRel(Integer numeroLinhaRel) {
		this.numeroLinhaRel = numeroLinhaRel;
	}
    
}
