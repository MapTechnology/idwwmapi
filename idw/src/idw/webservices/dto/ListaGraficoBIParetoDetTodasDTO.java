package idw.webservices.dto;

import java.util.List;

public class ListaGraficoBIParetoDetTodasDTO {
	private List<GraficoBIParetoDetTodasDTO> listaProdutos;
	private ResumoParetoPerdasDetTodasDTO resumoIndicadores;
	
	public List<GraficoBIParetoDetTodasDTO> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<GraficoBIParetoDetTodasDTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

    public ResumoParetoPerdasDetTodasDTO getResumoIndicadores() {
        return resumoIndicadores;
    }

    public void setResumoIndicadores(ResumoParetoPerdasDetTodasDTO resumoIndicadores) {
        this.resumoIndicadores = resumoIndicadores;
    }
	
	
	
}
