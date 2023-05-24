package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TeTarifasemanaisDTO  implements Serializable {

	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private int resultadoEvento;
	
	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	
	private List<TeTarifasemanalDTO> listaTeTarifasemanalDTO;

	public List<TeTarifasemanalDTO> getListaTeTarifasemanalDTO() {
		return listaTeTarifasemanalDTO;
	}

	public void setListaTeTarifasemanalDTO(List<TeTarifasemanalDTO> listaTeTarifasemanalDTO) {
		this.listaTeTarifasemanalDTO = listaTeTarifasemanalDTO;
	}


}
