package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.DwProrea;

@XmlRootElement
@SuppressWarnings("serial")
public class DwProreaDTO implements Serializable{
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

	public DwProrea getDwProrea() {
		return dwProrea;
	}

	public void setDwProrea(DwProrea dwProrea) {
		this.dwProrea = dwProrea;
	}

	private int EVENTO_BEM_SUCEDIDO = 0;
	private int resultadoEvento;
	
	private DwProrea dwProrea;
}
