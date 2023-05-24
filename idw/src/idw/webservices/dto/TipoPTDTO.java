package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmTppt;

public class TipoPTDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OmTppt omTppt;

	public OmTppt getOmTppt() {
		return omTppt;
	}

	public void setOmTppt(OmTppt omtppt) {
		this.omTppt = omtppt;
	}
	
	
}
