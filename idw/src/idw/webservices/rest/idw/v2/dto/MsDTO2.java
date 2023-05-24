package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ms")
public class MsDTO2 implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private Integer idMS;
	private String cdMS;
	private String dsMS;
	private String macAddress;
	private List<UpIcMsDTO2> associacoesUpIc;
	private String cdUsrRev;
	private Integer stRegistro; 
	private Integer revisao;
	
	public Integer getIdMS() {
		return idMS;
	}
	public void setIdMS(Integer idMS) {
		this.idMS = idMS;
	}
	public String getCdMS() {
		return cdMS;
	}
	public void setCdMS(String cdMS) {
		this.cdMS = cdMS;
	}
	public String getDsMS() {
		return dsMS;
	}
	public void setDsMS(String dsMS) {
		this.dsMS = dsMS;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public List<UpIcMsDTO2> getAssociacoesUpIc() {
		return associacoesUpIc;
	}
	public void setAssociacoesUpIc(List<UpIcMsDTO2> associacoesUpIc) {
		this.associacoesUpIc = associacoesUpIc;
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
	public Integer getRevisao() {
		return revisao;
	}
	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}
}
