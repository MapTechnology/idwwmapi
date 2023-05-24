/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmPa;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class PaDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private int ERRO_DSPA_INVALIDO = 2;
	private int ERRO_ORDEM_INVALIDO = 3;
	private int ERRO_DESVIO_INVALIDO = 4;
	private int ERRO_DEPARA_INVALIDO = 5;
	private int ERRO_CDPA_INVALIDO = 6;
	
    private OmPa pa;
    private int resultadoEvento;
	
    public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int evento_bem_sucedido) {
		EVENTO_BEM_SUCEDIDO = evento_bem_sucedido;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	public void setERRO_DESCONHECIDO(int erro_desconhecido) {
		ERRO_DESCONHECIDO = erro_desconhecido;
	}
	public OmPa getPa() {
		return pa;
	}
	public void setPa(OmPa pa) {
		this.pa = pa;
	}
	public int getERRO_DSPA_INVALIDO() {
		return ERRO_DSPA_INVALIDO;
	}
	public void setERRO_DSPA_INVALIDO(int erro_dspa_invalido) {
		ERRO_DSPA_INVALIDO = erro_dspa_invalido;
	}
	public int getERRO_ORDEM_INVALIDO() {
		return ERRO_ORDEM_INVALIDO;
	}
	public void setERRO_ORDEM_INVALIDO(int erro_ordem_invalido) {
		ERRO_ORDEM_INVALIDO = erro_ordem_invalido;
	}
	public int getERRO_DESVIO_INVALIDO() {
		return ERRO_DESVIO_INVALIDO;
	}
	public void setERRO_DESVIO_INVALIDO(int erro_desvio_invalido) {
		ERRO_DESVIO_INVALIDO = erro_desvio_invalido;
	}
	public int getERRO_DEPARA_INVALIDO() {
		return ERRO_DEPARA_INVALIDO;
	}
	public void setERRO_DEPARA_INVALIDO(int erro_depara_invalido) {
		ERRO_DEPARA_INVALIDO = erro_depara_invalido;
	}
	public int getERRO_CDPA_INVALIDO() {
		return ERRO_CDPA_INVALIDO;
	}
	public void setERRO_CDPA_INVALIDO(int erro_cdpa_invalido) {
		ERRO_CDPA_INVALIDO = erro_cdpa_invalido;
	}

    

}