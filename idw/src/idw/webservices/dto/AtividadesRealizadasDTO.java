package idw.webservices.dto;

import java.util.List;

public class AtividadesRealizadasDTO {
	List<AtividadeRealizadaDTO> atividadeRealizadaDTOs;
	List<ObservacaoRealizadaDTO> observacaoRealizadaDTOs;
	List<DwProreaUsrDTO> dwProreaUsrDTOs;

	public List<AtividadeRealizadaDTO> getAtividadeRealizadaDTOs() {
		return atividadeRealizadaDTOs;
	}

	public void setAtividadeRealizadaDTOs(
			List<AtividadeRealizadaDTO> atividadeRealizadaDTOs) {
		this.atividadeRealizadaDTOs = atividadeRealizadaDTOs;
	}

	public List<ObservacaoRealizadaDTO> getObservacaoRealizadaDTOs() {
		return observacaoRealizadaDTOs;
	}

	public void setObservacaoRealizadaDTOs(
			List<ObservacaoRealizadaDTO> observacaoRealizadaDTOs) {
		this.observacaoRealizadaDTOs = observacaoRealizadaDTOs;
	}

	public List<DwProreaUsrDTO> getDwProreaUsrDTOs() {
		return dwProreaUsrDTOs;
	}

	public void setDwProreaUsrDTOs(List<DwProreaUsrDTO> dwProreaUsrDTOs) {
		this.dwProreaUsrDTOs = dwProreaUsrDTOs;
	}
}
