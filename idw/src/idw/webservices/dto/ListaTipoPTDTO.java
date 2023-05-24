package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaTipoPTDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<TipoPTDTO> lista = new ArrayList<>()	;

	public List<TipoPTDTO> getLista() {
		return lista;	
	}

	public void setLista(List<TipoPTDTO> lista) {
		this.lista = lista;
	}
	
	
}
