package idw.webservices.rest.dto.monitorizacao.injet.bi;

public class FiltroBIParetoParadaDTO {
	private Boolean isComPeso;
	private Boolean isSemPeso;
	
	private String cdAreaResp;
	
	public Boolean getIsComPeso() {
		return isComPeso;
	}
	public void setIsComPeso(Boolean isComPeso) {
		this.isComPeso = isComPeso;
	}
	public String getCdAreaResp() {
		return cdAreaResp;
	}
	public void setCdAreaResp(String cdAreaResp) {
		this.cdAreaResp = cdAreaResp;
	}
	public Boolean getIsSemPeso() {
		return isSemPeso;
	}
	public void setIsSemPeso(Boolean isSemPeso) {
		this.isSemPeso = isSemPeso;
	}
	
	
}
