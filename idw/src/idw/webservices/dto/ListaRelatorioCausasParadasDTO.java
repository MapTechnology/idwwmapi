package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioCausasParadasDTO {

	private List<RelatorioCausasParadasDTO> paradasDTOs;
	private String tempoTotalParadas;
	private String tempoTotalParadasSP;
	private String tempoTotalParadasCP;
	
	public List<RelatorioCausasParadasDTO> getParadasDTOs() {
		return paradasDTOs;
	}
	public void setParadasDTOs(List<RelatorioCausasParadasDTO> paradasDTOs) {
		this.paradasDTOs = paradasDTOs;
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
