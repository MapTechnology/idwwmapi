package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="evtrefugo")
public class EvtIHMRefugoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cdPt;
	private String cdRefugo;
	private String cdCausa;
	private String cdAcao;
	private String dthrRefugoMs; //YMDHMS.m
	private String cdProduto;
	private Integer qtdRefugada;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdRefugo() {
		return cdRefugo;
	}
	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
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
	public String getDthrRefugoMs() {
		return dthrRefugoMs;
	}
	public void setDthrRefugoMs(String dthrRefugoMs) {
		this.dthrRefugoMs = dthrRefugoMs;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public Integer getQtdRefugada() {
		return qtdRefugada;
	}
	public void setQtdRefugada(Integer qtdRefugada) {
		this.qtdRefugada = qtdRefugada;
	}
}
