package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class RastreamentoNSDTO implements Serializable{
	private List<RastreamentoLocalDTO> listalocalDTO;
	private List<RastreamentoCompAtualDTO> listacompAtualDTO;

	public List<RastreamentoCompAtualDTO> getListacompAtualDTO() {
		return listacompAtualDTO;
	}

	public void setListacompAtualDTO(
			List<RastreamentoCompAtualDTO> listacompAtualDTO) {
		this.listacompAtualDTO = listacompAtualDTO;
	}

	public List<RastreamentoLocalDTO> getListalocalDTO() {
		return listalocalDTO;
	}

	public void setListalocalDTO(List<RastreamentoLocalDTO> listalocalDTO) {
		this.listalocalDTO = listalocalDTO;
	}

}
