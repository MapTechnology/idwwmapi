package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;


@SuppressWarnings("serial")
public class FiltroDetalhePTDTO implements Serializable {
	
	private OmGt gt;
	private OmPt pt;
	private OmTppt tppt;
	private DwTurno turno;
	private String nrSerieInicial;
	private String nrSerieFinal;
	private Date dtInicial;
	private Date dtFinal;
	private Integer agrupador;
	private DwEst destino;
	private OmProduto produto;
	private OmUsr operador;
	private OmProduto componente;
	private OmUsr supervisor;
	private OmProgrp plataforma;
	private DwPassagem passagem;
	public OmGt getGt() {
		return gt;
	}
	public void setGt(OmGt gt) {
		this.gt = gt;
	}
	public OmPt getPt() {
		return pt;
	}
	public void setPt(OmPt pt) {
		this.pt = pt;
	}
	public OmTppt getTppt() {
		return tppt;
	}
	public void setTppt(OmTppt tppt) {
		this.tppt = tppt;
	}
	public DwTurno getTurno() {
		return turno;
	}
	public void setTurno(DwTurno turno) {
		this.turno = turno;
	}
	public String getNrSerieInicial() {
		return nrSerieInicial;
	}
	public void setNrSerieInicial(String nrSerieInicial) {
		this.nrSerieInicial = nrSerieInicial;
	}
	public String getNrSerieFinal() {
		return nrSerieFinal;
	}
	public void setNrSerieFinal(String nrSerieFinal) {
		this.nrSerieFinal = nrSerieFinal;
	}
	public Date getDtInicial() {
		return dtInicial;
	}
	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}
	public Date getDtFinal() {
		return dtFinal;
	}
	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}
	public Integer getAgrupador() {
		return agrupador;
	}
	public void setAgrupador(Integer agrupador) {
		this.agrupador = agrupador;
	}
	public DwEst getDestino() {
		return destino;
	}
	public void setDestino(DwEst destino) {
		this.destino = destino;
	}
	public OmProduto getProduto() {
		return produto;
	}
	public void setProduto(OmProduto produto) {
		this.produto = produto;
	}
	public OmUsr getOperador() {
		return operador;
	}
	public void setOperador(OmUsr operador) {
		this.operador = operador;
	}
	public OmProduto getComponente() {
		return componente;
	}
	public void setComponente(OmProduto componente) {
		this.componente = componente;
	}
	public OmUsr getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(OmUsr supervisor) {
		this.supervisor = supervisor;
	}
	public OmProgrp getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(OmProgrp plataforma) {
		this.plataforma = plataforma;
	}
	public DwPassagem getPassagem() {
		return passagem;
	}
	public void setPassagem(DwPassagem passagem) {
		this.passagem = passagem;
	}
	
		
}
