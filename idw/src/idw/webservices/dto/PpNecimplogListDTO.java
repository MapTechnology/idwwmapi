package idw.webservices.dto;

import java.util.List;

public class PpNecimplogListDTO {
	
	private List<PpNecimplogDTO> logs;
	private ResultadoDTO resultado;
	
	
	public PpNecimplogListDTO() {
	}
	public PpNecimplogListDTO(List<PpNecimplogDTO> logs) {
		this.logs = logs;
	}

	public void setLogs(List<PpNecimplogDTO> logs) {
		this.logs = logs;
	}

	public List<PpNecimplogDTO> getLogs() {
		return logs;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public ResultadoDTO getResultado() {
		return resultado;
	}
	
}
