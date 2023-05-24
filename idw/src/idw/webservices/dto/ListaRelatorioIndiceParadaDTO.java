package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioIndiceParadaDTO {
	
	private List<RelatorioIndiceParadasDTO> indiceParadasDTO;
	private String tempoTotalParadas;
	private String tempoTotalParadasSP;
	private String tempoTotalParadasCP;
	private double tempoTotal;

	public List<RelatorioIndiceParadasDTO> getIndiceParadasDTO() {
		return indiceParadasDTO;
	}

	public void setIndiceParadasDTO(List<RelatorioIndiceParadasDTO> indiceParadasDTO) {
		this.indiceParadasDTO = indiceParadasDTO;
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

	public double getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(double tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	
}