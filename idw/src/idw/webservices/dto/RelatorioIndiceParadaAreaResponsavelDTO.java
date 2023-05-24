package idw.webservices.dto;

public class RelatorioIndiceParadaAreaResponsavelDTO {
	
	private String parada;
	private String areaResponsavel;
	private String indice;
	private String tempo;
	private Integer numeroLinhaRel;
    private double tempoTotalParadasCP;
    private double tempoTotalParadasSP;
    
    
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public String getAreaResponsavel() {
		return areaResponsavel;
	}
	public void setAreaResponsavel(String areaResponsavel) {
		this.areaResponsavel = areaResponsavel;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public Integer getNumeroLinhaRel() {
		return numeroLinhaRel;
	}
	public void setNumeroLinhaRel(Integer numeroLinhaRel) {
		this.numeroLinhaRel = numeroLinhaRel;
	}
	public double getTempoTotalParadasCP() {
		return tempoTotalParadasCP;
	}
	public void setTempoTotalParadasCP(double tempoTotalParadasCP) {
		this.tempoTotalParadasCP = tempoTotalParadasCP;
	}
	public double getTempoTotalParadasSP() {
		return tempoTotalParadasSP;
	}
	public void setTempoTotalParadasSP(double tempoTotalParadasSP) {
		this.tempoTotalParadasSP = tempoTotalParadasSP;
	}
	
	

}
