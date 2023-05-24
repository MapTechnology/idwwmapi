package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="calendariosemanal")
public class CalendarioTurnoIntervaloDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String hrInicio;
	private String hrFim;
	private String duracao;
	private String cdTurno;
	private String dsTurno;
	private String cor;
	private String hrInicioTurno;
	private String hrFimTurno;
	private String duracaoTurno;
	private Integer diaSemana;
	private Long preTolerancia;
	private Long posTolerancia;
	private int tpRefInicioTurno;
	private boolean inicioDeTurno;
	private boolean fimDeTurno;
	private Integer ordem;
	
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
	public Integer getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
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
	public String getHrInicioTurno() {
		return hrInicioTurno;
	}
	public void setHrInicioTurno(String hrInicioTurno) {
		this.hrInicioTurno = hrInicioTurno;
	}
	public String getHrFimTurno() {
		return hrFimTurno;
	}
	public void setHrFimTurno(String hrFimTurno) {
		this.hrFimTurno = hrFimTurno;
	}
	public String getDuracaoTurno() {
		return duracaoTurno;
	}
	public void setDuracaoTurno(String duracaoTurno) {
		this.duracaoTurno = duracaoTurno;
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
	public int getTpRefInicioTurno() {
		return tpRefInicioTurno;
	}
	public void setTpRefInicioTurno(int tpRefInicioTurno) {
		this.tpRefInicioTurno = tpRefInicioTurno;
	}
	public boolean getIsInicioDeTurno() {
		return inicioDeTurno;
	}
	public void setIsInicioDeTurno(boolean inicioDeTurno) {
		this.inicioDeTurno = inicioDeTurno;
	}
	public boolean getIsFimDeTurno() {
		return fimDeTurno;
	}
	public void setIsFimDeTurno(boolean fimDeTurno) {
		this.fimDeTurno = fimDeTurno;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	
}
