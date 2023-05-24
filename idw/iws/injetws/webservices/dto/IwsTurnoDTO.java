package injetws.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class IwsTurnoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cdTurno;
	private Long idCal;
	private Date dtReferencia;
	//private Date dtHrITurno;
	private Date dthrInicio;
	private Date dtHrFTurno;
	private BigDecimal dtHrIHora;
	private BigDecimal dtHrFHora;
	

	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}

	public Long getIdCal() {
		return idCal;
	}
	public void setIdCal(Long idCal) {
		this.idCal = idCal;
	}

	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}

	public Date getDthrInicio() {
		return dthrInicio;
	}
	public void setDthrInicio(Date dthrInicio) {
		this.dthrInicio = dthrInicio;
	}
	
	public Date getDtHrFTurno() {
		return dtHrFTurno;
	}
	public void setDtHrFTurno(Date dtHrFTurno) {
		this.dtHrFTurno = dtHrFTurno;
	}

	public BigDecimal getDtHrIHora() {
		return dtHrIHora;
	}
	public void setDtHrIHora(BigDecimal dtHrIHora) {
		this.dtHrIHora = dtHrIHora;
	}

	public BigDecimal getDtHrFHora() {
		return dtHrFHora;
	}
	public void setDtHrFHora(BigDecimal dtHrFHora) {
		this.dtHrFHora = dtHrFHora;
	}

}
