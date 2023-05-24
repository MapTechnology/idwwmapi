package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioProdRegulagemDTO {

	private OmGt omgt;
	private OmPt ompt;
	private TurnoDTO turnoDTO;
	private String horario;
	private Date periodoInicial;
	private Date periodoFinal;
	private int tipoAgrupamento;
	private boolean isPeso;
	private String tipoPeso;
	
	private Boolean isFiltrarApenasPostosComRegulagem = false;
	
	private DwGrupoFerramenta grupoFerramenta;
	private DwRap rap;
	
	public boolean isPeso() {
		return isPeso;
	}
	public void setPeso(boolean isPeso) {
		this.isPeso = isPeso;
	}
	public String getTipoPeso() {
		return tipoPeso;
	}
	public void setTipoPeso(String tipoPeso) {
		this.tipoPeso = tipoPeso;
	}
	public OmGt getOmgt() {
		return omgt;
	}
	public void setOmgt(OmGt omgt) {
		this.omgt = omgt;
	}
	public OmPt getOmpt() {
		return ompt;
	}
	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}
	public TurnoDTO getTurnoDTO() {
		return turnoDTO;
	}
	public void setTurnoDTO(TurnoDTO turnoDTO) {
		this.turnoDTO = turnoDTO;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
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
	public int getTipoAgrupamento() {
		return tipoAgrupamento;
	}
	public void setTipoAgrupamento(int tipoAgrupamento) {
		this.tipoAgrupamento = tipoAgrupamento;
	}
	public DwGrupoFerramenta getGrupoFerramenta() {
		return grupoFerramenta;
	}
	public void setGrupoFerramenta(DwGrupoFerramenta grupoFerramenta) {
		this.grupoFerramenta = grupoFerramenta;
	}
	public DwRap getRap() {
		return rap;
	}
	public void setRap(DwRap rap) {
		this.rap = rap;
	}
	public Boolean getIsFiltrarApenasPostosComRegulagem() {
		return isFiltrarApenasPostosComRegulagem;
	}
	public void setIsFiltrarApenasPostosComRegulagem(Boolean isFiltrarApenasPostosComRegulagem) {
		this.isFiltrarApenasPostosComRegulagem = isFiltrarApenasPostosComRegulagem;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelatorioProdRegulagemDTO ["; 
		
		retorno += "omgt=";
		
		if (this.omgt != null) {
			retorno += this.omgt.getCdGt() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "ompt=";
		
		if (this.ompt != null) {
			retorno += this.ompt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "turnoDTO=";
		
		if (this.turnoDTO != null) {
			retorno += this.turnoDTO.getTurno().getCdTurno() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "horario=" + horario + ", " +
				   "periodoInicial=" + periodoInicial + ", " +
				   "periodoFinal=" + periodoFinal + ", " +
				   "tipoAgrupamento=" + tipoAgrupamento + ", " +
				   "isPeso=" + isPeso + ", " +
				   "tipoPeso=" + tipoPeso + ", " +
				   "isFiltrarApenasPostosComRegulagem=" + isFiltrarApenasPostosComRegulagem + ", "; 
				   
		retorno += "grupoFerramenta=";
		
		if (this.grupoFerramenta != null) {
			retorno += this.grupoFerramenta.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "rap=";
		
		if (this.rap != null) {
			retorno += this.rap.getCd()  + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*
		return "FiltroRelatorioProdRegulagemDTO [omgt=" + omgt + ", ompt=" + ompt + ", turnoDTO=" + turnoDTO + ", horario=" + horario
				+ ", periodoInicial=" + periodoInicial + ", periodoFinal=" + periodoFinal + ", tipoAgrupamento=" + tipoAgrupamento
				+ ", isPeso=" + isPeso + ", tipoPeso=" + tipoPeso + ", isFiltrarApenasPostosComRegulagem="
				+ isFiltrarApenasPostosComRegulagem + ", grupoFerramenta=" + grupoFerramenta + ", rap=" + rap + "]";
		*/
	}
	
}
