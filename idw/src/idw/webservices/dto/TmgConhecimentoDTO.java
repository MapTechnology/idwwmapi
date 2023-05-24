package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.TtTmgCon;


/**
*
* @author fredson
*/
@SuppressWarnings("serial")
public class TmgConhecimentoDTO implements Serializable {

	public TtTmgCon getTmgconhecimento() {
		return tmgconhecimento;
	}
	public void setTmgconhecimento(TtTmgCon tmgconhecimento) {
		this.tmgconhecimento = tmgconhecimento;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	private TtTmgCon tmgconhecimento;
    private int resultadoEvento;

}
