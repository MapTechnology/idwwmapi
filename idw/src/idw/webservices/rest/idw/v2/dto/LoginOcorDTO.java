package idw.webservices.rest.idw.v2.dto;

public class LoginOcorDTO { 
	private String nmUsr;
	private String cdUsr;
	private String login;
	private String dthrLoginMs;  // YMDHMS.m
	private String dthrLogoutMs;
	private String tempoLogadoHMS;
	private Long tempoLogado;
	
	public String getNmUsr() {
		return nmUsr;
	}
	public void setNmUsr(String nmUsr) {
		this.nmUsr = nmUsr;
	}
	public String getCdUsr() {
		return cdUsr;
	}
	public void setCdUsr(String cdUsr) {
		this.cdUsr = cdUsr;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getDthrLoginMs() {
		return dthrLoginMs;
	}
	public void setDthrLoginMs(String dthrLoginMs) {
		this.dthrLoginMs = dthrLoginMs;
	}
	public String getDthrLogoutMs() {
		return dthrLogoutMs;
	}
	public void setDthrLogoutMs(String dthrLogoutMs) {
		this.dthrLogoutMs = dthrLogoutMs;
	}
	public String getTempoLogadoHMS() {
		return tempoLogadoHMS;
	}
	public void setTempoLogadoHMS(String tempoLogadoHMS) {
		this.tempoLogadoHMS = tempoLogadoHMS;
	}
	public Long getTempoLogado() {
		return tempoLogado;
	}
	public void setTempoLogado(Long tempoLogado) {
		this.tempoLogado = tempoLogado;
	}
	
	
}
