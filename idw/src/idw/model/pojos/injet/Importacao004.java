package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Importacao004 generated by hbm2java
 */
@Entity
@Table(name = "IMPORTACAO_004")
public class Importacao004 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3531361478481134072L;
	private String cdproduto;
	private String dsproduto;
	private String idlinguagemsap;
	private double pliquidomedio;
	private double pbrutomedio;
	private String unidmedpeso;

	public Importacao004() {
	}

	public Importacao004(String cdproduto, String dsproduto,
			String idlinguagemsap, double pliquidomedio, double pbrutomedio,
			String unidmedpeso) {
		this.cdproduto = cdproduto;
		this.dsproduto = dsproduto;
		this.idlinguagemsap = idlinguagemsap;
		this.pliquidomedio = pliquidomedio;
		this.pbrutomedio = pbrutomedio;
		this.unidmedpeso = unidmedpeso;
	}

	@Id
	@Column(name = "CDPRODUTO", unique = true, nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "DSPRODUTO", nullable = false, length = 40)
	public String getDsproduto() {
		return this.dsproduto;
	}

	public void setDsproduto(String dsproduto) {
		this.dsproduto = dsproduto;
	}

	@Column(name = "IDLINGUAGEMSAP", nullable = false, length = 2)
	public String getIdlinguagemsap() {
		return this.idlinguagemsap;
	}

	public void setIdlinguagemsap(String idlinguagemsap) {
		this.idlinguagemsap = idlinguagemsap;
	}

	@Column(name = "PLIQUIDOMEDIO", nullable = false, precision = 126, scale = 0)
	public double getPliquidomedio() {
		return this.pliquidomedio;
	}

	public void setPliquidomedio(double pliquidomedio) {
		this.pliquidomedio = pliquidomedio;
	}

	@Column(name = "PBRUTOMEDIO", nullable = false, precision = 126, scale = 0)
	public double getPbrutomedio() {
		return this.pbrutomedio;
	}

	public void setPbrutomedio(double pbrutomedio) {
		this.pbrutomedio = pbrutomedio;
	}

	@Column(name = "UNIDMEDPESO", nullable = false, length = 3)
	public String getUnidmedpeso() {
		return this.unidmedpeso;
	}

	public void setUnidmedpeso(String unidmedpeso) {
		this.unidmedpeso = unidmedpeso;
	}

}
