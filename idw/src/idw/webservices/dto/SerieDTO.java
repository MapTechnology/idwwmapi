package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class SerieDTO implements Serializable{
	String descricao = "";
	List<ElementoDTO> elementos = new ArrayList<ElementoDTO>();

	public void add(ElementoDTO elemento){
		this.elementos.add(elemento);
	}
	public List<ElementoDTO> getElementos() {
		return elementos;
	}

	public void setElementos(List<ElementoDTO> elemento) {
		this.elementos = elemento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
