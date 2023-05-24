package idw.webservices.dto;

public class GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO 
{
	
	private String cdProduto;
    private String dsProduto;
    private Double qtdEmUB; // unidade básica de contagem
    private Double qtdEmKg;
    private Double qtdEmTon;
    private Double qtdEmUM; // unidade monetária    
    
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
	public Double getQtdEmUB() {
		return qtdEmUB;
	}
	public void setQtdEmUB(Double qtdEmUB) {
		this.qtdEmUB = qtdEmUB;
	}
	public Double getQtdEmKg() {
		return qtdEmKg;
	}
	public void setQtdEmKg(Double qtdEmKg) {
		this.qtdEmKg = qtdEmKg;
	}
	public Double getQtdEmTon() {
		return qtdEmTon;
	}
	public void setQtdEmTon(Double qtdEmTon) {
		this.qtdEmTon = qtdEmTon;
	}
	public Double getQtdEmUM() {
		return qtdEmUM;
	}
	public void setQtdEmUM(Double qtdEmUM) {
		this.qtdEmUM = qtdEmUM;
	}


}
