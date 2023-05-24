package idw.webservices.rest.idw.v2.dto;

import java.math.BigDecimal;

public class AnaliseTurnoProducaoDTO {
	private BigDecimal efiRea;
	private BigDecimal oee;
	private BigDecimal indPerdas;
	private BigDecimal prodPlan;
	private BigDecimal prodPrev;
	private BigDecimal prodLiq;
	private BigDecimal prodPerdas;
	public BigDecimal getEfiRea() {
		return efiRea;
	}
	public void setEfiRea(BigDecimal efiRea) {
		this.efiRea = efiRea;
	}
	public BigDecimal getOee() {
		return oee;
	}
	public void setOee(BigDecimal oee) {
		this.oee = oee;
	}
	public BigDecimal getIndPerdas() {
		return indPerdas;
	}
	public void setIndPerdas(BigDecimal indPerdas) {
		this.indPerdas = indPerdas;
	}
	public BigDecimal getProdPlan() {
		return prodPlan;
	}
	public void setProdPlan(BigDecimal prodPlan) {
		this.prodPlan = prodPlan;
	}
	public BigDecimal getProdPrev() {
		return prodPrev;
	}
	public void setProdPrev(BigDecimal prodPrev) {
		this.prodPrev = prodPrev;
	}
	public BigDecimal getProdLiq() {
		return prodLiq;
	}
	public void setProdLiq(BigDecimal prodLiq) {
		this.prodLiq = prodLiq;
	}
	public BigDecimal getProdPerdas() {
		return prodPerdas;
	}
	public void setProdPerdas(BigDecimal prodPerdas) {
		this.prodPerdas = prodPerdas;
	}
	
	
}
