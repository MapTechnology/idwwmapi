package idw.webservices.dto;

import java.util.List;

public class ListaGraficoBIParetoDetRefOrdemMaquinaDTO {

	private List<GraficoBIParetoDetRefOrdemMaquinaDTO> maquinas;
	private ResumoParetoPerdasDetRefugosDTO resumoIndicadores;
	
	public List<GraficoBIParetoDetRefOrdemMaquinaDTO> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(List<GraficoBIParetoDetRefOrdemMaquinaDTO> maquinas) {
		this.maquinas = maquinas;
	}

    public ResumoParetoPerdasDetRefugosDTO getResumoIndicadores() {
        return resumoIndicadores;
    }

    public void setResumoIndicadores(ResumoParetoPerdasDetRefugosDTO resumoIndicadores) {
        this.resumoIndicadores = resumoIndicadores;
    }

 
	
}
