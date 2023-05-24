/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author milton
 */
@SuppressWarnings("serial")
public class ObjsDTO implements Serializable {
    private List<ObjDTO> objs;
	private static final int ERRO_EXISTE_REFERENCIA_CIRCULAR = 1;
    private int resultadoEvento;

    
	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public int getERRO_EXISTE_REFERENCIA_CIRCULAR() {
		return ERRO_EXISTE_REFERENCIA_CIRCULAR;
	}

	public List<ObjDTO> getObjs() {
		return objs;
	}

	public void setObjs(List<ObjDTO> objs) {
		this.objs = objs;
	}
	
    
}