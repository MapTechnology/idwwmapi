package idw.webservices.dto;

public class FeederDTO {

	private String modulo;
	private String slot;
	private String componente;
	private Boolean isErro;
	private int quantidadeUsada;
	private int quantidadeErro;
	private String origem;
	
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	public Boolean getIsErro() {
		return isErro;
	}
	public void setIsErro(Boolean isErro) {
		this.isErro = isErro;
	}
	public int getQuantidadeUsada() {
		return quantidadeUsada;
	}
	public void setQuantidadeUsada(int quantidadeUsada) {
		this.quantidadeUsada = quantidadeUsada;
	}
	public int getQuantidadeErro() {
		return quantidadeErro;
	}
	public void setQuantidadeErro(int quantidadeErro) {
		this.quantidadeErro = quantidadeErro;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
}
