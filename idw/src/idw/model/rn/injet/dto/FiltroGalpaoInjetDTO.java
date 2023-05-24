package idw.model.rn.injet.dto;


import java.util.List;

import idw.model.pojos.injet.Ijtbinj;

@SuppressWarnings("serial")
public class FiltroGalpaoInjetDTO extends FiltroMaquinaInjetDTO{

	private String cdGalpao;
	private List<Ijtbinj> listaIjtbinj;

	public String getCdGalpao() {
		return cdGalpao;
	}

	public void setCdGalpao(String cdGalpao) {
		this.cdGalpao = cdGalpao;
	}

	public List<Ijtbinj> getListaIjtbinj() {
		return listaIjtbinj;
	}

	public void setListaIjtbinj(List<Ijtbinj> listaIjtbinj) {
		this.listaIjtbinj = listaIjtbinj;
	}
	
}
