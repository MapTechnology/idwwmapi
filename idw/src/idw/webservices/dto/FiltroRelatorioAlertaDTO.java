package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioAlertaDTO {
	
	private TurnoDTO TurnoDTO;
    private OmPt Ompt;
	private Date periodoInicial;
	private Date periodoFinal;
	private String horarios;
	private OmGt omgt;

	public OmGt getOmgt() {
		return omgt;
	}
	public void setOmgt(OmGt omgt) {
		this.omgt = omgt;
	}
	public TurnoDTO getTurnoDTO() {
		return TurnoDTO;
	}
	public void setTurnoDTO(TurnoDTO turnoDTO) {
		TurnoDTO = turnoDTO;
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
	public String getHorarios() {
		return horarios;
	}
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelatorioAlertaDTO ["; 
		
		retorno += "TurnoDTO=";
		
		if (this.TurnoDTO != null) {
			retorno += this.TurnoDTO.getTurno().getCdTurno() + ", ";
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
				   "periodoFinal=" + this.periodoFinal + ", " +
				   "horarios=" + this.horarios + ", ";
		
		retorno += "omgt=";

		if (this.omgt != null) {
			retorno += this.omgt.getCdGt() + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*
		return "FiltroRelatorioAlertaDTO [TurnoDTO=" + TurnoDTO + ", Ompt=" + Ompt + ", periodoInicial=" + periodoInicial
				+ ", periodoFinal=" + periodoFinal + ", horarios=" + horarios + ", omgt=" + omgt + "]";
		*/
	}
}
