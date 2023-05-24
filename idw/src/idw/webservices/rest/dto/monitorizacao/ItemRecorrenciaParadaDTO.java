package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="itemRecorrenciaParada")
public class ItemRecorrenciaParadaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String dtHrInicio;
	private String dtHrFim;
	private String duracao;
	private String turno;
	private String posto;
	private String folha;
	private String produto;
	
	public String getDtHrInicio() {
		return dtHrInicio;
	}
	public void setDtHrInicio(String dtHrInicio) {
		this.dtHrInicio = dtHrInicio;
	}
	public String getDtHrFim() {
		return dtHrFim;
	}
	public void setDtHrFim(String dtHrFim) {
		this.dtHrFim = dtHrFim;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
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
