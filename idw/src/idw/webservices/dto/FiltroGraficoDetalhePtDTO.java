package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

public class FiltroGraficoDetalhePtDTO {
	private OmPt omPt;
	private PpCp ppCp;
	private OmGt omGt;
	private Date dtReferencia;
	private Date dtReferenciaFinal;
	private Date dtReferenciaInicial;
	private long idrt;
	private DwTurno dwTurno;
	private DwFolha dwfolha;
	private DwTParada dwTParada;
	private Date dthrIturno;
	private Date dthrFturno;
	private Date dthrIhora;
	private Date dthrFhora;
	private Byte tpId;
	
	private DwRap dwRap;
	private OmProduto omProduto;

	private Integer anoInicial;
	private Integer mesInicial;
	private Integer anoFinal;
	private Integer mesFinal;
	private Long idCp; 
	private boolean isComParadas;
	
	private long idConsolid;
	
	public boolean isComParadas() {
		return isComParadas;
	}
	public void setComParadas(boolean isComParadas) {
		this.isComParadas = isComParadas;
	}
	public PpCp getPpCp() {
		return ppCp;
	}
	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}
	
	public DwTParada getDwTParada() {
		return dwTParada;
	}
	public void setDwTParada(DwTParada dwTParada) {
		this.dwTParada = dwTParada;
	}
	public Date getDthrIturno() {
		return dthrIturno;
	}
	public void setDthrIturno(Date dthrIturno) {
		this.dthrIturno = dthrIturno;
	}
	public Date getDthrFturno() {
		return dthrFturno;
	}
	public void setDthrFturno(Date dthrFturno) {
		this.dthrFturno = dthrFturno;
	}
	public Date getDthrIhora() {
		return dthrIhora;
	}
	public void setDthrIhora(Date dthrIhora) {
		this.dthrIhora = dthrIhora;
	}
	public Date getDthrFhora() {
		return dthrFhora;
	}
	public void setDthrFhora(Date dthrFhora) {
		this.dthrFhora = dthrFhora;
	}
	public Byte getTpId() {
		return tpId;
	}
	public void setTpId(Byte tpId) {
		this.tpId = tpId;
	}
	public long getIdrt() {
		return idrt;
	}
	public void setIdrt(long idrt) {
		this.idrt = idrt;
	}
	public Date getDtReferenciaFinal() {
		return dtReferenciaFinal;
	}
	public void setDtReferenciaFinal(Date dtReferenciaFinal) {
		this.dtReferenciaFinal = dtReferenciaFinal;
	}
	public Date getDtReferenciaInicial() {
		return dtReferenciaInicial;
	}
	public void setDtReferenciaInicial(Date dtReferenciaInicial) {
		this.dtReferenciaInicial = dtReferenciaInicial;
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
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public void setDwfolha(DwFolha dwfolha) {
		this.dwfolha = dwfolha;
	}
	public DwFolha getDwfolha() {
		return dwfolha;
	}
	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}
	
	public Integer getAnoInicial() {
		return anoInicial;
	}
	public void setAnoInicial(Integer anoInicial) {
		this.anoInicial = anoInicial;
	}
	public Integer getMesInicial() {
		return mesInicial;
	}
	public void setMesInicial(Integer mesInicial) {
		this.mesInicial = mesInicial;
	}
	public Integer getAnoFinal() {
		return anoFinal;
	}
	public void setAnoFinal(Integer anoFinal) {
		this.anoFinal = anoFinal;
	}
	public Integer getMesFinal() {
		return mesFinal;
	}
	public void setMesFinal(Integer mesFinal) {
		this.mesFinal = mesFinal;
	}
	public Long getIdCp() {
		return idCp;
	}
	public void setIdCp(Long idCp) {
		this.idCp = idCp;
	}
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}
	public OmProduto getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}
	public long getIdConsolid() {
		return idConsolid;
	}
	public void setIdConsolid(long idConsolid) {
		this.idConsolid = idConsolid;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "FiltroGraficoDetalhePtDTO ["; 
		
		retorno += "omPt=";
		
		if (this.omPt != null) {
			retorno += this.omPt.getCdPt() + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "ppCp=";
		
		if (this.ppCp != null) {
			retorno += this.ppCp.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
       retorno += "omGt=";

		if (this.omGt != null) {
			retorno += this.omGt.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dtReferencia=" + this.dtReferencia + ", " +
				   "dtReferenciaFinal=" + this.dtReferenciaFinal + ", " +
				   "dtReferenciaInicial=" + this.dtReferenciaInicial + ", " +
		           "idrt=" + this.idrt + ", ";
		
		retorno += "dwTurno=";
		
		if (this.dwTurno != null) {
			retorno += this.dwTurno.getCdTurno() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dwfolha=";
		
		if (this.dwfolha != null) {
			retorno += this.dwfolha.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dwTParada=";
		
		if (this.dwTParada != null) {
			retorno += this.dwTParada.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dthrIturno=" + this.dthrIturno + ", " +
				   "dthrFturno=" + this.dthrFturno + ", " +
				   "dthrIhora=" + this.dthrIhora + ", " +
		           "dthrFhora=" + this.dthrFhora + ", " +
		           "tpId=" + this.tpId + ", ";

		retorno += "dwRap=";
		
		if (this.dwRap != null) {
			retorno += this.dwRap.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "omProduto=";
		
		if (this.omProduto != null) {
			retorno += this.omProduto.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "anoInicial=" + this.anoInicial + ", " +
				   "mesInicial=" + this.mesInicial + ", " +
				   "anoFinal=" + this.anoFinal + ", " +
		           "mesFinal=" + this.mesFinal + ", " +
		           "idCp=" + this.idCp + ", " +
		           "isComParadas=" + this.isComParadas + ", " +
		           "idConsolid=" + this.idConsolid + "]";
		
		return retorno;
		/*
		return "FiltroGraficoDetalhePtDTO [omPt=" + omPt + ", ppCp=" + ppCp + ", omGt=" + omGt + ", dtReferencia=" + dtReferencia
				+ ", dtReferenciaFinal=" + dtReferenciaFinal + ", dtReferenciaInicial=" + dtReferenciaInicial + ", idrt=" + idrt
				+ ", dwTurno=" + dwTurno + ", dwfolha=" + dwfolha + ", dwTParada=" + dwTParada + ", dthrIturno=" + dthrIturno
				+ ", dthrFturno=" + dthrFturno + ", dthrIhora=" + dthrIhora + ", dthrFhora=" + dthrFhora + ", tpId=" + tpId + ", dwRap="
				+ dwRap + ", omProduto=" + omProduto + ", anoInicial=" + anoInicial + ", mesInicial=" + mesInicial + ", anoFinal="
				+ anoFinal + ", mesFinal=" + mesFinal + ", idCp=" + idCp + ", isComParadas=" + isComParadas + ", idConsolid=" + idConsolid
				+ "]";
		*/
	}
	
}
