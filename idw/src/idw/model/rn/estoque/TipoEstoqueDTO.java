package idw.model.rn.estoque;

import java.io.Serializable;

import idw.model.pojos.DwTpest;

public class TipoEstoqueDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DwTpest tipoEstoque;

	public DwTpest getTipoEstoque() {
		return tipoEstoque;
	}

	public void setTipoEstoque(DwTpest tipoEstoque) {
		this.tipoEstoque = tipoEstoque;
	}

}
