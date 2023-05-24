package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RelatorioGraficoTempoProdutoDTO implements Serializable {

	private String fase;
	private String corFase;
	private String tempoFase;
	private String produto;
	
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
	public String getTempoFase() {
		return tempoFase;
	}
	public void setTempoFase(String tempoFase) {
		this.tempoFase = tempoFase;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	
		
}