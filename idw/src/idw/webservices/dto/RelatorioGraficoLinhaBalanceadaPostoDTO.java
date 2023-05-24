package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class RelatorioGraficoLinhaBalanceadaPostoDTO implements Serializable {

	private String fase;
	private String corFase;
	private Object iconeFase;
	private String posto;
	private String tempoPosto;
	private BigDecimal segCicloPadrao;
	
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getCorFase() {
		return corFase;
	}
	public void setCorFase(String corFase) {
		this.corFase = corFase;
	}
	public Object getIconeFase() {
		return iconeFase;
	}
	public void setIconeFase(Object iconeFase) {
		this.iconeFase = iconeFase;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public String getTempoPosto() {
		return tempoPosto;
	}
	public void setTempoPosto(String tempoPosto) {
		this.tempoPosto = tempoPosto;
	}
	public BigDecimal getSegCicloPadrao() {
		return segCicloPadrao;
	}
	public void setSegCicloPadrao(BigDecimal segCicloPadrao) {
		this.segCicloPadrao = segCicloPadrao;
	}
}
