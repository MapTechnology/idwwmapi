package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import idw.model.pojos.DwPassagem;

@SuppressWarnings("serial")
public class ListaDwPassagemDTO implements Serializable {

	 private List<DwPassagem> listaPessagem;

	public List<DwPassagem> getListaPessagem() {
		return listaPessagem;
	}

	public void setListaPessagem(List<DwPassagem> listaPessagem) {
		this.listaPessagem = listaPessagem;
	}
	 
	 
}
