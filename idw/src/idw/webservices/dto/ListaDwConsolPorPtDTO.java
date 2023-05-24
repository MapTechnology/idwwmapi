package idw.webservices.dto;

import java.util.List;

import idw.model.pojos.DwConsol;

public class ListaDwConsolPorPtDTO {
	private String cdPt;
	private String dsPt;
	private List<DwConsol> listaDwConsol;
	
 
	public List<DwConsol> getListaDwConsol() {
		return listaDwConsol;
	}
	public void setListaDwConsol(List<DwConsol> listaDwConsol) {
		this.listaDwConsol = listaDwConsol;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	
	
}
