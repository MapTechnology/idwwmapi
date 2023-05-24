package injetws.webservices.dto;

import injetws.model.pojos.PrUp;
import java.util.ArrayList;
import java.util.List;

public class IwsColetaDiscretaListaUPsDTO {

	private List<PrUp> lista = new ArrayList<PrUp>();
	private int totalUPs = 0;
	public List<PrUp> getLista() {
		return lista;
	}
	public void setLista(List<PrUp> lista) {
		this.lista = lista;
	}
	public int getTotalUPs() {
		return totalUPs;
	}
	public void setTotalUPs(int totalUPs) {
		this.totalUPs = totalUPs;
	}
 	
}
 