package idw.model.rn.monitorizacao.detalhes.dto;

import java.math.BigDecimal;

import idw.webservices.dto.DetalhamentoDefeitoDTO;

public class GraficoParettoDefeitoDTO {

	private BigDecimal indice;
	private DetalhamentoDefeitoDTO defeito;
	
	public BigDecimal getIndice() {
		return indice;
	}
	public void setIndice(BigDecimal indice) {
		this.indice = indice;
	}
	public DetalhamentoDefeitoDTO getDefeito() {
		return defeito;
	}
	public void setDefeito(DetalhamentoDefeitoDTO defeito) {
		this.defeito = defeito;
	}
	
	
	
	
}
