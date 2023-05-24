package idw.webservices.rest.idw.v2.dto;

import java.math.BigDecimal;

public class AnaliseTurnoRefugosDTO {
	private BigDecimal indRef;
	private BigDecimal prodRef;
	
	public BigDecimal getProdRef() {
		return prodRef;
	}

	public void setProdRef(BigDecimal prodRef) {
		this.prodRef = prodRef;
	}

	public BigDecimal getIndRef() {
		return indRef;
	}

	public void setIndRef(BigDecimal indRef) {
		this.indRef = indRef;
	}
}
