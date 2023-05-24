package idw.webservices.dto;

import java.util.List;

public class GraficoBIParetoDetRefOrdemMaquinaFerramentaDTO {
	
	private String cdFerramenta;
    private String dsFerramenta;
    
    private Double qtdRefEmUB; 
    private Double qtdRefEmKg;
    private Double qtdRefEmTon;
    private Double qtdRefEmUM;    

    private Double qtdPrev;
    private Double qtdProd;
    
    private Double indRef;
    
    private List<GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO> produtos;
    
    
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

	public Double getQtdRefEmUB() {
		return qtdRefEmUB;
	}
	public void setQtdRefEmUB(Double qtdRefEmUB) {
		this.qtdRefEmUB = qtdRefEmUB;
	}
	public Double getQtdRefEmKg() {
		return qtdRefEmKg;
	}
	public void setQtdRefEmKg(Double qtdRefEmKg) {
		this.qtdRefEmKg = qtdRefEmKg;
	}
	public Double getQtdRefEmTon() {
		return qtdRefEmTon;
	}
	public void setQtdRefEmTon(Double qtdRefEmTon) {
		this.qtdRefEmTon = qtdRefEmTon;
	}
	public Double getQtdRefEmUM() {
		return qtdRefEmUM;
	}
	public void setQtdRefEmUM(Double qtdRefEmUM) {
		this.qtdRefEmUM = qtdRefEmUM;
	}
	public Double getQtdPrev() {
		return qtdPrev;
	}
	public void setQtdPrev(Double qtdPrev) {
		this.qtdPrev = qtdPrev;
	}
	public Double getQtdProd() {
		return qtdProd;
	}
	public void setQtdProd(Double qtdProd) {
		this.qtdProd = qtdProd;
	}
	public Double getIndRef() {
		return indRef;
	}
	public void setIndRef(Double indRef) {
		this.indRef = indRef;
	}
	public List<GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(
			List<GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO> produtos) {
		this.produtos = produtos;
	}

}
