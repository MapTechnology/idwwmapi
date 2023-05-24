package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DwGrpativDTOs implements Serializable{
	private List<DwGrpativDTO> listaDwGrpativDTO;

	public List<DwGrpativDTO> getListaDwGrpativDTO() {
		return listaDwGrpativDTO;
	}

	public void setListaDwGrpativDTO(List<DwGrpativDTO> listaDwGrpativDTO) {
		this.listaDwGrpativDTO = listaDwGrpativDTO;
	}
	
}
