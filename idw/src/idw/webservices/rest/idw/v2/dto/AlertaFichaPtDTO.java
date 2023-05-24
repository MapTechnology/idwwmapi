package idw.webservices.rest.idw.v2.dto;

public class AlertaFichaPtDTO {
	private String cdPt;
	private String dthrIniAlerta;
	private String dthrFimAlerta; 
	private String cdAlerta;
	private String dsAlerta; 
	private String nmUsrResp;
	private String observacao;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getDthrIniAlerta() {
		return dthrIniAlerta;
	}
	public void setDthrIniAlerta(String dthrIniAlerta) {
		this.dthrIniAlerta = dthrIniAlerta;
	}
	public String getDthrFimAlerta() {
		return dthrFimAlerta;
	}
	public void setDthrFimAlerta(String dthrFimAlerta) {
		this.dthrFimAlerta = dthrFimAlerta;
	}
	public String getNmUsrResp() {
		return nmUsrResp;
	}
	public void setNmUsrResp(String nmUsrResp) {
		this.nmUsrResp = nmUsrResp;
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
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
}
