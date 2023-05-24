package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioIndiceParadaAreaRespDTO {
	
	private List<RelatorioIndiceParadaAreaResponsavelDTO> areaResponsavelDTOs;
	private String tempoTotalParadas;
	private String tempoTotalParadasSP;
	private String tempoTotalParadasCP;
	public List<RelatorioIndiceParadaAreaResponsavelDTO> getAreaResponsavelDTOs() {
		return areaResponsavelDTOs;
	}
	public void setAreaResponsavelDTOs(
			List<RelatorioIndiceParadaAreaResponsavelDTO> areaResponsavelDTOs) {
		this.areaResponsavelDTOs = areaResponsavelDTOs;
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
