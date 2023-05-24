package idw.model.rn.monitorizacao.detalhes.dto;

import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.DwTArea;

public class GraficoParetoParadaAreaRespDTO {
    private DwTArea areaResp;
    private Double tempoParada;
    private Double indiceArea;
    private Double qtdPerdasParada;
    private List<GraficoParettoParadaDTO> paradas = new ArrayList<GraficoParettoParadaDTO>();

    public DwTArea getAreaResp() {
        return areaResp;
    }

    public void setAreaResp(DwTArea areaResp) {
        this.areaResp = areaResp;
    }

    public List<GraficoParettoParadaDTO> getParadas() {
        return paradas;
    }

    public void setParadas(List<GraficoParettoParadaDTO> paradas) {
        this.paradas = paradas;
    }

    public Double getTempoParada() {
        return tempoParada;
    }

    public void setTempoParada(Double tempoParada) {
        this.tempoParada = tempoParada;
    }

    public Double getIndiceArea() {
        return indiceArea;
    }

    public void setIndiceArea(Double indiceArea) {
        this.indiceArea = indiceArea;
    }

    public Double getQtdPerdasParada() {
        return qtdPerdasParada;
    }

    public void setQtdPerdasParada(Double qtdPerdasParada) {
        this.qtdPerdasParada = qtdPerdasParada;
    }
}
