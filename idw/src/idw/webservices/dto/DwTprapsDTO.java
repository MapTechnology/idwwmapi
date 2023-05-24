package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

public class DwTprapsDTO extends SucessoDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<DwTprapDTO> dwtrapsDTO;

	public List<DwTprapDTO> getDwtrapsDTO() {
		return dwtrapsDTO;
	}

	public void setDwtrapsDTO(List<DwTprapDTO> dwtrapsDTO) {
		this.dwtrapsDTO = dwtrapsDTO;
	}


	
}
