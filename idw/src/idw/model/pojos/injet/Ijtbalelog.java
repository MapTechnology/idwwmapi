package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijtbalelog generated by hbm2java
 */
@Entity
@Table(name = "IJTBALELOG")
public class Ijtbalelog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5767305260608337451L;
	private IjtbalelogId id;

	public Ijtbalelog() {
	}

	public Ijtbalelog(IjtbalelogId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdalerta", column = @Column(name = "CDALERTA", nullable = false, length = 6)),
			@AttributeOverride(name = "dsalerta", column = @Column(name = "DSALERTA", length = 40)),
			@AttributeOverride(name = "dthrmanut", column = @Column(name = "DTHRMANUT", nullable = false, length = 7)),
			@AttributeOverride(name = "tpmanut", column = @Column(name = "TPMANUT", nullable = false, length = 20)),
			@AttributeOverride(name = "cdusuresp", column = @Column(name = "CDUSURESP", nullable = false, length = 6)) })
	public IjtbalelogId getId() {
		return this.id;
	}

	public void setId(IjtbalelogId id) {
		this.id = id;
	}

}
