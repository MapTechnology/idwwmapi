package idw.webservices.rest.wm.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pt")
public class PtDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idPt;
	private String cdPt;
	private String dsPt;
	
	public long getIdPt() {
		return idPt;
	}
	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	
	
}
