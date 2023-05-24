package idw.webservices.rest.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="usuario")
public class UsuarioDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private String cdUsr;
	private String token;
	private String login;
	private String senha;
	private String dsApelido;
	private String dsNome;
	private String cdGtMonitorizacao;
	
	public String getCdUsr() {
		return cdUsr;
	}
	public void setCdUsr(String cdUsr) {
		this.cdUsr = cdUsr;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	public String getDsApelido() {
		return dsApelido;
	}
	public void setDsApelido(String dsApelido) {
		this.dsApelido = dsApelido;
	}
	public String getDsNome() {
		return dsNome;
	}
	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}
	public String getCdGtMonitorizacao() {
		return cdGtMonitorizacao;
	}
	public void setCdGtMonitorizacao(String cdGtMonitorizacao) {
		this.cdGtMonitorizacao = cdGtMonitorizacao;
	}
	@Override
	public String toString() {
		return "UsuarioDTO [cdUsr=" + cdUsr + ", login=" + login + ", senha="
				+ senha + ", dsApelido=" + dsApelido + ", dsNome=" + dsNome
				+ ", cdGtMonitorizacao=" + cdGtMonitorizacao + "]";
	}	
	

}
