package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DwTJustsDTO implements Serializable {

	private List<DwTJustDTO> listaJustsDTO;

	public List<DwTJustDTO> getListaJustsDTO() {
		return listaJustsDTO;
	}

	public void setListaJustsDTO(List<DwTJustDTO> listaJustsDTO) {
		this.listaJustsDTO = listaJustsDTO;
	}
	
}