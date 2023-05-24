package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class IwsModDTO implements Serializable {

    private String idUsuario;
    private String nome;
    private String login;
    private String idGrupoUsu;
    private Date dthrLogin;
    private Date dthrLogout;
	/**
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the idGrupoUsu
	 */
	public String getIdGrupoUsu() {
		return idGrupoUsu;
	}
	/**
	 * @param idGrupoUsu the idGrupoUsu to set
	 */
	public void setIdGrupoUsu(String idGrupoUsu) {
		this.idGrupoUsu = idGrupoUsu;
	}
	/**
	 * @return the dthrLogin
	 */
	public Date getDthrLogin() {
		return dthrLogin;
	}
	/**
	 * @param dthrLogin the dthrLogin to set
	 */
	public void setDthrLogin(Date dthrLogin) {
		this.dthrLogin = dthrLogin;
	}
	/**
	 * @return the dthrLogout
	 */
	public Date getDthrLogout() {
		return dthrLogout;
	}
	/**
	 * @param dthrLogout the dthrLogout to set
	 */
	public void setDthrLogout(Date dthrLogout) {
		this.dthrLogout = dthrLogout;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}

