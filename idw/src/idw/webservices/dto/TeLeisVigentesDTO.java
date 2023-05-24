package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TeLeisVigentesDTO  implements Serializable {
	
private List<TeLeiVigenteDTO> listaTeLeiVigenteDTO;

public List<TeLeiVigenteDTO> getListaTeLeiVigenteDTO() {
	return listaTeLeiVigenteDTO;
}

public void setListaTeLeiVigenteDTO(List<TeLeiVigenteDTO> listaTeLeiVigenteDTO) {
	this.listaTeLeiVigenteDTO = listaTeLeiVigenteDTO;
}
	
	
}
