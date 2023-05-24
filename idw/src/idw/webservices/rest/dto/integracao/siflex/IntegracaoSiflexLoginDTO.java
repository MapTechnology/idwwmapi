package idw.webservices.rest.dto.integracao.siflex;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="usuario")
public class IntegracaoSiflexLoginDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3897435064459222042L;
	
	
	private String login;
	private String senha;
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
	
	
}
