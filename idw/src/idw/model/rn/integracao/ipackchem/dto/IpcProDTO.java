package idw.model.rn.integracao.ipackchem.dto;

public class IpcProDTO 
{
	private String cdProduto;
	private String dsProduto;
	private Double pesoBruto;
	private Double pesoLiquido;
	private Double vlrProduto;
	private String operacao;
	
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
	public Double getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public Double getPesoLiquido() {
		return pesoLiquido;
	}
	public void setPesoLiquido(Double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	public Double getVlrProduto() {
		return vlrProduto;
	}
	public void setVlrProduto(Double vlrProduto) {
		this.vlrProduto = vlrProduto;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
}
