package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="causa")
public class AlertaDTO2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idAlerta;
	private String cdAlerta;
	private String dsAlerta; 
	private String tpPt;
	private Boolean timeout;
	private Boolean automatico;
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdAlerta() {
		return idAlerta;
	}
	public void setIdAlerta(Long idAlerta) {
		this.idAlerta = idAlerta;
	}
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
	public String getTpPt() {
		return tpPt;
	}
	public void setTpPt(String tpPt) {
		this.tpPt = tpPt;
	}
	public Boolean isTimeout() {
		return timeout;
	}
	public void setTimeout(Boolean timeout) {
		this.timeout = timeout;
	}
	public Boolean isAutomatico() {
		return automatico;
	}
	public void setAutomatico(Boolean automatico) {
		this.automatico = automatico;
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
