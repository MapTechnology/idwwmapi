package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwTurno;

public class GraficoCEPDetParamDTO {
	private Long idFtParam;
	private String dsFtParam;
	private Date dtReferenciaParaToolTip;
	private DwTurno dwturnoParaToolTip;
	
	private DetalheMonitorizacaoCEPDTO detParam;

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

	public DetalheMonitorizacaoCEPDTO getDetParam() {
		return detParam;
	}

	public void setDetParam(DetalheMonitorizacaoCEPDTO detParam) {
		this.detParam = detParam;
	}

	public Date getDtReferenciaParaToolTip() {
		return dtReferenciaParaToolTip;
	}

	public void setDtReferenciaParaToolTip(Date dtReferenciaParaToolTip) {
		this.dtReferenciaParaToolTip = dtReferenciaParaToolTip;
	}

	public DwTurno getDwturnoParaToolTip() {
		return dwturnoParaToolTip;
	}

	public void setDwturnoParaToolTip(DwTurno dwturnoParaToolTip) {
		this.dwturnoParaToolTip = dwturnoParaToolTip;
	}
}
