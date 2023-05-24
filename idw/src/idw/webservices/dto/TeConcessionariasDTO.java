package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TeConcessionariasDTO  implements Serializable {
	
private List<TeConcessionariaDTO> listaTeConcessionariaDTO;

public List<TeConcessionariaDTO> getListaTeConcessionariaDTO() {
	return listaTeConcessionariaDTO;
}

public void setListaTeConcessionariaDTO(List<TeConcessionariaDTO> listaTeConcessionariaDTO) {
	this.listaTeConcessionariaDTO = listaTeConcessionariaDTO;
}
	
	
}
