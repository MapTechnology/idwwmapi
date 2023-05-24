package idw.webservices.dto;

import idw.model.pojos.OmProturno;

public class OmProTurnoDTO {

	
	private OmProturno omProturno;
	
	private ResultadoDTO resultadoDTO;

	public void setOmProturno(OmProturno omProturno) {
		this.omProturno = omProturno;
	}

	public OmProturno getOmProturno() {
		return omProturno;
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}

	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}
	
	
}
