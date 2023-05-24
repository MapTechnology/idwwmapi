package idw.webservices.dto;

import java.util.List;

public class RelatorioAnaliseCicloDTO {
	
	private String produto;
	private String folha;
	private String maquina;
	private String inicioCic;
	private String fimCic;
	private String duracao;
	private List<RelatorioAnaliseCicloDTO> itens;
	
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getFolha() {
		return folha;
	}
	public void setFolha(String folha) {
		this.folha = folha;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getInicioCic() {
		return inicioCic;
	}
	public void setInicioCic(String inicioCic) {
		this.inicioCic = inicioCic;
	}
	public String getFimCic() {
		return fimCic;
	}
	public void setFimCic(String fimCic) {
		this.fimCic = fimCic;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public List<RelatorioAnaliseCicloDTO> getItens() {
		return itens;
	}
	public void setItens(List<RelatorioAnaliseCicloDTO> itens) {
		this.itens = itens;
	}	
	
}