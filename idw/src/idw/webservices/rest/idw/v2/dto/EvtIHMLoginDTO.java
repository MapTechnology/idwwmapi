package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="evtlogin")
public class EvtIHMLoginDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cdPt;
	private String login;
	private String senha;
	private String dthrLoginMs; //YMDHMS.m
	private String dthrLogoutMs;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
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
	public String getDthrLoginMs() {
		return dthrLoginMs;
	}
	public void setDthrLoginMs(String dthrLoginMs) {
		this.dthrLoginMs = dthrLoginMs;
	}
	public String getDthrLogoutMs() {
		return dthrLogoutMs;
	}
	public void setDthrLogoutMs(String dthrLogoutMs) {
		this.dthrLogoutMs = dthrLogoutMs;
	}
	

	
}
