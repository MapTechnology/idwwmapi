package idw.webservices.dto;

import java.util.ArrayList;
import java.util.List;


public class PpCmsDTO {
		
	private List<PpCmDTO> listaPpCmDTO = new ArrayList<PpCmDTO>();

	public void setListaPpCmDTO(List<PpCmDTO> listaPpCmDTO) {
		this.listaPpCmDTO = listaPpCmDTO;
	}

	public List<PpCmDTO> getListaPpCmDTO() {
		return listaPpCmDTO;
	}
	
	

}
