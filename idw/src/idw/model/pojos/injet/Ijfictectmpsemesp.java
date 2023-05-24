package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijfictectmpsemesp generated by hbm2java
 */
@Entity
@Table(name = "IJFICTECTMPSEMESP")
public class Ijfictectmpsemesp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5564524690808596657L;
	private IjfictectmpsemespId id;
	private Ijfictec ijfictec;
	private double ciclopadraosemesp;

	public Ijfictectmpsemesp() {
	}

	public Ijfictectmpsemesp(IjfictectmpsemespId id, Ijfictec ijfictec,
			double ciclopadraosemesp) {
		this.id = id;
		this.ijfictec = ijfictec;
		this.ciclopadraosemesp = ciclopadraosemesp;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "dthrivalcic", column = @Column(name = "DTHRIVALCIC", nullable = false, length = 7)) })
	public IjfictectmpsemespId getId() {
		return this.id;
	}

	public void setId(IjfictectmpsemespId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDINJETORA", referencedColumnName = "CDINJETORA", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "DTHRIVALCIC", referencedColumnName = "DTHRIVALCIC", nullable = false, insertable = false, updatable = false) })
	public Ijfictec getIjfictec() {
		return this.ijfictec;
	}

	public void setIjfictec(Ijfictec ijfictec) {
		this.ijfictec = ijfictec;
	}

	@Column(name = "CICLOPADRAOSEMESP", nullable = false, precision = 126, scale = 0)
	public double getCiclopadraosemesp() {
		return this.ciclopadraosemesp;
	}

	public void setCiclopadraosemesp(double ciclopadraosemesp) {
		this.ciclopadraosemesp = ciclopadraosemesp;
	}

}
