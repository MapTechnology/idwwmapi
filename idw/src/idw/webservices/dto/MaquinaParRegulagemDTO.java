package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class MaquinaParRegulagemDTO implements Serializable  {
	private String maquina;
	private List<ParRegulagemDTO> paradas;
	private String tempoParMaq;
	private Double segTempoParMaq;
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public List<ParRegulagemDTO> getParadas() {
		return paradas;
	}
	public void setParadas(List<ParRegulagemDTO> paradas) {
		this.paradas = paradas;
	}
	public String getTempoParMaq() {
		return tempoParMaq;
	}
	public void setTempoParMaq(String tempoParMaq) {
		this.tempoParMaq = tempoParMaq;
	}
	public Double getSegTempoParMaq() {
		return segTempoParMaq;
	}
	public void setSegTempoParMaq(Double segTempoParMaq) {
		this.segTempoParMaq = segTempoParMaq;
	}	
}
