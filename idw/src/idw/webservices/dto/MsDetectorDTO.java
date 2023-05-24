package idw.webservices.dto;

import idw.model.pojos.MsDetector;

public class MsDetectorDTO {
	
	
	private ResultadoDTO resultadoDTO = new ResultadoDTO();
	
	
	private MsDetector msDetector;

	public void setMsDetector(MsDetector msDetector) {
		this.msDetector = msDetector;
	}

	public MsDetector getMsDetector() {
		return msDetector;
	}

	

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}

	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

}
