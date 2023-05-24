package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DwProcedimentosDTO implements Serializable{
	
	private List<DwProcedimentoDTO> listaDwProcedimentoDTO;

	public List<DwProcedimentoDTO> getListaDwProcedimentoDTO() {
		return listaDwProcedimentoDTO;
	}

	public void setListaDwProcedimentoDTO(List<DwProcedimentoDTO> listaDwProcedimentoDTO) {
		this.listaDwProcedimentoDTO = listaDwProcedimentoDTO;
	}

	
}