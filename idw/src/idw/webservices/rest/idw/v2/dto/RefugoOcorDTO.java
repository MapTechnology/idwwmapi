package idw.webservices.rest.idw.v2.dto;

public class RefugoOcorDTO {
	private String cdRefugo;
	private String dsRefugo;
	private String cdProduto;
	private String dsProduto;	
	private Integer qtdRef; 
	private String dthrRefugoMs; //ymdhms.m
	
	public String getCdRefugo() {
		return cdRefugo;
	}
	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}
	public String getDsRefugo() {
		return dsRefugo;
	}
	public void setDsRefugo(String dsRefugo) {
		this.dsRefugo = dsRefugo;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getDsProduto() {
		return dsProduto;
	}
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	public Integer getQtdRef() {
		return qtdRef;
	}
	public void setQtdRef(Integer qtdRef) {
		this.qtdRef = qtdRef;
	}
	public String getDthrRefugoMs() {
		return dthrRefugoMs;
	}
	public void setDthrRefugoMs(String dthrRefugoMs) {
		this.dthrRefugoMs = dthrRefugoMs;
	}
}
