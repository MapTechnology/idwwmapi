package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class PpTpplanoListDTO implements Serializable {
	
	private List<PpTpplanoDTO> tpPlanos;
	private ResultadoDTO resultado;
	
	
	public PpTpplanoListDTO() {
	}
	public PpTpplanoListDTO(List<PpTpplanoDTO> tpPlanos) {
		this.tpPlanos = tpPlanos;
	}
	
	public void setTpPlanos(List<PpTpplanoDTO> tpPlanos) {
		this.tpPlanos = tpPlanos;
	}
	public List<PpTpplanoDTO> getTpPlanos() {
		return tpPlanos;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public ResultadoDTO getResultado() {
		return resultado;
	}
	
}
