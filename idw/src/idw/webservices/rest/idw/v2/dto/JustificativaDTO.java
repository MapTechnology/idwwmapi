package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="justificativa")
public class JustificativaDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idJustificativa;
	private String cdJustificativa;
	private String dsJustificativa;
	private String tpPt;
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdJustificativa() {
		return idJustificativa;
	}
	public void setIdJustificativa(Long idJustificativa) {
		this.idJustificativa = idJustificativa;
	}
	public String getCdJustificativa() {
		return cdJustificativa;
	}
	public void setCdJustificativa(String cdJustificativa) {
		this.cdJustificativa = cdJustificativa;
	}
	public String getDsJustificativa() {
		return dsJustificativa;
	}
	public void setDsJustificativa(String dsJustificativa) {
		this.dsJustificativa = dsJustificativa;
	}
	public String getTpPt() {
		return tpPt;
	}
	public void setTpPt(String tpPt) {
		this.tpPt = tpPt;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
	
	 
	
}
