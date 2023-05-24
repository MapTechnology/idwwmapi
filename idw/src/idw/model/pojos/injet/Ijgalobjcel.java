package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijgalobjcel generated by hbm2java
 */
@Entity
@Table(name = "IJGALOBJCEL")
public class Ijgalobjcel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4691335575255542045L;
	private IjgalobjcelId id;
	private Ijtbgal ijtbgal;
	private Ijtbcelula ijtbcelula;
	private double coordx;
	private double coordy;

	public Ijgalobjcel() {
	}

	public Ijgalobjcel(IjgalobjcelId id, Ijtbgal ijtbgal,
			Ijtbcelula ijtbcelula, double coordx, double coordy) {
		this.id = id;
		this.ijtbgal = ijtbgal;
		this.ijtbcelula = ijtbcelula;
		this.coordx = coordx;
		this.coordy = coordy;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdgalpao", column = @Column(name = "CDGALPAO", nullable = false, length = 6)),
			@AttributeOverride(name = "cdcelula", column = @Column(name = "CDCELULA", nullable = false, length = 6)) })
	public IjgalobjcelId getId() {
		return this.id;
	}

	public void setId(IjgalobjcelId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDGALPAO", nullable = false, insertable = false, updatable = false)
	public Ijtbgal getIjtbgal() {
		return this.ijtbgal;
	}

	public void setIjtbgal(Ijtbgal ijtbgal) {
		this.ijtbgal = ijtbgal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDCELULA", nullable = false, insertable = false, updatable = false)
	public Ijtbcelula getIjtbcelula() {
		return this.ijtbcelula;
	}

	public void setIjtbcelula(Ijtbcelula ijtbcelula) {
		this.ijtbcelula = ijtbcelula;
	}

	@Column(name = "COORDX", nullable = false, precision = 126, scale = 0)
	public double getCoordx() {
		return this.coordx;
	}

	public void setCoordx(double coordx) {
		this.coordx = coordx;
	}

	@Column(name = "COORDY", nullable = false, precision = 126, scale = 0)
	public double getCoordy() {
		return this.coordy;
	}

	public void setCoordy(double coordy) {
		this.coordy = coordy;
	}

}
