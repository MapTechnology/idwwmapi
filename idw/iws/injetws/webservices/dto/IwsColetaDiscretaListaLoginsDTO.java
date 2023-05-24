package injetws.webservices.dto;

import java.util.ArrayList;
import java.util.List;

public class IwsColetaDiscretaListaLoginsDTO {

	private List<IwsColetaDiscretaLoginDTO> lista = new ArrayList<IwsColetaDiscretaLoginDTO>();
	private int totalLogins = 0;
	
	public List<IwsColetaDiscretaLoginDTO> getLista() {
		return lista;
	}

	public void setLista(List<IwsColetaDiscretaLoginDTO> lista) {
		this.lista = lista;
		setTotalLogins(this.totalLogins = this.lista.size());
	}

	public int getTotalLogins() {
		return this.totalLogins;
	}

	public void setTotalLogins(int totalLogins) {
		this.totalLogins = totalLogins;
	}

}
