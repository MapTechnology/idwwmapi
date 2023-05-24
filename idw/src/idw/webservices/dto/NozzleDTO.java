package idw.webservices.dto;

public class NozzleDTO {

	private String modulo;
	private String cabeca;
	private String posicao;
	private int quantidadUsada;
	private String origem;
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getCabeca() {
		return cabeca;
	}
	public void setCabeca(String cabeca) {
		this.cabeca = cabeca;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public int getQuantidadUsada() {
		return quantidadUsada;
	}
	public void setQuantidadUsada(int quantidadUsada) {
		this.quantidadUsada = quantidadUsada;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
}
