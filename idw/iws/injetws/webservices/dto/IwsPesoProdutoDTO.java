package injetws.webservices.dto;

import java.math.BigDecimal;

public class IwsPesoProdutoDTO {

	private IwsErroDTO status;
	private BigDecimal pliquidomedio;
	private BigDecimal pbrutomedio;
	
	public IwsPesoProdutoDTO() {
		this.status = new IwsErroDTO();
	}
	
	public IwsErroDTO getStatus() {
		return status;
	}
	public void setStatus(IwsErroDTO status) {
		this.status = status;
	}
	public BigDecimal getPliquidomedio() {
		return pliquidomedio;
	}
	public void setPliquidomedio(BigDecimal pliquidomedio) {
		this.pliquidomedio = pliquidomedio;
	}
	public BigDecimal getPbrutomedio() {
		return pbrutomedio;
	}
	public void setPbrutomedio(BigDecimal pbrutomedio) {
		this.pbrutomedio = pbrutomedio;
	}	
	
}
