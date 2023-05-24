package idw.webservices.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.PpCpproduto;;

public class AdiantamentoDTO {
	
	private List<PpCpproduto> produtos = new ArrayList<PpCpproduto>();
	private List<AlocacaoProdutoMaquinaDTO> maquina = new ArrayList<AlocacaoProdutoMaquinaDTO>();
	private Date data;

	public List<PpCpproduto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<PpCpproduto> produtos) {
		this.produtos = produtos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<AlocacaoProdutoMaquinaDTO> getMaquina() {
		return maquina;
	}

	public void setMaquina(List<AlocacaoProdutoMaquinaDTO> maquina) {
		this.maquina = maquina;
	}
	
}
