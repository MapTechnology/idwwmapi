package idw.webservices.rest.dto.monitorizacao.injet.bi;

import java.util.List;

public class BiParetoPerdasParadaDetalheDTO {	
	private String totalCusto;
	private String tempoDisponivel;
	private String tempoParadas;
	private String indPar;	
	private List<BiParetoPerdasParadaDetDTO> detalhes;
	
	public String getTotalCusto() {
		return totalCusto;
	}
	public void setTotalCusto(String totalCusto) {
		this.totalCusto = totalCusto;
	}
	public String getTempoDisponivel() {
		return tempoDisponivel;
	}
	public void setTempoDisponivel(String tempoDisponivel) {
		this.tempoDisponivel = tempoDisponivel;
	}
	public String getTempoParadas() {
		return tempoParadas;
	}
	public void setTempoParadas(String tempoParadas) {
		this.tempoParadas = tempoParadas;
	}
	public String getIndPar() {
		return indPar;
	}
	public void setIndPar(String indPar) {
		this.indPar = indPar;
	}
	public List<BiParetoPerdasParadaDetDTO> getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(List<BiParetoPerdasParadaDetDTO> detalhes) {
		this.detalhes = detalhes;
	}
	
	
	
}
