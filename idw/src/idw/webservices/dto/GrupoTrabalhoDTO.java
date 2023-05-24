package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GrupoTrabalhoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cdGt;

	public String getCdGt() {
		return cdGt;
	}

	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	
	

}
