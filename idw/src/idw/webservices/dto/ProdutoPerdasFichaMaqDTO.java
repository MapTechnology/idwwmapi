package idw.webservices.dto;

import java.math.BigDecimal;

import idw.model.pojos.DwRap;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;

public class ProdutoPerdasFichaMaqDTO {
	private OmPt maquina;
	private DwRap ferramenta;
	private OmProduto produto;
	private BigDecimal eficienciaciclo;
	private BigDecimal perdasineficienciaciclo;
	private BigDecimal indiceparadas;
	private BigDecimal perdasparada;
	private BigDecimal indicerefugos;
	private BigDecimal perdasrefugos;
	private BigDecimal indicecavativas;
	private BigDecimal perdascavativas;
	private BigDecimal totalperdas;
	private BigDecimal segTempoAtivo;
	private BigDecimal segTempoParComPeso;
	private BigDecimal segTempoCiclosNormais;
	private BigDecimal qtdCountCiclosNormais;
	private BigDecimal segSumCicloPadrao;
	private BigDecimal qtdSumPcsCicAtivas;
	private BigDecimal qtdSumPcsCicTotais;
	private BigDecimal qtdProducaoBruta;
	
	
	public OmProduto getProduto() {
		return produto;
	}
	public void setProduto(OmProduto produto) {
		this.produto = produto;
	}
	public DwRap getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(DwRap ferramenta) {
		this.ferramenta = ferramenta;
	}
	public BigDecimal getEficienciaciclo() {
		return eficienciaciclo;
	}
	public void setEficienciaciclo(BigDecimal eficienciaciclo) {
		this.eficienciaciclo = eficienciaciclo;
	}
	public BigDecimal getPerdasineficienciaciclo() {
		return perdasineficienciaciclo;
	}
	public void setPerdasineficienciaciclo(BigDecimal perdasineficienciaciclo) {
		this.perdasineficienciaciclo = perdasineficienciaciclo;
	}
	public BigDecimal getIndiceparadas() {
		return indiceparadas;
	}
	public void setIndiceparadas(BigDecimal indiceparadas) {
		this.indiceparadas = indiceparadas;
	}
	public BigDecimal getPerdasparada() {
		return perdasparada;
	}
	public void setPerdasparada(BigDecimal perdasparada) {
		this.perdasparada = perdasparada;
	}
	public BigDecimal getIndicerefugos() {
		return indicerefugos;
	}
	public void setIndicerefugos(BigDecimal indicerefugos) {
		this.indicerefugos = indicerefugos;
	}
	public BigDecimal getPerdasrefugos() {
		return perdasrefugos;
	}
	public void setPerdasrefugos(BigDecimal perdasrefugos) {
		this.perdasrefugos = perdasrefugos;
	}
	public BigDecimal getIndicecavativas() {
		return indicecavativas;
	}
	public void setIndicecavativas(BigDecimal indicecavativas) {
		this.indicecavativas = indicecavativas;
	}
	public BigDecimal getPerdascavativas() {
		return perdascavativas;
	}
	public void setPerdascavativas(BigDecimal perdascavativas) {
		this.perdascavativas = perdascavativas;
	}
	public BigDecimal getTotalperdas() {
		return totalperdas;
	}
	public void setTotalperdas(BigDecimal totalperdas) {
		this.totalperdas = totalperdas;
	}
	public OmPt getMaquina() {
		return maquina;
	}
	public void setMaquina(OmPt maquina) {
		this.maquina = maquina;
	}
	public BigDecimal getSegTempoAtivo() {
		return segTempoAtivo;
	}
	public void setSegTempoAtivo(BigDecimal segTempoAtivo) {
		this.segTempoAtivo = segTempoAtivo;
	}
	public BigDecimal getSegTempoParComPeso() {
		return segTempoParComPeso;
	}
	public void setSegTempoParComPeso(BigDecimal segTempoParComPeso) {
		this.segTempoParComPeso = segTempoParComPeso;
	}
	public BigDecimal getSegTempoCiclosNormais() {
		return segTempoCiclosNormais;
	}
	public void setSegTempoCiclosNormais(BigDecimal segTempoCiclosNormais) {
		this.segTempoCiclosNormais = segTempoCiclosNormais;
	}
	public BigDecimal getQtdCountCiclosNormais() {
		return qtdCountCiclosNormais;
	}
	public void setQtdCountCiclosNormais(BigDecimal qtdCountCiclosNormais) {
		this.qtdCountCiclosNormais = qtdCountCiclosNormais;
	}
	public BigDecimal getSegSumCicloPadrao() {
		return segSumCicloPadrao;
	}
	public void setSegSumCicloPadrao(BigDecimal segSumCicloPadrao) {
		this.segSumCicloPadrao = segSumCicloPadrao;
	}
	public BigDecimal getQtdSumPcsCicAtivas() {
		return qtdSumPcsCicAtivas;
	}
	public void setQtdSumPcsCicAtivas(BigDecimal qtdSumPcsCicAtivas) {
		this.qtdSumPcsCicAtivas = qtdSumPcsCicAtivas;
	}
	public BigDecimal getQtdSumPcsCicTotais() {
		return qtdSumPcsCicTotais;
	}
	public void setQtdSumPcsCicTotais(BigDecimal qtdSumPcsCicTotais) {
		this.qtdSumPcsCicTotais = qtdSumPcsCicTotais;
	}
	public BigDecimal getQtdProducaoBruta() {
		return qtdProducaoBruta;
	}
	public void setQtdProducaoBruta(BigDecimal qtdProducaoBruta) {
		this.qtdProducaoBruta = qtdProducaoBruta;
	}
	
	
}
