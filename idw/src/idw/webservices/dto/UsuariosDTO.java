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
@SuppressWarnings("serial")
@XmlRootElement
public class UsuariosDTO implements Serializable {	
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private int ERRO_NAO_HA_USUARIOS = 2;
	private int ERRO_USUARIO_LOGADO = 3;

	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
	private List<UsuarioDTO> usuarios;
	private int resultadoEvento;
	
	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
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

	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}

	public int getERRO_NAO_HA_USUARIOS() {
		return ERRO_NAO_HA_USUARIOS;
	}

	public void setERRO_NAO_HA_USUARIOS(int eRRO_NAO_HA_USUARIOS) {
		ERRO_NAO_HA_USUARIOS = eRRO_NAO_HA_USUARIOS;
	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}

	public int getERRO_USUARIO_LOGADO() {
		return ERRO_USUARIO_LOGADO;
	}

	public void setERRO_USUARIO_LOGADO(int eRRO_USUARIO_LOGADO) {
		ERRO_USUARIO_LOGADO = eRRO_USUARIO_LOGADO;
	}	
}