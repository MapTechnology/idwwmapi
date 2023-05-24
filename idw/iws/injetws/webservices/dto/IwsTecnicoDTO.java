package injetws.webservices.dto;

import java.io.Serializable;

public class IwsTecnicoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Integer idUsuario;
    private String login;
    private String password;
    private Integer idGrupoUsu;
    
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIdGrupoUsu() {
		return idGrupoUsu;
	}
	public void setIdGrupoUsu(Integer idGrupoUsu) {
		this.idGrupoUsu = idGrupoUsu;
	}
}
