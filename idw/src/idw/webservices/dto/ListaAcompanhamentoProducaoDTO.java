package idw.webservices.dto;

import java.util.List;

public class ListaAcompanhamentoProducaoDTO {

	private List<AcompanhamentoProducaoDTO> listaAcompanhamentoProducaoDTO;
	private List<RelatorioParadasAbertasDTO> listaCompletaParadas;
	
	public List<AcompanhamentoProducaoDTO> getListaAcompanhamentoProducaoDTO() {
		return listaAcompanhamentoProducaoDTO;
	}
	public void setListaAcompanhamentoProducaoDTO(
			List<AcompanhamentoProducaoDTO> listaAcompanhamentoProducaoDTO) {
		this.listaAcompanhamentoProducaoDTO = listaAcompanhamentoProducaoDTO;
	}
	public List<RelatorioParadasAbertasDTO> getListaCompletaParadas() {
		return listaCompletaParadas;
	}
	public void setListaCompletaParadas(List<RelatorioParadasAbertasDTO> listaCompletaParadas) {
		this.listaCompletaParadas = listaCompletaParadas;
	}

	
}
