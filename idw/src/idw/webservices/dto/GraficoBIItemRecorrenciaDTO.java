package idw.webservices.dto;


import java.util.Date;
import java.util.List;

public class GraficoBIItemRecorrenciaDTO {
	private Date dthrIni;
	private Date dthrFim;
	private Double indItem;
	private Double segTempoParadas;
	private Double qtdPerdida;
	private String toolTip;
	private Double qtdPerdidaKg;
	private Double qtdPerdidaTon;	
	private List<DetalheRecorrenciaParadaDTO> listaParadas;
	private List<DetalheRecorrenciaRefugoDTO> listaRefugos;
	private Boolean isParadaSemPeso = false; 

	
	public Date getDthrIni() {
		return dthrIni;
	}
	public void setDthrIni(Date dthrIni) {
		this.dthrIni = dthrIni;
	}
	public Date getDthrFim() {
		return dthrFim;
	}
	public void setDthrFim(Date dthrFim) {
		this.dthrFim = dthrFim;
	}
	public Double getIndItem() {
		return indItem;
	}
	public void setIndItem(Double indItem) {
		this.indItem = indItem;
	}
	public Double getSegTempoParadas() {
		return segTempoParadas;
	}
	public void setSegTempoParadas(Double segTempoParadas) {
		this.segTempoParadas = segTempoParadas;
	}
	public Double getQtdPerdida() {
		return qtdPerdida;
	}
	public void setQtdPerdida(Double qtdPerdida) {
		this.qtdPerdida = qtdPerdida;
	}
	public String getToolTip() {
		return toolTip;
	}
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}
	public List<DetalheRecorrenciaParadaDTO> getListaParadas() {
		return listaParadas;
	}
	public void setListaParadas(List<DetalheRecorrenciaParadaDTO> listaParadas) {
		this.listaParadas = listaParadas;
	}
	public List<DetalheRecorrenciaRefugoDTO> getListaRefugos() {
		return listaRefugos;
	}
	public void setListaRefugos(List<DetalheRecorrenciaRefugoDTO> listaRefugos) {
		this.listaRefugos = listaRefugos;
	}
	public Double getQtdPerdidaKg() {
		return qtdPerdidaKg;
	}
	public void setQtdPerdidaKg(Double qtdPerdidaKg) {
		this.qtdPerdidaKg = qtdPerdidaKg;
	}
	public Double getQtdPerdidaTon() {
		return qtdPerdidaTon;
	}
	public void setQtdPerdidaTon(Double qtdPerdidaTon) {
		this.qtdPerdidaTon = qtdPerdidaTon;
	}
	public Boolean getIsParadaSemPeso() {
		return isParadaSemPeso;
	}
	public void setIsParadaSemPeso(Boolean isParadaSemPeso) {
		this.isParadaSemPeso = isParadaSemPeso;
	}	
}
