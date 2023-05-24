package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="perdasProduto")
public class PerdasProdutoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long idProduto;
	private String cdProduto;
	private String corOcorrencia;
	private String quantidadePerdida;
	private String quantidadeUtilizada;
	private String porcentagemPerda;	
	private String quantidadePrevistaOP;
	private String porcentagemPerdaOP;	
	private String quantidadeAlimentada;
	private String porcentagemPerdaAlimentacao;
	
	private FiltroMpDTO filtro;

	public String getQuantidadePrevistaOP() {
		return quantidadePrevistaOP;
	}
	public void setQuantidadePrevistaOP(String quantidadePrevistaOP) {
		this.quantidadePrevistaOP = quantidadePrevistaOP;
	}
	public String getPorcentagemPerdaOP() {
		return porcentagemPerdaOP;
	}
	public void setPorcentagemPerdaOP(String porcentagemPerdaOP) {
		this.porcentagemPerdaOP = porcentagemPerdaOP;
	}
	public String getQuantidadeAlimentada() {
		return quantidadeAlimentada;
	}
	public void setQuantidadeAlimentada(String quantidadeAlimentada) {
		this.quantidadeAlimentada = quantidadeAlimentada;
	}
	public String getPorcentagemPerdaAlimentacao() {
		return porcentagemPerdaAlimentacao;
	}
	public void setPorcentagemPerdaAlimentacao(String porcentagemPerdaAlimentacao) {
		this.porcentagemPerdaAlimentacao = porcentagemPerdaAlimentacao;
	}
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getQuantidadePerdida() {
		return quantidadePerdida;
	}
	public void setQuantidadePerdida(String quantidadePerdida) {
		this.quantidadePerdida = quantidadePerdida;
	}
	public String getPorcentagemPerda() {
		return porcentagemPerda;
	}
	public void setPorcentagemPerda(String porcentagemPerda) {
		this.porcentagemPerda = porcentagemPerda;
	}
	public FiltroMpDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroMpDTO filtro) {
		this.filtro = filtro;
	}
	public String getCorOcorrencia() {
		return corOcorrencia;
	}
	public void setCorOcorrencia(String corOcorrencia) {
		this.corOcorrencia = corOcorrencia;
	}
	public String getQuantidadeUtilizada() {
		return quantidadeUtilizada;
	}
	public void setQuantidadeUtilizada(String quantidadeUtilizada) {
		this.quantidadeUtilizada = quantidadeUtilizada;
	}
	
	
}
