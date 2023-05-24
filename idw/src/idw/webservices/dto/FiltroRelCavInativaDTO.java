package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelCavInativaDTO {
	
	private Date dataInicial;
	private Date dataFinal;
	private DwTurno dwTurno;
	private OmPt omPt;
	private OmGt omGt;    
    private DwRap dwRap;
    private DwGrupoFerramenta dwGrupoFerramenta;
	private boolean isCavInativas;
	
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
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
	public boolean isCavInativas() {
		return isCavInativas;
	}
	public void setCavInativas(boolean isCavInativas) {
		this.isCavInativas = isCavInativas;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelCavInativaDTO [";
		
		retorno += "dataInicial=" + this.dataInicial + ", " + 
				   "dataFinal=" + this.dataFinal + ", ";

		retorno += "dwTurno=";
		
		if (this.dwTurno != null) {
			retorno += this.dwTurno.getCdTurno() + ", ";
		} else {
			retorno += "null, ";
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
		
		retorno += "dwRap=";
		
		if (this.dwRap != null) {
			retorno += this.dwRap.getCd() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "dwGrupoFerramenta=";
		
		if (this.dwGrupoFerramenta != null) {
			retorno += this.dwGrupoFerramenta.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "isCavInativas=" + this.isCavInativas + "]";
		
		return retorno;
		/*
		return "FiltroRelCavInativaDTO [dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", dwTurno=" + dwTurno + ", omPt="
				+ omPt + ", omGt=" + omGt + ", dwRap=" + dwRap + ", dwGrupoFerramenta=" + dwGrupoFerramenta + ", isCavInativas="
				+ isCavInativas + "]";
		*/
	}
	
}