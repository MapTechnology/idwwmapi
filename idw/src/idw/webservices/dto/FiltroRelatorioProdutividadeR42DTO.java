package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioProdutividadeR42DTO {

	private OmGt omgt;
	private OmPt ompt;
	private TurnoDTO turnoDTO;
	private String horario;
	private Date periodoInicial;
	private Date periodoFinal;
	private DwRap dwRap;
	private DwGrupoFerramenta grupoFerramenta;
	
	/**
	 * @return the omgt
	 */
	public OmGt getOmgt() {
		return omgt;
	}
	/**
	 * @param omgt the omgt to set
	 */
	public void setOmgt(OmGt omgt) {
		this.omgt = omgt;
	}
	/**
	 * @return the ompt
	 */
	public OmPt getOmpt() {
		return ompt;
	}
	/**
	 * @param ompt the ompt to set
	 */
	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}
	/**
	 * @return the turnoDTO
	 */
	public TurnoDTO getTurnoDTO() {
		return turnoDTO;
	}
	/**
	 * @param turnoDTO the turnoDTO to set
	 */
	public void setTurnoDTO(TurnoDTO turnoDTO) {
		this.turnoDTO = turnoDTO;
	}
	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}
	/**
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	/**
	 * @return the periodoInicial
	 */
	public Date getPeriodoInicial() {
		return periodoInicial;
	}
	/**
	 * @param periodoInicial the periodoInicial to set
	 */
	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}
	/**
	 * @return the periodoFinal
	 */
	public Date getPeriodoFinal() {
		return periodoFinal;
	}
	/**
	 * @param periodoFinal the periodoFinal to set
	 */
	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}
	/**
	 * @return the dwRap
	 */
	public DwRap getDwRap() {
		return dwRap;
	}
	/**
	 * @param dwRap the dwRap to set
	 */
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}
	/**
	 * @return the grupoFerramenta
	 */
	public DwGrupoFerramenta getGrupoFerramenta() {
		return grupoFerramenta;
	}
	/**
	 * @param grupoFerramenta the grupoFerramenta to set
	 */
	public void setGrupoFerramenta(DwGrupoFerramenta grupoFerramenta) {
		this.grupoFerramenta = grupoFerramenta;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelatorioProdutividadeR42DTO ["; 
		
		retorno += "omgt=";
		
		if (this.omgt != null) {
			retorno += this.omgt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "ompt=";
		
		if (this.ompt != null) {
			retorno += this.ompt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "TurnoDTO=";
		
		if (this.turnoDTO != null) {
			retorno += this.turnoDTO.getTurno().getCdTurno() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "horario=" + this.horario + ", " + 
				   "periodoInicial=" + this.periodoInicial + ", " +
				   "periodoFinal=" + this.periodoFinal + ", ";				   

		retorno += "dwRap=";
		
		if (this.dwRap != null) {
			retorno += this.dwRap.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "grupoFerramenta=";
		
		if (this.grupoFerramenta != null) {
			retorno += this.grupoFerramenta.getCd() + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*
		return "FiltroRelatorioProdutividadeR42DTO [omgt=" + omgt + ", ompt=" + ompt + ", turnoDTO=" + turnoDTO + ", horario=" + horario
				+ ", periodoInicial=" + periodoInicial + ", periodoFinal=" + periodoFinal + ", dwRap=" + dwRap + ", grupoFerramenta="
				+ grupoFerramenta + "]";
		*/
	}
	
}
