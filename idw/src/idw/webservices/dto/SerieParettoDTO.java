package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SerieParettoDTO implements Serializable {
	
	private String elemento;
	private Double qtdeApontamento;
	
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	public Double getQtdeApontamento() {
		return qtdeApontamento;
	}
	public void setQtdeApontamento(Double qtdeApontamento) {
		this.qtdeApontamento = qtdeApontamento;
	}
	
	
}
