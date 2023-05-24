package idw.model.rn.monitorizacao.detalhes.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.rn.geraplano.dtos.DatasDTO;

public class GraficoParettoLogVRotSDTO {

	private List<GraficoParettoLogVRotDTO> itens = new ArrayList<GraficoParettoLogVRotDTO>();
	
	private BigDecimal indInferior;
	private BigDecimal indSuperior;
	private BigDecimal indMeta;
	
	private DatasDTO corVerde;
	private DatasDTO corAmarela;
	private DatasDTO corLaranja;
	private DatasDTO corVermelho;
	
	public List<GraficoParettoLogVRotDTO> getItens() {
		return itens;
	}
	public void setItens(List<GraficoParettoLogVRotDTO> itens) {
		this.itens = itens;
	}
	public BigDecimal getIndInferior() {
		return indInferior;
	}
	public void setIndInferior(BigDecimal indInferior) {
		this.indInferior = indInferior;
	}
	public BigDecimal getIndSuperior() {
		return indSuperior;
	}
	public void setIndSuperior(BigDecimal indSuperior) {
		this.indSuperior = indSuperior;
	}
	public BigDecimal getIndMeta() {
		return indMeta;
	}
	public void setIndMeta(BigDecimal indMeta) {
		this.indMeta = indMeta;
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
