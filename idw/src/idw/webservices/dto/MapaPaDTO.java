/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmMapapa;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class MapaPaDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private int ERRO_PRODUTO_DESCONHECIDO = 4;
	private int ERRO_PA_DESCONHECIDO = 5;
	
    private OmMapapa mapaPa;
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
	public OmMapapa getMapaPa() {
		return mapaPa;
	}
	public void setMapaPa(OmMapapa mapaPa) {
		this.mapaPa = mapaPa;
	}
	public int getERRO_PRODUTO_DESCONHECIDO() {
		return ERRO_PRODUTO_DESCONHECIDO;
	}
	public void setERRO_PRODUTO_DESCONHECIDO(int erro_produto_desconhecido) {
		ERRO_PRODUTO_DESCONHECIDO = erro_produto_desconhecido;
	}
	public int getERRO_PA_DESCONHECIDO() {
		return ERRO_PA_DESCONHECIDO;
	}
	public void setERRO_PA_DESCONHECIDO(int erro_pa_desconhecido) {
		ERRO_PA_DESCONHECIDO = erro_pa_desconhecido;
	}
	
}