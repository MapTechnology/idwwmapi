package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DwTAreasDTO  implements Serializable {
	
	private List<DwTAreaDTO> listaAreasDTO;
	
	public List<DwTAreaDTO> getListaAreasDTO(){
		return listaAreasDTO;
	}
	public void setListaAreasDTO(List<DwTAreaDTO> listaAreasDTO){
		this.listaAreasDTO = listaAreasDTO;
	}
}
