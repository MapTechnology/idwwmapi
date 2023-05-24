package idw.webservices.rest.idw.v2.dto;

import java.math.BigDecimal;

import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;

public class AnaliseTurnoIndicadoresPTDTO {
	private String cdPt;
	private BigDecimal efiRea;
	private BigDecimal efiCic;
	private BigDecimal efiInst;
	private BigDecimal indRef;
	private BigDecimal indPar;
	private BigDecimal indQtdAloc;
	private BigDecimal indPerdas;
	private BigDecimal oee;	
	private FiltroDetalhePostoDTO filtroClick;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public BigDecimal getEfiRea() {
		return efiRea;
	}
	public void setEfiRea(BigDecimal efiRea) {
		this.efiRea = efiRea;
	}
	public BigDecimal getEfiCic() {
		return efiCic;
	}
	public void setEfiCic(BigDecimal efiCic) {
		this.efiCic = efiCic;
	}
	public BigDecimal getEfiInst() {
		return efiInst;
	}
	public void setEfiInst(BigDecimal efiInst) {
		this.efiInst = efiInst;
	}
	public BigDecimal getIndRef() {
		return indRef;
	}
	public void setIndRef(BigDecimal indRef) {
		this.indRef = indRef;
	}
	public BigDecimal getIndPar() {
		return indPar;
	}
	public void setIndPar(BigDecimal indPar) {
		this.indPar = indPar;
	}
	public BigDecimal getIndQtdAloc() {
		return indQtdAloc;
	}
	public void setIndQtdAloc(BigDecimal indQtdAloc) {
		this.indQtdAloc = indQtdAloc;
	}
	public BigDecimal getIndPerdas() {
		return indPerdas;
	}
	public void setIndPerdas(BigDecimal indPerdas) {
		this.indPerdas = indPerdas;
	}
	public BigDecimal getOee() {
		return oee;
	}
	public void setOee(BigDecimal oee) {
		this.oee = oee;
	}
	public FiltroDetalhePostoDTO getFiltroClick() {
		return filtroClick;
	}
	public void setFiltroClick(FiltroDetalhePostoDTO filtroClick) {
		this.filtroClick = filtroClick;
	}
}
