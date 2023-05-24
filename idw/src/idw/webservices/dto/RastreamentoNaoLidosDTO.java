package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class RastreamentoNaoLidosDTO implements Serializable{
	
	private List<RastreamentoNaoLidoDTO> listaNumeroSerieNaoLidosDTO;

	public List<RastreamentoNaoLidoDTO> getListaNumeroSerieNaoLidosDTO() {
		return listaNumeroSerieNaoLidosDTO;
	}

	public void setListaNumeroSerieNaoLidosDTO(List<RastreamentoNaoLidoDTO> listaNumeroSerieNaoLidosDTO) {
		this.listaNumeroSerieNaoLidosDTO = listaNumeroSerieNaoLidosDTO;
	}
	
}
