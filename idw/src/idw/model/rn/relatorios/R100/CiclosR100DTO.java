package idw.model.rn.relatorios.R100;

import java.io.Serializable;
import java.math.BigDecimal;

public class CiclosR100DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cicloDoProduto;
	private BigDecimal cicloPadrao;
	private BigDecimal cicloMedio;
	
	
	// atributos para calcular o ciclo medio
	private BigDecimal segAutoTempoCicloProdutivo = BigDecimal.ZERO;
	private BigDecimal segAutoQtCicloProdutivo = BigDecimal.ZERO;
	
	public BigDecimal getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(BigDecimal cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public BigDecimal getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(BigDecimal cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public BigDecimal getSegAutoTempoCicloProdutivo() {
		return segAutoTempoCicloProdutivo;
	}
	public void setSegAutoTempoCicloProdutivo(BigDecimal segAutoTempoCicloProdutivo) {
		this.segAutoTempoCicloProdutivo = segAutoTempoCicloProdutivo;
	}
	public BigDecimal getSegAutoQtCicloProdutivo() {
		return segAutoQtCicloProdutivo;
	}
	public void setSegAutoQtCicloProdutivo(BigDecimal segAutoQtCicloProdutivo) {
		this.segAutoQtCicloProdutivo = segAutoQtCicloProdutivo;
	}
	public String getCicloDoProduto() {
		return cicloDoProduto;
	}
	public void setCicloDoProduto(String cicloDoProduto) {
		this.cicloDoProduto = cicloDoProduto;
	}
}
