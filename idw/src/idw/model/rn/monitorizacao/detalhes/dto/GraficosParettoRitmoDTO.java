package idw.model.rn.monitorizacao.detalhes.dto;

import java.util.List;

import idw.model.rn.geraplano.dtos.DatasDTO;

public class GraficosParettoRitmoDTO {

	List<GraficoParettoRitmoDTO> ritmos;
	private DatasDTO corVerde;
	private DatasDTO corAmarela;
	private DatasDTO corLaranja;
	private DatasDTO corVermelho;

	public List<GraficoParettoRitmoDTO> getRitmos() {
		return ritmos;
	}

	public void setRitmos(List<GraficoParettoRitmoDTO> ritmos) {
		this.ritmos = ritmos;
	}

	public DatasDTO getCorVerde() {
		return corVerde;
	}

	public void setCorVerde(DatasDTO corVerde) {
		this.corVerde = corVerde;
	}

	public DatasDTO getCorAmarela() {
		return corAmarela;
	}

	public void setCorAmarela(DatasDTO corAmarela) {
		this.corAmarela = corAmarela;
	}

	public DatasDTO getCorLaranja() {
		return corLaranja;
	}

	public void setCorLaranja(DatasDTO corLaranja) {
		this.corLaranja = corLaranja;
	}

	public DatasDTO getCorVermelho() {
		return corVermelho;
	}

	public void setCorVermelho(DatasDTO corVermelho) {
		this.corVermelho = corVermelho;
	}
	
	
}
