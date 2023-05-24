package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DwTCausasDTO implements Serializable {
	private List<DwTCausaDTO> listaCausasDTO;
	
	public List<DwTCausaDTO> getListaCausasDTO(){
		return listaCausasDTO;
	}
	public void setListaCausasDTO(List<DwTCausaDTO> listaCausasDTO){
		this.listaCausasDTO = listaCausasDTO;
	}
}


