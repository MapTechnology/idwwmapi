package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="folharap")
public class FolhaRapDTO2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cdFerramenta;
	private String dsFerramenta;
	private BigDecimal tempoPreparacao;
	private BigDecimal qtTotal;
	private BigDecimal qtAlocada;
	private List<FolhaRapProdutoDTO> produtos;
	
	public String getCdFerramenta() {
		return cdFerramenta;
	}
	public void setCdFerramenta(String cdFerramenta) {
		this.cdFerramenta = cdFerramenta;
	}
	public String getDsFerramenta() {
		return dsFerramenta;
	}
	public void setDsFerramenta(String dsFerramenta) {
		this.dsFerramenta = dsFerramenta;
	}
	public BigDecimal getTempoPreparacao() {
		return tempoPreparacao;
	}
	public void setTempoPreparacao(BigDecimal tempoPreparacao) {
		this.tempoPreparacao = tempoPreparacao;
	}
	public BigDecimal getQtTotal() {
		return qtTotal;
	}
	public void setQtTotal(BigDecimal qtTotal) {
		this.qtTotal = qtTotal;
	}
	public BigDecimal getQtAlocada() {
		return qtAlocada;
	}
	public void setQtAlocada(BigDecimal qtAlocada) {
		this.qtAlocada = qtAlocada;
	}
	public List<FolhaRapProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<FolhaRapProdutoDTO> produtos) {
		this.produtos = produtos;
	}
}
