package idw.webservices.rest.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="op")
public class OpDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	private String cdCp;
	private String nrDoc;
	private String opView;
	private String opDataHoraView;
	private Date dataHoraIni;
	
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	public String getNrDoc() {
		return nrDoc;
	}
	public void setNrDoc(String nrDoc) {
		this.nrDoc = nrDoc;
	}
	public String getOpView() {
		return opView;
	}
	public void setOpView(String opView) {
		this.opView = opView;
	}
	public String getOpDataHoraView() {
		return opDataHoraView;
	}
	public void setOpDataHoraView(String opDataHoraView) {
		this.opDataHoraView = opDataHoraView;
	}
	public Date getDataHoraIni() {
		return dataHoraIni;
	}
	public void setDataHoraIni(Date dataHoraIni) {
		this.dataHoraIni = dataHoraIni;
	}
	
	
}
