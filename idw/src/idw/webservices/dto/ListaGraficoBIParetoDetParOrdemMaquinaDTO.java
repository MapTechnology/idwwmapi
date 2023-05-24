package idw.webservices.dto;

import java.util.List;

public class ListaGraficoBIParetoDetParOrdemMaquinaDTO {

	private List<GraficoBIParetoDetParOrdemMaquinaDTO> maquinas;
	private ResumoParetoPerdasDetParadasDTO resumoIndicadores;
	
	public List<GraficoBIParetoDetParOrdemMaquinaDTO> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(List<GraficoBIParetoDetParOrdemMaquinaDTO> maquinas) {
		this.maquinas = maquinas;
	}

    public ResumoParetoPerdasDetParadasDTO getResumoIndicadores() {
        return resumoIndicadores;
    }

    public void setResumoIndicadores(ResumoParetoPerdasDetParadasDTO resumoIndicadores) {
        this.resumoIndicadores = resumoIndicadores;
    }
	
	
}
