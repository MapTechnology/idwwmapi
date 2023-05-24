package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioRefugoSemConsolidacaoDTO {
	private List<RelatorioRefugoSemConsolidacaoDTO>listaRelatorioRefugoSemConsolidacao;
	private Double totalRefugado;
	
	
	
	public Double getTotalRefugado() {
		return totalRefugado;
	}

	public void setTotalRefugado(Double totalRefugado) {
		this.totalRefugado = totalRefugado;
	}

	public List<RelatorioRefugoSemConsolidacaoDTO> getListaRelatorioRefugoSemConsolidacao() {
		return listaRelatorioRefugoSemConsolidacao;
	}

	public void setListaRelatorioRefugoSemConsolidacao(List<RelatorioRefugoSemConsolidacaoDTO> listaRelatorioRefugoSemConsolidacao) {
		this.listaRelatorioRefugoSemConsolidacao = listaRelatorioRefugoSemConsolidacao;
	}
	
}
