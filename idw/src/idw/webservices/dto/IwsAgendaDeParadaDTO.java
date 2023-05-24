package idw.webservices.dto;

import java.util.Date;

public class IwsAgendaDeParadaDTO {
	private Date dthrInicioAgenda;
	private Date dthrFimAgenda;
	private String motivoParadaAgenda;
	
	public Date getDthrInicioAgenda() {
		return dthrInicioAgenda;
	}
	public void setDthrInicioAgenda(Date dthrInicioAgenda) {
		this.dthrInicioAgenda = dthrInicioAgenda;
	}
	public Date getDthrFimAgenda() {
		return dthrFimAgenda;
	}
	public void setDthrFimAgenda(Date dthrFimAgenda) {
		this.dthrFimAgenda = dthrFimAgenda;
	}
	public String getMotivoParadaAgenda() {
		return motivoParadaAgenda;
	}
	public void setMotivoParadaAgenda(String motivoParadaAgenda) {
		this.motivoParadaAgenda = motivoParadaAgenda;
	}
	
	
}
