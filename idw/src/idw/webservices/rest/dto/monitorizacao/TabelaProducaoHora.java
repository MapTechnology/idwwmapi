package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tabelaProducaoHora")
public class TabelaProducaoHora implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String posto;
	private String ferramenta;
	private String produto;
	private String producaoPrevista;
	private String producaoRealizada;
	private String refugadas;
	private String boas;
	private String eficienciaRealizacao;
	private String eficienciaCiclo;
	private String perdasCiclo;
	private String cicloPadrao;
	private String dtRevisao;
	private String idFolha;
	private String producaoCiclo;
	
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getProducaoPrevista() {
		return producaoPrevista;
	}
	public void setProducaoPrevista(String producaoPrevista) {
		this.producaoPrevista = producaoPrevista;
	}
	public String getProducaoRealizada() {
		return producaoRealizada;
	}
	public void setProducaoRealizada(String producaoRealizada) {
		this.producaoRealizada = producaoRealizada;
	}
	public String getRefugadas() {
		return refugadas;
	}
	public void setRefugadas(String refugadas) {
		this.refugadas = refugadas;
	}
	public String getBoas() {
		return boas;
	}
	public void setBoas(String boas) {
		this.boas = boas;
	}
	public String getEficienciaRealizacao() {
		return eficienciaRealizacao;
	}
	public void setEficienciaRealizacao(String eficienciaRealizacao) {
		this.eficienciaRealizacao = eficienciaRealizacao;
	}
	public String getEficienciaCiclo() {
		return eficienciaCiclo;
	}
	public void setEficienciaCiclo(String eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
	public String getPerdasCiclo() {
		return perdasCiclo;
	}
	public void setPerdasCiclo(String perdasCiclo) {
		this.perdasCiclo = perdasCiclo;
	}
	public String getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(String cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public String getDtRevisao() {
		return dtRevisao;
	}
	public void setDtRevisao(String dtRevisao) {
		this.dtRevisao = dtRevisao;
	}
	public String getIdFolha() {
		return idFolha;
	}
	public void setIdFolha(String idFolha) {
		this.idFolha = idFolha;
	}
	public String getProducaoCiclo() {
		return producaoCiclo;
	}
	public void setProducaoCiclo(String producaoCiclo) {
		this.producaoCiclo = producaoCiclo;
	}
	
	
}
