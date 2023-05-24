package idw.webservices.dto;

import java.util.List;

public class RelatorioIndiceRefugoDTO {

	private String maquina;
	private String produto;
	private String refugo;
	private Double qtdRefugada = 0d;
	private Double totalqtdProduzidoPt = 0d;
	private Double totalqtdProduzidoProd = 0d;
	private List<RelatorioIndiceRefugoDTO> listaItens;

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getRefugo() {
		return refugo;
	}

	public void setRefugo(String refugo) {
		this.refugo = refugo;
	}

	public Double getQtdRefugada() {
		return qtdRefugada;
	}

	public void setQtdRefugada(Double qtdRefugada) {
		this.qtdRefugada = qtdRefugada;
	}
	
	public Double getTotalqtdProduzidoPt() {
		return totalqtdProduzidoPt;
	}

	public void setTotalqtdProduzidoPt(Double totalqtdProduzidoPt) {
		this.totalqtdProduzidoPt = totalqtdProduzidoPt;
	}

	public Double getTotalqtdProduzidoProd() {
		return totalqtdProduzidoProd;
	}

	public void setTotalqtdProduzidoProd(Double totalqtdProduzidoProd) {
		this.totalqtdProduzidoProd = totalqtdProduzidoProd;
	}
	
	public List<RelatorioIndiceRefugoDTO> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<RelatorioIndiceRefugoDTO> listaItens) {
		this.listaItens = listaItens;
	}

}