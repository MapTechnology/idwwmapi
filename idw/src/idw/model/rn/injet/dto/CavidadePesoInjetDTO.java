package idw.model.rn.injet.dto;

import java.math.BigDecimal;

public class CavidadePesoInjetDTO {
	Integer qtcavidadesAtivas = 0;
	Integer qtcavidades = 0;
	BigDecimal pesoBruto = new BigDecimal(0);
	BigDecimal pesoLiquido = new BigDecimal(0);
	BigDecimal custo = new BigDecimal(0);
	/**
	 * @return the qtcavidadesAtivas
	 */
	public Integer getQtcavidadesAtivas() {
		return qtcavidadesAtivas;
	}
	/**
	 * @param qtcavidadesAtivas the qtcavidadesAtivas to set
	 */
	public void setQtcavidadesAtivas(Integer qtcavidadesAtivas) {
		this.qtcavidadesAtivas = qtcavidadesAtivas;
	}
	public void addQtcavidadesAtivas(Integer qtcavidadesAtivas) {
		this.qtcavidadesAtivas += qtcavidadesAtivas;
	}
	/**
	 * @return the qtcavidades
	 */
	public Integer getQtcavidades() {
		return qtcavidades;
	}
	/**
	 * @param qtcavidades the qtcavidades to set
	 */
	public void setQtcavidades(Integer qtcavidades) {
		this.qtcavidades = qtcavidades;
	}
	public void addQtcavidades(Integer qtcavidades) {
		this.qtcavidades += qtcavidades;
	}
	/**
	 * @return the pesoBruto
	 */
	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}
	/**
	 * @param pesoBruto the pesoBruto to set
	 */
	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public void addPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto.add(pesoBruto);
	}
	/**
	 * @return the pesoLiquido
	 */
	public BigDecimal getPesoLiquido() {
		return pesoLiquido;
	}
	/**
	 * @param pesoLiquido the pesoLiquido to set
	 */
	public void setPesoLiquido(BigDecimal pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	public void addPesoLiquido(BigDecimal pesoLiquido) {
		this.pesoLiquido.add(pesoLiquido);
	}
	/**
	 * @return the custo
	 */
	public BigDecimal getCusto() {
		return custo;
	}
	/**
	 * @param custo the custo to set
	 */
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	public void addCusto(BigDecimal custo) {
		this.custo.add(custo);
	}

}
