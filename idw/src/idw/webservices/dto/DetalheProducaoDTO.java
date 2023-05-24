package idw.webservices.dto;

import java.util.Date;

public class DetalheProducaoDTO {
	
	private String maquina;
	private String dsPt;
	private String ferramenta;
	private String ferramenta_agrupada;
	private String produto;
	private double prod_prevista;
	private double prod_realizada;
	private double prod_refugadas;
	private double prod_boas;
	private double eficiencia_realizacao;
	private double eficiencia_ciclo;
	private double perdas_ciclo;
	private double cicloPadrao;
	private double producaoPorCiclo;
	private long idFolha;
	private Date dtRevisao;
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getFerramenta_agrupada() {
		return ferramenta_agrupada;
	}
	public void setFerramenta_agrupada(String ferramenta_agrupada) {
		this.ferramenta_agrupada = ferramenta_agrupada;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getProd_prevista() {
		return prod_prevista;
	}
	public void setProd_prevista(double prod_prevista) {
		this.prod_prevista = prod_prevista;
	}
	public double getProd_realizada() {
		return prod_realizada;
	}
	public void setProd_realizada(double prod_realizada) {
		this.prod_realizada = prod_realizada;
	}
	public double getProd_refugadas() {
		return prod_refugadas;
	}
	public void setProd_refugadas(double prod_refugadas) {
		this.prod_refugadas = prod_refugadas;
	}
	public double getProd_boas() {
		return prod_boas;
	}
	public void setProd_boas(double prod_boas) {
		this.prod_boas = prod_boas;
	}
	public double getEficiencia_realizacao() {
		return eficiencia_realizacao;
	}
	public void setEficiencia_realizacao(double eficiencia_realizacao) {
		this.eficiencia_realizacao = eficiencia_realizacao;
	}
	public double getEficiencia_ciclo() {
		return eficiencia_ciclo;
	}
	public void setEficiencia_ciclo(double eficiencia_ciclo) {
		this.eficiencia_ciclo = eficiencia_ciclo;
	}
	public double getPerdas_ciclo() {
		return perdas_ciclo;
	}
	public void setPerdas_ciclo(double perdas_ciclo) {
		this.perdas_ciclo = perdas_ciclo;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public double getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public double getProducaoPorCiclo() {
		return producaoPorCiclo;
	}
	public void setProducaoPorCiclo(double producaoPorCiclo) {
		this.producaoPorCiclo = producaoPorCiclo;
	}
	public long getIdFolha() {
		return idFolha;
	}
	public void setIdFolha(long idFolha) {
		this.idFolha = idFolha;
	}
	public Date getDtRevisao() {
		return dtRevisao;
	}
	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}
	
	
}
