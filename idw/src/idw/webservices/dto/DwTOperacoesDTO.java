package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DwTOperacoesDTO implements Serializable {

	private List<DwTOperacaoDTO> listaOperacoesDTO;

	public List<DwTOperacaoDTO> getListaOperacoesDTO() {
		return listaOperacoesDTO;
	}

	public void setListaOperacoesDTO(List<DwTOperacaoDTO> listaOperacoesDTO) {
		this.listaOperacoesDTO = listaOperacoesDTO;
	}
	
	
}
