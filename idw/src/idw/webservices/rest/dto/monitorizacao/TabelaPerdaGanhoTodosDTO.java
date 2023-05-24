package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tabelaPerdaGanhoTodos")
public class TabelaPerdaGanhoTodosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String produto;
	private String perdaGanho;
	private String perdaGanhoKg;
	private String perdaGanhoTon;
	private String custo;
	private String previstas;
	private String previstasKg;
	private String previstasTon;
	private String boas;
	private String boasKg;
	private String boasTon;
	private String eficienciaRealizacao;
	
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
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
	public String getPrevistas() {
		return previstas;
	}
	public void setPrevistas(String previstas) {
		this.previstas = previstas;
	}
	public String getPrevistasKg() {
		return previstasKg;
	}
	public void setPrevistasKg(String previstasKg) {
		this.previstasKg = previstasKg;
	}
	public String getPrevistasTon() {
		return previstasTon;
	}
	public void setPrevistasTon(String previstasTon) {
		this.previstasTon = previstasTon;
	}
	public String getBoas() {
		return boas;
	}
	public void setBoas(String boas) {
		this.boas = boas;
	}
	public String getBoasKg() {
		return boasKg;
	}
	public void setBoasKg(String boasKg) {
		this.boasKg = boasKg;
	}
	public String getBoasTon() {
		return boasTon;
	}
	public void setBoasTon(String boasTon) {
		this.boasTon = boasTon;
	}
	public String getEficienciaRealizacao() {
		return eficienciaRealizacao;
	}
	public void setEficienciaRealizacao(String eficienciaRealizacao) {
		this.eficienciaRealizacao = eficienciaRealizacao;
	}
	
	
	
}
