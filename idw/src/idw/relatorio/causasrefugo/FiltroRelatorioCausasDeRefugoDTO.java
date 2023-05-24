package idw.relatorio.causasrefugo;

import java.util.Date;

import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.webservices.dto.TurnoDTO;

public class FiltroRelatorioCausasDeRefugoDTO {

	private String nrDoc;
    private Date periodoInicial;
    private Date periodoFinal;
    
    private TurnoDTO turnoDTO;
    
    private OmGt omgt;
    private OmPt ompt;
    private DwRap rap;
    private DwGrupoFerramenta dwGrupoFerramenta;
    
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
    public DwRap getRap() {
        return rap;
    }
    public void setRap(DwRap rap) {
        this.rap = rap;
    }
    public DwGrupoFerramenta getDwGrupoFerramenta() {
        return dwGrupoFerramenta;
    }
    public void setDwGrupoFerramenta(DwGrupoFerramenta dwGrupoFerramenta) {
        this.dwGrupoFerramenta = dwGrupoFerramenta;
    }
	public String getNrDoc() {
		return nrDoc;
	}
	public void setNrDoc(String nrDoc) {
		this.nrDoc = nrDoc;
	}
	@Override
	public String toString() {

		String retorno;
		
		retorno = "FiltroRelatorioCausasDeRefugoDTO ["; 
		
		retorno += "nrDoc=" + nrDoc + ", " +
		           "periodoInicial=" + periodoInicial + ", " +
				   "periodoFinal=" + periodoFinal + ", ";

		retorno += "turnoDTO=";
		
		if (this.turnoDTO != null) {
			retorno += this.turnoDTO.getTurno().getCdTurno() + ", ";
		} else {
			retorno += "null, ";
		}
		
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
		
		retorno += "rap=";
		
		if (this.rap != null) {
			retorno += this.rap.getCd()  + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dwGrupoFerramenta=";
		
		if (this.dwGrupoFerramenta != null) {
			retorno += this.dwGrupoFerramenta.getCd() + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*
		return "FiltroRelatorioCausasDeRefugoDTO [nrDoc=" + nrDoc + ", periodoInicial=" + periodoInicial + ", periodoFinal=" + periodoFinal
				+ ", turnoDTO=" + turnoDTO + ", omgt=" + omgt + ", ompt=" + ompt + ", rap=" + rap + ", dwGrupoFerramenta="
				+ dwGrupoFerramenta + "]";
		*/
	}

}