package idw.webservices.rest.dto.monitorizacao.injet.bi;

public class FiltroBIParetoPerdasParadaDTO {
	private int ordenacaoPareto;
	private Boolean isComPeso;
	private String cdAreaResp;
	private String cdParada;
	
	public int getOrdenacaoPareto() {
		return ordenacaoPareto;
	}
	public void setOrdenacaoPareto(int ordenacaoPareto) {
		this.ordenacaoPareto = ordenacaoPareto;
	}
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
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	
	
}
