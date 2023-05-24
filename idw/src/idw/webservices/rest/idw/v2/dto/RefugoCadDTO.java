package idw.webservices.rest.idw.v2.dto;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="refugo")
public class RefugoCadDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idRefugo;
	private String cdRefugo;
	private String dsRefugo;
	private String tpPt;
	private String cdArea;
	private Boolean requerCausa;
	private Boolean requerAcao; 
	private String cdUsrRev;
	private Integer revisao;
	private Integer stRegistro;
	
	public Integer getIdRefugo() {
		return idRefugo;
	}
	public void setIdRefugo(Integer idRefugo) {
		this.idRefugo = idRefugo;
	}
	public String getCdRefugo() {
		return cdRefugo;
	}
	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}
	public String getDsRefugo() {
		return dsRefugo;
	}
	public void setDsRefugo(String dsRefugo) {
		this.dsRefugo = dsRefugo;
	}
	public String getTpPt() {
		return tpPt;
	}
	public void setTpPt(String tpPt) {
		this.tpPt = tpPt;
	}
	public String getCdArea() {
		return cdArea;
	}
	public void setCdArea(String cdArea) {
		this.cdArea = cdArea;
	}
	public Boolean isRequerCausa() {
		return requerCausa;
	}
	public void setRequerCausa(Boolean requerCausa) {
		this.requerCausa = requerCausa;
	}
	public Boolean isRequerAcao() {
		return requerAcao;
	}
	public void setRequerAcao(Boolean requerAcao) {
		this.requerAcao = requerAcao;
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
