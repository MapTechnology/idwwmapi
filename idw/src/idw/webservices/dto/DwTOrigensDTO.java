package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DwTOrigensDTO implements Serializable {
	private List<DwTOrigemDTO> listaOrigensDTO;
	
	public List<DwTOrigemDTO> getListaOrigensDTO(){
		return listaOrigensDTO;
	}
	public void setListaOrigensDTO(List<DwTOrigemDTO> listaOrigensDTO){
		this.listaOrigensDTO = listaOrigensDTO;
	}
}


