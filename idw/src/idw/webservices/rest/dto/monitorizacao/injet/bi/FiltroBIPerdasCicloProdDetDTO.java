package idw.webservices.rest.dto.monitorizacao.injet.bi;

public class FiltroBIPerdasCicloProdDetDTO {
	private int ordenacaoPareto;
	private String cdPtSelecaoPareto;
	private String cdProdutoSelecaoPareto;
	public int getOrdenacaoPareto() {
		return ordenacaoPareto;
	}
	public void setOrdenacaoPareto(int ordenacaoPareto) {
		this.ordenacaoPareto = ordenacaoPareto;
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
