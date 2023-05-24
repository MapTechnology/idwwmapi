/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import idw.model.pojos.DwTurno;


/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class CalendarioWizardDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 3;
	
	private DwTurno turno;
	private List<Integer> diasSemana;
	private BigDecimal hrInicioTurno;
	private BigDecimal hrFinalTurno;
	private double duracao;
	private double intervalo;
	private BigDecimal preTolerancia;
	private BigDecimal posTolerancia;
	private int tpReferencia;
    private int resultadoEvento;
	
    public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTOBEMSUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTOBEMSUCEDIDO;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	public void setERRO_DESCONHECIDO(int eRRODESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRODESCONHECIDO;
	}
	public DwTurno getTurno() {
		return turno;
	}
	public void setTurno(DwTurno turno) {
		this.turno = turno;
	}
	public List<Integer> getDiasSemana() {
		return diasSemana;
	}
	public void setDiasSemana(List<Integer> diasSemana) {
		this.diasSemana = diasSemana;
	}
	public double getDuracao() {
		return duracao;
	}
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	public double getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(double intervalo) {
		this.intervalo = intervalo;
	}
	public BigDecimal getPreTolerancia() {
		return preTolerancia;
	}
	public void setPreTolerancia(BigDecimal preTolerancia) {
		this.preTolerancia = preTolerancia;
	}
	public BigDecimal getPosTolerancia() {
		return posTolerancia;
	}
	public void setPosTolerancia(BigDecimal posTolerancia) {
		this.posTolerancia = posTolerancia;
	}
	public int getTpReferencia() {
		return tpReferencia;
	}
	public void setTpReferencia(int tpReferencia) {
		this.tpReferencia = tpReferencia;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public BigDecimal getHrInicioTurno() {
		return hrInicioTurno;
	}
	public void setHrInicioTurno(BigDecimal hrInicioTurno) {
		this.hrInicioTurno = hrInicioTurno;
	}
	public BigDecimal getHrFinalTurno() {
		return hrFinalTurno;
	}
	public void setHrFinalTurno(BigDecimal hrFinalTurno) {
		this.hrFinalTurno = hrFinalTurno;
	}
	
	
}