/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import idw.model.pojos.DwTurno;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class TurnoDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_TURNO_JA_EXISTE = 1;
	private int ERRO_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_CDTURNO_INVALIDO = 6;
	private int ERRO_REATIVACAO_INDISPONIVEL = 7;
	private int ERRO_DS_INVALIDA = 8;
	
    private DwTurno turno;
    private BigDecimal quantidade = BigDecimal.valueOf(0);
    private int resultadoEvento;
    
    public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
    public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTOBEMSUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTOBEMSUCEDIDO;
	}
	public int getERRO_TURNO_JA_EXISTE() {
		return ERRO_TURNO_JA_EXISTE;
	}
	public void setERRO_TURNO_JA_EXISTE(int eRROTURNOJAEXISTE) {
		ERRO_TURNO_JA_EXISTE = eRROTURNOJAEXISTE;
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
	public int getERRO_CDTURNO_INVALIDO() {
		return ERRO_CDTURNO_INVALIDO;
	}
	public void setERRO_CDTURNO_INVALIDO(int eRROCDTURNOINVALIDO) {
		ERRO_CDTURNO_INVALIDO = eRROCDTURNOINVALIDO;
	}
	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}
	public void setERRO_REATIVACAO_INDISPONIVEL(int eRROREATIVACAOINDISPONIVEL) {
		ERRO_REATIVACAO_INDISPONIVEL = eRROREATIVACAOINDISPONIVEL;
	}
	public DwTurno getTurno() {
		return turno;
	}
	public void setTurno(DwTurno turno) {
		this.turno = turno;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public int getERRO_DS_INVALIDA() {
		return ERRO_DS_INVALIDA;
	}
	public void setERRO_DS_INVALIDA(int eRRO_DS_INVALIDA) {
		ERRO_DS_INVALIDA = eRRO_DS_INVALIDA;
	}
	
}