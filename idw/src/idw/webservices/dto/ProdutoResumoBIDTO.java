package idw.webservices.dto;

public class ProdutoResumoBIDTO 
{
	private Long idProduto;
	private String cdProduto;
	private String dsProduto;
	
	private Double cicloPadrao;
	private Double cicloMedio;
	private Double cicloPadraoSUM;
	private Double cicloPadraoCOUNT;
	private Double qtdCiclosProdutivos;
	private Double segCiclosProdutivos;
	private Double qtPcsCicloTotal;
	private Double qtPcsCicloAtiva;
	private Double qtPcsCicloTotalSUM;
	private Double qtPcsCicloAtivaSUM;
	
	private Double segTempoAtivo;
	private Double segTempoParadasComPeso;
	private Double segTempoParadaSemPeso;
	private Double segTempoProdutivas;
	
	
	private Double qtdPorConjunto;
	private Double qtBruta;
	private Double qtRefugada;
	private Double qtLiquida;
	private Double qtPrevista;
	private Double qtPerdas;
	private Double efiRea;
	private Double efiCic;
	private Double indRef;
	private Double indPar;
	private Double indPCI;
	private Double indPer;
	private Double oee;
	
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getDsProduto() {
		return dsProduto;
	}
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	public Double getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(Double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public Double getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(Double cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public Double getQtdPorConjunto() {
		return qtdPorConjunto;
	}
	public void setQtdPorConjunto(Double qtdPorConjunto) {
		this.qtdPorConjunto = qtdPorConjunto;
	}
	public Double getQtBruta() {
		return qtBruta;
	}
	public void setQtBruta(Double qtBruta) {
		this.qtBruta = qtBruta;
	}
	public Double getQtRefugada() {
		return qtRefugada;
	}
	public void setQtRefugada(Double qtRefugada) {
		this.qtRefugada = qtRefugada;
	}
	public Double getQtLiquida() {
		return qtLiquida;
	}
	public void setQtLiquida(Double qtLiquida) {
		this.qtLiquida = qtLiquida;
	}
	public Double getQtPrevista() {
		return qtPrevista;
	}
	public void setQtPrevista(Double qtPrevista) {
		this.qtPrevista = qtPrevista;
	}
	public Double getQtPerdas() {
		return qtPerdas;
	}
	public void setQtPerdas(Double qtPerdas) {
		this.qtPerdas = qtPerdas;
	}
	public Double getEfiRea() {
		return efiRea;
	}
	public void setEfiRea(Double efiRea) {
		this.efiRea = efiRea;
	}
	public Double getEfiCic() {
		return efiCic;
	}
	public void setEfiCic(Double efiCic) {
		this.efiCic = efiCic;
	}
	public Double getIndRef() {
		return indRef;
	}
	public void setIndRef(Double indRef) {
		this.indRef = indRef;
	}
	public Double getIndPar() {
		return indPar;
	}
	public void setIndPar(Double indPar) {
		this.indPar = indPar;
	}
	public Double getIndPCI() {
		return indPCI;
	}
	public void setIndPCI(Double indPCI) {
		this.indPCI = indPCI;
	}
	public Double getIndPer() {
		return indPer;
	}
	public void setIndPer(Double indPer) {
		this.indPer = indPer;
	}
	public Double getOee() {
		return oee;
	}
	public void setOee(Double oee) {
		this.oee = oee;
	}
	public Double getSegTempoAtivo() {
		return segTempoAtivo;
	}
	public void setSegTempoAtivo(Double segTempoAtivo) {
		this.segTempoAtivo = segTempoAtivo;
	}
	public Double getSegTempoParadasComPeso() {
		return segTempoParadasComPeso;
	}
	public void setSegTempoParadasComPeso(Double segTempoParadasComPeso) {
		this.segTempoParadasComPeso = segTempoParadasComPeso;
	}
	
	public Double getSegTempoParadaSemPeso() {
		return segTempoParadaSemPeso;
	}
	public void setSegTempoParadaSemPeso(Double segTempoParadaSemPeso) {
		this.segTempoParadaSemPeso = segTempoParadaSemPeso;
	}
	public Double getQtPcsCicloTotal() {
		return qtPcsCicloTotal;
	}
	public void setQtPcsCicloTotal(Double qtPcsCicloTotal) {
		this.qtPcsCicloTotal = qtPcsCicloTotal;
	}
	public Double getQtPcsCicloAtiva() {
		return qtPcsCicloAtiva;
	}
	public void setQtPcsCicloAtiva(Double qtPcsCicloAtiva) {
		this.qtPcsCicloAtiva = qtPcsCicloAtiva;
	}
	public Double getSegTempoProdutivas() {
		return segTempoProdutivas;
	}
	public void setSegTempoProdutivas(Double segTempoProdutivas) {
		this.segTempoProdutivas = segTempoProdutivas;
	}
	public Double getCicloPadraoSUM() {
		return cicloPadraoSUM;
	}
	public void setCicloPadraoSUM(Double cicloPadraoSUM) {
		this.cicloPadraoSUM = cicloPadraoSUM;
	}

	public Double getQtPcsCicloTotalSUM() {
		return qtPcsCicloTotalSUM;
	}
	public void setQtPcsCicloTotalSUM(Double qtPcsCicloTotalSUM) {
		this.qtPcsCicloTotalSUM = qtPcsCicloTotalSUM;
	}
	public Double getQtPcsCicloAtivaSUM() {
		return qtPcsCicloAtivaSUM;
	}
	public void setQtPcsCicloAtivaSUM(Double qtPcsCicloAtivaSUM) {
		this.qtPcsCicloAtivaSUM = qtPcsCicloAtivaSUM;
	}
	public Double getQtdCiclosProdutivos() {
		return qtdCiclosProdutivos;
	}
	public void setQtdCiclosProdutivos(Double qtdCiclosProdutivos) {
		this.qtdCiclosProdutivos = qtdCiclosProdutivos;
	}
	public Double getSegCiclosProdutivos() {
		return segCiclosProdutivos;
	}
	public void setSegCiclosProdutivos(Double segCiclosProdutivos) {
		this.segCiclosProdutivos = segCiclosProdutivos;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
    public Double getCicloPadraoCOUNT() {
        return cicloPadraoCOUNT;
    }
    public void setCicloPadraoCOUNT(Double cicloPadraoCOUNT) {
        this.cicloPadraoCOUNT = cicloPadraoCOUNT;
    }
	
	
	
}
