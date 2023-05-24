package idw.webservices.rest.idw.v2.dto;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="upicms")
public class UpIcMsDTO2 implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private String cdUP;
	private String cdIC;
	private String urlConexao;
	private String tipoConexao;
	
	public String getCdUP() {
		return cdUP;
	}
	public void setCdUP(String cdUP) {
		this.cdUP = cdUP;
	}
	public String getCdIC() {
		return cdIC;
	}
	public void setCdIC(String cdIC) {
		this.cdIC = cdIC;
	}
	public String getUrlConexao() {
		return urlConexao;
	}
	public void setUrlConexao(String urlConexao) {
		this.urlConexao = urlConexao;
	}
	public String getTipoConexao() {
		return tipoConexao;
	}
	public void setTipoConexao(String tipoConexao) {
		this.tipoConexao = tipoConexao;
	}
	
	
	
}
