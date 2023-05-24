package idw.model.rn.injet.dto;


import java.io.Serializable;
import java.math.BigDecimal;

import idw.util.FormulasInjet;

@SuppressWarnings("serial")
public class DadosParaECPonderadaInjetDTO implements Serializable{

	private String cdMolde;
	private String cdEstrutra;
	private BigDecimal tmpCicNormal;
	private BigDecimal qtInjNormal;
	private BigDecimal cicloPadrao;
	private BigDecimal tempoAtivo;
	private Integer qtCicloPadrao;

	// o atributo abaixo sao usados apenas no momento do calculo da ECPonderada
	private String cdMaquina;

	public Float getEficienciaCiclo(){
		return FormulasInjet.calcularEficienciaCiclo(this.cicloPadrao, getCicloMedio());
	}
	public BigDecimal getCicloMedio(){
		return FormulasInjet.calcularCicloMedio(this.tmpCicNormal, this.qtInjNormal);
	}
	/**
	 * @return the cdMolde
	 */
	public String getCdMolde() {
		return cdMolde;
	}
	/**
	 * @param cdMolde the cdMolde to set
	 */
	public void setCdMolde(String cdMolde) {
		this.cdMolde = cdMolde;
	}
	/**
	 * @return the cdEstrutra
	 */
	public String getCdEstrutra() {
		return cdEstrutra;
	}
	/**
	 * @param cdEstrutra the cdEstrutra to set
	 */
	public void setCdEstrutra(String cdEstrutra) {
		this.cdEstrutra = cdEstrutra;
	}
	/**
	 * @return the tempoAtivo
	 */
	public BigDecimal getTempoAtivo() {
		return tempoAtivo;
	}
	/**
	 * @param tempoAtivo the tempoAtivo to set
	 */
	public void setTempoAtivo(BigDecimal tempoAtivo) {
		this.tempoAtivo = tempoAtivo;
	}
	public void addTempoAtivo(BigDecimal tempoAtivo) {
		this.tempoAtivo.add(tempoAtivo);
	}
	/**
	 * @return the tmpCicNormal
	 */
	public BigDecimal getTmpCicNormal() {
		return tmpCicNormal;
	}
	/**
	 * @param tmpCicNormal the tmpCicNormal to set
	 */
	public void setTmpCicNormal(BigDecimal tmpCicNormal) {
		this.tmpCicNormal = tmpCicNormal;
	}
	public void addTmpCicNormal(BigDecimal tmpCicNormal) {
		this.tmpCicNormal.add(tmpCicNormal);
	}
	/**
	 * @return the qtInjNormal
	 */
	public BigDecimal getQtInjNormal() {
		return qtInjNormal;
	}
	/**
	 * @param qtInjNormal the qtInjNormal to set
	 */
	public void setQtInjNormal(BigDecimal qtInjNormal) {
		this.qtInjNormal = qtInjNormal;
	}
	public void addQtInjNormal(BigDecimal qtInjNormal) {
		this.qtInjNormal.add(qtInjNormal);
	}
	/**
	 * @return the cicloPadrao
	 */
	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}
	/**
	 * @param cicloPadrao the cicloPadrao to set
	 */
	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public void addCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao.add(cicloPadrao);
	}
	/**
	 * @return the qtCicloPadrao
	 */
	public Integer getQtCicloPadrao() {
		return qtCicloPadrao;
	}
	/**
	 * @param qtCicloPadrao the qtCicloPadrao to set
	 */
	public void setQtCicloPadrao(Integer qtCicloPadrao) {
		this.qtCicloPadrao = qtCicloPadrao;
	}
	public void addQtCicloPadrao() {
		this.qtCicloPadrao += 1;
	}
	
	@Override
	public boolean equals(Object objeto){
		DadosParaECPonderadaInjetDTO comparacao = (DadosParaECPonderadaInjetDTO) objeto;
		
		return (this.getCdMolde().equals(comparacao.getCdMolde()) && 
				this.getCdEstrutra().equals(comparacao.getCdEstrutra()) &&
				this.getCdMaquina().equals(comparacao.getCdMaquina()));
	}
	/**
	 * @return the cdMaquina
	 */
	public String getCdMaquina() {
		return cdMaquina;
	}
	/**
	 * @param cdMaquina the cdMaquina to set
	 */
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
}
