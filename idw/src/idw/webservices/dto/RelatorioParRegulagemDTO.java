package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class RelatorioParRegulagemDTO implements Serializable  {
	private List<ParRegulagemDTO> paradas;

	public List<ParRegulagemDTO> getParadas() {
		return paradas;
	}

	public void setParadas(List<ParRegulagemDTO> paradas) {
		this.paradas = paradas;
	}
	
}
