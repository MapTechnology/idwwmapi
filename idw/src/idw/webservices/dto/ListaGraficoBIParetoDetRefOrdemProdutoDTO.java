package idw.webservices.dto;

import java.util.List;

public class ListaGraficoBIParetoDetRefOrdemProdutoDTO {

	private List<GraficoBIParetoDetRefOrdemProdutoDTO> produtos;

	private ResumoParetoPerdasDetRefugosDTO resumoIndicadores;
	
	public List<GraficoBIParetoDetRefOrdemProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<GraficoBIParetoDetRefOrdemProdutoDTO> produtos) {
		this.produtos = produtos;
	}

    public ResumoParetoPerdasDetRefugosDTO getResumoIndicadores() {
        return resumoIndicadores;
    }

    public void setResumoIndicadores(ResumoParetoPerdasDetRefugosDTO resumoIndicadores) {
        this.resumoIndicadores = resumoIndicadores;
    }

 
	
}
