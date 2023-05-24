package idw.model.rn.impprog;

import java.math.BigDecimal;

public class MaquinaSMDFeeder {
	private String cdFeederDePara;
	private String cdProduto;
	// Luiz 25/04/2018: Campo adicionado segundo solicitacao.
	private String cdProdutoAlternativo;
	private BigDecimal posicao;
	private String idNum;
	private BigDecimal quantidade;
	// Ailton 03/10/2017: campo adicionado segundo solicitacao pelo chamado Funcionalidade #4639
	private String descricao;
	
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public BigDecimal getPosicao() {
		return posicao;
	}
	public void setPosicao(BigDecimal posicao) {
		this.posicao = posicao;
	}
	public String getCdFeederDePara() {
		return cdFeederDePara;
	}
	public void setCdFeederDePara(String cdFeederDePara) {
		this.cdFeederDePara = cdFeederDePara;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCdProdutoAlternativo() {
		return cdProdutoAlternativo;
	}
	public void setCdProdutoAlternativo(String cdProdutoAlternativo) {
		this.cdProdutoAlternativo = cdProdutoAlternativo;
	}
}
