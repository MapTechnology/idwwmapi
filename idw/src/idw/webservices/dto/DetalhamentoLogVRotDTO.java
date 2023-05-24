package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DetalhamentoLogVRotDTO {

	private List<DetalhamentoLogVRotDTO> listaResultadoPesquisa;	
	private String posto;
	private String ferramenta;
	private String codigoItem;
	private String descricaoItem;
	private String codigoProduto;
	private String descricaoProduto;
	private BigDecimal quantidade;
	private String area;
	private Date dtReferencia;
	private String turno;
	
	public List<DetalhamentoLogVRotDTO> getListaResultadoPesquisa() {
		return listaResultadoPesquisa;
	}
	public void setListaResultadoPesquisa(
			List<DetalhamentoLogVRotDTO> listaResultadoPesquisa) {
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
	public String getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}
	public String getDescricaoItem() {
		return descricaoItem;
	}
	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
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
