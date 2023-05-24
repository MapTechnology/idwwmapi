package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="evtparada")
public class EvtIHMParadaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cdPt;
	private String cdParada;
	private String cdCausa;
	private String cdAcao;
	private String cdJust;
	private String dthrIniParMs; //YMDHMS.m
	private String cdTecResp;
	private String cdTec1;
	private String cdTec2;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	public String getCdCausa() {
		return cdCausa;
	}
	public void setCdCausa(String cdCausa) {
		this.cdCausa = cdCausa;
	}
	public String getCdAcao() {
		return cdAcao;
	}
	public void setCdAcao(String cdAcao) {
		this.cdAcao = cdAcao;
	}
	public String getCdJust() {
		return cdJust;
	}
	public void setCdJust(String cdJust) {
		this.cdJust = cdJust;
	}
	public String getDthrIniParMs() {
		return dthrIniParMs;
	}
	public void setDthrIniParMs(String dthrIniParMs) {
		this.dthrIniParMs = dthrIniParMs;
	}
	public String getCdTecResp() {
		return cdTecResp;
	}
	public void setCdTecResp(String cdTecResp) {
		this.cdTecResp = cdTecResp;
	}
	public String getCdTec1() {
		return cdTec1;
	}
	public void setCdTec1(String cdTec1) {
		this.cdTec1 = cdTec1;
	}
	public String getCdTec2() {
		return cdTec2;
	}
	public void setCdTec2(String cdTec2) {
		this.cdTec2 = cdTec2;
	}
}
