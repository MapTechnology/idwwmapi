package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TeTipoConsumidoresDTO  implements Serializable {
	
private List<TeTipoConsumidorDTO> listaTeTipoConsumidorDTO;

public List<TeTipoConsumidorDTO> getListaTeTipoConsumidorDTO() {
	return listaTeTipoConsumidorDTO;
}

public void setListaTeTipoConsumidorDTO(List<TeTipoConsumidorDTO> listaTeTipoConsumidorDTO) {
	this.listaTeTipoConsumidorDTO = listaTeTipoConsumidorDTO;
}
	
	
}
