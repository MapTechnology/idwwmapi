package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;

public class FiltroAnaliseProducaoDTO {

	private byte tpId;
	private Date dtReferencia;
	private OmGt omGt;
	private DwTurno dwTurno;
	
	public byte getTpId() {
		return tpId;
	}
	public void setTpId(byte tpId) {
		this.tpId = tpId;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}
	public DwTurno getDwTurno() {
		return dwTurno;
	}
	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}

}