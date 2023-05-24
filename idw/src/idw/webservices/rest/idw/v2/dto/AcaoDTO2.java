package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="acao")
public class AcaoDTO2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idAcao;
	private String cdAcao;
	private String dsAcao;
	private String tpPt;
	private String cdUsrRev;
	private Integer stRegistro;
	private Long revisao;
	
	public Long getIdAcao() {
		return idAcao;
	}
	public void setIdAcao(Long idAcao) {
		this.idAcao = idAcao;
	}
	public String getCdAcao() {
		return cdAcao;
	}
	public void setCdAcao(String cdAcao) {
		this.cdAcao = cdAcao;
	}
	public String getDsAcao() {
		return dsAcao;
	}
	public void setDsAcao(String dsAcao) {
		this.dsAcao = dsAcao;
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
	public Long getRevisao() {
		return revisao;
	}
	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}
	
}
