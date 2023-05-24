package idw.webservices.rest.dto;

import java.io.Serializable; 

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="turno")
public class TurnoDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private long idTurno;
	private String cdTurno;
	private String dsTurno;
	private String dtReferencia;  //dd/mm/yyyy
	private String dtRefYMD; //yyyy-mm-dd
	private Long dtRefTimestamp; 
	private Long idCal;
	
	public long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}
	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	public String getDsTurno() {
		return dsTurno;
	}
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}
	public String getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(String dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
 
	public String getDtRefYMD() {
		return dtRefYMD;
	}
	public void setDtRefYMD(String dtRefYMD) {
		this.dtRefYMD = dtRefYMD;
	}
	public Long getDtRefTimestamp() {
		return dtRefTimestamp;
	}
	public void setDtRefTimestamp(Long dtRefTimestamp) {
		this.dtRefTimestamp = dtRefTimestamp;
	}
	public Long getIdCal() {
		return idCal;
	}
	public void setIdCal(Long idCal) {
		this.idCal = idCal;
	}
	
	
}
