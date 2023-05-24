package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="calendario")
public class CalendarioDTO2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCalendario;
	private String cdCalendario;
	private String dsCalendario;
	private String dtHrIValidade;
	private String dtHrFValidade;
	private List<CalendarioTurnoDTO> turnos;
    private List<CalendarioTurnoIntervaloDTO> intervalos;
    private List<CalendarioPtDTO2> pts;
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdCalendario() {
		return idCalendario;
	}
	public void setIdCalendario(Long idCalendario) {
		this.idCalendario = idCalendario;
	}
	public String getCdCalendario() {
		return cdCalendario;
	}
	public void setCdCalendario(String cdCalendario) {
		this.cdCalendario = cdCalendario;
	}
	public String getDsCalendario() {
		return dsCalendario;
	}
	public void setDsCalendario(String dsCalendario) {
		this.dsCalendario = dsCalendario;
	}
	public String getDtHrIValidade() {
		return dtHrIValidade;
	}
	public void setDtHrIValidade(String dtHrIValidade) {
		this.dtHrIValidade = dtHrIValidade;
	}
	public String getDtHrFValidade() {
		return dtHrFValidade;
	}
	public void setDtHrFValidade(String dtHrFValidade) {
		this.dtHrFValidade = dtHrFValidade;
	}
	public List<CalendarioPtDTO2> getPts() {
		return pts;
	}
	public void setPts(List<CalendarioPtDTO2> pts) {
		this.pts = pts;
	}
	public List<CalendarioTurnoIntervaloDTO> getIntervalos() {
		return intervalos;
	}
	public void setIntervalos(List<CalendarioTurnoIntervaloDTO> intervalos) {
		this.intervalos = intervalos;
	}
	public List<CalendarioTurnoDTO> getTurnos() {
		return turnos;
	}
	public void setTurnos(List<CalendarioTurnoDTO> turnos) {
		this.turnos = turnos;
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
