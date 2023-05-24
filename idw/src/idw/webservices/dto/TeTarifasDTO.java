package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TeTarifasDTO  implements Serializable {
	
private List<TeTarifaDTO> listaTeTarifaDTO;

public List<TeTarifaDTO> getListaTeTarifaDTO() {
	return listaTeTarifaDTO;
}

public void setListaTeTarifaDTO(List<TeTarifaDTO> listaTeTarifaDTO) {
	this.listaTeTarifaDTO = listaTeTarifaDTO;
}
	
	
}
