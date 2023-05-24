package idw.webservices.dto;

import java.util.List;

public class GraficoBIParetoDetCiclosOrdemMaquinaFerramentaDTO {
	
    private String cdFerramenta;
    private String dsFerramenta;
    private Double cicloPadrao;
    private Double cicloMedio;
    private Double qtdCiclosExecutados;
    private Double segCiclosProdutivos;
    private Double qtdEmUB; // unidade básica de contagem
    private Double qtdEmKg;
    private Double qtdEmTon;
    private Double qtdEmUM; // unidade monetária  
    
    private List<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO> produtos;
    
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
	public Double getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(Double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
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
	
	public Double getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(Double cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public Double getSegCiclosProdutivos() {
		return segCiclosProdutivos;
	}
	public void setSegCiclosProdutivos(Double segCiclosProdutivos) {
		this.segCiclosProdutivos = segCiclosProdutivos;
	}
	public List<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<GraficoBIParetoDetCiclosOrdemMaquinaFerramentaProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	public Double getQtdCiclosExecutados() {
		return qtdCiclosExecutados;
	}
	public void setQtdCiclosExecutados(Double qtdCiclosExecutados) {
		this.qtdCiclosExecutados = qtdCiclosExecutados;
	}
    
}
