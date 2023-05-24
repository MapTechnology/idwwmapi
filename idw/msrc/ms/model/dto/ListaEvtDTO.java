package ms.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ListaEvtDTO {
	private List<EvtDTO> listaEvtDTO = new ArrayList<EvtDTO>();
	private ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();

	public void setListaEvtDTO(List<EvtDTO> listaEvtDTO) {
		this.listaEvtDTO = listaEvtDTO;
	}

	public List<EvtDTO> getListaEvtDTO() {
		return listaEvtDTO;
	}
	public void setResultadoDTO(ResultadoMSDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	public ResultadoMSDTO getResultadoDTO() {
		return resultadoDTO;
	}
}
