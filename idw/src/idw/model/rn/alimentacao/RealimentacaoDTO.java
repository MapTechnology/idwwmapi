package idw.model.rn.alimentacao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import idw.webservices.dto.SucessoDTO;

public class RealimentacaoDTO extends SucessoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cdPt;
	private String cdMapa;
	private String cdPa;
	private String cdProduto;
	private Integer ordem;
	
	private List<String> cdProdutoAlternativo;

	// Abaixo campos realizados
	private String cdProdutoLido;
	private String reelId;
	private Double qtAlimentada;
	
	private int qtRealimentacoesExecutadas;
	private Boolean isSucesso;
	
	private Date dthrLeitura;
	
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdMapa() {
		return cdMapa;
	}
	public void setCdMapa(String cdMapa) {
		this.cdMapa = cdMapa;
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
	public List<String> getCdProdutoAlternativo() {
		return cdProdutoAlternativo;
	}
	public void setCdProdutoAlternativo(List<String> cdProdutoAlternativo) {
		this.cdProdutoAlternativo = cdProdutoAlternativo;
	}
	public String getCdProdutoLido() {
		return cdProdutoLido;
	}
	public void setCdProdutoLido(String cdProdutoLido) {
		this.cdProdutoLido = cdProdutoLido;
	}
	public String getReelId() {
		return reelId;
	}
	public void setReelId(String reelId) {
		this.reelId = reelId;
	}
	public Double getQtAlimentada() {
		return qtAlimentada;
	}
	public void setQtAlimentada(Double qtAlimentada) {
		this.qtAlimentada = qtAlimentada;
	}
	public int getQtRealimentacoesExecutadas() {
		return qtRealimentacoesExecutadas;
	}
	public void setQtRealimentacoesExecutadas(int qtRealimentacoesExecutadas) {
		this.qtRealimentacoesExecutadas = qtRealimentacoesExecutadas;
	}
	public Boolean getIsSucesso() {
		return isSucesso;
	}
	public void setIsSucesso(Boolean isSucesso) {
		this.isSucesso = isSucesso;
	}
	public Date getDthrLeitura() {
		return dthrLeitura;
	}
	public void setDthrLeitura(Date dthrLeitura) {
		this.dthrLeitura = dthrLeitura;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	
}
