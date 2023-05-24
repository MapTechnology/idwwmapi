package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaTipoGTDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<TipoGTDTO> lista = new ArrayList<>();

	public List<TipoGTDTO> getLista() {
		return lista;
	}

	public void setLista(List<TipoGTDTO> lista) {
		this.lista = lista;
	}
	
	

}
