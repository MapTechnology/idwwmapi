package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="turno")
public class TurnoDTO2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idTurno;
	private String cdTurno;
	private String dsTurno;
	private String cor;
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(Long idTurno) {
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
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
}
