package idw.webservices.dto;

import java.util.Date;

public class AtividadeRealizadaDTO {
	Long idCp;
	Date dthrInicio;
	Long idProcedimento;
	Date dthrFim;
	Long idProcativ;
	Long idUsr;
	Byte stProreaativ; 
	String dsObs;
	
	public Long getIdCp() {
		return idCp;
	}
	public void setIdCp(Long idCp) {
		this.idCp = idCp;
	}
	public Long getIdProcativ() {
		return idProcativ;
	}
	public void setIdProcativ(Long idProcativ) {
		this.idProcativ = idProcativ;
	}
	public Long getIdUsr() {
		return idUsr;
	}
	public void setIdUsr(Long idUsr) {
		this.idUsr = idUsr;
	}
	public Byte getStProreaativ() {
		return stProreaativ;
	}
	public void setStProreaativ(Byte stProreaativ) {
		this.stProreaativ = stProreaativ;
	}
	public String getDsObs() {
		return dsObs;
	}
	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}
	public Date getDthrInicio() {
		return dthrInicio;
	}
	public void setDthrInicio(Date dthrInicio) {
		this.dthrInicio = dthrInicio;
	}
	public Date getDthrFim() {
		return dthrFim;
	}
	public void setDthrFim(Date dthrFim) {
		this.dthrFim = dthrFim;
	}
	public Long getIdProcedimento() {
		return idProcedimento;
	}
	public void setIdProcedimento(Long idProcedimento) {
		this.idProcedimento = idProcedimento;
	}

}
