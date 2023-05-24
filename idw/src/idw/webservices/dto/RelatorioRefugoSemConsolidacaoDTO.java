package idw.webservices.dto;

public class RelatorioRefugoSemConsolidacaoDTO {
	private String maquina;
	private String produto;
	private String Refugo;
	private Double qtdRefugada;
	
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getRefugo() {
		return Refugo;
	}
	public void setRefugo(String refugo) {
		Refugo = refugo;
	}
	public Double getQtdRefugada() {
		return qtdRefugada;
	}
	public void setQtdRefugada(Double qtdRefugada) {
		this.qtdRefugada = qtdRefugada;
	}

}
