package idw.webservices.dto;

import java.util.List;

public class GraficoBIParetoDetAreaRespParDTO {
    
    private Long idTParada;
    private String cdParada;
    private String dsParada;
    
    private Double segTempoParadas;
    private Double qtOcorrParadas;
    
    private Double qtPerdasUB;
    private Double qtPerdasKg;
    private Double qtPerdasTon;
    private Double qtPerdasUM;

    private Double segTempoMicroParadas; 
    private Double qtdOcorrMicroParadas;
    private Double indMicroParadas;
    
    private List<GraficoBIParetoDetAreaRespParProDTO> produtos;

    
    
    public Long getIdTParada() {
        return idTParada;
    }

    public void setIdTParada(Long idTParada) {
        this.idTParada = idTParada;
    }

    public String getCdParada() {
        return cdParada;
    }

    public void setCdParada(String cdParada) {
        this.cdParada = cdParada;
    }

    public String getDsParada() {
        return dsParada;
    }

    public void setDsParada(String dsParada) {
        this.dsParada = dsParada;
    }

    public Double getSegTempoParadas() {
        return segTempoParadas;
    }

    public void setSegTempoParadas(Double segTempoParadas) {
        this.segTempoParadas = segTempoParadas;
    }

    public Double getQtOcorrParadas() {
        return qtOcorrParadas;
    }

    public void setQtOcorrParadas(Double qtOcorrParadas) {
        this.qtOcorrParadas = qtOcorrParadas;
    }

    public Double getQtPerdasUB() {
        return qtPerdasUB;
    }

    public void setQtPerdasUB(Double qtPerdasUB) {
        this.qtPerdasUB = qtPerdasUB;
    }

    public Double getQtPerdasKg() {
        return qtPerdasKg;
    }

    public void setQtPerdasKg(Double qtPerdasKg) {
        this.qtPerdasKg = qtPerdasKg;
    }

    public Double getQtPerdasTon() {
        return qtPerdasTon;
    }

    public void setQtPerdasTon(Double qtPerdasTon) {
        this.qtPerdasTon = qtPerdasTon;
    }

    public Double getQtPerdasUM() {
        return qtPerdasUM;
    }

    public void setQtPerdasUM(Double qtPerdasUM) {
        this.qtPerdasUM = qtPerdasUM;
    }

    public Double getSegTempoMicroParadas() {
        return segTempoMicroParadas;
    }

    public void setSegTempoMicroParadas(Double segTempoMicroParadas) {
        this.segTempoMicroParadas = segTempoMicroParadas;
    }

    public Double getQtdOcorrMicroParadas() {
        return qtdOcorrMicroParadas;
    }

    public void setQtdOcorrMicroParadas(Double qtdOcorrMicroParadas) {
        this.qtdOcorrMicroParadas = qtdOcorrMicroParadas;
    }

    public Double getIndMicroParadas() {
        return indMicroParadas;
    }

    public void setIndMicroParadas(Double indMicroParadas) {
        this.indMicroParadas = indMicroParadas;
    }

    public List<GraficoBIParetoDetAreaRespParProDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<GraficoBIParetoDetAreaRespParProDTO> produtos) {
        this.produtos = produtos;
    }
    
    
}
