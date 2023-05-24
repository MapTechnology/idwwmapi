/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmObj;


/**
 *
 * @author milton
 */
@SuppressWarnings("serial")
public class ObjDTO implements Serializable {

	private OmObj obj;
	
	private static final int EVENTO_BEM_SUCEDIDO = 0;
	private static final int ERRO_EXISTE_REFERENCIA_CIRCULAR = 1;
	
    private int resultadoEvento;
    
    /**
     * @return the obj
     */
    public OmObj getObj() {
        return obj;
    }

    /**
     * @param Obj the Obj to set
     */
    public void setObj(OmObj obj) {
        this.obj = obj;
    }

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

	public int getERRO_EXISTE_REFERENCIA_CIRCULAR() {
		return ERRO_EXISTE_REFERENCIA_CIRCULAR;
	}
    
   
	
}