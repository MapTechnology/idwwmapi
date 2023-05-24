package idw.webservices.rest.idw.v2.dto;

import java.math.BigDecimal;

public class AnaliseTurnoCiclosDTO {
	private BigDecimal efic;
	private BigDecimal perdasCic;
	private BigDecimal efiInst;
	
	public BigDecimal getEfic() {
		return efic;
	}
	public void setEfic(BigDecimal efic) {
		this.efic = efic;
	}
	public BigDecimal getPerdasCic() {
		return perdasCic;
	}
	public void setPerdasCic(BigDecimal perdasCic) {
		this.perdasCic = perdasCic;
	}
	public BigDecimal getEfiInst() {
		return efiInst;
	}
	public void setEfiInst(BigDecimal efiInst) {
		this.efiInst = efiInst;
	}

}
