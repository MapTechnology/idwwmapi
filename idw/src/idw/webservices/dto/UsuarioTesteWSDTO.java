/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class UsuarioTesteWSDTO implements Serializable {
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_USUARIO_JA_EXISTE = 1;
	private int ERRO_GRUPO_DESCONHECIDO = 2;
	private int ERRO_CC_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_DESCONHECIDO = 6;
	private int ERRO_CDUSR_INVALIDO = 7;
	private int ERRO_LOGIN_INVALIDO = 8;
	private int ERRO_REATIVACAO_INDISPONIVEL = 8;

//	private OmUsr usuario;
	private HomologacoesDTO homologacoes;
//    private int resultadoEvento;

    /**
     * @return the usuario
     */

    /**
     * @return the resultadoEvento
     */
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


}