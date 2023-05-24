package ms.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ListaBcDTO implements Serializable {

	private List<BcDTO> listaBcDTO = new ArrayList<BcDTO>();
	
	


	public List<BcDTO> getListaBcDTO() {
		return listaBcDTO;
	}

	public void setListaBcDTO(List<BcDTO> listaBcDTO) {
		this.listaBcDTO = listaBcDTO;
	}}
