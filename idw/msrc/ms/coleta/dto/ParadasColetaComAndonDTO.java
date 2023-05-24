package ms.coleta.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParadasColetaComAndonDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<ParadaColetaComAndonDTO> lista = new ArrayList<ParadaColetaComAndonDTO>();
	private boolean isTNC;
	
	public List<ParadaColetaComAndonDTO> getLista() {
		return lista;
	}

	public boolean isTNC() {
		return isTNC;
	}

	public void setTNC(boolean isTNC) {
		this.isTNC = isTNC;
	}

	public void setLista(List<ParadaColetaComAndonDTO> lista) {
		this.lista = lista;
	}

}
