package idw.webservices.rest.dto.monitorizacao.injet.manutencao;

import java.math.BigDecimal;

public class AcumuladoManutencaoDTO {
	private String cdRecurso;
	private BigDecimal qtdCicExec;
	private BigDecimal hrsTrabEmSeg;
	
	public String getCdRecurso() {
		return cdRecurso;
	}
	public void setCdRecurso(String cdRecurso) {
		this.cdRecurso = cdRecurso;
	}
	public BigDecimal getQtdCicExec() {
		return qtdCicExec;
	}
	public void setQtdCicExec(BigDecimal qtdCicExec) {
		this.qtdCicExec = qtdCicExec;
	}
	public BigDecimal getHrsTrabEmSeg() {
		return hrsTrabEmSeg;
	}
	public void setHrsTrabEmSeg(BigDecimal hrsTrabEmSeg) {
		this.hrsTrabEmSeg = hrsTrabEmSeg;
	}
	
	
}
