package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

public class FiltroRelProcedimentoDTO {
	
	private Date dataInicio;
	private Date dataFim;
	private DwTurno dwTurno;
	private OmPt omPt;
	private OmGt omGt;
	private OmProduto omProduto;
	private PpCp ppCp;
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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
	public OmProduto getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}
	public PpCp getPpCp() {
		return ppCp;
	}
	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroRelProcedimentoDTO [";
		
		retorno += "dataInicio=" + this.dataInicio + ", " +
				   "dataFim=" + this.dataFim + ", ";

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
		
		retorno += "omProduto=";
		
		if (this.omProduto != null) {
			retorno += this.omProduto.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "ppCp=";
		
		if (this.ppCp != null) {
			retorno += this.ppCp.getCd() + "]";
		} else {
			retorno += "null]";
		}
		
		return retorno;
		/*
		return "FiltroRelProcedimentoDTO [dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", dwTurno=" + dwTurno + ", omPt=" + omPt
				+ ", omGt=" + omGt + ", omProduto=" + omProduto + ", ppCp=" + ppCp + "]";
		*/
	}

}