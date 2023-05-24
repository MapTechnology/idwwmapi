package idw.webservices.rest.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="gt")
public class GtDTO implements Serializable {
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private String idGt;
	private String cdGt;
	private String dsGt;
	private String dsView;
	
	public GtDTO() {
		super();
	}

	public String getIdGt() {
		return idGt;
	}

	public void setIdGt(String idGt) {
		this.idGt = idGt;
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

	public String getDsView() {
		return dsView;
	}

	public void setDsView(String dsView) {
		this.dsView = dsView;
	}
	
}
