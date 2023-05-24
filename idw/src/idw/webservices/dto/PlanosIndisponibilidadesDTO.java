package idw.webservices.dto;

import java.util.List;

public class PlanosIndisponibilidadesDTO {
	
	private List<PlanoIndisponibilidadeDTO> planos;
	private ResultadoDTO resultado;
	
	public void setPlanos(List<PlanoIndisponibilidadeDTO> planos) {
		this.planos = planos;
	}

	public List<PlanoIndisponibilidadeDTO> getPlanos() {
		return planos;
	}

	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

	public ResultadoDTO getResultado() {
		return resultado;
	}
}
