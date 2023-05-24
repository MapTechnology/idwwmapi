package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="itemRecorrenciaRefugo")
public class ItemRecorrenciaRefugoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String dtHrRefugo;
	private String quantidadeRefugada;
	private String turno;
	private String posto;
	private String folha;
	private String produto;
	
	public String getDtHrRefugo() {
		return dtHrRefugo;
	}
	public void setDtHrRefugo(String dtHrRefugo) {
		this.dtHrRefugo = dtHrRefugo;
	}
	public String getQuantidadeRefugada() {
		return quantidadeRefugada;
	}
	public void setQuantidadeRefugada(String quantidadeRefugada) {
		this.quantidadeRefugada = quantidadeRefugada;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
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
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	
}
