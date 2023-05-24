package idw.webservices.dto;

import java.util.List;

public class GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoDTO {
	private String cdProduto;
    private String dsProduto;
    
    private Double qtdRefEmUB; 
    private Double qtdRefEmKg;
    private Double qtdRefEmTon;
    private Double qtdRefEmUM;    

    private Double qtdPrev;
    private Double qtdProd;
    
    private Double indRef;
    
    private List<GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO> refugos;
    
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
	}	public Double getQtdProd() {
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
	public List<GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO> getRefugos() {
		return refugos;
	}
	public void setRefugos(
			List<GraficoBIParetoDetRefOrdemMaquinaFerramentaProdutoRefugoDTO> refugos) {
		this.refugos = refugos;
	}
	
	
}
