package idw.model.rn.diariobordo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DiariosBordoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<DiarioBordoDTO> diarios = new ArrayList<>();

	public List<DiarioBordoDTO> getDiarios() {
		return diarios;
	}

	public void setDiarios(List<DiarioBordoDTO> diarios) {
		this.diarios = diarios;
	}
}
