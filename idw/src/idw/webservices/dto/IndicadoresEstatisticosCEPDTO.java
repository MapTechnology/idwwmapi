package idw.webservices.dto;

import java.math.BigDecimal;

public class IndicadoresEstatisticosCEPDTO 
{
	private Long idFtParam;
	private String dsFtParam;
	private BigDecimal lsc_X;
	private BigDecimal lc_X;
	private BigDecimal lic_X;
	private BigDecimal lsc_R;
	private BigDecimal lc_R;
	private BigDecimal lic_R;
	private Integer m;
	private Integer n;
	private BigDecimal desvioPadrao;
	private BigDecimal media;
	private BigDecimal cp;
	private BigDecimal cpk;
	private BigDecimal cpi;
	private BigDecimal cps;

	
	public Long getIdFtParam() {
		return idFtParam;
	}
	public void setIdFtParam(Long idFtParam) {
		this.idFtParam = idFtParam;
	}
	public String getDsFtParam() {
		return dsFtParam;
	}
	public void setDsFtParam(String dsFtParam) {
		this.dsFtParam = dsFtParam;
	}
	public BigDecimal getLsc_X() {
		return lsc_X;
	}
	public void setLsc_X(BigDecimal lsc_X) {
		this.lsc_X = lsc_X;
	}
	public BigDecimal getLc_X() {
		return lc_X;
	}
	public void setLc_X(BigDecimal lc_X) {
		this.lc_X = lc_X;
	}
	public BigDecimal getLic_X() {
		return lic_X;
	}
	public void setLic_X(BigDecimal lic_X) {
		this.lic_X = lic_X;
	}
	public BigDecimal getLsc_R() {
		return lsc_R;
	}
	public void setLsc_R(BigDecimal lsc_R) {
		this.lsc_R = lsc_R;
	}
	public BigDecimal getLc_R() {
		return lc_R;
	}
	public void setLc_R(BigDecimal lc_R) {
		this.lc_R = lc_R;
	}
	public BigDecimal getLic_R() {
		return lic_R;
	}
	public void setLic_R(BigDecimal lic_R) {
		this.lic_R = lic_R;
	}
	public Integer getM() {
		return m;
	}
	public void setM(Integer m) {
		this.m = m;
	}
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public BigDecimal getDesvioPadrao() {
		return desvioPadrao;
	}
	public void setDesvioPadrao(BigDecimal desvioPadrao) {
		this.desvioPadrao = desvioPadrao;
	}
	
	public BigDecimal getMedia() {
		return media;
	}
	public void setMedia(BigDecimal media) {
		this.media = media;
	}
	public BigDecimal getCp() {
		return cp;
	}
	public void setCp(BigDecimal cp) {
		this.cp = cp;
	}
	public BigDecimal getCpk() {
		return cpk;
	}
	public void setCpk(BigDecimal cpk) {
		this.cpk = cpk;
	}
	public BigDecimal getCpi() {
		return cpi;
	}
	public void setCpi(BigDecimal cpi) {
		this.cpi = cpi;
	}
	public BigDecimal getCps() {
		return cps;
	}
	public void setCps(BigDecimal cps) {
		this.cps = cps;
	}
	
}

