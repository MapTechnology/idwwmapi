package idw.webservices.dto;

import java.util.List;

public class GraficoBIParetoDetCiclosOrdemProdutoDTO {

	private String cdProduto;
    private String dsProduto;
    private Double qtdEmUB; 
    private Double qtdEmKg;
    private Double qtdEmTon;
    private Double qtdEmUM;    
    private Double qtdCiclosExecutados;
    private Double segCiclosProdutivos;
    
    private List<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO> fictec;
    
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
	
	public Double getQtdCiclosExecutados() {
		return qtdCiclosExecutados;
	}
	public void setQtdCiclosExecutados(Double qtdCiclosExecutados) {
		this.qtdCiclosExecutados = qtdCiclosExecutados;
	}
	public Double getSegCiclosProdutivos() {
		return segCiclosProdutivos;
	}
	public void setSegCiclosProdutivos(Double segCiclosProdutivos) {
		this.segCiclosProdutivos = segCiclosProdutivos;
	}
	public List<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO> getFictec() {
		return fictec;
	}
	public void setFictec(
			List<GraficoBIParetoDetCiclosOrdemProdutoFicTecDTO> fictec) {
		this.fictec = fictec;
	}

    
}
