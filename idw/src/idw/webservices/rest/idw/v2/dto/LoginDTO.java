package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="login")
public class LoginDTO implements Serializable {
	private static final long serialVersionUID = 1L; 

	private Long idUsr;
	private String cdUsr;
	private String dsUsr; 
	private String login;
	private String senha; 
	private String token;
	
	private List<MenusAcessoDTO> acessos;

	public long getIdUsr() {
		return idUsr;
	}

	public void setIdUsr(Long idUsr) {
		this.idUsr = idUsr;
	}

	public String getCdUsr() {
		return cdUsr;
	}

	public void setCdUsr(String cdUsr) {
		this.cdUsr = cdUsr;
	}

	public String getDsUsr() {
		return dsUsr;
	}

	public void setDsUsr(String dsUsr) {
		this.dsUsr = dsUsr;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<MenusAcessoDTO> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<MenusAcessoDTO> acessos) {
		this.acessos = acessos;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	} 
	
	
}
