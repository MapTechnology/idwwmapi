package idw.webservices.dto;

import java.util.Date;
import java.util.List;

import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;

public class FiltroRelMaqCriticaDTO {

	private Date dataReferencia;
	private DwTurno dwTurno;
	private List<OmPt> listaMaquinas;
	private boolean isMostrarEmPeca;
	private boolean isMostrarEmKilograma;
	private boolean isMostrarEmTonela;
	
	public Date getDataReferencia() {
		return dataReferencia;
	}
	public void setDataReferencia(Date dataReferencia) {
		this.dataReferencia = dataReferencia;
	}
	public DwTurno getDwTurno() {
		return dwTurno;
	}
	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}
	public List<OmPt> getListaMaquinas() {
		return listaMaquinas;
	}
	public void setListaMaquinas(List<OmPt> listaMaquinas) {
		this.listaMaquinas = listaMaquinas;
	}
	public boolean isMostrarEmPeca() {
		return isMostrarEmPeca;
	}
	public void setMostrarEmPeca(boolean isMostrarEmPeca) {
		this.isMostrarEmPeca = isMostrarEmPeca;
	}
	public boolean isMostrarEmKilograma() {
		return isMostrarEmKilograma;
	}
	public void setMostrarEmKilograma(boolean isMostrarEmKilograma) {
		this.isMostrarEmKilograma = isMostrarEmKilograma;
	}
	public boolean isMostrarEmTonela() {
		return isMostrarEmTonela;
	}
	public void setMostrarEmTonela(boolean isMostrarEmTonela) {
		this.isMostrarEmTonela = isMostrarEmTonela;
	}
	
}