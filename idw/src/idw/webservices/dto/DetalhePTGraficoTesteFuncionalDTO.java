package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import idw.model.pojos.DwPasstfsepm;


@SuppressWarnings("serial")
public class DetalhePTGraficoTesteFuncionalDTO implements Serializable {
	private List<DwPasstfsepm> medicoes;
	private ResultadoDTO resultado = new ResultadoDTO();
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public List<DwPasstfsepm> getMedicoes() {
		return medicoes;
	}
	public void setMedicoes(List<DwPasstfsepm> medicoes) {
		this.medicoes = medicoes;
	}
	
}
