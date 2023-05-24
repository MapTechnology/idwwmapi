package idw.webservices.dto;

import java.util.List;

import idw.model.pojos.OmTppt;

public class OmTpptDTO {
	
	private List<OmTppt> listaOmTppts;

	public void setListaOmTppts(List<OmTppt> listaOmTppts) {
		this.listaOmTppts = listaOmTppts;
	}

	public List<OmTppt> getListaOmTppts() {
		return listaOmTppts;
	}

}
