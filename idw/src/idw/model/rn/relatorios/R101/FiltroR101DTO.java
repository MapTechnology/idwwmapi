package idw.model.rn.relatorios.R101;

import java.io.Serializable;
import java.util.Date;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroR101DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean isPeriodo;
	private Date dthrInicio;
	private Date dthrFinal;
	private String ns;
	private String op;
	private OmPt ompt;
	private OmGt omgt;
	private Boolean isTodosTurnos;
	private DwTurno dwturno;
	public Boolean getIsPeriodo() {
		return isPeriodo;
	}
	public void setIsPeriodo(Boolean isPeriodo) {
		this.isPeriodo = isPeriodo;
	}
	public Date getDthrInicio() {
		return dthrInicio;
	}
	public void setDthrInicio(Date dthrInicio) {
		this.dthrInicio = dthrInicio;
	}
	public Date getDthrFinal() {
		return dthrFinal;
	}
	public void setDthrFinal(Date dthrFinal) {
		this.dthrFinal = dthrFinal;
	}
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public OmPt getOmpt() {
		return ompt;
	}
	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}
	public OmGt getOmgt() {
		return omgt;
	}
	public void setOmgt(OmGt omgt) {
		this.omgt = omgt;
	}
	public Boolean getIsTodosTurnos() {
		return isTodosTurnos;
	}
	public void setIsTodosTurnos(Boolean isTodosTurnos) {
		this.isTodosTurnos = isTodosTurnos;
	}
	public DwTurno getDwturno() {
		return dwturno;
	}
	public void setDwturno(DwTurno dwturno) {
		this.dwturno = dwturno;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroR101DTO ["; 
		
		retorno += "isPeriodo=" + this.isPeriodo + ", " +
		           "dthrInicio=" + this.dthrInicio + ", " +
				   "dthrFinal=" + this.dthrFinal + ", " +
		           "ns=" + this.ns + ", " +
		           "op=" + this.op + ", "; 
		
		retorno += "ompt=";
		
		if (this.ompt != null) {
			retorno += this.ompt.getCdPt() + ", ";
		} else {
			retorno += "null, ";
		}

       retorno += "omgt=";

		if (this.omgt != null) {
			retorno += this.omgt.getCdGt() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "isTodosTurnos=" + this.isTodosTurnos + ", ";
		
		retorno += "dwturno=";
		
		if (this.dwturno != null) {
			retorno += this.dwturno.getCdTurno() + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*
		return "FiltroR101DTO [isPeriodo=" + isPeriodo + ", dthrInicio=" + dthrInicio + ", dthrFinal=" + dthrFinal + ", ns=" + ns + ", op="
				+ op + ", ompt=" + ompt + ", omgt=" + omgt + ", isTodosTurnos=" + isTodosTurnos + ", dwturno=" + dwturno + "]";
		*/
	}
	
}
