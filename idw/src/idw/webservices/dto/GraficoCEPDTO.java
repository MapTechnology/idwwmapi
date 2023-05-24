package idw.webservices.dto;

import java.util.List;

public class GraficoCEPDTO 
{
	private List<GraficoCEPPeriodoDTO> itemGrafico;
	private List<IndicadoresEstatisticosCEPDTO> indicadoresEstatisticos;
	private List<RelatorioGraficoCEPDTO> listaRelatorio;

	public List<GraficoCEPPeriodoDTO> getItemGrafico() {
		return itemGrafico;
	}

	public void setItemGrafico(List<GraficoCEPPeriodoDTO> itemGrafico) {
		this.itemGrafico = itemGrafico;
	}

	public List<IndicadoresEstatisticosCEPDTO> getIndicadoresEstatisticos() {
		return indicadoresEstatisticos;
	}

	public void setIndicadoresEstatisticos(
			List<IndicadoresEstatisticosCEPDTO> indicadoresEstatisticos) {
		this.indicadoresEstatisticos = indicadoresEstatisticos;
	}

	public List<RelatorioGraficoCEPDTO> getListaRelatorio() {
		return listaRelatorio;
	}

	public void setListaRelatorio(List<RelatorioGraficoCEPDTO> listaRelatorio) {
		this.listaRelatorio = listaRelatorio;
	}
	
	
}
