package ms.model.dto;

import java.util.List;

public class ListaMSDTO {
	
	private List<MsDTO> listaMSDTO;
	private ResultadoMSDTO resultadoDTO;
	
	public void setListaMSDTO(List<MsDTO> listaMSDTO) {
		this.listaMSDTO = listaMSDTO;
	}
	public List<MsDTO> getListaMSDTO() {
		return listaMSDTO;
	}
	
	public void setResultadoDTO(ResultadoMSDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	public ResultadoMSDTO getResultadoDTO() {
		return resultadoDTO;
	}

}
