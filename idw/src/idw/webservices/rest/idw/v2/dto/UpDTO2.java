package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="up") 
public class UpDTO2 implements Serializable {
	private static final long serialVersionUID = 1L; 

	private Integer idUP;
	private String cdUP;
	private String dsUP;
	private List<IhmUpDTO2> ihms;
	private String cdUsrRev;
	private Integer stRegistro;
	public Integer getIdUP() {
		return idUP;
	}
	public void setIdUP(Integer idUP) {
		this.idUP = idUP;
	}
	public String getCdUP() {
		return cdUP;
	}
	public void setCdUP(String cdUP) {
		this.cdUP = cdUP;
	}
	public String getDsUP() {
		return dsUP;
	}
	public void setDsUP(String dsUP) {
		this.dsUP = dsUP;
	}
	public List<IhmUpDTO2> getIhms() {
		return ihms;
	}
	public void setIhms(List<IhmUpDTO2> ihms) {
		this.ihms = ihms;
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
