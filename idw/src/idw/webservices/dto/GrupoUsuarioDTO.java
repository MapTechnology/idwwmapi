/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmUsrgrp;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class GrupoUsuarioDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_GRUPO_USUARIO_JA_EXISTE = 1;
	private int ERRO_RESGUI_DESCONHECIDO = 2;
	private int ERRO_DESCONHECIDO = 3;
	private int ERRO_CDUSRGRP_INVALIDO = 4;
	private int ERRO_DESCRICAO_INVALIDA = 5;
	private int ERRO_REATIVACAO_INDISPONIVEL = 6;
	
    private OmUsrgrp grupoUsuario;
    private DireitosAcessoDTO direitosAcesso;
    private DireitosAcessoDTO direitosAcessoParaExclusao;
    private int resultadoEvento;

    /**
     * @return the grupoUsuario
     */
    public OmUsrgrp getGrupoUsuario() {
        return grupoUsuario;
    }

    /**
     * @param grupoUsuario the grupoUsuario to set
     */
    public void setGrupoUsuario(OmUsrgrp grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
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

	public DireitosAcessoDTO getDireitosAcesso() {
		return direitosAcesso;
	}

	public void setDireitosAcesso(DireitosAcessoDTO direitosAcesso) {
		this.direitosAcesso = direitosAcesso;
	}

	public DireitosAcessoDTO getDireitosAcessoParaExclusao() {
		return direitosAcessoParaExclusao;
	}

	public void setDireitosAcessoParaExclusao(
			DireitosAcessoDTO direitosAcessoParaExclusao) {
		this.direitosAcessoParaExclusao = direitosAcessoParaExclusao;
	}

	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int evento_bem_sucedido) {
		EVENTO_BEM_SUCEDIDO = evento_bem_sucedido;
	}

	public int getERRO_GRUPO_USUARIO_JA_EXISTE() {
		return ERRO_GRUPO_USUARIO_JA_EXISTE;
	}

	public void setERRO_GRUPO_USUARIO_JA_EXISTE(int erro_grupo_usuario_ja_existe) {
		ERRO_GRUPO_USUARIO_JA_EXISTE = erro_grupo_usuario_ja_existe;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int erro_desconhecido) {
		ERRO_DESCONHECIDO = erro_desconhecido;
	}

	public int getERRO_RESGUI_DESCONHECIDO() {
		return ERRO_RESGUI_DESCONHECIDO;
	}

	public void setERRO_RESGUI_DESCONHECIDO(int erro_resgui_desconhecido) {
		ERRO_RESGUI_DESCONHECIDO = erro_resgui_desconhecido;
	}

	public int getERRO_CDUSRGRP_INVALIDO() {
		return ERRO_CDUSRGRP_INVALIDO;
	}

	public void setERRO_CDUSRGRP_INVALIDO(int erro_cdusrgrp_invalido) {
		ERRO_CDUSRGRP_INVALIDO = erro_cdusrgrp_invalido;
	}

	public int getERRO_DESCRICAO_INVALIDA() {
		return ERRO_DESCRICAO_INVALIDA;
	}

	public void setERRO_DESCRICAO_INVALIDA(int erro_descricao_invalida) {
		ERRO_DESCRICAO_INVALIDA = erro_descricao_invalida;
	}

	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}

	public void setERRO_REATIVACAO_INDISPONIVEL(int erro_reativacao_indisponivel) {
		ERRO_REATIVACAO_INDISPONIVEL = erro_reativacao_indisponivel;
	}

}