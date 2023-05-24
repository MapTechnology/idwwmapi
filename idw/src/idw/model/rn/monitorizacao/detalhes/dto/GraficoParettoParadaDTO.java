package idw.model.rn.monitorizacao.detalhes.dto;

public class GraficoParettoParadaDTO {

    private String cdParada;
    private String dsParada;
    private String tempoFormatado;
    private Double indiceParada;
    private String corBarra;
    private Long idTParada;
    private Double qtdPerdasParada;
    private Double indiceParadaQtdPerdasPar;
    private Double tempo;
    private Boolean isPesa;
    private Long idTArea;
    private String cdArea;
    private String dsArea;
    private String corHexa;

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

    public String getTempoFormatado() {
        return tempoFormatado;
    }

    public void setTempoFormatado(String tempoFormatado) {
        this.tempoFormatado = tempoFormatado;
    }

    public Double getIndiceParada() {
        return indiceParada;
    }

    public void setIndiceParada(Double indiceParada) {
        this.indiceParada = indiceParada;
    }

    public String getCorBarra() {
        return corBarra;
    }

    public void setCorBarra(String corBarra) {
        this.corBarra = corBarra;
    }

    public Long getIdTParada() {
        return idTParada;
    }

    public void setIdTParada(Long idTParada) {
        this.idTParada = idTParada;
    }

    public Double getQtdPerdasParada() {
        return qtdPerdasParada;
    }

    public void setQtdPerdasParada(Double qtdPerdasParada) {
        this.qtdPerdasParada = qtdPerdasParada;
    }

    public Double getIndiceParadaQtdPerdasPar() {
        return indiceParadaQtdPerdasPar;
    }

    public void setIndiceParadaQtdPerdasPar(Double indiceParadaQtdPerdasPar) {
        this.indiceParadaQtdPerdasPar = indiceParadaQtdPerdasPar;
    }

    public Double getTempo() {
        return tempo;
    }

    public void setTempo(Double tempo) {
        this.tempo = tempo;
    }

    public Boolean getIsPesa() {
        return isPesa;
    }

    public void setIsPesa(Boolean isPesa) {
        this.isPesa = isPesa;
    }

    public Long getIdTArea() {
        return idTArea;
    }

    public void setIdTArea(Long idTArea) {
        this.idTArea = idTArea;
    }

    public String getCdArea() {
        return cdArea;
    }

    public void setCdArea(String cdArea) {
        this.cdArea = cdArea;
    }

    public String getDsArea() {
        return dsArea;
    }

    public void setDsArea(String dsArea) {
        this.dsArea = dsArea;
    }

	public String getCorHexa() {
		return corHexa;
	}

	public void setCorHexa(String corHexa) {
		this.corHexa = corHexa;
	}

}
