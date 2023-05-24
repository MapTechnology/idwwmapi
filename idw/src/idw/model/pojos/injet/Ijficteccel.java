package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijficteccel generated by hbm2java
 */
@Entity
@Table(name = "IJFICTECCEL")
public class Ijficteccel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8846025095547808405L;
	private IjficteccelId id;
	private Ijtbcelula ijtbcelula;
	private Date dthrfvalciccel;
	private double ciclopadraocel;

	public Ijficteccel() {
	}

	public Ijficteccel(IjficteccelId id, Ijtbcelula ijtbcelula,
			double ciclopadraocel) {
		this.id = id;
		this.ijtbcelula = ijtbcelula;
		this.ciclopadraocel = ciclopadraocel;
	}

	public Ijficteccel(IjficteccelId id, Ijtbcelula ijtbcelula,
			Date dthrfvalciccel, double ciclopadraocel) {
		this.id = id;
		this.ijtbcelula = ijtbcelula;
		this.dthrfvalciccel = dthrfvalciccel;
		this.ciclopadraocel = ciclopadraocel;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdcelula", column = @Column(name = "CDCELULA", nullable = false, length = 6)),
			@AttributeOverride(name = "dthrivalciccel", column = @Column(name = "DTHRIVALCICCEL", nullable = false, length = 7)) })
	public IjficteccelId getId() {
		return this.id;
	}

	public void setId(IjficteccelId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDCELULA", nullable = false, insertable = false, updatable = false)
	public Ijtbcelula getIjtbcelula() {
		return this.ijtbcelula;
	}

	public void setIjtbcelula(Ijtbcelula ijtbcelula) {
		this.ijtbcelula = ijtbcelula;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFVALCICCEL", length = 7)
	public Date getDthrfvalciccel() {
		return this.dthrfvalciccel;
	}

	public void setDthrfvalciccel(Date dthrfvalciccel) {
		this.dthrfvalciccel = dthrfvalciccel;
	}

	@Column(name = "CICLOPADRAOCEL", nullable = false, precision = 126, scale = 0)
	public double getCiclopadraocel() {
		return this.ciclopadraocel;
	}

	public void setCiclopadraocel(double ciclopadraocel) {
		this.ciclopadraocel = ciclopadraocel;
	}

}
