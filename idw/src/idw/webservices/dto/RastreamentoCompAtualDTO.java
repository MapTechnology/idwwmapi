package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class RastreamentoCompAtualDTO implements Serializable{
	private String ns;
	private String fase;
	private String cdModelo;
	private String dsModelo;
	private Date dthr;
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getCdModelo() {
		return cdModelo;
	}
	public void setCdModelo(String cdModelo) {
		this.cdModelo = cdModelo;
	}
	public String getDsModelo() {
		return dsModelo;
	}
	public void setDsModelo(String dsModelo) {
		this.dsModelo = dsModelo;
	}
	public Date getDthr() {
		return dthr;
	}
	public void setDthr(Date dthr) {
		this.dthr = dthr;
	}
}
