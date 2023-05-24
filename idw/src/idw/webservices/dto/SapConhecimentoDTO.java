package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.TtSapCon;


/**
*
* @author fredson
*/
@SuppressWarnings("serial")
public class SapConhecimentoDTO implements Serializable  {
	private TtSapCon sapconhecimento;
    private int resultadoEvento;

	public TtSapCon getSapconhecimento() {
		return sapconhecimento;
	}
	public void setSapconhecimento(TtSapCon sapconhecimento) {
		this.sapconhecimento = sapconhecimento;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

}
