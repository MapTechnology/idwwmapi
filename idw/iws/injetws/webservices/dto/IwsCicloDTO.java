package injetws.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class IwsCicloDTO implements Serializable {

	private Double vlEficUltCiclo; //para uso no andon configuravel
	private boolean cicloValido;
	private BigDecimal numeroCiclosCont;
	private boolean finaizouOP=false;
	
	public boolean isFinaizouOP() {
		return finaizouOP;
	}

	public void setFinaizouOP(boolean finaizouOP) {
		this.finaizouOP = finaizouOP;
	}

	public void setVlEficUltCiclo(Double vlEficUltCiclo) {
		this.vlEficUltCiclo = vlEficUltCiclo;
	}

	public Double getVlEficUltCiclo() {
		return vlEficUltCiclo;
	}

	public void setCicloValido(boolean cicloValido) {
		this.cicloValido = cicloValido;
	}

	public boolean getCicloValido() {
		return cicloValido;
	}

	public void setNumeroCiclosCont(BigDecimal numeroCiclosCont) {
		this.numeroCiclosCont = numeroCiclosCont;
	}

	public BigDecimal getNumeroCiclosCont() {
		return numeroCiclosCont;
	}
}
