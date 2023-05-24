package idw.model.rn.relatorios.R101;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RelatorioR101DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<LinhaDetalheR101DTO> linhas = new ArrayList<>();

	public List<LinhaDetalheR101DTO> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<LinhaDetalheR101DTO> linhas) {
		this.linhas = linhas;
	}
}
