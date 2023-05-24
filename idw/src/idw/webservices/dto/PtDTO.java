/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.OmCfgurl;
import idw.model.pojos.OmPt;


/**
 *
 * @author lineker
 */
@XmlRootElement
@SuppressWarnings("serial")
public class PtDTO implements Serializable {
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_PT_JA_EXISTE = 1;
	private int ERRO_TIPOPOSTO_DESCONHECIDO = 2;	
	private int ERRO_CC_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_DESCONHECIDO = 6;
	private int ERRO_CDPT_INVALIDO = 7;
	private int ERRO_REATIVACAO_INDISPONIVEL = 8;
	private int ERRO_GRUPOTRABALHO_DESCONHECIDO = 9;
	private int ERRO_TP_IMPPROG = 10;
	private int ERRO_PERC_VARITMO_VAZIO = 11;
	private int ERRO_QTD_VARITMO_VAZIO = 12;
	private int ERRO_UP_EXISTE = 13;

	private OmPt Pt;
	private PAsDTO pas;
	private OmPtcncsDTO ptsCncs;
	
    private PAsDTO pasParaExclusao;
    private OmPtcncsDTO cncsParaExclusao;
    private HomologacoesDTO homologacoes;
    private int resultadoEvento;
    private OmCfgurl omcfgurl;

    private Boolean isMostrarGtDoPt = false;
    
    public OmPt getPt() {
		return Pt;
	}

	public void setPt(OmPt omPt) {
		Pt = omPt;
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

	public int getERRO_CC_DESCONHECIDO() {
		return ERRO_CC_DESCONHECIDO;
	}

	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}

	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int evento_bem_sucedido) {
		EVENTO_BEM_SUCEDIDO = evento_bem_sucedido;
	}

	public void setERRO_CC_DESCONHECIDO(int erro_cc_desconhecido) {
		ERRO_CC_DESCONHECIDO = erro_cc_desconhecido;
	}

	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int erro_usuario_revisao_desconhecido) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = erro_usuario_revisao_desconhecido;
	}

	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int erro_usuario_status_desconhecido) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = erro_usuario_status_desconhecido;
	}

	public void setERRO_DESCONHECIDO(int erro_desconhecido) {
		ERRO_DESCONHECIDO = erro_desconhecido;
	}

	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}

	public void setERRO_REATIVACAO_INDISPONIVEL(int erro_reativacao_indisponivel) {
		ERRO_REATIVACAO_INDISPONIVEL = erro_reativacao_indisponivel;
	}

	public int getERRO_PT_JA_EXISTE() {
		return ERRO_PT_JA_EXISTE;
	}

	public void setERRO_PT_JA_EXISTE(int erro_pt_ja_existe) {
		ERRO_PT_JA_EXISTE = erro_pt_ja_existe;
	}

	public int getERRO_TIPOPOSTO_DESCONHECIDO() {
		return ERRO_TIPOPOSTO_DESCONHECIDO;
	}

	public void setERRO_TIPOPOSTO_DESCONHECIDO(int erro_tipoposto_desconhecido) {
		ERRO_TIPOPOSTO_DESCONHECIDO = erro_tipoposto_desconhecido;
	}

	public int getERRO_CDPT_INVALIDO() {
		return ERRO_CDPT_INVALIDO;
	}

	public void setERRO_CDPT_INVALIDO(int erro_cdpt_invalido) {
		ERRO_CDPT_INVALIDO = erro_cdpt_invalido;
	}

	public int getERRO_GRUPOTRABALHO_DESCONHECIDO() {
		return ERRO_GRUPOTRABALHO_DESCONHECIDO;
	}

	public void setERRO_GRUPOTRABALHO_DESCONHECIDO(
			int erro_grupotrabalho_desconhecido) {
		ERRO_GRUPOTRABALHO_DESCONHECIDO = erro_grupotrabalho_desconhecido;
	}

	public PAsDTO getPas() {
		return pas;
	}

	public void setPas(PAsDTO pas) {
		this.pas = pas;
	}
	
	public OmPtcncsDTO getPtsCncs() {
		return ptsCncs;
	}

	public void setPtsCncs(OmPtcncsDTO ptsCncs) {
		this.ptsCncs = ptsCncs;
	}

	public PAsDTO getPasParaExclusao() {
		return pasParaExclusao;
	}

	public void setPasParaExclusao(PAsDTO pasParaExclusao) {
		this.pasParaExclusao = pasParaExclusao;
	}
	
	public OmPtcncsDTO getCncsParaExclusao() {
		return cncsParaExclusao;
	}

	public void setCncsParaExclusao(OmPtcncsDTO cncsParaExclusao) {
		this.cncsParaExclusao = cncsParaExclusao;
	}

	public HomologacoesDTO getHomologacoes() {
		return homologacoes;
	}

	public void setHomologacoes(HomologacoesDTO homologacoes) {
		this.homologacoes = homologacoes;
	}

	public int getERRO_TP_IMPPROG() {
		return ERRO_TP_IMPPROG;
	}

	public void setERRO_TP_IMPPROG(int eRRO_TP_IMPPROG) {
		ERRO_TP_IMPPROG = eRRO_TP_IMPPROG;
	}

	public OmCfgurl getOmcfgurl() {
		return omcfgurl;
	}

	public void setOmcfgurl(OmCfgurl omcfgurl) {
		this.omcfgurl = omcfgurl;
	}

	public int getERRO_PERC_VARITMO_VAZIO() {
		return ERRO_PERC_VARITMO_VAZIO;
	}

	public void setERRO_PERC_VARITMO_VAZIO(int eRRO_PERC_VARITMO_VAZIO) {
		ERRO_PERC_VARITMO_VAZIO = eRRO_PERC_VARITMO_VAZIO;
	}

	public int getERRO_QTD_VARITMO_VAZIO() {
		return ERRO_QTD_VARITMO_VAZIO;
	}

	public void setERRO_QTD_VARITMO_VAZIO(int eRRO_QTD_VARITMO_VAZIO) {
		ERRO_QTD_VARITMO_VAZIO = eRRO_QTD_VARITMO_VAZIO;
	}

	public Boolean getIsMostrarGtDoPt() {
		return isMostrarGtDoPt;
	}

	public void setIsMostrarGtDoPt(Boolean isMostrarGtDoPt) {
		this.isMostrarGtDoPt = isMostrarGtDoPt;
	}

	public int getERRO_UP_EXISTE() {
		return ERRO_UP_EXISTE;
	}

	public void setERRO_UP_EXISTE(int eRRO_UP_EXISTE) {
		ERRO_UP_EXISTE = eRRO_UP_EXISTE;
	}

	
	
}