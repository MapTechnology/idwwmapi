package idw.webservices.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ObservacaoRealizadaDTO {
	
	private String idObs;
	private Date dthr;
	private Long idProcativ;
	private Long idCp;
	private Long idProcedimento;	
	private String dsObs;
	
	public Date getDthr() {
		return dthr;
	}
	public void setDthr(Date dthr) {
		this.dthr = dthr;
	}
	public Long getIdProcativ() {
		return idProcativ;
	}
	public void setIdProcativ(Long idProcativ) {
		this.idProcativ = idProcativ;
	}
	public String getDsObs() {
		return dsObs;
	}
	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}
	public Long getIdProcedimento() {
		return idProcedimento;
	}
	public void setIdProcedimento(Long idProcedimento) {
		this.idProcedimento = idProcedimento;
	}
	public Long getIdCp() {
		return idCp;
	}
	public void setIdCp(Long idCp) {
		this.idCp = idCp;
	}
	public String getIdObs() {
		return idObs;
	}
	public void setIdObs(String idObs) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		this.idObs = idCp.toString() + idProcativ.toString() + idProcedimento.toString() + formatter.format(dthr);
	}

}
