package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RastreamentoLocalDTO implements Serializable{
	private String fase;
	private String etapa;
	private String turno;
	private String posto;
	private String operador;
	private String dthr;
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getEtapa() {
		return etapa;
	}
	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getDthr() {
		return dthr;
	}
	public void setDthr(String dthr) {
		this.dthr = dthr;
	}
}
