package idw.model.rn.monitorizacao.detalhes.dto;

import java.math.BigDecimal;

import idw.webservices.dto.DetalhamentoLogVRotDTO;

public class GraficoParettoLogVRotDTO {

	private BigDecimal indice;
	private DetalhamentoLogVRotDTO itemdetalhe;
	
	public BigDecimal getIndice() {
		return indice;
	}
	public void setIndice(BigDecimal indice) {
		this.indice = indice;
	}
	public DetalhamentoLogVRotDTO getItemDetalhe() {
		return itemdetalhe;
	}
	public void setItemDetalhe(DetalhamentoLogVRotDTO itemdetalhe) {
		this.itemdetalhe = itemdetalhe;
	}
	
	
	
	
}
