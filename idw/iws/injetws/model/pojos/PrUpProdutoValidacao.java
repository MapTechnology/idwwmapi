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
 * PrUpProdutoValidacao generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PR_UP_PRODUTO_VALIDACAO", uniqueConstraints = @UniqueConstraint(columnNames = {
		"IDUP", "CDPRODUTO" }))
public class PrUpProdutoValidacao implements java.io.Serializable {

	private String idproduto;
	private PrUp prUp;
	private String cdproduto;
	private char idreduzidaproduto;
	private String dsproduto;
	private double qtplan;

	public PrUpProdutoValidacao() {
	}

	public PrUpProdutoValidacao(String idproduto, PrUp prUp, String cdproduto,
			char idreduzidaproduto, String dsproduto, double qtplan) {
		this.idproduto = idproduto;
		this.prUp = prUp;
		this.cdproduto = cdproduto;
		this.idreduzidaproduto = idreduzidaproduto;
		this.dsproduto = dsproduto;
		this.qtplan = qtplan;
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

	@Column(name = "QTPLAN", nullable = false, precision = 126, scale = 0)
	public double getQtplan() {
		return this.qtplan;
	}

	public void setQtplan(double qtplan) {
		this.qtplan = qtplan;
	}

}