package ms.model.dto;

import idw.webservices.dto.DadosProdutoSADTO;

import java.util.List;

public class OPAutomaticaDTO {
	
	private String nrDoc;
	private long qtdPlanejada;
	private String cdProduto;
	private String cdFolha;
	private long idFolha;
	private long cicloPadrao;
	private long cicloTimeout;
	private long cicloMinimo;
	private long timeoutCIP;
	private long qtdPcsPorCiclo;
	private List<DadosProdutoSADTO> listaProdutos;
	
	public String getNrDoc() {
		return nrDoc;
	}
	public void setNrDoc(String nrDoc) {
		this.nrDoc = nrDoc;
	}
	public long getQtdPlanejada() {
		return qtdPlanejada;
	}
	public void setQtdPlanejada(long qtdPlanejada) {
		this.qtdPlanejada = qtdPlanejada;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public long getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(long cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public long getQtdPcsPorCiclo() {
		return qtdPcsPorCiclo;
	}
	public void setQtdPcsPorCiclo(long qtdPcsPorCiclo) {
		this.qtdPcsPorCiclo = qtdPcsPorCiclo;
	}
	public long getCicloTimeout() {
		return cicloTimeout;
	}
	public void setCicloTimeout(long cicloTimeout) {
		this.cicloTimeout = cicloTimeout;
	}
	public List<DadosProdutoSADTO> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<DadosProdutoSADTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public long getCicloMinimo() {
		return cicloMinimo;
	}
	public void setCicloMinimo(long cicloMinimo) {
		this.cicloMinimo = cicloMinimo;
	}
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	public long getTimeoutCIP() {
		return timeoutCIP;
	}
	public void setTimeoutCIP(long timeoutCIP) {
		this.timeoutCIP = timeoutCIP;
	}
	public long getIdFolha() {
		return idFolha;
	}
	public void setIdFolha(long idFolha) {
		this.idFolha = idFolha;
	}
}
