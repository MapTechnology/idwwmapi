package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioOcorrenciaParadasDTO {

	private List<RelatorioOcorrenciaParadasDTO> ocorrenciaParadasDTOs;
	private String tempoTotalParadas;
	private String tempoTotalParadasSP;
	private String tempoTotalParadasCP;
	
	public List<RelatorioOcorrenciaParadasDTO> getOcorrenciaParadasDTOs() {
		return ocorrenciaParadasDTOs;
	}
	public void setOcorrenciaParadasDTOs(
			List<RelatorioOcorrenciaParadasDTO> ocorrenciaParadasDTOs) {
		this.ocorrenciaParadasDTOs = ocorrenciaParadasDTOs;
	}
	public String getTempoTotalParadas() {
		return tempoTotalParadas;
	}
	public void setTempoTotalParadas(String tempoTotalParadas) {
		this.tempoTotalParadas = tempoTotalParadas;
	}
	public String getTempoTotalParadasSP() {
		return tempoTotalParadasSP;
	}
	public void setTempoTotalParadasSP(String tempoTotalParadasSP) {
		this.tempoTotalParadasSP = tempoTotalParadasSP;
	}
	public String getTempoTotalParadasCP() {
		return tempoTotalParadasCP;
	}
	public void setTempoTotalParadasCP(String tempoTotalParadasCP) {
		this.tempoTotalParadasCP = tempoTotalParadasCP;
	}
	
}
