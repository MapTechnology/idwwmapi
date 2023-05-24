package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioProgramacaoDTO {
	
	private Date dtInicio;
	private Date dtFim;
	private DwTurno dwTurno;
	private OmPt omPt;
	private OmGt omGt;
	private boolean isPeca;
	private boolean isKilograma;
	private boolean isOpsDisponiveis;
	private boolean isOpsEmMaquinas;
	
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	public Date getDtFim() {
		return dtFim;
	}
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
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
	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}
	public boolean isPeca() {
		return isPeca;
	}
	public void setPeca(boolean isPeca) {
		this.isPeca = isPeca;
	}
	public boolean isKilograma() {
		return isKilograma;
	}
	public void setKilograma(boolean isKilograma) {
		this.isKilograma = isKilograma;
	}
	public boolean isOpsDisponiveis() {
		return isOpsDisponiveis;
	}
	public void setOpsDisponiveis(boolean isOpsDisponiveis) {
		this.isOpsDisponiveis = isOpsDisponiveis;
	}
	public boolean isOpsEmMaquinas() {
		return isOpsEmMaquinas;
	}
	public void setOpsEmMaquinas(boolean isOpsEmMaquinas) {
		this.isOpsEmMaquinas = isOpsEmMaquinas;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelatorioProgramacaoDTO ["; 
		
		retorno += "dtInicio=" + this.dtInicio + ", " +
				   "dtFim=" + this.dtFim + ", ";
		
		retorno += "dwTurno=";
		
		if (this.dwTurno != null) {
			retorno += this.dwTurno.getCdTurno() + ", ";
		} else {
			retorno += "null]";
		}
		
		retorno += "omPt=";
		
		if (this.omPt != null) {
			retorno += this.omPt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "omGt=";

		if (this.omGt != null) {
			retorno += this.omGt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "isPeca=" + this.isPeca + ", " +
				   "isKilograma=" + this.isKilograma + ", " +
				   "isOpsDisponiveis=" + this.isOpsDisponiveis + ", " +
				   "isOpsEmMaquinas=" + this.isOpsEmMaquinas + "]";
		
		return retorno;
		/*		
		return "FiltroRelatorioProgramacaoDTO [dtInicio=" + dtInicio + ", dtFim=" + dtFim + ", dwTurno=" + dwTurno + ", omPt=" + omPt
				+ ", omGt=" + omGt + ", isPeca=" + isPeca + ", isKilograma=" + isKilograma + ", isOpsDisponiveis=" + isOpsDisponiveis
				+ ", isOpsEmMaquinas=" + isOpsEmMaquinas + "]";
		*/
	}
	
}