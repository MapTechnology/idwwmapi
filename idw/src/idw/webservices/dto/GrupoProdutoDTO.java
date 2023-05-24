/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmProgrp;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class GrupoProdutoDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_GRUPOPRODUTO_JA_EXISTE = 1;
	private int ERRO_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_CDGRUPOPRODUTO_INVALIDO = 6;
	private int ERRO_REATIVACAO_INDISPONIVEL = 7;	
	
    private OmProgrp grupoProduto;
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
	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}
	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int eRROUSUARIOREVISAODESCONHECIDO) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = eRROUSUARIOREVISAODESCONHECIDO;
	}
	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}
	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int eRROUSUARIOSTATUSDESCONHECIDO) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = eRROUSUARIOSTATUSDESCONHECIDO;
	}
	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}
	public void setERRO_REATIVACAO_INDISPONIVEL(int eRROREATIVACAOINDISPONIVEL) {
		ERRO_REATIVACAO_INDISPONIVEL = eRROREATIVACAOINDISPONIVEL;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public OmProgrp getGrupoProduto() {
		return grupoProduto;
	}
	public void setGrupoProduto(OmProgrp grupoProduto) {
		this.grupoProduto = grupoProduto;
	}
	public int getERRO_GRUPOPRODUTO_JA_EXISTE() {
		return ERRO_GRUPOPRODUTO_JA_EXISTE;
	}
	public void setERRO_GRUPOPRODUTO_JA_EXISTE(int eRROGRUPOPRODUTOJAEXISTE) {
		ERRO_GRUPOPRODUTO_JA_EXISTE = eRROGRUPOPRODUTOJAEXISTE;
	}
	public int getERRO_CDGRUPOPRODUTO_INVALIDO() {
		return ERRO_CDGRUPOPRODUTO_INVALIDO;
	}
	public void setERRO_CDGRUPOPRODUTO_INVALIDO(int eRROCDGRUPOPRODUTOINVALIDO) {
		ERRO_CDGRUPOPRODUTO_INVALIDO = eRROCDGRUPOPRODUTOINVALIDO;
	}
	  	
}