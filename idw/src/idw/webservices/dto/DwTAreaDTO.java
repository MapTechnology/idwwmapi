package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwTArea;

@SuppressWarnings("serial")
public class DwTAreaDTO implements Serializable 
{
	private DwTArea dwTArea;

	private int EVENTO_BEM_SUCEDIDO = 0;
	private int resultadoEvento;
	
	//20160928FVA:
	private int ERRO_REATIVACAO_INDISPONIVEL = 7;
	
	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}
	public void setERRO_REATIVACAO_INDISPONIVEL(int eRROREATIVACAOINDISPONIVEL) {
	//	ERRO_REATIVACAO_INDISPONIVEL = eRROREATIVACAOINDISPONIVEL;
	}
	
	public DwTArea getDwTArea() {
		return dwTArea;
	}

	public void setDwTArea(DwTArea dwTArea) {
		this.dwTArea = dwTArea;
	}

	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTOBEMSUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTOBEMSUCEDIDO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "DwTAreaDTO [";
		
		retorno += "dwTArea=";
		
		if (this.dwTArea != null) {
			retorno += this.dwTArea.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "EVENTO_BEM_SUCEDIDO=" + this.EVENTO_BEM_SUCEDIDO + ", " +
				   "resultadoEvento=" + this.resultadoEvento + ", " +
				   "ERRO_REATIVACAO_INDISPONIVEL=" + this.ERRO_REATIVACAO_INDISPONIVEL + "]";
		
		return retorno;
		/*
		return "DwTAreaDTO [dwTArea=" + dwTArea + ", EVENTO_BEM_SUCEDIDO=" + EVENTO_BEM_SUCEDIDO + ", resultadoEvento=" + resultadoEvento
				+ ", ERRO_REATIVACAO_INDISPONIVEL=" + ERRO_REATIVACAO_INDISPONIVEL + "]";
		*/
	}
	
}
