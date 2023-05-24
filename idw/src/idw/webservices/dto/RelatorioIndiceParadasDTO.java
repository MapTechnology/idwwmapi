package idw.webservices.dto;

public class RelatorioIndiceParadasDTO {
	
	private String parada;
    private Double tempo;
    private String indice;
    private String produto;
    private String ferramenta;
    private String maquina;
    private Double tempoTotalMaquina;
    private Double tempoTotalProduto;
    private Double numeroLinhaRel;
    private String indiceRelatorio;
    private String indiceMaquina;
    private String indiceProduto;
    private double tempoParadaCP;
    private double tempoParadaSP;
    private double tempoFerProd;
    
    public String getIndiceRelatorio() {
		return indiceRelatorio;
	}
	public void setIndiceRelatorio(String indiceRelatorio) {
		this.indiceRelatorio = indiceRelatorio;
	}
	public String getIndiceMaquina() {
		return indiceMaquina;
	}
	public void setIndiceMaquina(String indiceMaquina) {
		this.indiceMaquina = indiceMaquina;
	}
	public String getIndiceProduto() {
		return indiceProduto;
	}
	public void setIndiceProduto(String indiceProduto) {
		this.indiceProduto = indiceProduto;
	}
	private double tempoTotalParadasCP;
    
    public Double getTempoTotalMaquina() {
		return tempoTotalMaquina;
	}
	public void setTempoTotalMaquina(Double tempoTotalMaquina) {
		this.tempoTotalMaquina = tempoTotalMaquina;
	}
	public Double getTempoTotalProduto() {
		return tempoTotalProduto;
	}
	public void setTempoTotalProduto(Double tempoTotalProduto) {
		this.tempoTotalProduto = tempoTotalProduto;
	}
	private double tempoTotalParadasSP;
    
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public Double getTempo() {
		return tempo;
	}
	public void setTempo(Double tempo) {
		this.tempo = tempo;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public Double getNumeroLinhaRel() {
		return numeroLinhaRel;
	}
	public void setNumeroLinhaRel(Double numeroLinhaRel) {
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
	public double getTempoParadaCP() {
		return tempoParadaCP;
	}
	public void setTempoParadaCP(double tempoParadaCP) {
		this.tempoParadaCP = tempoParadaCP;
	}
	public double getTempoParadaSP() {
		return tempoParadaSP;
	}
	public void setTempoParadaSP(double tempoParadaSP) {
		this.tempoParadaSP = tempoParadaSP;
	}
	public double getTempoFerProd() {
		return tempoFerProd;
	}
	public void setTempoFerProd(double tempoFerProd) {
		this.tempoFerProd = tempoFerProd;
	}
	
}