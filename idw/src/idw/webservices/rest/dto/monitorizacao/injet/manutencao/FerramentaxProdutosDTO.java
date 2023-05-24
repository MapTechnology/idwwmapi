package idw.webservices.rest.dto.monitorizacao.injet.manutencao;

import java.util.List;

public class FerramentaxProdutosDTO {
	private String cdFerramenta;
	private List<ProdutoDTO> produtos;
	
	public String getCdFerramenta() {
		return cdFerramenta;
	}
	public void setCdFerramenta(String cdFerramenta) {
		this.cdFerramenta = cdFerramenta;
	}
	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
	
}
