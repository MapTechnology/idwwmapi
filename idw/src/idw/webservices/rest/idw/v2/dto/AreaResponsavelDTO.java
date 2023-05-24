package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="acao")
public class AreaResponsavelDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idAreaResponsavel;
	private String cdAreaResponsavel;
	private String dsAreaResponsavel;
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdAreaResponsavel() {
		return idAreaResponsavel;
	}
	public void setIdAreaResponsavel(Long idAreaResponsavel) {
		this.idAreaResponsavel = idAreaResponsavel;
	}
	public String getCdAreaResponsavel() {
		return cdAreaResponsavel;
	}
	public void setCdAreaResponsavel(String cdAreaResponsavel) {
		this.cdAreaResponsavel = cdAreaResponsavel;
	}
	public String getDsAreaResponsavel() {
		return dsAreaResponsavel;
	}
	public void setDsAreaResponsavel(String dsAreaResponsavel) {
		this.dsAreaResponsavel = dsAreaResponsavel;
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
