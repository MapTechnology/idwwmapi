package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioAlimentacaoDTO {
	private List<RelatorioAlimentacaoDTO> lista;
	
	public ListaRelatorioAlimentacaoDTO() {		
	}
	
	public ListaRelatorioAlimentacaoDTO(List<RelatorioAlimentacaoDTO> lista) {
		this.lista = lista;
	}
	
	public List<RelatorioAlimentacaoDTO> getLista() {
		return lista;
	}

	public void setLista(List<RelatorioAlimentacaoDTO> lista) {
		this.lista = lista;
	}
	
}
