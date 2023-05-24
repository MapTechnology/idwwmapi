/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwCalavu;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class CalendarioAvulsoDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 3;
	
    private DwCalavu calendarioAvulso;
    private int resultadoEvento;
	
    public int getEVENTO_BEM_SUCEDIDO() {    	
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTOBEMSUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTOBEMSUCEDIDO;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	public void setERRO_DESCONHECIDO(int eRRODESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRODESCONHECIDO;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public DwCalavu getCalendarioAvulso() {
		return calendarioAvulso;
	}
	public void setCalendarioAvulso(DwCalavu calendarioAvulso) {
		this.calendarioAvulso = calendarioAvulso;
	}
			
}