package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class PpClientesDTO  implements Serializable{

	private List<PpClienteDTO> listaPpClientesDTO;

	public List<PpClienteDTO> getListaPpClientesDTO() {
		return listaPpClientesDTO;
	}

	public void setListaPpClientesDTO(List<PpClienteDTO> listaPpClientesDTO) {
		this.listaPpClientesDTO = listaPpClientesDTO;
	}
	
	
}
