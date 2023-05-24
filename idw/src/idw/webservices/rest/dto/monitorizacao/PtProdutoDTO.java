package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptProduto")
public class PtProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String dtReferencia;
	private String folha;
	private String turno;
	private String posto;
	private String cp;
	private String dtInicioProducao;
	private String produto;
	private String tempoDisponivel;
	private String producaoPrevista;
	private String producaoBruta;
	private String producaoLiquida;
	private String saldoAProduzir;
	private String producaoRefugada;
	private String eficienciaRealizacao;
	private String cicloPadrao;
	private String cicloMedio;
	private String ultimoCiclo;
	private String dtRevisaoFolha;
	private String producaoOuCiclo;
	private String calendario;
	private String periodoProdutivo;
	
	public String getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(String dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public String getFolha() {
		return folha;
	}
	public void setFolha(String folha) {
		this.folha = folha;
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
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getDtInicioProducao() {
		return dtInicioProducao;
	}
	public void setDtInicioProducao(String dtInicioProducao) {
		this.dtInicioProducao = dtInicioProducao;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getTempoDisponivel() {
		return tempoDisponivel;
	}
	public void setTempoDisponivel(String tempoDisponivel) {
		this.tempoDisponivel = tempoDisponivel;
	}
	public String getProducaoPrevista() {
		return producaoPrevista;
	}
	public void setProducaoPrevista(String producaoPrevista) {
		this.producaoPrevista = producaoPrevista;
	}
	public String getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(String producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public String getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(String producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public String getSaldoAProduzir() {
		return saldoAProduzir;
	}
	public void setSaldoAProduzir(String saldoAProduzir) {
		this.saldoAProduzir = saldoAProduzir;
	}
	public String getProducaoRefugada() {
		return producaoRefugada;
	}
	public void setProducaoRefugada(String producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}
	public String getEficienciaRealizacao() {
		return eficienciaRealizacao;
	}
	public void setEficienciaRealizacao(String eficienciaRealizacao) {
		this.eficienciaRealizacao = eficienciaRealizacao;
	}
	public String getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(String cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public String getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(String cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public String getUltimoCiclo() {
		return ultimoCiclo;
	}
	public void setUltimoCiclo(String ultimoCiclo) {
		this.ultimoCiclo = ultimoCiclo;
	}
	public String getDtRevisaoFolha() {
		return dtRevisaoFolha;
	}
	public void setDtRevisaoFolha(String dtRevisaoFolha) {
		this.dtRevisaoFolha = dtRevisaoFolha;
	}
	public String getProducaoOuCiclo() {
		return producaoOuCiclo;
	}
	public void setProducaoOuCiclo(String producaoOuCiclo) {
		this.producaoOuCiclo = producaoOuCiclo;
	}
	public String getCalendario() {
		return calendario;
	}
	public void setCalendario(String calendario) {
		this.calendario = calendario;
	}
	public String getPeriodoProdutivo() {
		return periodoProdutivo;
	}
	public void setPeriodoProdutivo(String periodoProdutivo) {
		this.periodoProdutivo = periodoProdutivo;
	}
	
	
}
