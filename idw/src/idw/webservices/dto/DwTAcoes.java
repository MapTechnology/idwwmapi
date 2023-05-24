package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import idw.model.pojos.DwTAcao;

public class DwTAcoes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<DwTAcao> listaDwTAcoes;

	public List<DwTAcao> getListaDwTAcoes() {
		return listaDwTAcoes;
	}

	public void setListaDwTAcoes(List<DwTAcao> listaDwTAcoes) {
		this.listaDwTAcoes = listaDwTAcoes;
	}
	
	
	
	
	
}
