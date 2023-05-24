package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ic")
public class IcDTO2 implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private Integer idIC;
	private String cdIC;
	private String dsIC;
	private String url;
	private Integer tpConexao;
	private String cdUsrRev;
	private Integer revisao;
	private Integer stRegistro;
	public Integer getIdIC() {
		return idIC;
	}
	public void setIdIC(Integer idIC) {
		this.idIC = idIC;
	}
	public String getCdIC() {
		return cdIC;
	}
	public void setCdIC(String cdIC) {
		this.cdIC = cdIC;
	}
	public String getDsIC() {
		return dsIC;
	}
	public void setDsIC(String dsIC) {
		this.dsIC = dsIC;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getTpConexao() {
		return tpConexao;
	}
	public void setTpConexao(Integer tpConexao) {
		this.tpConexao = tpConexao;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getRevisao() {
		return revisao;
	}
	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}	
}	
