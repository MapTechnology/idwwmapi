package idw.webservices.rest.idw.v2.dto;

import java.math.BigDecimal;

public class MetaIndicadorDTO2 {
	private BigDecimal limInf = BigDecimal.ZERO;
	private BigDecimal limSup = BigDecimal.ZERO;
	private BigDecimal limMeta = BigDecimal.ZERO;
	private Boolean metaMaisAltaMelhor;
	
	public BigDecimal getLimInf() {
		return limInf;
	}
	public void setLimInf(BigDecimal limInf) {
		this.limInf = limInf;
	}
	public BigDecimal getLimSup() {
		return limSup;
	}
	public void setLimSup(BigDecimal limSup) {
		this.limSup = limSup;
	}
	public BigDecimal getLimMeta() {
		return limMeta;
	}
	public void setLimMeta(BigDecimal limMeta) {
		this.limMeta = limMeta;
	}
	public Boolean isMetaMaisAltaMelhor() {
		return metaMaisAltaMelhor;
	}
	public void setMetaMaisAltaMelhor(Boolean metaMaisAltaMelhor) {
		this.metaMaisAltaMelhor = metaMaisAltaMelhor;
	}
	
	
}
