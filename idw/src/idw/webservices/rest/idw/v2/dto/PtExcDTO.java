package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="posto")
public class PtExcDTO  implements Serializable {
	private static final long serialVersionUID = 1L; 

	private Long idPt;
	private String cdPt;
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdPt() {
		return idPt;
	}
	public void setIdPt(Long idPt) {
		this.idPt = idPt;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
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
