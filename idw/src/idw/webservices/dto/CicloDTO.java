package idw.webservices.dto;

import java.math.BigDecimal;

import idw.model.pojos.DwRtcic;

public class CicloDTO {
	private DwRtcic dwRtcic;
	private BigDecimal cicloPadrao;
	private Integer cavAtivas;
	private BigDecimal metaHora;
	private BigDecimal eficienciaCiclo;
	
	public BigDecimal getEficienciaCiclo() {
		return eficienciaCiclo;
	}

	public void setEficienciaCiclo(BigDecimal eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}

	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}

	public Integer getCavAtivas() {
		return cavAtivas;
	}

	public void setCavAtivas(Integer cavAtivas) {
		this.cavAtivas = cavAtivas;
	}

	public BigDecimal getMetaHora() {
		return metaHora;
	}

	public void setMetaHora(BigDecimal metaHora) {
		this.metaHora = metaHora;
	}

	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}

	public DwRtcic getDwRtcic() {
		return dwRtcic;
	}

	public void setDwRtcic(DwRtcic dwRtcic) {
		this.dwRtcic = dwRtcic;
	}
	
	

}
