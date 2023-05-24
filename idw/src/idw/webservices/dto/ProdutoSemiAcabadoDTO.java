package idw.webservices.dto;

import java.math.BigDecimal;

import idw.model.pojos.DwRotapasso;

public class ProdutoSemiAcabadoDTO {
	
	private DwRotapasso dwRotapasso;
	private BigDecimal producaoPlanejada;

	public DwRotapasso getDwRotapasso() {
		return dwRotapasso;
	}
	public void setDwRotapasso(DwRotapasso dwRotapasso) {
		this.dwRotapasso = dwRotapasso;
	}
	public BigDecimal getProducaoPlanejada() {
		return producaoPlanejada;
	}
	public void setProducaoPlanejada(BigDecimal producaoPlanejada) {
		this.producaoPlanejada = producaoPlanejada;
	}
	
}