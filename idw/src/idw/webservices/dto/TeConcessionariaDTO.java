package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.TeConcessionaria;

@SuppressWarnings("serial")
public class TeConcessionariaDTO  implements Serializable{
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int resultadoEvento;
	
	private TeConcessionaria teConcessionaria;

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

	public TeConcessionaria getTeConcessionaria() {
		return teConcessionaria;
	}

	public void setTeConcessionaria(TeConcessionaria teConcessionaria) {
		this.teConcessionaria = teConcessionaria;
	}
}
