package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="upihm") 
public class IhmUpDTO2 implements Serializable {
	private static final long serialVersionUID = 1L; 

	private String cdIHM;
	private String urlConexao;

	public String getCdIHM() {
		return cdIHM;
	}

	public void setCdIHM(String cdIHM) {
		this.cdIHM = cdIHM;
	}

	public String getUrlConexao() {
		return urlConexao;
	}

	public void setUrlConexao(String urlConexao) {
		this.urlConexao = urlConexao;
	}
	
	
}
