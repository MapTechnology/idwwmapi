package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioPeriodoSemOpDTO {
	
	private OmGt omgt;
    private OmPt Ompt;
    private Date periodoInicial;
    private Date periodoFinal;
    private DwTurno dwTurno;
    
	public OmGt getOmgt() {
		return omgt;
	}
	public void setOmgt(OmGt omgt) {
		this.omgt = omgt;
	}
	public OmPt getOmpt() {
		return Ompt;
	}
	public void setOmpt(OmPt ompt) {
		Ompt = ompt;
	}
	public Date getPeriodoInicial() {
		return periodoInicial;
	}
	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}
	public Date getPeriodoFinal() {
		return periodoFinal;
	}
	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}
	public DwTurno getDwTurno() {
		return dwTurno;
	}
	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelatorioPeriodoSemOpDTO ["; 
		
		retorno += "omgt=";

		if (this.omgt != null) {
			retorno += this.omgt.getCdGt() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "Ompt=";
		
		if (this.Ompt != null) {
			retorno += this.Ompt.getCdPt() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "periodoInicial=" + this.periodoInicial + ", " +
				   "periodoFinal=" + this.periodoFinal + ", ";
		
		retorno += "dwTurno=";
		
		if (this.dwTurno != null) {
			retorno += this.dwTurno.getCdTurno() + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*
		return "FiltroRelatorioPeriodoSemOpDTO [omgt=" + omgt + ", Ompt=" + Ompt + ", periodoInicial=" + periodoInicial + ", periodoFinal="
				+ periodoFinal + ", dwTurno=" + dwTurno + "]";
		*/
	}
	
}
