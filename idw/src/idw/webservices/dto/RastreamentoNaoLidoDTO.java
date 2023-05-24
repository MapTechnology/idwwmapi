package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RastreamentoNaoLidoDTO implements Serializable{
	
	private String nsnaolido;
	private String cdmodelo;
	private String dsmodelo;
	
	public String getNsnaolido() {
		return nsnaolido;
	}
	public void setNsnaolido(String nsnaolido) {
		this.nsnaolido = nsnaolido;
	}
	public String getCdmodelo() {
		return cdmodelo;
	}
	public void setCdmodelo(String cdmodelo) {
		this.cdmodelo = cdmodelo;
	}
	public String getDsmodelo() {
		return dsmodelo;
	}
	public void setDsmodelo(String dsmodelo) {
		this.dsmodelo = dsmodelo;
	}
	
}
