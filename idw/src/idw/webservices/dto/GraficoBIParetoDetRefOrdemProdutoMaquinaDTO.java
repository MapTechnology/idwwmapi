package idw.webservices.dto;

import java.util.List;

public class GraficoBIParetoDetRefOrdemProdutoMaquinaDTO {

	private String cdMaquina;
	private String dsMaquina;
	
    private Double qtdRefEmUB; 
    private Double qtdRefEmKg;
    private Double qtdRefEmTon;
    private Double qtdRefEmUM;    

    private Double qtdPrev;
    private Double qtdProd;
    
    private Double indRef;

    List<GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO> ferramentas;

	public String getCdMaquina() {
		return cdMaquina;
	}

	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}

	public String getDsMaquina() {
		return dsMaquina;
	}

	public void setDsMaquina(String dsMaquina) {
		this.dsMaquina = dsMaquina;
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

	public List<GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(
			List<GraficoBIParetoDetRefOrdemProdutoMaquinaFerramentaDTO> ferramentas) {
		this.ferramentas = ferramentas;
	}
	
}
