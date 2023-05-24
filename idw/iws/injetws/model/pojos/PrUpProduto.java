package injetws.model.pojos;
// default package
// Generated 16/10/2008 15:14:14 by Hibernate Tools 3.2.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * PrUpProduto generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PR_UP_PRODUTO", uniqueConstraints = @UniqueConstraint(columnNames = {
		"IDUP", "CDPRODUTO" }))
public class PrUpProduto implements java.io.Serializable {

	private String idproduto;
	private PrUp prUp;
	private String cdproduto;
	private char idreduzidaproduto;
	private String dsproduto;
	private double qtdplan;
	private double qtdprodliquida;

	public PrUpProduto() {
	}

	public PrUpProduto(String idproduto, PrUp prUp, String cdproduto,
			char idreduzidaproduto, String dsproduto, double qtdplan,
			double qtdprodliquida) {
		this.idproduto = idproduto;
		this.prUp = prUp;
		this.cdproduto = cdproduto;
		this.idreduzidaproduto = idreduzidaproduto;
		this.dsproduto = dsproduto;
		this.qtdplan = qtdplan;
		this.qtdprodliquida = qtdprodliquida;
	}

	@Id
	@Column(name = "IDPRODUTO", unique = true, nullable = false, length = 36)
	public String getIdproduto() {
		return this.idproduto;
	}

	public void setIdproduto(String idproduto) {
		this.idproduto = idproduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUP", nullable = false)
	public PrUp getPrUp() {
		return this.prUp;
	}

	public void setPrUp(PrUp prUp) {
		this.prUp = prUp;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "IDREDUZIDAPRODUTO", nullable = false, length = 1)
	public char getIdreduzidaproduto() {
		return this.idreduzidaproduto;
	}

	public void setIdreduzidaproduto(char idreduzidaproduto) {
		this.idreduzidaproduto = idreduzidaproduto;
	}

	@Column(name = "DSPRODUTO", nullable = false, length = 40)
	public String getDsproduto() {
		return this.dsproduto;
	}

	public void setDsproduto(String dsproduto) {
		this.dsproduto = dsproduto;
	}

	@Column(name = "QTDPLAN", nullable = false, precision = 126, scale = 0)
	public double getQtdplan() {
		return this.qtdplan;
	}

	public void setQtdplan(double qtdplan) {
		this.qtdplan = qtdplan;
	}

	@Column(name = "QTDPRODLIQUIDA", nullable = false, precision = 126, scale = 0, updatable=false)
	public double getQtdprodliquida() {
		return this.qtdprodliquida;
	}

	public void setQtdprodliquida(double qtdprodliquida) {
		this.qtdprodliquida = qtdprodliquida;
	}

}