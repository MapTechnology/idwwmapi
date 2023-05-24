package idw.model.rn.injet.dto;

import java.math.BigDecimal;

public class RefugoTempoInjetDTO {
	private BigDecimal tempoRefugo = new BigDecimal(0);
	private BigDecimal producaoRefugada = new BigDecimal(0);
	private BigDecimal producaoRefugadaKg = new BigDecimal(0);
	private BigDecimal producaoRefugadaCusto = new BigDecimal(0);
	private BigDecimal qtCiclosRefugados = new BigDecimal(0);
	
	/**
	 * @return the tempoRefugo
	 */
	public BigDecimal getTempoRefugo() {
		return tempoRefugo;
	}
	/**
	 * @param tempoRefugo the tempoRefugo to set
	 */
	public void setTempoRefugo(BigDecimal tempoRefugo) {
		this.tempoRefugo = tempoRefugo;
	}
	public void addTempoRefugo(BigDecimal tempoRefugo) {
		this.tempoRefugo = this.tempoRefugo.add(tempoRefugo);
	}
	/**
	 * @return the producaoRefugada
	 */
	public BigDecimal getProducaoRefugada() {
		return producaoRefugada;
	}
	/**
	 * @param producaoRefugada the producaoRefugada to set
	 */
	public void setProducaoRefugada(BigDecimal producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}
	public void addProducaoRefugada(BigDecimal producaoRefugada) {
		this.producaoRefugada = this.producaoRefugada.add(producaoRefugada);
	}
	public void addQtCiclosRefugados(BigDecimal qtCiclosRefugados) {
		this.qtCiclosRefugados = this.qtCiclosRefugados.add(qtCiclosRefugados);
	}
	/**
	 * @return the producaoRefugadaKg
	 */
	public BigDecimal getProducaoRefugadaKg() {
		return producaoRefugadaKg;
	}
	/**
	 * @param producaoRefugadaKg the producaoRefugadaKg to set
	 */
	public void setProducaoRefugadaKg(BigDecimal producaoRefugadaKg) {
		this.producaoRefugadaKg = producaoRefugadaKg;
	}
	public void addProducaoRefugadaKg(BigDecimal producaoRefugadaKg) {
		this.producaoRefugadaKg = this.producaoRefugadaKg.add(producaoRefugadaKg);
	}
	/**
	 * @return the producaoRefugadaCusto
	 */
	public BigDecimal getProducaoRefugadaCusto() {
		return producaoRefugadaCusto;
	}
	/**
	 * @param producaoRefugadaCusto the producaoRefugadaCusto to set
	 */
	public void setProducaoRefugadaCusto(BigDecimal producaoRefugadaCusto) {
		this.producaoRefugadaCusto = producaoRefugadaCusto;
	}
	public void addtProducaoRefugadaCusto(BigDecimal producaoRefugadaCusto) {
		this.producaoRefugadaCusto = this.producaoRefugadaCusto.add(producaoRefugadaCusto);
	}
	/**
	 * @return the qtCiclosRefugados
	 */
	public BigDecimal getQtCiclosRefugados() {
		return qtCiclosRefugados;
	}
	/**
	 * @param qtCiclosRefugados the qtCiclosRefugados to set
	 */
	public void setQtCiclosRefugados(BigDecimal qtCiclosRefugados) {
		this.qtCiclosRefugados = qtCiclosRefugados;
	}

}
