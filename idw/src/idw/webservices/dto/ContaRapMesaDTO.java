package idw.webservices.dto;

import idw.model.pojos.DwRap;

public class ContaRapMesaDTO {
	private Long idRap;
	private int qtdUsada;
	private DwRap dwRap;
	
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}
	public Long getIdRap() {
		return idRap;
	}
	public void setIdRap(Long idRap) {
		this.idRap = idRap;
	}
	public int getQtdUsada() {
		return qtdUsada;
	}
	public void setQtdUsada(int qtdUsada) {
		this.qtdUsada = qtdUsada;
	}
}
