package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ListaComboDTO implements Serializable {

	List<ComboDTO> dtos;

	public List<ComboDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<ComboDTO> dtos) {
		this.dtos = dtos;
	}

}
