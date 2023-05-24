package idw.webservices.rest.dto.monitorizacao.injet.manutencao;

import java.math.BigDecimal;

public class AcumTempoDispSemParManutDTO {
	private String cdRecurso;
	private BigDecimal tempo;
	
	public String getCdRecurso() {
		return cdRecurso;
	}
	public void setCdRecurso(String cdRecurso) {
		this.cdRecurso = cdRecurso;
	}
	public BigDecimal getTempo() {
		return tempo;
	}
	public void setTempo(BigDecimal tempo) {
		this.tempo = tempo;
	}
	
	
}
