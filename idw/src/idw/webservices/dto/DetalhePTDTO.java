package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import idw.model.pojos.OmCfg;


@SuppressWarnings("serial")
public class DetalhePTDTO implements Serializable {
	private List<DetalhePTSerieDTO> series;
	private OmCfg omCfg;
	private ResultadoDTO resultado = new ResultadoDTO();
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public List<DetalhePTSerieDTO> getSeries() {
		return series;
	}
	public void setSeries(List<DetalhePTSerieDTO> series) {
		this.series = series;
	}
	public OmCfg getOmCfg() {
		return omCfg;
	}
	public void setOmCfg(OmCfg omCfg) {
		this.omCfg = omCfg;
	}
	
}
