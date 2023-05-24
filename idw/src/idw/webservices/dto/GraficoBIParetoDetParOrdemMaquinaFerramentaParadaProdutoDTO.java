package idw.webservices.dto;

public class GraficoBIParetoDetParOrdemMaquinaFerramentaParadaProdutoDTO {

	private String cdProduto;
	private String dsProduto;
	
	private Double qtPerdasUB;
	private Double qtPerdasKg;
	private Double qtPerdasTon;
	private Double qtPerdasUM;
	
	private Double qtProd;
	private Double qtPrev;
	private Double indPerda;
 	
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
	
}
