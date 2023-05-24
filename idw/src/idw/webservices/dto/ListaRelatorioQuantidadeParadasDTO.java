package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioQuantidadeParadasDTO {

	private List<RelatorioQuantidadeParadasDTO> paradasDTOs;
	private String qtdTotal;
	private String tempoTotalParadas;
	private String tempoTotalParadasSP;
	private String tempoTotalParadasCP;
	
	public List<RelatorioQuantidadeParadasDTO> getParadasDTOs() {
		return paradasDTOs;
	}
	public void setParadasDTOs(List<RelatorioQuantidadeParadasDTO> paradasDTOs) {
		this.paradasDTOs = paradasDTOs;
	}
	public String getQtdTotal() {
		return qtdTotal;
	}
	public void setQtdTotal(String qtdTotal) {
		this.qtdTotal = qtdTotal;
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
