package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import idw.model.pojos.OmProgrp;


@SuppressWarnings("serial")
public class FiltroRelDTO implements Serializable {
	
	private Date dataInicial;
	private Date dataFinal;
	private List<OmProgrp> plataformas;
	private Integer agrupamento;
	private Integer apontamento;
	private long idPt;
	private long idTurno;

	public long getIdPt() {
		return idPt;
	}
	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}
	public long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public List<OmProgrp> getPlataformas() {
		return plataformas;
	}
	public void setPlataformas(List<OmProgrp> plataformas) {
		this.plataformas = plataformas;
	}
	public Integer getAgrupamento() {
		return agrupamento;
	}
	public void setAgrupamento(Integer agrupamento) {
		this.agrupamento = agrupamento;
	}
	public Integer getApontamento() {
		return apontamento;
	}
	public void setApontamento(Integer apontamento) {
		this.apontamento = apontamento;
	}
	
	
	
}
