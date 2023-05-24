package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ListaTipoAlgoritmoBalanceamentoDTO implements Serializable {

	List<TipoAlgoritmoBalanceamentoDTO> dtos;

	public List<TipoAlgoritmoBalanceamentoDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<TipoAlgoritmoBalanceamentoDTO> dtos) {
		this.dtos = dtos;
	}
	
	
}
