package idw.model.rn.detalhemonitorizacao;

import java.math.BigDecimal;

public class EnergiaConsumidaProducaoDTO {

	private String nrop;
	private BigDecimal producaoBrutaKwh;
	private BigDecimal producaoBrutaValormonetario;
	private BigDecimal producaoLiquidaKwh;
	private BigDecimal producaoLiquidaValormonetario;
	private BigDecimal producaoRefugadaKwh;
	private BigDecimal producaoRefugadaValormonetario;
	
	private BigDecimal producaoBruta;
	private BigDecimal producaoLiquida;
	private BigDecimal producaoRefugada;

	private BigDecimal kwh;
	private BigDecimal valorMonetario;
	
	public String getNrop() {
		return nrop;
	}
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}
	public BigDecimal getProducaoBrutaKwh() {
		return producaoBrutaKwh;
	}
	public void setProducaoBrutaKwh(BigDecimal producaoBrutaKwh) {
		this.producaoBrutaKwh = producaoBrutaKwh;
	}
	public BigDecimal getProducaoBrutaValormonetario() {
		return producaoBrutaValormonetario;
	}
	public void setProducaoBrutaValormonetario(BigDecimal producaoBrutaValormonetario) {
		this.producaoBrutaValormonetario = producaoBrutaValormonetario;
	}
	public BigDecimal getProducaoLiquidaKwh() {
		return producaoLiquidaKwh;
	}
	public void setProducaoLiquidaKwh(BigDecimal producaoLiquidaKwh) {
		this.producaoLiquidaKwh = producaoLiquidaKwh;
	}
	public BigDecimal getProducaoLiquidaValormonetario() {
		return producaoLiquidaValormonetario;
	}
	public void setProducaoLiquidaValormonetario(BigDecimal producaoLiquidaValormonetario) {
		this.producaoLiquidaValormonetario = producaoLiquidaValormonetario;
	}
	public BigDecimal getProducaoRefugadaKwh() {
		return producaoRefugadaKwh;
	}
	public void setProducaoRefugadaKwh(BigDecimal producaoRefugadaKwh) {
		this.producaoRefugadaKwh = producaoRefugadaKwh;
	}
	public BigDecimal getProducaoRefugadaValormonetario() {
		return producaoRefugadaValormonetario;
	}
	public void setProducaoRefugadaValormonetario(BigDecimal producaoRefugadaValormonetario) {
		this.producaoRefugadaValormonetario = producaoRefugadaValormonetario;
	}
	public BigDecimal getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(BigDecimal producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public BigDecimal getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(BigDecimal producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public BigDecimal getProducaoRefugada() {
		return producaoRefugada;
	}
	public void setProducaoRefugada(BigDecimal producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}
	public BigDecimal getKwh() {
		return kwh;
	}
	public void setKwh(BigDecimal kwh) {
		this.kwh = kwh;
	}
	public BigDecimal getValorMonetario() {
		return valorMonetario;
	}
	public void setValorMonetario(BigDecimal valorMonetario) {
		this.valorMonetario = valorMonetario;
	}
	
	@Override
	public String toString() {
		StringBuilder valor = new StringBuilder();
		valor.append("producaoBruta=");
		valor.append(getProducaoBruta());
		valor.append(" energiaConsumida=");
		valor.append(getKwh());
		return valor.toString();
	}
}
