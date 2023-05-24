package idw.webservices.rest.idw.v2.dto;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="usr")
public class UsrDTO implements Serializable {
	private static final long serialVersionUID = 1L; 

	private Long idUsr;
	
	private String cdUsr;
	private String dsUsr; 
	private String login;
	private String senha;
	private String email;
	
	private String cdUsrGrp;
	private String dsUsrGrp;
	private String cdGt;
	private String dsGt;
	private String cdCargo;
	
	private String cdUsrRev;
	private Integer stRegistro;
	public Long getIdUsr() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCdUsrGrp() {
		return cdUsrGrp;
	}
	public void setCdUsrGrp(String cdUsrGrp) {
		this.cdUsrGrp = cdUsrGrp;
	}
	public String getDsUsrGrp() {
		return dsUsrGrp;
	}
	public void setDsUsrGrp(String dsUsrGrp) {
		this.dsUsrGrp = dsUsrGrp;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public String getDsGt() {
		return dsGt;
	}
	public void setDsGt(String dsGt) {
		this.dsGt = dsGt;
	}
	public String getCdCargo() {
		return cdCargo;
	}
	public void setCdCargo(String cdCargo) {
		this.cdCargo = cdCargo;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
	
		
}
