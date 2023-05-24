package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="calendariopt")
public class CalendarioPtDTO2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cdCal;
	private String cdPt;
	private String dsPt;
	private Boolean selecionado;
	
	public String getCdCal() {
		return cdCal;
	}
	public void setCdCal(String cdCal) {
		this.cdCal = cdCal;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public Boolean isSelecionado() {
		return selecionado;
	}
	public void setSelecionado(Boolean selecionado) {
		this.selecionado = selecionado;
	}
	
}
