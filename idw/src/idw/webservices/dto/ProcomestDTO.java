package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmProcomest;

@SuppressWarnings("serial")
public class ProcomestDTO implements Serializable{
	private OmProcomest procomest;

	public OmProcomest getProcomest() {
		return procomest;
	}

	public void setProcomest(OmProcomest procomest) {
		this.procomest = procomest;
	}	
	
}
