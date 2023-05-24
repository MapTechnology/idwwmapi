/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lineker
 */
@XmlRootElement
@SuppressWarnings("serial")
public class HomologacoesDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_USUARIO_JA_HOMOLOGADO = 1;
	private int ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR = 2;
	private int ERRO_USUARIO_DESCONHECIDO = 3;
	private int ERRO_PT_DESCONHECIDO = 4;
	private int ERRO_GT_DESCONHECIDO = 4;
	private int ERRO_TIPOHOMOLOGACAO_INVALIDA = 5;
	private int ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR = 6;
	
	private List<HomologacaoDTO> homologacoesPt;
	private List<HomologacaoDTO> homologacoesGt;
	private int resultadoEvento;
	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTOBEMSUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTOBEMSUCEDIDO;
	}

	public int getERRO_USUARIO_JA_HOMOLOGADO() {
		return ERRO_USUARIO_JA_HOMOLOGADO;
	}

	public void setERRO_USUARIO_JA_HOMOLOGADO(int eRROUSUARIOJAHOMOLOGADO) {
		ERRO_USUARIO_JA_HOMOLOGADO = eRROUSUARIOJAHOMOLOGADO;
	}

	public int getERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR() {
		return ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR;
	}

	public void setERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR(
			int eRROUSUARIOJAHOMOLOGADOSUPERVISOR) {
		ERRO_USUARIO_JA_HOMOLOGADO_SUPERVISOR = eRROUSUARIOJAHOMOLOGADOSUPERVISOR;
	}

	public int getERRO_USUARIO_DESCONHECIDO() {
		return ERRO_USUARIO_DESCONHECIDO;
	}

	public void setERRO_USUARIO_DESCONHECIDO(int eRROUSUARIODESCONHECIDO) {
		ERRO_USUARIO_DESCONHECIDO = eRROUSUARIODESCONHECIDO;
	}

	public int getERRO_PT_DESCONHECIDO() {
		return ERRO_PT_DESCONHECIDO;
	}

	public void setERRO_PT_DESCONHECIDO(int eRROPTDESCONHECIDO) {
		ERRO_PT_DESCONHECIDO = eRROPTDESCONHECIDO;
	}

	public int getERRO_TIPOHOMOLOGACAO_INVALIDA() {
		return ERRO_TIPOHOMOLOGACAO_INVALIDA;
	}

	public void setERRO_TIPOHOMOLOGACAO_INVALIDA(int eRROTIPOHOMOLOGACAOINVALIDA) {
		ERRO_TIPOHOMOLOGACAO_INVALIDA = eRROTIPOHOMOLOGACAOINVALIDA;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	
	public int getERRO_GT_DESCONHECIDO() {
		return ERRO_GT_DESCONHECIDO;
	}

	public void setERRO_GT_DESCONHECIDO(int eRROGTDESCONHECIDO) {
		ERRO_GT_DESCONHECIDO = eRROGTDESCONHECIDO;
	}

	public List<HomologacaoDTO> getHomologacoesPt() {
		return homologacoesPt;
	}

	public void setHomologacoesPt(List<HomologacaoDTO> homologacoesPt) {
		this.homologacoesPt = homologacoesPt;
	}

	public List<HomologacaoDTO> getHomologacoesGt() {
		return homologacoesGt;
	}

	public void setHomologacoesGt(List<HomologacaoDTO> homologacoesGt) {
		this.homologacoesGt = homologacoesGt;
	}

	public int getERRO_USUARIO_JA_HOMOLOGADO_OPERADOR() {
		return ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR;
	}

	public void setERRO_USUARIO_JA_HOMOLOGADO_OPERADOR(
			int eRROUSUARIOJAHOMOLOGADOOPERADOR) {
		ERRO_USUARIO_JA_HOMOLOGADO_OPERADOR = eRROUSUARIOJAHOMOLOGADOOPERADOR;
	}	

	
}