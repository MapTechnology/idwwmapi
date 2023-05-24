package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import idw.model.pojos.IpBalanceamento;

@SuppressWarnings("serial")
public class IpBalanceamentoDTO implements Serializable {

	private ResultadoDTO resultado;
	private IpBalanceamento balanceamento;
	private List<FaseDTO> fases;
	
	private boolean isFirmado;
	private boolean rebalancear;
	private BigDecimal taktTime;
	private String corTaktTime;
	private BigDecimal tempoTotalMontagem;
	private long quantidadeTotalOperacoes;
	private BigDecimal numeroPostosTrabalho;
	private BigDecimal eficiencia;
	
	private List<RelatorioGraficoLinhaBalanceadaPostoDTO> listaRelatorioPosto;
	private List<RelatorioGraficoLinhaBalanceadaOperacaoDTO> listaRelatorioOperacao;
	
	private List<RelatorioGraficoTempoProdutoDTO> listaRelatorioGraficoTempoProduto;
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public IpBalanceamento getBalanceamento() {
		return balanceamento;
	}
	public void setBalanceamento(IpBalanceamento balanceamento) {
		this.balanceamento = balanceamento;
	}
	public List<FaseDTO> getFases() {
		return fases;
	}
	public void setFases(List<FaseDTO> fases) {
		this.fases = fases;
	}
	public boolean isFirmado() {
		return isFirmado;
	}
	public void setFirmado(boolean isFirmado) {
		this.isFirmado = isFirmado;
	}
	public boolean isRebalancear() {
		return rebalancear;
	}
	public void setRebalancear(boolean rebalancear) {
		this.rebalancear = rebalancear;
	}
	public BigDecimal getTaktTime() {
		return taktTime;
	}
	public void setTaktTime(BigDecimal taktTime) {
		this.taktTime = taktTime;
	}
	public String getCorTaktTime() {
		return corTaktTime;
	}
	public void setCorTaktTime(String corTaktTime) {
		this.corTaktTime = corTaktTime;
	}
	public BigDecimal getTempoTotalMontagem() {
		return tempoTotalMontagem;
	}
	public void setTempoTotalMontagem(BigDecimal tempoTotalMontagem) {
		this.tempoTotalMontagem = tempoTotalMontagem;
	}
	public long getQuantidadeTotalOperacoes() {
		return quantidadeTotalOperacoes;
	}
	public void setQuantidadeTotalOperacoes(long quantidadeTotalOperacoes) {
		this.quantidadeTotalOperacoes = quantidadeTotalOperacoes;
	}
	public BigDecimal getNumeroPostosTrabalho() {
		return numeroPostosTrabalho;
	}
	public void setNumeroPostosTrabalho(BigDecimal numeroPostosTrabalho) {
		this.numeroPostosTrabalho = numeroPostosTrabalho;
	}
	public BigDecimal getEficiencia() {
		return eficiencia;
	}
	public void setEficiencia(BigDecimal eficiencia) {
		this.eficiencia = eficiencia;
	}
	public List<RelatorioGraficoLinhaBalanceadaPostoDTO> getListaRelatorioPosto() {
		return listaRelatorioPosto;
	}
	public void setListaRelatorioPosto(
			List<RelatorioGraficoLinhaBalanceadaPostoDTO> listaRelatorioPosto) {
		this.listaRelatorioPosto = listaRelatorioPosto;
	}
	public List<RelatorioGraficoLinhaBalanceadaOperacaoDTO> getListaRelatorioOperacao() {
		return listaRelatorioOperacao;
	}
	public void setListaRelatorioOperacao(
			List<RelatorioGraficoLinhaBalanceadaOperacaoDTO> listaRelatorioOperacao) {
		this.listaRelatorioOperacao = listaRelatorioOperacao;
	}
	public List<RelatorioGraficoTempoProdutoDTO> getListaRelatorioGraficoTempoProduto() {
		return listaRelatorioGraficoTempoProduto;
	}
	public void setListaRelatorioGraficoTempoProduto(
			List<RelatorioGraficoTempoProdutoDTO> listaRelatorioGraficoTempoProduto) {
		this.listaRelatorioGraficoTempoProduto = listaRelatorioGraficoTempoProduto;
	}

	
	
	
}
