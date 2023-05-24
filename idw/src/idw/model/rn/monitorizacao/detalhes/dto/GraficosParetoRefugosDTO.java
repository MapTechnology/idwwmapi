package idw.model.rn.monitorizacao.detalhes.dto;

import java.util.ArrayList;
import java.util.List;

import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.webservices.rest.dto.monitorizacao.LegendaDataHoraDTO;

public class GraficosParetoRefugosDTO {

	private List<GraficoParetoRefugosDTO> refugos = new ArrayList<GraficoParetoRefugosDTO>();
	private List<GraficoParetoRefugosDTO> refugosGr = new ArrayList<GraficoParetoRefugosDTO>();
	private DatasDTO corVerde;
	private DatasDTO corAmarela;
	private DatasDTO corLaranja;
	private DatasDTO corVermelho;
	private List<LegendaDataHoraDTO> legendas;
	
	public List<GraficoParetoRefugosDTO> getRefugos() {
		return refugos;
	}

	public void setRefugos(List<GraficoParetoRefugosDTO> refugos) {
		this.refugos = refugos;
	}

	public DatasDTO getCorVerde() {
		return corVerde;
	}

	public void setCorVerde(DatasDTO corVerde) {
		this.corVerde = corVerde;
	}

	public DatasDTO getCorAmarela() {
		return corAmarela;
	}

	public void setCorAmarela(DatasDTO corAmarela) {
		this.corAmarela = corAmarela;
	}

	public DatasDTO getCorLaranja() {
		return corLaranja;
	}

	public void setCorLaranja(DatasDTO corLaranja) {
		this.corLaranja = corLaranja;
	}

	public DatasDTO getCorVermelho() {
		return corVermelho;
	}

	public void setCorVermelho(DatasDTO corVermelho) {
		this.corVermelho = corVermelho;
	}

	public List<GraficoParetoRefugosDTO> getRefugosGr() {
		return refugosGr;
	}

	public void setRefugosGr(List<GraficoParetoRefugosDTO> refugosGr) {
		this.refugosGr = refugosGr;
	}

	public List<LegendaDataHoraDTO> getLegendas() {
		return legendas;
	}

	public void setLegendas(List<LegendaDataHoraDTO> legendas) {
		this.legendas = legendas;
	}
	
	
}
