package injetws.model.pojos;

// default package
// Generated 08/03/2010 15:46:01 by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PrUpAndonAlertaInspecao generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PR_UP_ANDON_ALERTA_INSPECAO")
public class PrUpAndonAlertaInspecao implements java.io.Serializable {

	private String idup;
	private PrUp prUp;
	private String nrop;
	private String cdmolde;
	private String cdestrutura;
	private String cdproduto;
	private Date dthralerta;
	private BigDecimal tmpliminspqld;

	public PrUpAndonAlertaInspecao() {
	}

	public PrUpAndonAlertaInspecao(String idup, PrUp prUp) {
		this.idup = idup;
		this.prUp = prUp;
	}

	public PrUpAndonAlertaInspecao(String idup, PrUp prUp, String nrop,
			String cdmolde, String cdestrutura, String cdproduto,
			Date dthralerta, BigDecimal tmpliminspqld) {
		this.idup = idup;
		this.prUp = prUp;
		this.nrop = nrop;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.cdproduto = cdproduto;
		this.dthralerta = dthralerta;
		this.tmpliminspqld = tmpliminspqld;
	}

	@Id
	@Column(name = "IDUP", unique = true, nullable = false, length = 36)
	public String getIdup() {
		return this.idup;
	}

	public void setIdup(String idup) {
		this.idup = idup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUP", unique = true, nullable = false, insertable = false, updatable = false)
	public PrUp getPrUp() {
		return this.prUp;
	}

	public void setPrUp(PrUp prUp) {
		this.prUp = prUp;
	}

	@Column(name = "NROP", length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "CDMOLDE", length = 6)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Column(name = "CDESTRUTURA", length = 4)
	public String getCdestrutura() {
		return this.cdestrutura;
	}

	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}

	@Column(name = "CDPRODUTO", length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHRALERTA", length = 7)
	public Date getDthralerta() {
		return this.dthralerta;
	}

	public void setDthralerta(Date dthralerta) {
		this.dthralerta = dthralerta;
	}

	@Column(name = "TMPLIMINSPQLD", precision = 22, scale = 0)
	public BigDecimal getTmpliminspqld() {
		return this.tmpliminspqld;
	}

	public void setTmpliminspqld(BigDecimal tmpliminspqld) {
		this.tmpliminspqld = tmpliminspqld;
	}

}