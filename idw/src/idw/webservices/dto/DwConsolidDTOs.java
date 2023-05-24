package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DwConsolidDTOs implements Serializable{

	private List<DwConsolidDTO> listaDwConsolidDTO;
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private ResultadoDTO resultadoDTO;
	
	
	public void setListaDwConsolidDTO(List<DwConsolidDTO> listaDwConsolidDTO) {
		this.listaDwConsolidDTO = listaDwConsolidDTO;
	}
	public List<DwConsolidDTO> getListaDwConsolidDTO() {
		return listaDwConsolidDTO;
	}
	
	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	
	
	
}
