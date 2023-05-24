package idw.model.rn.joblog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.OmJobdetlog;

public class ListaOmJobdetLogDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<OmJobdetlog> lista = new ArrayList<>();

	public List<OmJobdetlog> getLista() {
		return lista;
	}

	public void setLista(List<OmJobdetlog> lista) {
		this.lista = lista;
	}
	
	
}
