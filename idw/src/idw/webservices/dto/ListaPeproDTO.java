package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import idw.model.pojos.DwPepro;

public class ListaPeproDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<DwPepro> periodosProdutivos;

	public List<DwPepro> getPeriodosProdutivos() {
		return periodosProdutivos;
	}

	public void setPeriodosProdutivos(List<DwPepro> periodosProdutivos) {
		this.periodosProdutivos = periodosProdutivos;
	}
	
	
}
