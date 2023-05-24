package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DwNseriesDTO implements Serializable{
	
	private List<DwNserieDTO> listaDwNserieDTO;

	public List<DwNserieDTO> getListaDwNserieDTO() {
		return listaDwNserieDTO;
	}

	public void setListaDwNserieDTO(List<DwNserieDTO> listaDwNserieDTO) {
		this.listaDwNserieDTO = listaDwNserieDTO;
	}  
}
