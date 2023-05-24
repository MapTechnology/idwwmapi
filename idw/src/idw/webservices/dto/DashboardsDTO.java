package idw.webservices.dto;

import java.util.List;

public class DashboardsDTO {
	private List<DashboardDTO> listaDashboardDTO;
	private String turnoAtual;
	
	public List<DashboardDTO> getListaDashboardDTO() {
		return listaDashboardDTO;
	}

	public void setListaDashboardDTO(List<DashboardDTO> listaDashboardDTO) {
		this.listaDashboardDTO = listaDashboardDTO;
	}

	public String getTurnoAtual() {
		return turnoAtual;
	}

	public void setTurnoAtual(String turnoAtual) {
		this.turnoAtual = turnoAtual;
	}
	
}
