package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="evtalerta")
public class EvtIHMAlertaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cdPt;
	private String cdAlerta;
	private String dthrIniAlertaMs; //YMDHMS.m
	private String dthrFimAlertaMs;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdAlerta() {
		return cdAlerta;
	}
	public void setCdAlerta(String cdAlerta) {
		this.cdAlerta = cdAlerta;
	}
	public String getDthrIniAlertaMs() {
		return dthrIniAlertaMs;
	}
	public void setDthrIniAlertaMs(String dthrIniAlertaMs) {
		this.dthrIniAlertaMs = dthrIniAlertaMs;
	}
	public String getDthrFimAlertaMs() {
		return dthrFimAlertaMs;
	}
	public void setDthrFimAlertaMs(String dthrFimAlertaMs) {
		this.dthrFimAlertaMs = dthrFimAlertaMs;
	}
	

		
}
