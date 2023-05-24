package idw.webservices.dto;

import java.util.List;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.OmProduto;

public class FiltroMonitorizacaoLocalEstoque {
	List<OmProduto> produtos;
	DwEst estoque;
	DwEstlocal local;
	public List<OmProduto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<OmProduto> produtos) {
		this.produtos = produtos;
	}
	public DwEst getEstoque() {
		return estoque;
	}
	public void setEstoque(DwEst estoque) {
		this.estoque = estoque;
	}
	public DwEstlocal getLocal() {
		return local;
	}
	public void setLocal(DwEstlocal local) {
		this.local = local;
	}
}
