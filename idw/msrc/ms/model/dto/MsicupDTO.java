/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ms.model.dto;

import java.io.Serializable;

import idw.model.pojos.MsMsicup;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class MsicupDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_MSICUP_JA_EXISTE = 1;
	private int ERRO_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;

	
    private MsMsicup msicup;
    private int resultadoEvento;

  

    public MsMsicup getMsicup() {
		return msicup;
	}

	public void setMsicup(MsMsicup msicup) {
		this.msicup = msicup;
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

	public void setEVENTO_BEM_SUCEDIDO(int evento_bem_sucedido) {
		EVENTO_BEM_SUCEDIDO = evento_bem_sucedido;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int erro_desconhecido) {
		ERRO_DESCONHECIDO = erro_desconhecido;
	}

	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}

	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int erro_usuario_revisao_desconhecido) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = erro_usuario_revisao_desconhecido;
	}

	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}

	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int erro_usuario_status_desconhecido) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = erro_usuario_status_desconhecido;
	}

	public int getERRO_MSICUP_JA_EXISTE() {
		return ERRO_MSICUP_JA_EXISTE;
	}

	public void setERRO_MSICUP_JA_EXISTE(int eRRO_MSICUP_JA_EXISTE) {
		ERRO_MSICUP_JA_EXISTE = eRRO_MSICUP_JA_EXISTE;
	}

		
}