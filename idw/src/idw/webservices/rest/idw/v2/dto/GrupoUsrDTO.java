package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="grpusr")
public class GrupoUsrDTO implements Serializable {
	private static final long serialVersionUID = 1L; 

	private Long idGrpUsr;
	
	private String cdGrpUsr;
	private String dsGrpUsr;
	
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdGrpUsr() {
		return idGrpUsr;
	}
	public void setIdGrpUsr(Long idGrpUsr) {
		this.idGrpUsr = idGrpUsr;
	}
	public String getCdGrpUsr() {
		return cdGrpUsr;
	}
	public void setCdGrpUsr(String cdGrpUsr) {
		this.cdGrpUsr = cdGrpUsr;
	}
	public String getDsGrpUsr() {
		return dsGrpUsr;
	}
	public void setDsGrpUsr(String dsGrpUsr) {
		this.dsGrpUsr = dsGrpUsr;
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
