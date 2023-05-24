package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ihm")
public class IhmDTO2  implements Serializable {
	private static final long serialVersionUID = 1L; 
 
	private Integer idIHM;
	private String cdIHM;
	private String urlConexao; 
	private String cdUsrRev;
	private List<UpIhmDTO2> ups;
	
	public Integer getIdIHM() {
		return idIHM;
	}
	public void setIdIHM(Integer idIHM) {
		this.idIHM = idIHM;
	}
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
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public List<UpIhmDTO2> getUps() {
		return ups;
	}
	public void setUps(List<UpIhmDTO2> ups) {
		this.ups = ups;
	}
	
	
}
