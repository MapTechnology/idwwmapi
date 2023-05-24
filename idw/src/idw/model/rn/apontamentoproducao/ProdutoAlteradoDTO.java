package idw.model.rn.apontamentoproducao;

import java.math.BigDecimal;

public class ProdutoAlteradoDTO {

	private BigDecimal pcsAutoProducaobruta;
	private BigDecimal pcsManuProducaobruta;
	
	
	private BigDecimal pcsAutoProducaorefugada;
	private BigDecimal pcsManuProducaorefugada;
	
	public BigDecimal getPcsAutoProducaobruta() {
		return pcsAutoProducaobruta;
	}
	public void setPcsAutoProducaobruta(BigDecimal pcsAutoProducaobruta) {
		this.pcsAutoProducaobruta = pcsAutoProducaobruta;
	}
	public BigDecimal getPcsManuProducaobruta() {
		return pcsManuProducaobruta;
	}
	public void setPcsManuProducaobruta(BigDecimal pcsManuProducaobruta) {
		this.pcsManuProducaobruta = pcsManuProducaobruta;
	}
	public BigDecimal getPcsAutoProducaorefugada() {
		return pcsAutoProducaorefugada;
	}
	public void setPcsAutoProducaorefugada(BigDecimal pcsAutoProducaorefugada) {
		this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
	}
	public BigDecimal getPcsManuProducaorefugada() {
		return pcsManuProducaorefugada;
	}
	public void setPcsManuProducaorefugada(BigDecimal pcsManuProducaorefugada) {
		this.pcsManuProducaorefugada = pcsManuProducaorefugada;
	}
}
