package idw.webservices.dto;

public class PtRapResumoDTO 

{
	private String cdPt;
	private String dsPt;
	private String cdRap;
	
	private String cdFolha;

	private Double cicloPadrao;
	private Double cicloMedio;
	private Double cicloPadraoSUM;
	private Integer qtCicloPadraoSUM = 0;
	private Double qtdCiclosProdutivos;
	private Double segCiclosProdutivos;
	private Double qtPcsCicloTotal;
	private Double qtPcsCicloAtiva;
	private Double qtPcsCicloTotalSUM;
	private Double qtPcsCicloAtivaSUM;
	
	private Double segTempoAtivo;
	private Double segTempoParadasComPeso;
	private Double segTempoParadasSemPeso;
	private Double segTempoParadas;
	private Double segTempoProdutivas;
	
	
	private Double qtBruta;
	private Double qtRefugada;
	private Double qtLiquida;
	private Double qtPrevista;
	private Double qtPerdas;
	private Double qtPerdasCic;
	private Double qtPerdasPar;
	private Double qtPerdasPCI;
	private Double efiRea;
	private Double efiCic;
	private Double indRef;
	private Double indPar;
	private Double indPCI;
	private Double indPer;
	private Double oee;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public String getCdRap() {
		return cdRap;
	}
	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
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
	public Double getCicloPadraoSUM() {
		return cicloPadraoSUM;
	}
	public void setCicloPadraoSUM(Double cicloPadraoSUM) {
		this.cicloPadraoSUM = cicloPadraoSUM;
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
	public Double getSegTempoParadasSemPeso() {
		return segTempoParadasSemPeso;
	}
	public void setSegTempoParadasSemPeso(Double segTempoParadasSemPeso) {
		this.segTempoParadasSemPeso = segTempoParadasSemPeso;
	}
	public Double getSegTempoParadas() {
		return segTempoParadas;
	}
	public void setSegTempoParadas(Double segTempoParadas) {
		this.segTempoParadas = segTempoParadas;
	}
	public Double getSegTempoProdutivas() {
		return segTempoProdutivas;
	}
	public void setSegTempoProdutivas(Double segTempoProdutivas) {
		this.segTempoProdutivas = segTempoProdutivas;
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
	public Double getQtPerdasCic() {
		return qtPerdasCic;
	}
	public void setQtPerdasCic(Double qtPerdasCic) {
		this.qtPerdasCic = qtPerdasCic;
	}
	public Double getQtPerdasPar() {
		return qtPerdasPar;
	}
	public void setQtPerdasPar(Double qtPerdasPar) {
		this.qtPerdasPar = qtPerdasPar;
	}
	public Double getQtPerdasPCI() {
		return qtPerdasPCI;
	}
	public void setQtPerdasPCI(Double qtPerdasPCI) {
		this.qtPerdasPCI = qtPerdasPCI;
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
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	public Integer getQtCicloPadraoSUM() {
		return qtCicloPadraoSUM;
	}
	public void setQtCicloPadraoSUM(Integer qtCicloPadraoSUM) {
		this.qtCicloPadraoSUM = qtCicloPadraoSUM;
	}
	
	
}
