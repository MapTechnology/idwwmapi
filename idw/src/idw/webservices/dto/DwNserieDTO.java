package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwNserie;

@SuppressWarnings("serial")
public class DwNserieDTO implements Serializable{
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int resultadoEvento;
	private DwNserie dwNserie;
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public DwNserie getDwNserie() {
		return dwNserie;
	}
	public void setDwNserie(DwNserie dwNserie) {
		this.dwNserie = dwNserie;
	}
}
