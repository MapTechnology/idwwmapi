package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwTArea;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

public class FiltroRelatorioParadasAbertasDTO {
	
	private DwTArea area;
	private String cdop;
	private Date dt_inicio;
	private Date dt_final;
	private OmPt ompt;
	private OmGt omgt;
	
	
	
	
	public Date getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Date getDt_final() {
		return dt_final;
	}
	public void setDt_final(Date dt_final) {
		this.dt_final = dt_final;
	}
	public OmPt getOmpt() {
		return ompt;
	}
	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}
	public OmGt getOmgt() {
		return omgt;
	}
	public void setOmgt(OmGt omgt) {
		this.omgt = omgt;
	}
	public DwTArea getArea() {
		return area;
	}
	public void setArea(DwTArea area) {
		this.area = area;
	}
	public String getCdop() {
		return cdop;
	}
	public void setCdop(String cdop) {
		this.cdop = cdop;
	}

}