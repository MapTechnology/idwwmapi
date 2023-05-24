package idw.model.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import idw.webservices.dto.ResultadoDTO;

@SuppressWarnings("serial")
public class IpBalanceamentoDTO implements Serializable {

	private ResultadoDTO resultado;
	private IpBalanceamento balanceamento;
	private List<PostoBalanceamentoDTO> postos;
	
	private boolean isFirmado;
	private boolean rebalancear;
	private BigDecimal taktTime;
	private BigDecimal tempoTotalMontagem;
	private long quantidadeTotalOperacoes;
	private BigDecimal numeroPostosTrabalho;
	private BigDecimal eficiencia;
	
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
	public List<PostoBalanceamentoDTO> getPostos() {
		return postos;
	}
	public void setPostos(List<PostoBalanceamentoDTO> postos) {
		this.postos = postos;
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

	
	
	
}
