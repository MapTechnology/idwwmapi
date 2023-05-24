package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.List;

public class ListaRelatorioProdutividade {
	
	private List<RelatorioProdutividadeDTO> lista;
	private BigDecimal totalProduzido;

	public List<RelatorioProdutividadeDTO> getLista() {
		return lista;
	}

	public void setLista(List<RelatorioProdutividadeDTO> lista) {
		this.lista = lista;
	}

	public BigDecimal getTotalProduzido() {
		return totalProduzido;
	}

	public void setTotalProduzido(BigDecimal totalProduzido) {
		this.totalProduzido = totalProduzido;
	}

}