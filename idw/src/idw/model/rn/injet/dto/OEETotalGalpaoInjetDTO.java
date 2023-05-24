package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import idw.util.FormulasInjet;

@SuppressWarnings("serial")
public class OEETotalGalpaoInjetDTO implements Serializable{
	private Integer quantidadeMaquinas;
	private BigDecimal metaOEEMin;
	private BigDecimal metaOEEMax;
	private String cdGalpao;
	private String dsGalpao;
	private BigDecimal coordX;
	private BigDecimal coordY;
	private Double oee;
	
	public Integer getQuantidadeMaquinas() {
		return quantidadeMaquinas;
	}
	public void setQuantidadeMaquinas(Integer quantidadeMaquinas) {
		this.quantidadeMaquinas = quantidadeMaquinas;
	}
	public BigDecimal getMetaOEEMin() {
		return metaOEEMin;
	}
	public void setMetaOEEMin(BigDecimal metaOEEMin) {
		this.metaOEEMin = metaOEEMin;
	}
	public BigDecimal getMetaOEEMax() {
		return metaOEEMax;
	}
	public String getMetaOEEMaxString() {
		try {
			return FormulasInjet.formatarCasaDecimalDoFloat(metaOEEMax.floatValue()).toString();
		} catch (Exception e) {
			return "0";
		}
	}
	public void setMetaOEEMax(BigDecimal metaOEEMax) {
		this.metaOEEMax = metaOEEMax;
	}
	public String getDsGalpao() {
		return dsGalpao;
	}
	public void setDsGalpao(String dsGalpao) {
		this.dsGalpao = dsGalpao;
	}
	public BigDecimal getCoordX() {
		return coordX;
	}
	public void setCoordX(BigDecimal coordX) {
		this.coordX = coordX;
	}
	public BigDecimal getCoordY() {
		return coordY;
	}
	public void setCoordY(BigDecimal coordY) {
		this.coordY = coordY;
	}
	public Double getOee() {
		return oee;
	}
	public void setOee(Double oee) {
		this.oee = oee;
	}
	public String getCdGalpao() {
		return cdGalpao;
	}
	public void setCdGalpao(String cdGalpao) {
		this.cdGalpao = cdGalpao;
	}
		
	public String getOeeString() {
		try {
			return FormulasInjet.formatarCasaDecimalDoFloat(oee.floatValue()).toString();
		} catch (Exception e) {
			return "0";
		}
		
	}
}
