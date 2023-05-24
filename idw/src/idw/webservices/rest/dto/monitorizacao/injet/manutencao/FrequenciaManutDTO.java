package idw.webservices.rest.dto.monitorizacao.injet.manutencao;

import java.util.List;

public class FrequenciaManutDTO {
	private String cdRecurso;
	private List<FrequenciaCheckListDTO> frequencias;
	public String getCdRecurso() {
		return cdRecurso;
	}
	public void setCdRecurso(String cdRecurso) {
		this.cdRecurso = cdRecurso;
	}
	public List<FrequenciaCheckListDTO> getFrequencias() {
		return frequencias;
	}
	public void setFrequencias(List<FrequenciaCheckListDTO> frequencias) {
		this.frequencias = frequencias;
	}
	
	
}
