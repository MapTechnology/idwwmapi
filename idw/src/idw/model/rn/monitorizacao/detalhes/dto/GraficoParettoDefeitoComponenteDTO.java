package idw.model.rn.monitorizacao.detalhes.dto;

import java.math.BigDecimal;

import idw.webservices.dto.DetalhamentoDefeitoComponenteDTO;
import idw.webservices.dto.DetalhamentoDefeitoDTO;

public class GraficoParettoDefeitoComponenteDTO {

	private BigDecimal indice;
	private DetalhamentoDefeitoComponenteDTO defeitoComponente;
	
	public BigDecimal getIndice() {
		return indice;
	}
	public void setIndice(BigDecimal indice) {
		this.indice = indice;
	}
	public DetalhamentoDefeitoComponenteDTO getDefeitoComponente() {
		return defeitoComponente;
	}
	public void setDefeitoComponente(DetalhamentoDefeitoComponenteDTO defeitoComponente) {
		this.defeitoComponente = defeitoComponente;
	}
	
	
	
	
}
