package ms.coleta.dto;

import java.util.Date;

public class SessaoAlertaDTO {
	private String cdAlerta = "";
	private String dsAlerta = "";
	private Date dthrIAlerta;
	private boolean isTimeout;
	private boolean isAutomatico;
	private long idTppt;
	
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
	public Date getDthrIAlerta() {
		return dthrIAlerta;
	}
	public void setDthrIAlerta(Date dthrIAlerta) {
		this.dthrIAlerta = dthrIAlerta;
	}
	public boolean isTimeout() {
		return isTimeout;
	}
	public void setTimeout(boolean isTimeout) {
		this.isTimeout = isTimeout;
	}
	public boolean isAutomatico() {
		return isAutomatico;
	}
	public void setAutomatico(boolean isAutomatico) {
		this.isAutomatico = isAutomatico;
	}
	public long getIdTppt() {
		return idTppt;
	}
	public void setIdTppt(long idTppt) {
		this.idTppt = idTppt;
	}
	
}
