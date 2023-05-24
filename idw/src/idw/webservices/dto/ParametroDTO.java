/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwFtParam;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class ParametroDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private int ERRO_PARAMETRO_DESCONHECIDO = 2;
	private int ERRO_PARAMETRO_SENDO_USADO = 3;
	private int ERRO_FALTA_MULTISELECAO = 4;
	
    private DwFtParam parametro;
    private int resultadoEvento;    
    
    
    /**
     * @return the resultadoEvento
     */
    public int getResultadoEvento() {
    	return resultadoEvento;
    }

    /**
     * @param resultadoEvento the resultadoEvento to set
     */
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

	public DwFtParam getParametro() {
		return parametro;
	}

	public void setParametro(DwFtParam parametro) {
		this.parametro = parametro;
	}

	public int getERRO_PARAMETRO_DESCONHECIDO() {
		return ERRO_PARAMETRO_DESCONHECIDO;
	}

	public void setERRO_PARAMETRO_DESCONHECIDO(int eRROPARAMETRODESCONHECIDO) {
		ERRO_PARAMETRO_DESCONHECIDO = eRROPARAMETRODESCONHECIDO;
	}

	public int getERRO_PARAMETRO_SENDO_USADO() {
		return ERRO_PARAMETRO_SENDO_USADO;
	}

	public void setERRO_PARAMETRO_SENDO_USADO(int eRROPARAMETROSENDOUSADO) {
		ERRO_PARAMETRO_SENDO_USADO = eRROPARAMETROSENDOUSADO;
	}

	public int getERRO_FALTA_MULTISELECAO() {
		return ERRO_FALTA_MULTISELECAO;
	}

	public void setERRO_FALTA_MULTISELECAO(int eRRO_FALTA_MULTISELECAO) {
		ERRO_FALTA_MULTISELECAO = eRRO_FALTA_MULTISELECAO;
	}

	
}