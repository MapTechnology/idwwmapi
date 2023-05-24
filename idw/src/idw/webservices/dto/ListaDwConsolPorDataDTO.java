package idw.webservices.dto;

import java.util.Date;
import java.util.List;

import idw.model.pojos.DwConsol;

public class ListaDwConsolPorDataDTO {
	private Date dtReferencia;
	private List<DwConsol> listaDwConsol;
	
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public List<DwConsol> getListaDwConsol() {
		return listaDwConsol;
	}
	public void setListaDwConsol(List<DwConsol> listaDwConsol) {
		this.listaDwConsol = listaDwConsol;
	}
	
	
}
