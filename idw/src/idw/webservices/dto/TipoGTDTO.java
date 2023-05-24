package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmTpgt;

public class TipoGTDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OmTpgt omtpgt;

	public OmTpgt getOmtpgt() {
		return omtpgt;
	}

	public void setOmtpgt(OmTpgt omtpgt) {
		this.omtpgt = omtpgt;
	}
	
	
}
