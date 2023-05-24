package idw.webservices.dto;

import java.util.List;

public class ListaGraficoBIParetoDetCiclosOrdemMaquinaDTO {
	private List<GraficoBIParetoDetCiclosOrdemMaquinaDTO> listaMaquinas;
	private ResumoParetoPerdasDetCiclosDTO resumoIndicadores;

	public List<GraficoBIParetoDetCiclosOrdemMaquinaDTO> getListaMaquinas() {
		return listaMaquinas;
	}

	public void setListaMaquinas(
			List<GraficoBIParetoDetCiclosOrdemMaquinaDTO> listaMaquinas) {
		this.listaMaquinas = listaMaquinas;
	}

    public ResumoParetoPerdasDetCiclosDTO getResumoIndicadores() {
        return resumoIndicadores;
    }

    public void setResumoIndicadores(ResumoParetoPerdasDetCiclosDTO resumoIndicadores) {
        this.resumoIndicadores = resumoIndicadores;
    }	
}
