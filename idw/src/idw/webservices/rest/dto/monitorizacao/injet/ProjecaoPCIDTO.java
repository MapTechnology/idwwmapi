package idw.webservices.rest.dto.monitorizacao.injet;

import java.math.BigDecimal;

public class ProjecaoPCIDTO {
	private BigDecimal qtdCiclosExec = BigDecimal.ZERO;
	private BigDecimal segProjPCI = BigDecimal.ZERO;
	public BigDecimal getQtdCiclosExec() {
		return qtdCiclosExec;
	}
	public void setQtdCiclosExec(BigDecimal qtdCiclosExec) {
		this.qtdCiclosExec = qtdCiclosExec;
	}
	public BigDecimal getSegProjPCI() {
		return segProjPCI;
	}
	public void setSegProjPCI(BigDecimal segProjPCI) {
		this.segProjPCI = segProjPCI;
	}
}
