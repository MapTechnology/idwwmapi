/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmGrnts;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class DireitoAcessoDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private int ERRO_RESGUI_INVALIDO = 2;
	
    private OmGrnts direitoAcesso;
    private int resultadoEvento;
	
    public OmGrnts getDireitoAcesso() {
		return direitoAcesso;
	}
	public void setDireitoAcesso(OmGrnts direitoAcesso) {
		this.direitoAcesso = direitoAcesso;
	}
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
	public int getERRO_RESGUI_INVALIDO() {
		return ERRO_RESGUI_INVALIDO;
	}
	public void setERRO_RESGUI_INVALIDO(int erro_resgui_invalido) {
		ERRO_RESGUI_INVALIDO = erro_resgui_invalido;
	}

    

}