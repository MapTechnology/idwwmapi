package idw.webservices.dto;

public class MonitorizacaoCheckFeederDTO {
	
	
private String cdPt;
private String cdPa;
private String Ompt;
private int qtd;
private String mapapa;
private double cicloPadra;
private long previsaoTermino;
private long cicloRestante;
private long producaoRestante;


public String getCdPt() {
	return cdPt;
}
public void setCdPt(String cdPt) {
	this.cdPt = cdPt;
}
public String getCdPa() {
	return cdPa;
}
public void setCdPa(String cdPa) {
	this.cdPa = cdPa;
}
public String getOmpt() {
	return Ompt;
}
public void setOmpt(String ompt) {
	Ompt = ompt;
}
public int getQtd() {
	return qtd;
}
public void setQtd(int qtd) {
	this.qtd = qtd;
}
public String getMapapa() {
	return mapapa;
}
public void setMapapa(String mapapa) {
	this.mapapa = mapapa;
}
public double getCicloPadra() {
	return cicloPadra;
}
public void setCicloPadra(double cicloPadra) {
	this.cicloPadra = cicloPadra;
}
public long getPrevisaoTermino() {
	return previsaoTermino;
}
public void setPrevisaoTermino(long previsaoTermino) {
	this.previsaoTermino = previsaoTermino;
}
public long getCicloRestante() {
	return cicloRestante;
}
public void setCicloRestante(long cicloRestante) {
	this.cicloRestante = cicloRestante;
}
public long getProducaoRestante() {
	return producaoRestante;
}
public void setProducaoRestante(long producaoRestante) {
	this.producaoRestante = producaoRestante;
}




}
