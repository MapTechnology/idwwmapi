package idw.webservices.rest.dto.iawm;

import java.math.BigDecimal;
import java.util.Date;

public class PtAnaliseIADTO {
	private String cdGt;
	private String cdPt;
	private BigDecimal idConsolId = BigDecimal.ZERO;
	private BigDecimal coordY = BigDecimal.ZERO;
	private BigDecimal coordX = BigDecimal.ZERO;
	private BigDecimal monitoracao = BigDecimal.ZERO;
	private BigDecimal cicloPadrao = BigDecimal.ZERO;
	private BigDecimal cicloMedio = BigDecimal.ZERO;
	private String dtReferencia;//Date
	private Long cdTurno;
	private String dsTurno;
	private TotaisAnaliseIADTO totais = new TotaisAnaliseIADTO();
	
	
	public String getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(String dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public Long getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(Long cdTurno) {
		this.cdTurno = cdTurno;
	}
	public String getDsTurno() {
		return dsTurno;
	}
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public BigDecimal getIdConsolId() {
		return idConsolId;
	}
	public void setIdConsolId(BigDecimal idConsolId) {
		this.idConsolId = idConsolId;
	}
	public BigDecimal getCoordY() {
		return coordY;
	}
	public void setCoordY(BigDecimal coordY) {
		this.coordY = coordY;
	}
	public BigDecimal getCoordX() {
		return coordX;
	}
	public void setCoordX(BigDecimal coordX) {
		this.coordX = coordX;
	}
	public BigDecimal getMonitoracao() {
		return monitoracao;
	}
	public void setMonitoracao(BigDecimal monitoracao) {
		this.monitoracao = monitoracao;
	}
	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public BigDecimal getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(BigDecimal cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public TotaisAnaliseIADTO getTotais() {
		return totais;
	}
	public void setTotais(TotaisAnaliseIADTO totais) {
		this.totais = totais;
	} 
	
	
}
