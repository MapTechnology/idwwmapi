package idw.webservices.rest.idw.v2.dto;

import java.math.BigDecimal;

public class OPSimplesPesqDTO {
	private String nrDoc;
	private String cdPt;
	private String cdFolha;
	private String cdCliente;
	private BigDecimal prodPlan;
	private String dthrIniPlan; //ymdhms
	private String dthrFimPlan; 
	private String dthrIniRealMs; //ymdhms.m
	
	public String getNrDoc() {
		return nrDoc;
	}
	public void setNrDoc(String nrDoc) {
		this.nrDoc = nrDoc;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	public String getCdCliente() {
		return cdCliente;
	}
	public void setCdCliente(String cdCliente) {
		this.cdCliente = cdCliente;
	}
	public BigDecimal getProdPlan() {
		return prodPlan;
	}
	public void setProdPlan(BigDecimal prodPlan) {
		this.prodPlan = prodPlan;
	}
	public String getDthrIniPlan() {
		return dthrIniPlan;
	}
	public void setDthrIniPlan(String dthrIniPlan) {
		this.dthrIniPlan = dthrIniPlan;
	}
	public String getDthrFimPlan() {
		return dthrFimPlan;
	}
	public void setDthrFimPlan(String dthrFimPlan) {
		this.dthrFimPlan = dthrFimPlan;
	}
	public String getDthrIniRealMs() {
		return dthrIniRealMs;
	}
	public void setDthrIniRealMs(String dthrIniRealMs) {
		this.dthrIniRealMs = dthrIniRealMs;
	}
	
	
	
}
