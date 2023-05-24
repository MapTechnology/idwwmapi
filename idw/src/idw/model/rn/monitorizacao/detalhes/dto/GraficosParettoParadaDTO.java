package idw.model.rn.monitorizacao.detalhes.dto;

import java.util.ArrayList;
import java.util.List;

import idw.model.rn.geraplano.dtos.DatasDTO;
import idw.webservices.rest.dto.monitorizacao.LegendaDataHoraDTO;

public class GraficosParettoParadaDTO {

    private List<GraficoParettoParadaDTO> paradas = new ArrayList<GraficoParettoParadaDTO>();
    private List<GraficoParetoParadaAreaRespDTO> areas = new ArrayList<GraficoParetoParadaAreaRespDTO>();
    private DatasDTO corVerde;
    private DatasDTO corAmarela;
    private DatasDTO corLaranja;
    private DatasDTO corVermelho;
    private List<LegendaDataHoraDTO> legendas;
    
    public List<GraficoParettoParadaDTO> getParadas() {
        return paradas;
    }

    public void setParadas(List<GraficoParettoParadaDTO> paradas) {
        this.paradas = paradas;
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

    public List<GraficoParetoParadaAreaRespDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<GraficoParetoParadaAreaRespDTO> areas) {
        this.areas = areas;
    }

	public List<LegendaDataHoraDTO> getLegendas() {
		return legendas;
	}

	public void setLegendas(List<LegendaDataHoraDTO> legendas) {
		this.legendas = legendas;
	}

}
