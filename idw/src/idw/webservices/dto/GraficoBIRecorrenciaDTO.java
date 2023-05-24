package idw.webservices.dto;

import java.util.List;

public class GraficoBIRecorrenciaDTO {

	private List<GraficoBIItemRecorrenciaDTO> grafico;
	
	public GraficoBIRecorrenciaDTO()
	{
	super();	
	}

	public List<GraficoBIItemRecorrenciaDTO> getGrafico() {
		return grafico;
	}

	public void setGrafico(List<GraficoBIItemRecorrenciaDTO> grafico) {
		this.grafico = grafico;
	}

}
