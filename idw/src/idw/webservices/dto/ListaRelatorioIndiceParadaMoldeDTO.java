package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioIndiceParadaMoldeDTO {

	private List<RelatorioIndiceParadasMoldeDTO> moldeDTOs;
	private String tempoAtivo;
	private String tempoTotalParadas;
	private String tempoTotalParadasSP;
	private String tempoTotalParadasCP;
	private String indiceParadas;
	
	public List<RelatorioIndiceParadasMoldeDTO> getMoldeDTOs() {
		return moldeDTOs;
	}
	public void setMoldeDTOs(List<RelatorioIndiceParadasMoldeDTO> moldeDTOs) {
		this.moldeDTOs = moldeDTOs;
	}
	public String getTempoAtivo() {
		return tempoAtivo;
	}
	public void setTempoAtivo(String tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
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
	public String getIndiceParadas() {
		return indiceParadas;
	}
	public void setIndiceParadas(String indiceParadas) {
		this.indiceParadas = indiceParadas;
	}
	
	
}
