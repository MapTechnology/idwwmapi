package idw.webservices.dto;

import java.util.Date;
import java.util.List;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioIndiceParadasDTO {
	
	private OmGt omgt;
    private OmPt Ompt;
    private DwRap dwRap;
    private DwGrupoFerramenta dwGrupoFerramenta;
    private TurnoDTO TurnoDTO;
	private Date periodoInicial;
	private Date periodoFinal;
	private String horarios;
	private String tipo;
	private String cdop;
	private List<DwTParada> dwTParadas;
	private List<DwTArea> dwTAreas;
	private Boolean isTodasAreas;
	private Boolean isTodasParadas;
	private DwFolha dwFolha;
	private Boolean isRetirarParadasPequenas;
	
	public String getCdop() {
		return cdop;
	}
	public void setCdop(String cdop) {
		this.cdop = cdop;
	}	
	public DwGrupoFerramenta getDwGrupoFerramenta() {
		return dwGrupoFerramenta;
	}
	public void setDwGrupoFerramenta(DwGrupoFerramenta dwGrupoFerramenta) {
		this.dwGrupoFerramenta = dwGrupoFerramenta;
	}
	public TurnoDTO getTurnoDTO() {
		return TurnoDTO;
	}
	public void setTurnoDTO(TurnoDTO turnoDTO) {
		TurnoDTO = turnoDTO;
	}
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
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<DwTParada> getDwTParadas() {
		return dwTParadas;
	}
	public void setDwTParadas(List<DwTParada> dwTParadas) {
		this.dwTParadas = dwTParadas;
	}
	public List<DwTArea> getDwTAreas() {
		return dwTAreas;
	}
	public void setDwTAreas(List<DwTArea> dwTAreas) {
		this.dwTAreas = dwTAreas;
	}
	public Boolean getIsTodasAreas() {
		return isTodasAreas;
	}
	public void setIsTodasAreas(Boolean isTodasAreas) {
		this.isTodasAreas = isTodasAreas;
	}
	public DwFolha getDwFolha() {
		return dwFolha;
	}
	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}
	public Boolean getIsTodasParadas() {
		return isTodasParadas;
	}
	public void setIsTodasParadas(Boolean isTodasParadas) {
		this.isTodasParadas = isTodasParadas;
	}
	
	public void setIsRetirarParadasPequenas (boolean isRetirarParadasPequenas){
		this.isRetirarParadasPequenas = isRetirarParadasPequenas;
	}
	
	public boolean getIsRetirarParadasPequenas (){
		return this.isRetirarParadasPequenas;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelatorioIndiceParadasDTO ["; 
		
		retorno += "omgt=";

		if (this.omgt != null) {
			retorno += this.omgt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "Ompt=";
		
		if (this.Ompt != null) {
			retorno += this.Ompt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dwRap=";
		
		if (this.dwRap != null) {
			retorno += this.dwRap.getCd()  + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dwGrupoFerramenta=";
		
		if (this.dwGrupoFerramenta != null) {
			retorno += this.dwGrupoFerramenta.getCd() + "]";
		} else {
			retorno += "null]";
		}
		
		retorno += "TurnoDTO=";
		
		if (this.TurnoDTO != null) {
			retorno += this.TurnoDTO.getTurno().getCdTurno() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "periodoInicial=" + this.periodoInicial + ", " +
				   "periodoFinal=" + this.periodoFinal + ", " +
				   "horarios=" + this.horarios + ", " +
				   "tipo=" + this.tipo + ", " +
				   "cdop=" + this.cdop + ", ";
		
		retorno += "dwTParadas=";
		
		if (this.dwTParadas != null) {
			retorno += this.dwTParadas + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dwTAreas=";
		
		if (this.dwTAreas != null) {
			retorno += this.dwTAreas + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "isTodasAreas=" + this.isTodasAreas + ", " +
				   "isTodasParadas=" + this.isTodasParadas + ", ";
		
		retorno += "dwFolha=";
		
		if (this.dwFolha != null) {
			retorno += this.dwFolha.getCd() + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*
		return "FiltroRelatorioIndiceParadasDTO [omgt=" + omgt + ", Ompt=" + Ompt + ", dwRap=" + dwRap + ", dwGrupoFerramenta="
				+ dwGrupoFerramenta + ", TurnoDTO=" + TurnoDTO + ", periodoInicial=" + periodoInicial + ", periodoFinal=" + periodoFinal
				+ ", horarios=" + horarios + ", tipo=" + tipo + ", cdop=" + cdop + ", dwTParadas=" + dwTParadas + ", dwTAreas=" + dwTAreas
				+ ", isTodasAreas=" + isTodasAreas + ", isTodasParadas=" + isTodasParadas + ", dwFolha=" + dwFolha + "]";
		*/
	}
	
}