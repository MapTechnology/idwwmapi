package idw.webservices.dto;

import idw.model.pojos.OmPt;

public class DetalheAnaliseTurnoDTO {
	
	private OmPt omPt;
	private IndicadoresDTO indicadoresDTO;	
	
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	public IndicadoresDTO getIndicadoresDTO() {
		return indicadoresDTO;
	}
	public void setIndicadoresDTO(IndicadoresDTO indicadoresDTO) {
		this.indicadoresDTO = indicadoresDTO;
	}

}
