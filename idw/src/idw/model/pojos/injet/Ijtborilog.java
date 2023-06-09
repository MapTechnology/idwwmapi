package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijtborilog generated by hbm2java
 */
@Entity
@Table(name = "IJTBORILOG")
public class Ijtborilog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4620525126878524093L;
	private IjtborilogId id;

	public Ijtborilog() {
	}

	public Ijtborilog(IjtborilogId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdorigem", column = @Column(name = "CDORIGEM", nullable = false, length = 6)),
			@AttributeOverride(name = "dsorigem", column = @Column(name = "DSORIGEM", length = 40)),
			@AttributeOverride(name = "dthrmanut", column = @Column(name = "DTHRMANUT", nullable = false, length = 7)),
			@AttributeOverride(name = "tpmanut", column = @Column(name = "TPMANUT", nullable = false, length = 1)),
			@AttributeOverride(name = "cdusuresp", column = @Column(name = "CDUSURESP", nullable = false, length = 6)) })
	public IjtborilogId getId() {
		return this.id;
	}

	public void setId(IjtborilogId id) {
		this.id = id;
	}

}
