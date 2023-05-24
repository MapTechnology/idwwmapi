/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstpro;

/**
 *
 * @author Adriano Souza
 */
@SuppressWarnings("serial")
public class EstoqueDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_ESTOQUE_JA_EXISTE = 1;
	private int ERRO_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_CDESTOQUE_INVALIDO = 6;
	private int ERRO_REATIVACAO_INDISPONIVEL = 7;	
	
    private DwEst estoque;
    private DwEstpro dwEstPro;
    private DwEstmov dwEstmov;
    private Integer mudarPara;
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
	public DwEst getEstoque() {
		return estoque;
	}
	public void setEstoque(DwEst estoque) {
		this.estoque = estoque;
	}
	public int getERRO_ESTOQUE_JA_EXISTE() {
		return ERRO_ESTOQUE_JA_EXISTE;
	}
	public void setERRO_ESTOQUE_JA_EXISTE(int eRROESTOQUEJAEXISTE) {
		ERRO_ESTOQUE_JA_EXISTE = eRROESTOQUEJAEXISTE;
	}
	public int getERRO_CDESTOQUE_INVALIDO() {
		return ERRO_CDESTOQUE_INVALIDO;
	}
	public void setERRO_CDESTOQUE_INVALIDO(int eRROCDESTOQUEINVALIDO) {
		ERRO_CDESTOQUE_INVALIDO = eRROCDESTOQUEINVALIDO;
	}
	public void setDwEstPro(DwEstpro dwEstPro) {
		this.dwEstPro = dwEstPro;
	}
	public DwEstpro getDwEstPro() {
		return dwEstPro;
	}
	public void setDwEstmov(DwEstmov dwEstmov) {
		this.dwEstmov = dwEstmov;
	}
	public DwEstmov getDwEstmov() {
		return dwEstmov;
	}
	public void setMudarPara(Integer mudarPara) {
		this.mudarPara = mudarPara;
	}
	public Integer getMudarPara() {
		return mudarPara;
	}
	  	
}













