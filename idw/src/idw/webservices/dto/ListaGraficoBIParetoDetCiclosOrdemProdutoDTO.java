package idw.webservices.dto;

import java.util.List;

public class ListaGraficoBIParetoDetCiclosOrdemProdutoDTO {
	List<GraficoBIParetoDetCiclosOrdemProdutoDTO> listaProdutos;
	private ResumoParetoPerdasDetCiclosDTO resumoIndicadores;
	
	public List<GraficoBIParetoDetCiclosOrdemProdutoDTO> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(
			List<GraficoBIParetoDetCiclosOrdemProdutoDTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

    public ResumoParetoPerdasDetCiclosDTO getResumoIndicadores() {
        return resumoIndicadores;
    }

    public void setResumoIndicadores(ResumoParetoPerdasDetCiclosDTO resumoIndicadores) {
        this.resumoIndicadores = resumoIndicadores;
    }
	
}
