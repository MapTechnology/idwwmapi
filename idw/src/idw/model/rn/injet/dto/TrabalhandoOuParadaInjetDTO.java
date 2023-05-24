package idw.model.rn.injet.dto;

import java.io.Serializable;

import idw.util.FormulasInjet;

@SuppressWarnings("serial")
public class TrabalhandoOuParadaInjetDTO implements Serializable{
	private Double oee;
	private String cdMaqEstendido;
	private String cdMolEstendido;
	private String cdParada;
	private String dsParada;
	private String dsArea;
	private String dthrIParada;
	private String duracao;
	private String stFuncionamento;
	private String dsGalpao;
	
	public String getDsGalpao() {
		return dsGalpao;
	}
	public void setDsGalpao(String dsGalpao) {
		this.dsGalpao = dsGalpao;
	}
	public String getOeeString() {
		try {
			return FormulasInjet.formatarCasaDecimalDoFloat(oee.floatValue()).toString();
		} catch (Exception e) {
			return "0";
		}
		
	}
	public Double getOee() {		
		return oee;
	}
	public void setOee(Double oee) {
		this.oee = oee;
	}
	public String getCdMaqEstendido() {
		return cdMaqEstendido;
	}
	public void setCdMaqEstendido(String cdMaqEstendido) {
		this.cdMaqEstendido = cdMaqEstendido;
	}
	public String getCdMolEstendido() {
		return cdMolEstendido;
	}
	public void setCdMolEstendido(String cdMolEstendido) {
		this.cdMolEstendido = cdMolEstendido;
	}
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	public String getDsParada() {
		return dsParada;
	}
	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
	}
	public String getDsArea() {
		return dsArea;
	}
	public void setDsArea(String dsArea) {
		this.dsArea = dsArea;
	}
	public String getDthrIParada() {
		return dthrIParada;
	}
	public void setDthrIParada(String dthrIParada) {
		this.dthrIParada = dthrIParada;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getStFuncionamento() {
		return stFuncionamento;
	}
	public void setStFuncionamento(String stFuncionamento) {
		this.stFuncionamento = stFuncionamento;
	}
}
