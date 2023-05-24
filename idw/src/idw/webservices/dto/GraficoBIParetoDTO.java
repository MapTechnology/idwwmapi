package idw.webservices.dto;

import java.util.List;

import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;

public class GraficoBIParetoDTO {

	private List<GraficoBIParetoPerdasDTO> grafBIProdutoPerdas;
	private List<GraficoBIParetoPerdasDTO> grafBIMaquinaPerdas;
	private List<GraficoBIParetoPerdasDTO> grafBIProdutoGanhos;
	private List<GraficoBIParetoPerdasDTO> grafBIMaquinaGanhos;	
	private MetaIndicadorDTO metaIndicadorPerdaProduto;
	
	public List<GraficoBIParetoPerdasDTO> getGrafBIProdutoPerdas() {
		return grafBIProdutoPerdas;
	}


	public void setGrafBIProdutoPerdas(
			List<GraficoBIParetoPerdasDTO> grafBIProdutoPerdas) {
		this.grafBIProdutoPerdas = grafBIProdutoPerdas;
	}


	public List<GraficoBIParetoPerdasDTO> getGrafBIMaquinaPerdas() {
		return grafBIMaquinaPerdas;
	}


	public void setGrafBIMaquinaPerdas(
			List<GraficoBIParetoPerdasDTO> grafBIMaquinaPerdas) {
		this.grafBIMaquinaPerdas = grafBIMaquinaPerdas;
	}


	public List<GraficoBIParetoPerdasDTO> getGrafBIProdutoGanhos() {
		return grafBIProdutoGanhos;
	}


	public void setGrafBIProdutoGanhos(List<GraficoBIParetoPerdasDTO> grafBIProdutoGanhos) {
		this.grafBIProdutoGanhos = grafBIProdutoGanhos;
	}


	public List<GraficoBIParetoPerdasDTO> getGrafBIMaquinaGanhos() {
		return grafBIMaquinaGanhos;
	}


	public void setGrafBIMaquinaGanhos(
			List<GraficoBIParetoPerdasDTO> grafBIMaquinaGanhos) {
		this.grafBIMaquinaGanhos = grafBIMaquinaGanhos;
	}


	public MetaIndicadorDTO getMetaIndicadorPerdaProduto() {
		return metaIndicadorPerdaProduto;
	}


	public void setMetaIndicadorPerdaProduto(MetaIndicadorDTO metaIndicadorPerdaProduto) {
		this.metaIndicadorPerdaProduto = metaIndicadorPerdaProduto;
	}

}
