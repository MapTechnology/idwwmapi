package injetws.webservices.dto;

import java.util.ArrayList;
import java.util.List;

public class IwsColetaDiscretaListaOPsDTO {

	private List<IwsColetaDiscretaOPEmAbertoDTO> lista = new ArrayList<IwsColetaDiscretaOPEmAbertoDTO>();
	private int totalOPs = 0;
	
	public List<IwsColetaDiscretaOPEmAbertoDTO> getLista() {
		return lista;
	}

	public void setLista(List<IwsColetaDiscretaOPEmAbertoDTO> lista) {
		this.lista = lista;
		setTotalOPs(this.totalOPs = this.lista.size());
	}

	public int getTotalOPs() {
		return this.totalOPs;
	}

	public void setTotalOPs(int totalOPs) {
		this.totalOPs = totalOPs;
	}

}
