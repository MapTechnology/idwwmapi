package idw.webservices.dto;

public class ParadaRelatorioDTO {
	
	private String parada;
	private String indiceBA;
	private String indiceCA;
	private Double tempoParada;
	private int quantidade;
	private int qtdParadaComPeso;
	private int qtdMTTR_MTBF;
	private Double segMTTR;
	private Double segMTBF;
	
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public String getIndiceBA() {
		return indiceBA;
	}
	public void setIndiceBA(String indiceBA) {
		this.indiceBA = indiceBA;
	}
	public Double getTempoParada() {
		return tempoParada;
	}
	public void setTempoParada(Double tempoParada) {
		this.tempoParada = tempoParada;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getQtdParadaComPeso() {
		return qtdParadaComPeso;
	}
	public void setQtdParadaComPeso(int qtdParadaComPeso) {
		this.qtdParadaComPeso = qtdParadaComPeso;
	}
	public String getIndiceCA() {
		return indiceCA;
	}
	public void setIndiceCA(String indiceCA) {
		this.indiceCA = indiceCA;
	}
	public int getQtdMTTR_MTBF() {
		return qtdMTTR_MTBF;
	}
	public void setQtdMTTR_MTBF(int qtdMTTR_MTBF) {
		this.qtdMTTR_MTBF = qtdMTTR_MTBF;
	}
	public Double getSegMTTR() {
		return segMTTR;
	}
	public void setSegMTTR(Double segMTTR) {
		this.segMTTR = segMTTR;
	}
	public Double getSegMTBF() {
		return segMTBF;
	}
	public void setSegMTBF(Double segMTBF) {
		this.segMTBF = segMTBF;
	}
	
}