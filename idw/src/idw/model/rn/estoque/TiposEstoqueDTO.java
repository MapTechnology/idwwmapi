package idw.model.rn.estoque;

import java.io.Serializable;
import java.util.List;

public class TiposEstoqueDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TipoEstoqueDTO> tiposEstoque;

	public List<TipoEstoqueDTO> getTiposEstoque() {
		return tiposEstoque;
	}

	public void setTiposEstoque(List<TipoEstoqueDTO> tiposEstoque) {
		this.tiposEstoque = tiposEstoque;
	}
	
	
}
