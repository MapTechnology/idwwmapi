package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioPlanejamentoRealizadoDTO {

	private OmGt omgt;
	private OmPt Ompt;
	private DwRap dwRap;
	private DwRap gpDwRap;
	private Date periodoInicial;
	private Date periodoFinal;
	private Date periodoEmissaoRelatorio;
	private String horarios;
	private DwGrupoFerramenta dwGrupoFerramenta;
	private boolean peca;
	private boolean kilograma;
	private boolean tonelada;

	public Date getPeriodoEmissaoRelatorio() {
		return periodoEmissaoRelatorio;
	}

	public void setPeriodoEmissaoRelatorio(Date periodoEmissaoRelatorio) {
		this.periodoEmissaoRelatorio = periodoEmissaoRelatorio;
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

	public DwRap getGpDwRap() {
		return gpDwRap;
	}

	public void setGpDwRap(DwRap gpDwRap) {
		this.gpDwRap = gpDwRap;
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

	public Date getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public DwGrupoFerramenta getDwGrupoFerramenta() {
		return dwGrupoFerramenta;
	}

	public void setDwGrupoFerramenta(DwGrupoFerramenta dwGrupoFerramenta) {
		this.dwGrupoFerramenta = dwGrupoFerramenta;
	}

	public boolean isKilograma() {
		return kilograma;
	}

	public void setKilograma(boolean kilograma) {
		this.kilograma = kilograma;
	}

	public boolean isTonelada() {
		return tonelada;
	}

	public void setTonelada(boolean tonelada) {
		this.tonelada = tonelada;
	}

	public boolean isPeca() {
		return peca;
	}

	public void setPeca(boolean peca) {
		this.peca = peca;
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

		retorno += "dwRap=";
		
		if (this.dwRap != null) {
			retorno += this.dwRap.getCd()  + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "gpDwRap=";
		
		if (this.gpDwRap != null) {
			retorno += this.gpDwRap.getCd()  + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "periodoInicial=" + this.periodoInicial + ", " +
				   "periodoFinal=" + this.periodoFinal + ", " +
				   "periodoEmissaoRelatorio=" + this.periodoEmissaoRelatorio + ", " +
				   "horarios=" + this.horarios + ", ";
		
		retorno += "dwGrupoFerramenta=";
		
		if (this.dwGrupoFerramenta != null) {
			retorno += this.dwGrupoFerramenta.getCd()  + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "peca=" + this.peca + ", " +
				   "kilograma=" + this.kilograma + ", " +
				   "tonelada=" + this.tonelada + "]";
		
		return retorno;
		/*
		return "FiltroRelatorioPlanejamentoRealizadoDTO [omgt=" + omgt + ", Ompt=" + Ompt + ", dwRap=" + dwRap + ", gpDwRap=" + gpDwRap
				+ ", periodoInicial=" + periodoInicial + ", periodoFinal=" + periodoFinal + ", periodoEmissaoRelatorio="
				+ periodoEmissaoRelatorio + ", horarios=" + horarios + ", dwGrupoFerramenta=" + dwGrupoFerramenta + ", peca=" + peca
				+ ", kilograma=" + kilograma + ", tonelada=" + tonelada + "]";
		*/
		
	}

}
