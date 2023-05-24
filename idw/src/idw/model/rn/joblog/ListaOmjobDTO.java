package idw.model.rn.joblog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.OmJob;

public class ListaOmjobDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OmJob> listaOmJob = new ArrayList<>();

	public List<OmJob> getListaOmJob() {
		return listaOmJob;
	}

	public void setListaOmJob(List<OmJob> listaOmJob) {
		this.listaOmJob = listaOmJob;
	}
	
	
}
