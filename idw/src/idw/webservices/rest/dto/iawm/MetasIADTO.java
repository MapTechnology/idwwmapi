package idw.webservices.rest.dto.iawm;

import java.math.BigDecimal;

public class MetasIADTO {
	private BigDecimal limInf = BigDecimal.ZERO;
	private BigDecimal limSup = BigDecimal.ZERO;
	private BigDecimal limMeta = BigDecimal.ZERO;
	
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
	
	
}
