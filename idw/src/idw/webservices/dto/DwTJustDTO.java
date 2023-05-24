package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwTJust;

@SuppressWarnings("serial")
public class DwTJustDTO implements Serializable {

	private DwTJust dwTJust;
	
	//20160928FVA:
	private int EVENTO_BEM_SUCEDIDO = 0;
	
	private int resultadoEvento;
	
	private int ERRO_REATIVACAO_INDISPONIVEL = 7;
	
	public DwTJust getDwTJust() {
		return dwTJust;
	}
	public void setDwTJust(DwTJust dwTJust) {
		this.dwTJust = dwTJust;
	}

	
	//20160928FVA:
	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}
	public void setERRO_REATIVACAO_INDISPONIVEL(int eRROREATIVACAOINDISPONIVEL) {
		//ERRO_REATIVACAO_INDISPONIVEL = eRROREATIVACAOINDISPONIVEL;
	}
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
	
	
}
