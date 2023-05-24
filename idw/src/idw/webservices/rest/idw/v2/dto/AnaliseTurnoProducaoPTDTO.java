package idw.webservices.rest.idw.v2.dto;

import java.math.BigDecimal;

public class AnaliseTurnoProducaoPTDTO {
	private String cdPt;
	private BigDecimal efiRea;
	private BigDecimal efiCic;
	private BigDecimal indQtdAloc;
	private BigDecimal prodPlan;
	private BigDecimal prodPrev;
	private BigDecimal prodBruta;
	private BigDecimal prodRef;
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public BigDecimal getEfiRea() {
		return efiRea;
	}
	public void setEfiRea(BigDecimal efiRea) {
		this.efiRea = efiRea;
	}
	public BigDecimal getEfiCic() {
		return efiCic;
	}
	public void setEfiCic(BigDecimal efiCic) {
		this.efiCic = efiCic;
	}
	public BigDecimal getIndQtdAloc() {
		return indQtdAloc;
	}
	public void setIndQtdAloc(BigDecimal indQtdAloc) {
		this.indQtdAloc = indQtdAloc;
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
	public BigDecimal getProdBruta() {
		return prodBruta;
	}
	public void setProdBruta(BigDecimal prodBruta) {
		this.prodBruta = prodBruta;
	}
	public BigDecimal getProdRef() {
		return prodRef;
	}
	public void setProdRef(BigDecimal prodRef) {
		this.prodRef = prodRef;
	}	
}
