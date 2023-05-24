/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import idw.model.pojos.DwCalpt;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class CalendarioPtsDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_PT_DESCONHECIDO = 1;
	
	private List<DwCalpt> pts;
	private int resultadoEvento;

	public List<DwCalpt> getPts() {
		return pts;
	}

	public void setPts(List<DwCalpt> pts) {
		this.pts = pts;
	}

	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTOBEMSUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTOBEMSUCEDIDO;
	}

	public int getERRO_PT_DESCONHECIDO() {
		return ERRO_PT_DESCONHECIDO;
	}

	public void setERRO_PT_DESCONHECIDO(int eRROPTDESCONHECIDO) {
		ERRO_PT_DESCONHECIDO = eRROPTDESCONHECIDO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	
}