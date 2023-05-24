package idw.webservices.rest.dto.monitorizacao.injet.manutencao;

import java.util.List;

public class FerramentasDTO { 
	private List<ItemListaDTO> ferramentas;

	public List<ItemListaDTO> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(List<ItemListaDTO> ferramentas) {
		this.ferramentas = ferramentas;
	}
	
	
}
