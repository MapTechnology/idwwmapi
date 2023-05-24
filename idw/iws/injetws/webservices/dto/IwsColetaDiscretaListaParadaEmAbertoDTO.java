package injetws.webservices.dto;

import java.util.ArrayList;
import java.util.List;

public class IwsColetaDiscretaListaParadaEmAbertoDTO {

	private List<IwsColetaDiscretaParadaEmAbertoDTO> lista = new ArrayList<IwsColetaDiscretaParadaEmAbertoDTO>();
	private int totalUPsComParada = 0;
	
	public List<IwsColetaDiscretaParadaEmAbertoDTO> getLista() {
		return lista;
	}

	public void setLista(List<IwsColetaDiscretaParadaEmAbertoDTO> lista) {
		this.lista = lista;
	}

	public int getTotalUPsComParada() {
		return this.totalUPsComParada;
	}

	public void setTotalUPsComParada(int totalUPsComParada) {
		this.totalUPsComParada = totalUPsComParada;
	}

}
