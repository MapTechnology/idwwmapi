/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwTDefeito;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class TDefeitoDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DEFEITO_JA_EXISTE = 1;
	private int ERRO_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_CDDEFEITO_INVALIDO = 6;
	private int ERRO_REATIVACAO_INDISPONIVEL = 7;
	private int ERRO_TIPOPOSTO_DESCONHECIDO = 8;
	private int ERRO_COMPONENTE_DESCONHECIDO = 9;
	
	private DwTDefeito defeito;
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
	public int getERRO_DEFEITO_JA_EXISTE() {
		return ERRO_DEFEITO_JA_EXISTE;
	}
	public void setERRO_DEFEITO_JA_EXISTE(int eRRODEFEITOJAEXISTE) {
		ERRO_DEFEITO_JA_EXISTE = eRRODEFEITOJAEXISTE;
	}
	public int getERRO_CDDEFEITO_INVALIDO() {
		return ERRO_CDDEFEITO_INVALIDO;
	}
	public void setERRO_CDDEFEITO_INVALIDO(int eRROCDDEFEITOINVALIDO) {
		ERRO_CDDEFEITO_INVALIDO = eRROCDDEFEITOINVALIDO;
	}
	public DwTDefeito getDefeito() {
		return defeito;
	}
	public void setDefeito(DwTDefeito defeito) {
		this.defeito = defeito;
	}
	public int getERRO_TIPOPOSTO_DESCONHECIDO() {
		return ERRO_TIPOPOSTO_DESCONHECIDO;
	}
	public void setERRO_TIPOPOSTO_DESCONHECIDO(int eRROTIPOPOSTODESCONHECIDO) {
		ERRO_TIPOPOSTO_DESCONHECIDO = eRROTIPOPOSTODESCONHECIDO;
	}
    public int getERRO_COMPONENTE_DESCONHECIDO() {
		return ERRO_COMPONENTE_DESCONHECIDO;
	}
	public void setERRO_COMPONENTE_DESCONHECIDO(int eRROCOMPONENTEDESCONHECIDO) {
		ERRO_COMPONENTE_DESCONHECIDO = eRROCOMPONENTEDESCONHECIDO;
	}
}