package idw.webservices.rest.dto.monitorizacao.injet.manutencao;

import java.util.List;

public class MaquinaxFerramentasxProdutosDTO {
	private String cdMaquina;
	private List<FerramentaxProdutosDTO> ferramentaxProdutos;
	
	public String getCdMaquina() {
		return cdMaquina;
	}
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
	public List<FerramentaxProdutosDTO> getFerramentaxProdutos() {
		return ferramentaxProdutos;
	}
	public void setFerramentaxProdutos(List<FerramentaxProdutosDTO> ferramentaxProdutos) {
		this.ferramentaxProdutos = ferramentaxProdutos;
	}
	
	
}
