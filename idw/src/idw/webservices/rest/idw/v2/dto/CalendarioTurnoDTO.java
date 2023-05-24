package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="calendarioturno")
public class CalendarioTurnoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdTurno;
	private String dsTurno;
	private String cor;
	private List<Integer> diasSemana;
	private String hrInicio;
	private String hrFim;
	private String duracao;
	private String intervaloQuebraTurno;
	private Long preTolerancia;
	private Long posTolerancia;
	private Integer tpRefInicioTurno;

	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	public List<Integer> getDiasSemana() {
		return diasSemana;
	}
	public void setDiasSemana(List<Integer> diasSemana) {
		this.diasSemana = diasSemana;
	}
	public String getHrInicio() {
		return hrInicio;
	}
	public void setHrInicio(String hrInicio) {
		this.hrInicio = hrInicio;
	}
	public String getHrFim() {
		return hrFim;
	}
	public void setHrFim(String hrFim) {
		this.hrFim = hrFim;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getIntervaloQuebraTurno() {
		return intervaloQuebraTurno;
	}
	public void setIntervaloQuebraTurno(String intervaloQuebraTurno) {
		this.intervaloQuebraTurno = intervaloQuebraTurno;
	}
	public Long getPreTolerancia() {
		return preTolerancia;
	}
	public void setPreTolerancia(Long preTolerancia) {
		this.preTolerancia = preTolerancia;
	}
	public Long getPosTolerancia() {
		return posTolerancia;
	}
	public void setPosTolerancia(Long posTolerancia) {
		this.posTolerancia = posTolerancia;
	}
	public Integer getTpRefInicioTurno() {
		return tpRefInicioTurno;
	}
	public void setTpRefInicioTurno(Integer tpRefInicioTurno) {
		this.tpRefInicioTurno = tpRefInicioTurno;
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
	
}
