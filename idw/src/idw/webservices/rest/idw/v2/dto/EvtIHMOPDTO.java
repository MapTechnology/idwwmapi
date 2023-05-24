package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="evtopiini")
public class EvtIHMOPDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cdPt;
	private String nrDoc;
	private String cdCp;
	private String cdRap;
	private String cdProduto;
	private String dthrEvt; //YMDHMS 
	private Integer tpSessao;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	public String getCdRap() {
		return cdRap;
	}
	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getDthrEvt() {
		return dthrEvt;
	}
	public void setDthrEvt(String dthrEvt) {
		this.dthrEvt = dthrEvt;
	}
	public Integer getTpSessao() {
		return tpSessao;
	}
	public void setTpSessao(Integer tpSessao) {
		this.tpSessao = tpSessao;
	}
	public String getNrDoc() {
		return nrDoc;
	}
	public void setNrDoc(String nrDoc) {
		this.nrDoc = nrDoc;
	}

}
