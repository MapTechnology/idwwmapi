package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ParadaRegulagemDTO implements Serializable {

	private String parada;
	private long tempoParada;
	
	private String tempoParadaHora;

	public String getParada() {
		return parada;
	}

	public void setParada(String parada) {
		this.parada = parada;
	}

	public long getTempoParada() {
		return tempoParada;
	}

	public void setTempoParada(long tempoParada) {
		this.tempoParada = tempoParada;
	}

	public String getTempoParadaHora() {
		return tempoParadaHora;
	}

	public void setTempoParadaHora(String tempoParadaHora) {
		this.tempoParadaHora = tempoParadaHora;
	}
	
	
}
