package idw.model.rn.geraplano.dtos;

import java.util.Date;

import idw.model.rn.DataHoraRN;

public class DisponibilidadeDTO {

	private Date dtReferencia;
	private Double segTempoDisponivel;
	private Double segTempoIndisponivel;
	
	public DisponibilidadeDTO(IndisponibilidadeDTO ind, Date data) {
		super();
		
		this.dtReferencia = DataHoraRN.getDataSemHora(data);
		this.segTempoDisponivel = 24d * 3600d;
		
		// remove da disponibilidade o tempo indisponivel
		Date dtinicioParaCalculo = dtReferencia;
		Date dtfimParaCalculo = DataHoraRN.adicionaDiasDaData(dtReferencia, 1);
		
		Integer qtIndis = DataHoraRN.getQuantidadeSegundosNaIntersecao(dtinicioParaCalculo, dtfimParaCalculo, ind.getInicio(), ind.getFim());
		this.segTempoIndisponivel = (double) qtIndis;
		
		
	}
	
	public void add(DisponibilidadeDTO dto) {
		this.segTempoIndisponivel += dto.getSegTempoIndisponivel();
	}
	
	
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public Double getSegTempoDisponivel() {
		return segTempoDisponivel;
	}
	public void setSegTempoDisponivel(Double segTempoDisponivel) {
		this.segTempoDisponivel = segTempoDisponivel;
	}
	public Double getSegTempoIndisponivel() {
		return segTempoIndisponivel;
	}
	public void setSegTempoIndisponivel(Double segTempoIndisponivel) {
		this.segTempoIndisponivel = segTempoIndisponivel;
	}
}
