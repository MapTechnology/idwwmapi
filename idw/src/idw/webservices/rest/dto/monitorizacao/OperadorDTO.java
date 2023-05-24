package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="operador")
public class OperadorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdUsr;
	private String login;
	private String dsApelido;
	private String dsNome;
	private String dtHrLogin;
	private String dtHrLogout;
	
	public String getCdUsr() {
		return cdUsr;
	}
	public void setCdUsr(String cdUsr) {
		this.cdUsr = cdUsr;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	public String getDtHrLogin() {
		return dtHrLogin;
	}
	public void setDtHrLogin(String dtHrLogin) {
		this.dtHrLogin = dtHrLogin;
	}
	public String getDtHrLogout() {
		return dtHrLogout;
	}
	public void setDtHrLogout(String dtHrLogout) {
		this.dtHrLogout = dtHrLogout;
	}
	
	
	
}
