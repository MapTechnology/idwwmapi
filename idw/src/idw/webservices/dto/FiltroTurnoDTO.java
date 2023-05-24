package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;

public class FiltroTurnoDTO {
	
	private DwTurno dwTurno;
	private OmPt omPt;
	private Date dtReferencia;
	
	
	public DwTurno getDwTurno() {
		return dwTurno;
	}
	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	
}