package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DetalhamentoDefeitoDTO {

	private List<DetalhamentoDefeitoDTO> listaResultadoPesquisa;	
	private String posto;
	private String ferramenta;
	private String codigoDefeito;
	private String descricaoDefeito;
	private String codigoProduto;
	private String descricaoProduto;
	private BigDecimal quantidade;
	private String area;
	private Date dtReferencia;
	private String turno;
	
	public List<DetalhamentoDefeitoDTO> getListaResultadoPesquisa() {
		return listaResultadoPesquisa;
	}
	public void setListaResultadoPesquisa(
			List<DetalhamentoDefeitoDTO> listaResultadoPesquisa) {
		this.listaResultadoPesquisa = listaResultadoPesquisa;
	}
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
	public String getCodigoDefeito() {
		return codigoDefeito;
	}
	public void setCodigoDefeito(String codigoDefeito) {
		this.codigoDefeito = codigoDefeito;
	}
	public String getDescricaoDefeito() {
		return descricaoDefeito;
	}
	public void setDescricaoDefeito(String descricaoDefeito) {
		this.descricaoDefeito = descricaoDefeito;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}	
}
