package idw.model.rn.joblog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.OmJoblog;

public class ListaOmJobLogDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<OmJoblog> listaOmJoblog = new ArrayList<>();

	public List<OmJoblog> getListaOmJoblog() {
		return listaOmJoblog;
	}

	public void setListaOmJoblog(List<OmJoblog> listaOmJoblog) {
		this.listaOmJoblog = listaOmJoblog;
	}
	
	
}
