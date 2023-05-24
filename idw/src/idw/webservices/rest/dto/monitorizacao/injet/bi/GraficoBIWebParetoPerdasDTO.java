package idw.webservices.rest.dto.monitorizacao.injet.bi;

import java.math.BigDecimal;

public class GraficoBIWebParetoPerdasDTO {
    private String cdItemPareto;
    private String dsItemPareto;
    private String qtdItem;
    private String indItem;
    private String corIndItem;    
    private String segTempoFormatado;    
    private Boolean isParadaSemPeso = false;
    private BigDecimal qtd = BigDecimal.ZERO;
    
	public String getCdItemPareto() {
		return cdItemPareto;
	}
	public void setCdItemPareto(String cdItemPareto) {
		this.cdItemPareto = cdItemPareto;
	}
	public String getDsItemPareto() {
		return dsItemPareto;
	}
	public void setDsItemPareto(String dsItemPareto) {
		this.dsItemPareto = dsItemPareto;
	}
	public String getQtdItem() {
		return qtdItem;
	}
	public void setQtdItem(String qtdItem) {
		this.qtdItem = qtdItem;
	}
	public String getIndItem() {
		return indItem;
	}
	public void setIndItem(String indItem) {
		this.indItem = indItem;
	}
	public String getCorIndItem() {
		return corIndItem;
	}
	public void setCorIndItem(String corIndItem) {
		this.corIndItem = corIndItem;
	}
	public String getSegTempoFormatado() {
		return segTempoFormatado;
	}
	public void setSegTempoFormatado(String segTempoFormatado) {
		this.segTempoFormatado = segTempoFormatado;
	}
	public Boolean getIsParadaSemPeso() {
		return isParadaSemPeso;
	}
	public void setIsParadaSemPeso(Boolean isParadaSemPeso) {
		this.isParadaSemPeso = isParadaSemPeso;
	}
	public BigDecimal getQtd() {
		return qtd;
	}
	public void setQtd(BigDecimal qtd) {
		this.qtd = qtd;
	}
    
    
}