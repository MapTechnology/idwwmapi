package idw.webservices.rest.idw.v2.dto;

public class OpComRapDTO {
	private String cdCp;
	private String cdRap;
	private String nrDoc;
	private String cdProduto;
	private String dthrIni; //ymdhms
	private String dtHrFim; 
	private Integer statusCP;
	private Integer tpSessao;
	
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
	public String getDthrIni() {
		return dthrIni;
	}
	public void setDthrIni(String dthrIni) {
		this.dthrIni = dthrIni;
	}
	public Integer getStatusCP() {
		return statusCP;
	}
	public void setStatusCP(Integer statusCP) {
		this.statusCP = statusCP;
	}
	public String getDtHrFim() {
		return dtHrFim;
	}
	public void setDtHrFim(String dtHrFim) {
		this.dtHrFim = dtHrFim;
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
