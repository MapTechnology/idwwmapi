package idw.webservices.dto;

import java.util.List;

public class GraficoBIParetoDetParOrdemProdutoDTO {

	private String cdProduto;
	private String dsProduto;
	
	private Double segTempoDisponivel;
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
	
	private List<GraficoBIParetoDetParOrdemProdutoFerramentaDTO> ferramentas;

	public String getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getDsProduto() {
		return dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
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

	public List<GraficoBIParetoDetParOrdemProdutoFerramentaDTO> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(
			List<GraficoBIParetoDetParOrdemProdutoFerramentaDTO> ferramentas) {
		this.ferramentas = ferramentas;
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

    public Double getSegTempoDisponivel() {
        return segTempoDisponivel;
    }

    public void setSegTempoDisponivel(Double segTempoDisponivel) {
        this.segTempoDisponivel = segTempoDisponivel;
    }
	
	
}
