package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioConsolidadoDTO {

	private List<RelatorioConsolidadosDTO> consolidadosDTO;
	private RelatorioConsolidadosDTO consolidadosTotal;
	private List<RelatorioConsolidadosDTO> listaConsolidadosDTO;
	private List<RelatorioConsolidadosDTO> grpConsolidadosDTO;

	public List<RelatorioConsolidadosDTO> getConsolidadosDTO() {
		return consolidadosDTO;
	}

	public void setConsolidadosDTO(List<RelatorioConsolidadosDTO> consolidadosDTO) {
		this.consolidadosDTO = consolidadosDTO;
	}

	public RelatorioConsolidadosDTO getConsolidadosTotal() {
		return consolidadosTotal;
	}

	public void setConsolidadosTotal(RelatorioConsolidadosDTO consolidadosTotal) {
		this.consolidadosTotal = consolidadosTotal;
	}

	public List<RelatorioConsolidadosDTO> getListaConsolidadosDTO() {
		return listaConsolidadosDTO;
	}

	public void setListaConsolidadosDTO(
			List<RelatorioConsolidadosDTO> listaConsolidadosDTO) {
		this.listaConsolidadosDTO = listaConsolidadosDTO;
	}

	public List<RelatorioConsolidadosDTO> getGrpConsolidadosDTO() {
		return grpConsolidadosDTO;
	}

	public void setGrpConsolidadosDTO(
			List<RelatorioConsolidadosDTO> grpConsolidadosDTO) {
		this.grpConsolidadosDTO = grpConsolidadosDTO;
	}
	
}
