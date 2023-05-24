package idw.webservices.rest.dto.monitorizacao.injet.bi;

import idw.webservices.rest.dto.monitorizacao.MetaIndicadorDTO;

public class GraficoBIWebParetoDTO {
	private GraficosBIWebParetoPerdasDTO grafBIProdutoPerdas;
	private GraficosBIWebParetoPerdasDTO grafBIMaquinaPerdas;
	private GraficosBIWebParetoPerdasDTO grafBIProdutoGanhos;
	private GraficosBIWebParetoPerdasDTO grafBIMaquinaGanhos;	
	private MetaIndicadorDTO metaIndicadorPerdaProduto;
	private BiResumoGanhoPerdaDTO resumoCiclo;
	private BiResumoGanhoPerdaDTO resumoTodas;
	
	
	public BiResumoGanhoPerdaDTO getResumoCiclo() {
		return resumoCiclo;
	}
	public void setResumoCiclo(BiResumoGanhoPerdaDTO resumoCiclo) {
		this.resumoCiclo = resumoCiclo;
	}
	public BiResumoGanhoPerdaDTO getResumoTodas() {
		return resumoTodas;
	}
	public void setResumoTodas(BiResumoGanhoPerdaDTO resumoTodas) {
		this.resumoTodas = resumoTodas;
	}
	public GraficosBIWebParetoPerdasDTO getGrafBIProdutoPerdas() {
		return grafBIProdutoPerdas;
	}
	public void setGrafBIProdutoPerdas(GraficosBIWebParetoPerdasDTO grafBIProdutoPerdas) {
		this.grafBIProdutoPerdas = grafBIProdutoPerdas;
	}
	public GraficosBIWebParetoPerdasDTO getGrafBIMaquinaPerdas() {
		return grafBIMaquinaPerdas;
	}
	public void setGrafBIMaquinaPerdas(GraficosBIWebParetoPerdasDTO grafBIMaquinaPerdas) {
		this.grafBIMaquinaPerdas = grafBIMaquinaPerdas;
	}
	public GraficosBIWebParetoPerdasDTO getGrafBIProdutoGanhos() {
		return grafBIProdutoGanhos;
	}
	public void setGrafBIProdutoGanhos(GraficosBIWebParetoPerdasDTO grafBIProdutoGanhos) {
		this.grafBIProdutoGanhos = grafBIProdutoGanhos;
	}
	public GraficosBIWebParetoPerdasDTO getGrafBIMaquinaGanhos() {
		return grafBIMaquinaGanhos;
	}
	public void setGrafBIMaquinaGanhos(GraficosBIWebParetoPerdasDTO grafBIMaquinaGanhos) {
		this.grafBIMaquinaGanhos = grafBIMaquinaGanhos;
	}
	public MetaIndicadorDTO getMetaIndicadorPerdaProduto() {
		return metaIndicadorPerdaProduto;
	}
	public void setMetaIndicadorPerdaProduto(MetaIndicadorDTO metaIndicadorPerdaProduto) {
		this.metaIndicadorPerdaProduto = metaIndicadorPerdaProduto;
	}

}
