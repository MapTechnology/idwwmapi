package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;


@SuppressWarnings("serial")
public class DetalhePTSerieDTO implements Serializable {
	private DwNserie serie;
	private DwPassagem ultimaPassagem;
	private List<AcaoDTO> listaAcoes = new ArrayList<>();
	
	public DwNserie getSerie() {
		return serie;
	}
	public void setSerie(DwNserie serie) {
		this.serie = serie;
	}
	public DwPassagem getUltimaPassagem() {
		return ultimaPassagem;
	}
	public void setUltimaPassagem(DwPassagem ultimaPassagem) {
		this.ultimaPassagem = ultimaPassagem;
	}
	public List<AcaoDTO> getListaAcoes() {
		return listaAcoes;
	}
	public void setListaAcoes(List<AcaoDTO> listaAcoes) {
		this.listaAcoes = listaAcoes;
	}
}
