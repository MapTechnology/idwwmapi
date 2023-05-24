package idw.webservices.dto;

import java.util.List;

public class ListaGraficoBIParetoDetParOrdemProdutoDTO {

	private List<GraficoBIParetoDetParOrdemProdutoDTO> produtos;
	private ResumoParetoPerdasDetParadasDTO resumoIndicadores;
        
	public List<GraficoBIParetoDetParOrdemProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<GraficoBIParetoDetParOrdemProdutoDTO> produtos) {
		this.produtos = produtos;
	}

    public ResumoParetoPerdasDetParadasDTO getResumoIndicadores() {
        return resumoIndicadores;
    }

    public void setResumoIndicadores(ResumoParetoPerdasDetParadasDTO resumoIndicadores) {
        this.resumoIndicadores = resumoIndicadores;
    }
	
	
}
