package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaquinasInjetDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MaquinaInjetDTO> maquinas = new ArrayList<MaquinaInjetDTO>();
	private int resultado;
	
	public List<MaquinaInjetDTO> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(List<MaquinaInjetDTO> maquinas) {
		this.maquinas = maquinas;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	
}
