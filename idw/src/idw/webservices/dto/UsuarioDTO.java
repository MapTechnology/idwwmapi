/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.OmUsr;


/**
 *
 * @author lineker
 */
@XmlRootElement
@SuppressWarnings("serial")
public class UsuarioDTO implements Serializable {
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_USUARIO_JA_EXISTE = 1;
	private int ERRO_GRUPO_DESCONHECIDO = 2;
	private int ERRO_CC_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_DESCONHECIDO = 6;
	private int ERRO_CDUSR_INVALIDO = 7;
	private int ERRO_LOGIN_INVALIDO = 8;
	private int ERRO_CARGO_DESCONHECIDO = 9;
	private int ERRO_REATIVACAO_INDISPONIVEL = 10;
	private int USUARIO_EM_USO_NA_COFIGURACAO_GERAL = 11;
	private int ERRO_USUARIO_LOGADO = 12;

	private CamposEmUsoOmCfgDTO camposEmUso;
	private OmUsr usuario;
	private HomologacoesDTO homologacoes;
    private int resultadoEvento;
    private Date dthr; //Usado para testar fuso horario

    private String versaoServidor;
    
    /**
     * @return the usuario
     */
    public OmUsr getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(OmUsr usuario) {
        this.usuario = usuario;
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

	public int getERRO_USUARIO_JA_EXISTE() {
		return ERRO_USUARIO_JA_EXISTE;
	}

	public int getERRO_GRUPO_DESCONHECIDO() {
		return ERRO_GRUPO_DESCONHECIDO;
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

	public void setERRO_USUARIO_JA_EXISTE(int erro_usuario_ja_existe) {
		ERRO_USUARIO_JA_EXISTE = erro_usuario_ja_existe;
	}

	public void setERRO_GRUPO_DESCONHECIDO(int erro_grupo_desconhecido) {
		ERRO_GRUPO_DESCONHECIDO = erro_grupo_desconhecido;
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

	public int getERRO_CDUSR_INVALIDO() {
		return ERRO_CDUSR_INVALIDO;
	}

	public void setERRO_CDUSR_INVALIDO(int erro_cdusr_invalido) {
		ERRO_CDUSR_INVALIDO = erro_cdusr_invalido;
	}

	public int getERRO_LOGIN_INVALIDO() {
		return ERRO_LOGIN_INVALIDO;
	}

	public void setERRO_LOGIN_INVALIDO(int erro_login_invalido) {
		ERRO_LOGIN_INVALIDO = erro_login_invalido;
	}

	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}

	public void setERRO_REATIVACAO_INDISPONIVEL(int erro_reativacao_indisponivel) {
		ERRO_REATIVACAO_INDISPONIVEL = erro_reativacao_indisponivel;
	}

	public HomologacoesDTO getHomologacoes() {
		return homologacoes;
	}

	public void setHomologacoes(HomologacoesDTO homologacoes) {
		this.homologacoes = homologacoes;
	}

	public int getERRO_CARGO_DESCONHECIDO() {
		return ERRO_CARGO_DESCONHECIDO;
	}

	public void setERRO_CARGO_DESCONHECIDO(int eRRO_CARGO_DESCONHECIDO) {
		ERRO_CARGO_DESCONHECIDO = eRRO_CARGO_DESCONHECIDO;
	}

	public Date getDthr() {
		return dthr;
	}

	public void setDthr(Date dthr) {
		this.dthr = dthr;
	}

	public int getUSUARIO_EM_USO_NA_COFIGURACAO_GERAL() {
		return USUARIO_EM_USO_NA_COFIGURACAO_GERAL;
	}

	public void setUSUARIO_EM_USO_NA_COFIGURACAO_GERAL(
			int uSUARIO_EM_USO_NA_COFIGURACAO_GERAL) {
		USUARIO_EM_USO_NA_COFIGURACAO_GERAL = uSUARIO_EM_USO_NA_COFIGURACAO_GERAL;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUso() {
		return camposEmUso;
	}

	public void setCamposEmUso(CamposEmUsoOmCfgDTO camposEmUso) {
		this.camposEmUso = camposEmUso;
	}

	public int getERRO_USUARIO_LOGADO() {
		return ERRO_USUARIO_LOGADO;
	}

	public void setERRO_USUARIO_LOGADO(int eRRO_USUARIO_LOGADO) {
		ERRO_USUARIO_LOGADO = eRRO_USUARIO_LOGADO;
	}

	public String getVersaoServidor() {
		return versaoServidor;
	}

	public void setVersaoServidor(String versaoServidor) {
		this.versaoServidor = versaoServidor;
	}

	public String getDescricaoResultado() {
		String retorno = "";
		if (this.resultadoEvento == 0) retorno = "EVENTO_BEM_SUCEDIDO";
		if (this.resultadoEvento == 1) retorno = "ERRO_USUARIO_JA_EXISTE";
		if (this.resultadoEvento == 2) retorno = "ERRO_GRUPO_DESCONHECIDO";
		if (this.resultadoEvento == 3) retorno = "ERRO_CC_DESCONHECIDO";
		if (this.resultadoEvento == 4) retorno = "ERRO_USUARIO_REVISAO_DESCONHECIDO";
		if (this.resultadoEvento == 5) retorno = "ERRO_USUARIO_STATUS_DESCONHECIDO";
		if (this.resultadoEvento == 6) retorno = "ERRO_DESCONHECIDO";
		if (this.resultadoEvento == 7) retorno = "ERRO_CDUSR_INVALIDO";
		if (this.resultadoEvento == 8) retorno = "ERRO_LOGIN_INVALIDO";
		if (this.resultadoEvento == 9) retorno = "ERRO_CARGO_DESCONHECIDO";
		if (this.resultadoEvento == 10) retorno = "ERRO_REATIVACAO_INDISPONIVEL";
		if (this.resultadoEvento == 11) retorno = "USUARIO_EM_USO_NA_COFIGURACAO_GERAL";
		if (this.resultadoEvento == 12) retorno = "ERRO_USUARIO_LOGADO";

		return retorno;
	}
}