package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tabelaRefugoHora")
public class TabelaRefugoHora implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String posto;
	private String ferramenta;
	private String produto;
	private String refugo;
	private String quantidade;
	private String dtHrOcorrencia;
	private String causa;
	private String acao;
	private FiltroDetalheRefugoDTO filtro;
	
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getRefugo() {
		return refugo;
	}
	public void setRefugo(String refugo) {
		this.refugo = refugo;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getDtHrOcorrencia() {
		return dtHrOcorrencia;
	}
	public void setDtHrOcorrencia(String dtHrOcorrencia) {
		this.dtHrOcorrencia = dtHrOcorrencia;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public FiltroDetalheRefugoDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroDetalheRefugoDTO filtro) {
		this.filtro = filtro;
	}
	
	
}
