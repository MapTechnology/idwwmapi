package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="causa")
public class CausaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCausa;
	private String cdCausa;
	private String dsCausa; 
	private String tpPt;
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdCausa() {
		return idCausa;
	}
	public void setIdCausa(Long idCausa) {
		this.idCausa = idCausa;
	}
	public String getCdCausa() {
		return cdCausa;
	}
	public void setCdCausa(String cdCausa) {
		this.cdCausa = cdCausa;
	}
	public String getDsCausa() {
		return dsCausa;
	}
	public void setDsCausa(String dsCausa) {
		this.dsCausa = dsCausa;
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
