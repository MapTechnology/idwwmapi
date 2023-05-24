package idw.webservices.dto;

import java.util.List;

public class GraficoBIParetoDetParOrdemMaquinaFerramentaDTO {

	private String cdFerramenta;
	private String dsFerramenta;
	
	private Double segTempoParadas;
	private Double qtOcorrParadas;
	
	private Double qtPerdasUB;
	private Double qtPerdasKg;
	private Double qtPerdasTon;
	private Double qtPerdasUM;
	
	private Double qtProd;
	private Double qtPrev;
	private Double indPerda;
	
	private Double segTempoMicroParadas; 
	private Double qtdOcorrMicroParadas;
	private Double indMicroParadas;
	
	private List<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO> paradas;
	private List<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO> produtos;

	public String getCdFerramenta() {
		return cdFerramenta;
	}

	public void setCdFerramenta(String cdFerramenta) {
		this.cdFerramenta = cdFerramenta;
	}

	public String getDsFerramenta() {
		return dsFerramenta;
	}

	public void setDsFerramenta(String dsFerramenta) {
		this.dsFerramenta = dsFerramenta;
	}

	public Double getSegTempoParadas() {
		return segTempoParadas;
	}

	public void setSegTempoParadas(Double segTempoParadas) {
		this.segTempoParadas = segTempoParadas;
	}

	public Double getQtOcorrParadas() {
		return qtOcorrParadas;
	}

	public void setQtOcorrParadas(Double qtOcorrParadas) {
		this.qtOcorrParadas = qtOcorrParadas;
	}

	public Double getQtPerdasUB() {
		return qtPerdasUB;
	}

	public void setQtPerdasUB(Double qtPerdasUB) {
		this.qtPerdasUB = qtPerdasUB;
	}

	public Double getQtPerdasKg() {
		return qtPerdasKg;
	}

	public void setQtPerdasKg(Double qtPerdasKg) {
		this.qtPerdasKg = qtPerdasKg;
	}

	public Double getQtPerdasTon() {
		return qtPerdasTon;
	}

	public void setQtPerdasTon(Double qtPerdasTon) {
		this.qtPerdasTon = qtPerdasTon;
	}

	public Double getQtPerdasUM() {
		return qtPerdasUM;
	}

	public void setQtPerdasUM(Double qtPerdasUM) {
		this.qtPerdasUM = qtPerdasUM;
	}

	public Double getQtProd() {
		return qtProd;
	}

	public void setQtProd(Double qtProd) {
		this.qtProd = qtProd;
	}

	public Double getQtPrev() {
		return qtPrev;
	}

	public void setQtPrev(Double qtPrev) {
		this.qtPrev = qtPrev;
	}

	public Double getIndPerda() {
		return indPerda;
	}

	public void setIndPerda(Double indPerda) {
		this.indPerda = indPerda;
	}

	public List<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO> getParadas() {
		return paradas;
	}

	public void setParadas(
			List<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaDTO> paradas) {
		this.paradas = paradas;
	}

	public List<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO> produtos) {
		this.produtos = produtos;
	}

	public Double getSegTempoMicroParadas() {
		return segTempoMicroParadas;
	}

	public void setSegTempoMicroParadas(Double segTempoMicroParadas) {
		this.segTempoMicroParadas = segTempoMicroParadas;
	}

	public Double getQtdOcorrMicroParadas() {
		return qtdOcorrMicroParadas;
	}

	public void setQtdOcorrMicroParadas(Double qtdOcorrMicroParadas) {
		this.qtdOcorrMicroParadas = qtdOcorrMicroParadas;
	}

	public Double getIndMicroParadas() {
		return indMicroParadas;
	}

	public void setIndMicroParadas(Double indMicroParadas) {
		this.indMicroParadas = indMicroParadas;
	}
	
	
	
}
