package idw.webservices.dto;

import java.math.BigDecimal;

import idw.model.pojos.OmPapro;

public class MonitorizacaoAlimDTO {

	private OmPapro ompapro;
	
	
	private String cdPt;
	private String cdPa;
	private String cdProduto;
	private String cdProdutoLido;
	private String idEmbalagem;
	private String cdMapa;
	private Long idMapa;
	private Integer revisao;
	
	private Integer ordem;
	
	
	private BigDecimal qtAlimentada;
	private BigDecimal qtUsada;
	private BigDecimal qtPorPlaca;
	
	private BigDecimal qtAtual;
	
	
	private double cicloPadrao;
	private long previsaoTermino;
	private long qtProdutoRestante;
	private long qtCicloRestante;
	
	private int tipoAlimentacao; // 0 - alimentacao 1-realimentacao
	private boolean isSucesso; // true registro feito com sucesso
	private String dthrLeitura; // data e hora da leitura
	
	private String alimentador;
	
	public long getQtCicloRestante() {
		return qtCicloRestante;
	}

	public void setQtCicloRestante(long qtCicloRestante) {
		this.qtCicloRestante = qtCicloRestante;
	}

	public long getQtProdutoRestante() {
		return qtProdutoRestante;
	}

	public void setQtProdutoRestante(long qtdProdutoRestante) {
		this.qtProdutoRestante = qtdProdutoRestante;
	}

	public long getPrevisaoTermino() {
		return previsaoTermino;
	}

	public void setPrevisaoTermino(long previsaoTermino) {
		this.previsaoTermino = previsaoTermino;
	}

	public double getCicloPadrao() {
		return cicloPadrao;
	}

	public void setCicloPadrao(double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}

	public OmPapro getOmpapro() {		
		return ompapro;
	}

	public void setOmpapro(OmPapro ompapro) {
		this.ompapro = ompapro;
	}

	public String getCdPt() {
		return cdPt;
	}

	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}

	public String getCdPa() {
		return cdPa;
	}

	public void setCdPa(String cdPa) {
		this.cdPa = cdPa;
	}

	public String getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getCdMapa() {
		return cdMapa;
	}

	public void setCdMapa(String cdMapa) {
		this.cdMapa = cdMapa;
	}

	public BigDecimal getQtAtual() {
		return qtAtual;
	}

	public void setQtAtual(BigDecimal qtAtual) {
		this.qtAtual = qtAtual;
	}

	public BigDecimal getQtAlimentada() {
		return qtAlimentada;
	}

	public void setQtAlimentada(BigDecimal qtAlimentada) {
		this.qtAlimentada = qtAlimentada;
	}

	public BigDecimal getQtUsada() {
		return qtUsada;
	}

	public void setQtUsada(BigDecimal qtUsada) {
		this.qtUsada = qtUsada;
	}

	public BigDecimal getQtPorPlaca() {
		return qtPorPlaca;
	}

	public void setQtPorPlaca(BigDecimal qtPorPlaca) {
		this.qtPorPlaca = qtPorPlaca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdMapa == null) ? 0 : cdMapa.hashCode());
		result = prime * result + ((cdPa == null) ? 0 : cdPa.hashCode());
		result = prime * result + ((cdProduto == null) ? 0 : cdProduto.hashCode());
		result = prime * result + ((cdPt == null) ? 0 : cdPt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonitorizacaoAlimDTO other = (MonitorizacaoAlimDTO) obj;
		if (cdMapa == null) {
			if (other.cdMapa != null)
				return false;
		} else if (!cdMapa.equals(other.cdMapa))
			return false;
		if (cdPa == null) {
			if (other.cdPa != null)
				return false;
		} else if (!cdPa.equals(other.cdPa))
			return false;
		if (cdProduto == null) {
			if (other.cdProduto != null)
				return false;
		} else if (!cdProduto.equals(other.cdProduto))
			return false;
		if (cdPt == null) {
			if (other.cdPt != null)
				return false;
		} else if (!cdPt.equals(other.cdPt))
			return false;
		return true;
	}

	public int getTipoAlimentacao() {
		return tipoAlimentacao;
	}

	public void setTipoAlimentacao(int tipoAlimentacao) {
		this.tipoAlimentacao = tipoAlimentacao;
	}

	public boolean isSucesso() {
		return isSucesso;
	}

	public void setSucesso(boolean isSucesso) {
		this.isSucesso = isSucesso;
	}

	public String getDthrLeitura() {
		return dthrLeitura;
	}

	public void setDthrLeitura(String dthrLeitura) {
		this.dthrLeitura = dthrLeitura;
	}

	public String getAlimentador() {
		return alimentador;
	}

	public void setAlimentador(String alimentador) {
		this.alimentador = alimentador;
	}

	public String getCdProdutoLido() {
		return cdProdutoLido;
	}

	public void setCdProdutoLido(String cdProdutoLido) {
		this.cdProdutoLido = cdProdutoLido;
	}

	public String getIdEmbalagem() {
		return idEmbalagem;
	}

	public void setIdEmbalagem(String idEmbalagem) {
		this.idEmbalagem = idEmbalagem;
	}

	public Long getIdMapa() {
		return idMapa;
	}

	public void setIdMapa(Long idMapa) {
		this.idMapa = idMapa;
	}

	public Integer getRevisao() {
		return revisao;
	}

	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	
	
	
}
