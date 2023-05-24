package idw.model.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("serial")
public class PostoBalanceamentoDTO implements Serializable {
	
	private String codigoFolha;
	private long ordem;
	private BigDecimal cicloPadrao;
	private OmTppt omTppt;
	private OmProduto produtoSemiAcabado;
	private List<DwOperacao> operacoes;
	
	public String getCodigoFolha() {
		return codigoFolha;
	}
	public void setCodigoFolha(String codigoFolha) {
		this.codigoFolha = codigoFolha;
	}
	public long getOrdem() {
		return ordem;
	}
	public void setOrdem(long ordem) {
		this.ordem = ordem;
	}
	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public OmTppt getOmTppt() {
		return omTppt;
	}
	public void setOmTppt(OmTppt omTppt) {
		this.omTppt = omTppt;
	}
	public OmProduto getProdutoSemiAcabado() {
		return produtoSemiAcabado;
	}
	public void setProdutoSemiAcabado(OmProduto produtoSemiAcabado) {
		this.produtoSemiAcabado = produtoSemiAcabado;
	}
	public List<DwOperacao> getOperacoes() {
		return operacoes;
	}
	public void setOperacoes(List<DwOperacao> operacoes) {
		this.operacoes = operacoes;
	}
	
	
	
	
}
