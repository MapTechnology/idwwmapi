package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class PpPlanecListDTO implements Serializable {
	
	private List<PpPlanecDTO> planecs;
	private ResultadoDTO resultado;
	
	
	public void setPlanecs(List<PpPlanecDTO> planecs) {
		this.planecs = planecs;
	}
	public List<PpPlanecDTO> getPlanecs() {
		return planecs;
	}
	
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public ResultadoDTO getResultado() {
		return resultado;
	}

}
