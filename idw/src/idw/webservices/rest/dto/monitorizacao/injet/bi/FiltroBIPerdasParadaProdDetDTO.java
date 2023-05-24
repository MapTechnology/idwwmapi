package idw.webservices.rest.dto.monitorizacao.injet.bi;

public class FiltroBIPerdasParadaProdDetDTO {
	private int ordenacaoPareto;
	private Boolean isParComPeso;
	private String cdParada;
	private String cdPtSelecaoPareto;
	private String cdProdutoSelecaoPareto;
	public int getOrdenacaoPareto() {
		return ordenacaoPareto;
	}
	public void setOrdenacaoPareto(int ordenacaoPareto) {
		this.ordenacaoPareto = ordenacaoPareto;
	}
	public Boolean getIsParComPeso() {
		return isParComPeso;
	}
	public void setIsParComPeso(Boolean isParComPeso) {
		this.isParComPeso = isParComPeso;
	}
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	public String getCdPtSelecaoPareto() {
		return cdPtSelecaoPareto;
	}
	public void setCdPtSelecaoPareto(String cdPtSelecaoPareto) {
		this.cdPtSelecaoPareto = cdPtSelecaoPareto;
	}
	public String getCdProdutoSelecaoPareto() {
		return cdProdutoSelecaoPareto;
	}
	public void setCdProdutoSelecaoPareto(String cdProdutoSelecaoPareto) {
		this.cdProdutoSelecaoPareto = cdProdutoSelecaoPareto;
	}
	
	
}
