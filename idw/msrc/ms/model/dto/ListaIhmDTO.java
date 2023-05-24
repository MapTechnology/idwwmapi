package ms.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ListaIhmDTO {
	
	private List<IhmDTO> listaIhmDTO = new ArrayList<IhmDTO>();
	private ResultadoMSDTO resultadoDTO;
	
	public void setListaIhmDTO(List<IhmDTO> listaIhmDTO) {
		this.listaIhmDTO = listaIhmDTO;
	}
	public List<IhmDTO> getListaIhmDTO() {
		return listaIhmDTO;
	}
	
	public void setResultadoDTO(ResultadoMSDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	public ResultadoMSDTO getResultadoDTO() {
		return resultadoDTO;
	}
}
