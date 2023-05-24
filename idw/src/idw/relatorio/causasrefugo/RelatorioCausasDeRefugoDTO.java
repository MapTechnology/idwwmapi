package idw.relatorio.causasrefugo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCausasDeRefugoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String produto;
	private BigDecimal quantidadeProduzida;
	private BigDecimal quantidadeRefugada;
	private BigDecimal quantidadeLiquida;
	private BigDecimal indiceRefugo;
	private List<RelatorioCausasDeRefugoDetalheDTO> listaDetalheRefugo = new ArrayList<>();
	
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public BigDecimal getQuantidadeProduzida() {
		return quantidadeProduzida;
	}
	public void setQuantidadeProduzida(BigDecimal quantidadeProduzida) {
		this.quantidadeProduzida = quantidadeProduzida;
	}
	public BigDecimal getQuantidadeRefugada() {
		return quantidadeRefugada;
	}
	public void setQuantidadeRefugada(BigDecimal quantidadeRefugada) {
		this.quantidadeRefugada = quantidadeRefugada;
	}
	public BigDecimal getQuantidadeLiquida() {
		return quantidadeLiquida;
	}
	public void setQuantidadeLiquida(BigDecimal quantidadeLiquida) {
		this.quantidadeLiquida = quantidadeLiquida;
	}
	public BigDecimal getIndiceRefugo() {
		return indiceRefugo;
	}
	public void setIndiceRefugo(BigDecimal indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}
	public List<RelatorioCausasDeRefugoDetalheDTO> getListaDetalheRefugo() {
		return listaDetalheRefugo;
	}
	public void setListaDetalheRefugo(
			List<RelatorioCausasDeRefugoDetalheDTO> listaDetalheRefugo) {
		this.listaDetalheRefugo = listaDetalheRefugo;
	}	

}
