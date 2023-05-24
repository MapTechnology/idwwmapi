package idw.model.rn.relatorios.opprocessada;

import java.math.BigDecimal;

public class RelatorioOrdemProducaoProcessadaProdutoDTO {
	
	private String cdProduto;
	private String dsProduto;
	
	private BigDecimal producaoBruta = BigDecimal.ZERO;
	private BigDecimal producaoRefugada = BigDecimal.ZERO;
	private BigDecimal producaoLiquida = BigDecimal.ZERO;
	private Double indiceRefugo = 0d;

	private BigDecimal producaoBrutaEmRegulagem = BigDecimal.ZERO;
	private BigDecimal producaoBrutaMaisProducaoEmRegulagem = BigDecimal.ZERO;
	private BigDecimal producaoRefugadaMaiProducaoEmRegulagem = BigDecimal.ZERO;
	private Double indiceRefugoEmRegulagem = 0d;

	public BigDecimal getProducaoBruta() {
		return producaoBruta;
	}

	public void setProducaoBruta(BigDecimal producaoBruta) {
		this.producaoBruta = producaoBruta;
	}

	public BigDecimal getProducaoRefugada() {
		return producaoRefugada;
	}

	public void setProducaoRefugada(BigDecimal producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}

	public BigDecimal getProducaoLiquida() {
		return producaoLiquida;
	}

	public void setProducaoLiquida(BigDecimal producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}

	public Double getIndiceRefugo() {
		return indiceRefugo;
	}

	public void setIndiceRefugo(Double indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}

	public BigDecimal getProducaoBrutaEmRegulagem() {
		return producaoBrutaEmRegulagem;
	}

	public void setProducaoBrutaEmRegulagem(BigDecimal producaoBrutaEmRegulagem) {
		this.producaoBrutaEmRegulagem = producaoBrutaEmRegulagem;
	}

	public BigDecimal getProducaoRefugadaMaiProducaoEmRegulagem() {
		return producaoRefugadaMaiProducaoEmRegulagem;
	}

	public void setProducaoRefugadaMaiProducaoEmRegulagem(BigDecimal producaoRefugadaMaiProducaoEmRegulagem) {
		this.producaoRefugadaMaiProducaoEmRegulagem = producaoRefugadaMaiProducaoEmRegulagem;
	}

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

	public Double getIndiceRefugoEmRegulagem() {
		return indiceRefugoEmRegulagem;
	}

	public void setIndiceRefugoEmRegulagem(Double indiceRefugoEmRegulagem) {
		this.indiceRefugoEmRegulagem = indiceRefugoEmRegulagem;
	}

	public BigDecimal getProducaoBrutaMaisProducaoEmRegulagem() {
		return producaoBrutaMaisProducaoEmRegulagem;
	}

	public void setProducaoBrutaMaisProducaoEmRegulagem(BigDecimal producaoBrutaMaisProducaoEmRegulagem) {
		this.producaoBrutaMaisProducaoEmRegulagem = producaoBrutaMaisProducaoEmRegulagem;
	}
	
	
}
