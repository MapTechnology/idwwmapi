package idw.webservices.dto;

import idw.model.pojos.OmGt;

public class DetalheAnaliseTurnoGtDTO {
	
	private OmGt omGt;
	private IndicadoresDTO indicadoresDTO;
	
	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}
	public IndicadoresDTO getIndicadoresDTO() {
		return indicadoresDTO;
	}
	public void setIndicadoresDTO(IndicadoresDTO indicadoresDTO) {
		this.indicadoresDTO = indicadoresDTO;
	}	
	
	

}
