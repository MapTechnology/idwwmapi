package idw.webservices.dto;

import java.util.Date;

import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;

public class FiltroParadasDTO {
	
	private Date dataInicio;
	private Date dataFim;	
	private DwTurno turno;
	private DwTParada tParada;
	private OmPt pt;
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public DwTurno getTurno() {
		return turno;
	}
	public void setTurno(DwTurno turno) {
		this.turno = turno;
	}
	public DwTParada gettParada() {
		return tParada;
	}
	public void settParada(DwTParada tParada) {
		this.tParada = tParada;
	}
	public OmPt getPt() {
		return pt;
	}
	public void setPt(OmPt pt) {
		this.pt = pt;
	}
	
}
