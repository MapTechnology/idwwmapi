package idw.webservices.dto;

import java.util.List;

public class RelatorioDivergenciaDTO {

	private String produto;
	private Double pesoTeorico;
	private Double pesoMedioLido;
	private Integer qtdProduzida;
	private Double qtdDivergencia;
	private List<RelatorioDivergenciaDTO> itens;
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Double getPesoTeorico() {
		return pesoTeorico;
	}
	public void setPesoTeorico(Double pesoTeorico) {
		this.pesoTeorico = pesoTeorico;
	}
	public Double getPesoMedioLido() {
		return pesoMedioLido;
	}
	public void setPesoMedioLido(Double pesoMedioLido) {
		this.pesoMedioLido = pesoMedioLido;
	}
	public Integer getQtdProduzida() {
		return qtdProduzida;
	}
	public void setQtdProduzida(Integer qtdProduzida) {
		this.qtdProduzida = qtdProduzida;
	}
	public Double getQtdDivergencia() {
		return qtdDivergencia;
	}
	public void setQtdDivergencia(Double qtdDivergencia) {
		this.qtdDivergencia = qtdDivergencia;
	}
	public List<RelatorioDivergenciaDTO> getItens() {
		return itens;
	}
	public void setItens(List<RelatorioDivergenciaDTO> itens) {
		this.itens = itens;
	}
	
}
