package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="upihm") 
public class UpIhmDTO2  implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String cdUP;
	
	public String getCdUP() {
		return cdUP;
	}
	public void setCdUP(String cdUP) {
		this.cdUP = cdUP;
	}
 
	
}
