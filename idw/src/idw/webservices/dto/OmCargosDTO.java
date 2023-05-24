package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OmCargosDTO  implements Serializable {
	
private List<OmCargoDTO> listaOmCargoDTO;

public List<OmCargoDTO> getListaOmCargoDTO() {
	return listaOmCargoDTO;
}

public void setListaOmCargoDTO(List<OmCargoDTO> listaOmCargoDTO) {
	this.listaOmCargoDTO = listaOmCargoDTO;
}
	
	
}
