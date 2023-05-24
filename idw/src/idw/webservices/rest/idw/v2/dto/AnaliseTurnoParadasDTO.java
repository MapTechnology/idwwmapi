package idw.webservices.rest.idw.v2.dto;

import java.math.BigDecimal;

public class AnaliseTurnoParadasDTO {

	private BigDecimal indPar;
	private BigDecimal prodPerdasPar; 
	private String tempoPar;
	
	public BigDecimal getIndPar() {
		return indPar;
	}
	public void setIndPar(BigDecimal indPar) {
		this.indPar = indPar;
	}
	public BigDecimal getProdPerdasPar() {
		return prodPerdasPar;
	}
	public void setProdPerdasPar(BigDecimal prodPerdasPar) {
		this.prodPerdasPar = prodPerdasPar;
	}
	public String getTempoPar() {
		return tempoPar;
	}
	public void setTempoPar(String tempoPar) {
		this.tempoPar = tempoPar;
	}
	
	
}
