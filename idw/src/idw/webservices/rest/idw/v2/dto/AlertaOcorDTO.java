package idw.webservices.rest.idw.v2.dto;

public class AlertaOcorDTO {
	private String cdPt;
	private String cdAlerta;
	private String dsAlerta; 
	private String dtHrIniAlertaMs; //YMDHMS.m; 
	
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
	public String getDsAlerta() {
		return dsAlerta;
	}
	public void setDsAlerta(String dsAlerta) {
		this.dsAlerta = dsAlerta;
	}
	public String getDtHrIniAlertaMs() {
		return dtHrIniAlertaMs;
	}
	public void setDtHrIniAlertaMs(String dtHrIniAlertaMs) {
		this.dtHrIniAlertaMs = dtHrIniAlertaMs;
	}
	
 
 		
}
