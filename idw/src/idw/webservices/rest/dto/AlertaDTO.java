package idw.webservices.rest.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="ptAlerta")
public class AlertaDTO implements Serializable {
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private String cdAlerta;
	private String dsAlerta;
	private String dtHrInicio;
	private String dtHrFim;
	
	public String getCdAlerta() {
		return cdAlerta;
	}
	public void setCdAlerta(String cdAlerta) {
		this.cdAlerta = cdAlerta;
	}
	public String getDsAlerta() {
		return dsAlerta;
	}
	public void setDsAlerta(String dsAlerta) {
		this.dsAlerta = dsAlerta;
	}
	public String getDtHrInicio() {
		return dtHrInicio;
	}
	public void setDtHrInicio(String dtHrInicio) {
		this.dtHrInicio = dtHrInicio;
	}
	public String getDtHrFim() {
		return dtHrFim;
	}
	public void setDtHrFim(String dtHrFim) {
		this.dtHrFim = dtHrFim;
	}
	
	
	
	
}
