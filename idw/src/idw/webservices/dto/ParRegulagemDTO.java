package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ParRegulagemDTO  implements Serializable{
	private String maquina;
	private String tempoParMaq;
	private String raps;
	private String parada;
	private String tempoPar;
	private Double segTempoPar;
	
	public String getRaps() {
		return raps;
	}
	public void setRaps(String raps) {
		this.raps = raps;
	}
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public String getTempoPar() {
		return tempoPar;
	}
	public void setTempoPar(String tempoPar) {
		this.tempoPar = tempoPar;
	}
	public Double getSegTempoPar() {
		return segTempoPar;
	}
	public void setSegTempoPar(Double segTempoPar) {
		this.segTempoPar = segTempoPar;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getTempoParMaq() {
		return tempoParMaq;
	}
	public void setTempoParMaq(String tempoParMaq) {
		this.tempoParMaq = tempoParMaq;
	}
}
