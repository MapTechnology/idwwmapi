package idw.webservices.rest.dto.monitorizacao.injet;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRt;

public class RtFolhaDTO {	
	private DwFolha folha;
	private DwRt rt;
	
	public DwFolha getFolha() {
		return folha;
	}
	public void setFolha(DwFolha folha) {
		this.folha = folha;
	}
	public DwRt getRt() {
		return rt;
	}
	public void setRt(DwRt rt) {
		this.rt = rt;
	}
}
