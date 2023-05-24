package idw.webservices.dto;

import java.util.Date;

public class GraficoCicloDTO {
	private Double eficRealizacao;
	private Double eficVel;
	private Double indRefugos;
	private Double indParadas;
	private Double indPerdas;
	private Double indAcurAtivas;
	private Double produtividadeOEE;
	private Date dtReferencia;
	
	private Double qtdPerdasCiclo;
	private Double qtdPerdasRefugo;
	private Double qtdPerdasParada;
	private Double qtdPerdasPcsCicInativas;
	private Double qtdPerdasTotais;

	private String cdPt;
	private String dsPt;
	
	private String cdProduto;
	private String dsProduto;
	
	
	public Double getEficRealizacao() {
		return eficRealizacao;
	}
	public void setEficRealizacao(Double eficRealizacao) {
		this.eficRealizacao = eficRealizacao;
	}
	public Double getEficVel() {
		return eficVel;
	}
	public void setEficVel(Double eficVel) {
		this.eficVel = eficVel;
	}
	public Double getIndRefugos() {
		return indRefugos;
	}
	public void setIndRefugos(Double indRefugos) {
		this.indRefugos = indRefugos;
	}
	public Double getIndParadas() {
		return indParadas;
	}
	public void setIndParadas(Double indParadas) {
		this.indParadas = indParadas;
	}
	public Double getIndPerdas() {
		return indPerdas;
	}
	public void setIndPerdas(Double indPerdas) {
		this.indPerdas = indPerdas;
	}
	public Double getProdutividadeOEE() {
		return produtividadeOEE;
	}
	public void setProdutividadeOEE(Double produtividadeOEE) {
		this.produtividadeOEE = produtividadeOEE;
	}
	public Double getIndAcurAtivas() {
		return indAcurAtivas;
	}
	public void setIndAcurAtivas(Double indAcurAtivas) {
		this.indAcurAtivas = indAcurAtivas;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public Double getQtdPerdasCiclo() {
		return qtdPerdasCiclo;
	}
	public void setQtdPerdasCiclo(Double qtdPerdasCiclo) {
		this.qtdPerdasCiclo = qtdPerdasCiclo;
	}
	public Double getQtdPerdasRefugo() {
		return qtdPerdasRefugo;
	}
	public void setQtdPerdasRefugo(Double qtdPerdasRefugo) {
		this.qtdPerdasRefugo = qtdPerdasRefugo;
	}
	public Double getQtdPerdasParada() {
		return qtdPerdasParada;
	}
	public void setQtdPerdasParada(Double qtdPerdasParada) {
		this.qtdPerdasParada = qtdPerdasParada;
	}
	public Double getQtdPerdasPcsCicInativas() {
		return qtdPerdasPcsCicInativas;
	}
	public void setQtdPerdasPcsCicInativas(Double qtdPerdasPcsCicInativas) {
		this.qtdPerdasPcsCicInativas = qtdPerdasPcsCicInativas;
	}
	public Double getQtdPerdasTotais() {
		return qtdPerdasTotais;
	}
	public void setQtdPerdasTotais(Double qtdPerdasTotais) {
		this.qtdPerdasTotais = qtdPerdasTotais;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
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
	 
}
