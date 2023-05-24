package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="parada")
public class ParadaCadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idParada;
	private String cdParada; 
	private String dsParada;
	private String tpPt;
	private String cdArea;
	private String dsArea;
	private Integer qtdTec;
		
	private Boolean reqPesaEficiencia;
	private Boolean reqCancelamento;
	private Boolean reqPermiteCorrecao;
	private Boolean reqMTBFMTTR;
	private Boolean reqCausa;
	private Boolean reqAcao;
	private Boolean reqJustificativa;
	
	private TimeOutAlertaParCadDTO timeOutAlerta;
	private TimeOutParadaParCadDTO timeOutParada;
	
	private String cdUsrRev;
	private Integer revisao;
	private Integer stRegistro;
	
	public Integer getIdParada() {
		return idParada;
	}
	public void setIdParada(Integer idParada) {
		this.idParada = idParada;
	}
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	public String getDsParada() {
		return dsParada;
	}
	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
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
	public String getDsArea() {
		return dsArea;
	}
	public void setDsArea(String dsArea) {
		this.dsArea = dsArea;
	}
	public Integer getQtdTec() {
		return qtdTec;
	}
	public void setQtdTec(Integer qtdTec) {
		this.qtdTec = qtdTec;
	}
	public Boolean isReqPesaEficiencia() {
		return reqPesaEficiencia;
	}
	public void setReqPesaEficiencia(Boolean reqPesaEficiencia) {
		this.reqPesaEficiencia = reqPesaEficiencia;
	}
	public Boolean isReqCancelamento() {
		return reqCancelamento;
	}
	public void setReqCancelamento(Boolean reqCancelamento) {
		this.reqCancelamento = reqCancelamento;
	}
	public Boolean isReqPermiteCorrecao() {
		return reqPermiteCorrecao;
	}
	public void setReqPermiteCorrecao(Boolean reqPermiteCorrecao) {
		this.reqPermiteCorrecao = reqPermiteCorrecao;
	}
	public Boolean isReqMTBFMTTR() {
		return reqMTBFMTTR;
	}
	public void setReqMTBFMTTR(Boolean reqMTBFMTTR) {
		this.reqMTBFMTTR = reqMTBFMTTR;
	}
	public Boolean isReqCausa() {
		return reqCausa;
	}
	public void setReqCausa(Boolean reqCausa) {
		this.reqCausa = reqCausa;
	}
	public Boolean isReqAcao() {
		return reqAcao;
	}
	public void setReqAcao(Boolean reqAcao) {
		this.reqAcao = reqAcao;
	}
	public Boolean isReqJustificativa() {
		return reqJustificativa;
	}
	public void setReqJustificativa(Boolean reqJustificativa) {
		this.reqJustificativa = reqJustificativa;
	}
	public TimeOutAlertaParCadDTO getTimeOutAlerta() {
		return timeOutAlerta;
	}
	public void setTimeOutAlerta(TimeOutAlertaParCadDTO timeOutAlerta) {
		this.timeOutAlerta = timeOutAlerta;
	}
	public TimeOutParadaParCadDTO getTimeOutParada() {
		return timeOutParada;
	}
	public void setTimeOutParada(TimeOutParadaParCadDTO timeOutParada) {
		this.timeOutParada = timeOutParada;
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
