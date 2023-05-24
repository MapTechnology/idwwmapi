package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tabelaPerdaGanhoCiclo")
public class TabelaPerdaGanhoCicloDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String posto;
	private String folha;
	private String cicloPadrao;
	private String cicloLido;
	private String produto;
	private String ciclosProdutivos;
	private String perdaGanho;
	private String perdaGanhoKg;
	private String perdaGanhoTon;
	private String custo;
	
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getFolha() {
		return folha;
	}
	public void setFolha(String folha) {
		this.folha = folha;
	}
	public String getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(String cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public String getCicloLido() {
		return cicloLido;
	}
	public void setCicloLido(String cicloLido) {
		this.cicloLido = cicloLido;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getCiclosProdutivos() {
		return ciclosProdutivos;
	}
	public void setCiclosProdutivos(String ciclosProdutivos) {
		this.ciclosProdutivos = ciclosProdutivos;
	}
	public String getPerdaGanho() {
		return perdaGanho;
	}
	public void setPerdaGanho(String perdaGanho) {
		this.perdaGanho = perdaGanho;
	}
	public String getPerdaGanhoKg() {
		return perdaGanhoKg;
	}
	public void setPerdaGanhoKg(String perdaGanhoKg) {
		this.perdaGanhoKg = perdaGanhoKg;
	}
	public String getPerdaGanhoTon() {
		return perdaGanhoTon;
	}
	public void setPerdaGanhoTon(String perdaGanhoTon) {
		this.perdaGanhoTon = perdaGanhoTon;
	}
	public String getCusto() {
		return custo;
	}
	public void setCusto(String custo) {
		this.custo = custo;
	}
	
}
