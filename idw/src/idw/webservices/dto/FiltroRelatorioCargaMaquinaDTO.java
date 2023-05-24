package idw.webservices.dto;

import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioCargaMaquinaDTO {
	private OmGt omgt;
    private OmPt Ompt;
    private DwRap dwRap;
    private DwGrupoFerramenta dwGrupoFerramenta;
    private DwGrupoFerramenta molde;   
	private Integer selecionaMes;
    private Integer selecionaAno;
    
	public DwGrupoFerramenta getMolde() {
		return molde;
	}
	public void setMolde(DwGrupoFerramenta molde) {
		this.molde = molde;
	}
	public Integer getSelecionaAno() {
		return selecionaAno;
	}
	public void setSelecionaAno(Integer selecionaAno) {
		this.selecionaAno = selecionaAno;
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
	public DwGrupoFerramenta getDwGrupoFerramenta() {
		return dwGrupoFerramenta;
	}
	public void setDwGrupoFerramenta(DwGrupoFerramenta dwGrupoFerramenta) {
		this.dwGrupoFerramenta = dwGrupoFerramenta;
	}
	public Integer getSelecionaMes() {
		return selecionaMes;
	}
	public void setSelecionaMes(Integer selecionaMes) {
		this.selecionaMes = selecionaMes;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelatorioCargaMaquinaDTO ["; 
		
		retorno += "omgt=";
		
		if (this.omgt != null) {
			retorno += this.omgt.getCdGt() + ", ";
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
			retorno += this.dwGrupoFerramenta.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "molde=";
		
		if (this.molde != null) {
			retorno += this.molde.getCd() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "selecionaMes=" + this.selecionaMes + ", " +
				   "selecionaAno=" + this.selecionaAno + "]";
		
		return retorno;
		/*
		return "FiltroRelatorioCargaMaquinaDTO [omgt=" + omgt + ", Ompt=" + Ompt + ", dwRap=" + dwRap + ", dwGrupoFerramenta="
				+ dwGrupoFerramenta + ", molde=" + molde + ", selecionaMes=" + selecionaMes + ", selecionaAno=" + selecionaAno + "]";
		*/
	}
}
