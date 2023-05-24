package ms.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ListaIcDTO {
	private List<IcDTO> listaIcDTO = new ArrayList<IcDTO>();
	private ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();

	public void setListaIcDTO(List<IcDTO> listaIcDTO) {
		this.listaIcDTO = listaIcDTO;
	}

	public List<IcDTO> getListaIcDTO() {
		return listaIcDTO;
	}
	public void setResultadoDTO(ResultadoMSDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	public ResultadoMSDTO getResultadoDTO() {
		return resultadoDTO;
	}
}
