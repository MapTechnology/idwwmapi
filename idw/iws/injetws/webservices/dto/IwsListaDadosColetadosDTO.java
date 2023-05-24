package injetws.webservices.dto;

import java.io.Serializable;
import java.util.List;

public class IwsListaDadosColetadosDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 398190975333084318L;
	private List<IwsDadosColetadosDTO> inspecoes=null;
	private boolean isSetado=false;

	public boolean isSetado() {
		return isSetado;
	}

	public void setSetado(boolean isSetado) {
		this.isSetado = isSetado;
	}

	public List<IwsDadosColetadosDTO> getInspecoes() {
		return inspecoes;
	}
	
	public void setInspecoes(List<IwsDadosColetadosDTO> inspecoes) {
		this.inspecoes = inspecoes;
	}
	
}
