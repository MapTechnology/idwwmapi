package idw.webservices.dto;

import java.util.List;

public class RelatorioProdutoClasseDTO {
	
	private double indiceClasseA;
	private double indiceClasseBInferior;
	private double indiceClasseBSuperior;
	private double indiceClasseC;
	private String produto;
    private double custoUnitario;
    private int producaoLiquida;
    private double custoTotal;
    private double indiceClassificacao;
    private double classe;
    private List<RelatorioProdutoClasseDTO> itens;
    
	public String getProduto() {
		return produto;
	}
	public double getIndiceClasseA() {
		return indiceClasseA;
	}
	public void setIndiceClasseA(double indiceClasseA) {
		this.indiceClasseA = indiceClasseA;
	}
	public double getIndiceClasseBInferior() {
		return indiceClasseBInferior;
	}
	public void setIndiceClasseBInferior(double indiceClasseBInferior) {
		this.indiceClasseBInferior = indiceClasseBInferior;
	}
	public double getIndiceClasseBSuperior() {
		return indiceClasseBSuperior;
	}
	public void setIndiceClasseBSuperior(double indiceClasseBSuperior) {
		this.indiceClasseBSuperior = indiceClasseBSuperior;
	}
	public double getIndiceClasseC() {
		return indiceClasseC;
	}
	public void setIndiceClasseC(double indiceClasseC) {
		this.indiceClasseC = indiceClasseC;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getCustoUnitario() {
		return custoUnitario;
	}
	public void setCustoUnitario(double custoUnitario) {
		this.custoUnitario = custoUnitario;
	}
	public int getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(int producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public double getCustoTotal() {
		return custoTotal;
	}
	public void setCustoTotal(double custoTotal) {
		this.custoTotal = custoTotal;
	}
	public double getIndiceClassificacao() {
		return indiceClassificacao;
	}
	public void setIndiceClassificacao(double indiceClassificacao) {
		this.indiceClassificacao = indiceClassificacao;
	}
	public double getClasse() {
		return classe;
	}
	public void setClasse(double classe) {
		this.classe = classe;
	}
	public List<RelatorioProdutoClasseDTO> getItens() {
		return itens;
	}
	public void setItens(List<RelatorioProdutoClasseDTO> itens) {
		this.itens = itens;
	}
	
}