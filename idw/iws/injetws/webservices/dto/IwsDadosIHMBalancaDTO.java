package injetws.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class IwsDadosIHMBalancaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3078329442809188776L;
	
	private String dslinha;
	private String numeroItem;
	private String dsprodutoext;
	private Integer qtdprodutoemb;
	private String nropext;
	private String cliente;
	private Double pesoembalagem;
	private Double pesoprodutoun;
	private String cdlinha;
	
	public String getCdlinha() {
		return cdlinha;
	}
	public void setCdlinha(String cdlinha) {
		this.cdlinha = cdlinha;
	}
	public String getDslinha() {
		return dslinha;
	}
	public void setDslinha(String dslinha) {
		this.dslinha = dslinha;
	}
	public String getNumeroItem() {
		return numeroItem;
	}
	public void setNumeroItem(String numeroItem) {
		this.numeroItem = numeroItem;
	}
	public String getDsprodutoext() {
		return dsprodutoext;
	}
	public void setDsprodutoext(String dsprodutoext) {
		this.dsprodutoext = dsprodutoext;
	}
	public Integer getQtdprodutoemb() {
		return qtdprodutoemb;
	}
	public void setQtdprodutoemb(Integer qtdprodutoemb) {
		this.qtdprodutoemb = qtdprodutoemb;
	}
	public String getNropext() {
		return nropext;
	}
	public void setNropext(String nropext) {
		this.nropext = nropext;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Double getPesoembalagem() {
		return pesoembalagem;
	}
	public void setPesoembalagem(Double pesoembalagem) {
		this.pesoembalagem = pesoembalagem;
	}
	public Double getPesoprodutoun() {
		return pesoprodutoun;
	}
	public void setPesoprodutoun(BigDecimal pesoprodutoun) {
		this.pesoprodutoun = pesoprodutoun.doubleValue();
	}
	
	
}
