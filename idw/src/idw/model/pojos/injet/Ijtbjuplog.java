package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijtbjuplog generated by hbm2java
 */
@Entity
@Table(name = "IJTBJUPLOG")
public class Ijtbjuplog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5444926299451833496L;
	private IjtbjuplogId id;

	public Ijtbjuplog() {
	}

	public Ijtbjuplog(IjtbjuplogId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdjustparada", column = @Column(name = "CDJUSTPARADA", nullable = false, length = 6)),
			@AttributeOverride(name = "dsjustparada", column = @Column(name = "DSJUSTPARADA", length = 40)),
			@AttributeOverride(name = "stativo", column = @Column(name = "STATIVO", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "dthrmanut", column = @Column(name = "DTHRMANUT", nullable = false, length = 7)),
			@AttributeOverride(name = "tpmanut", column = @Column(name = "TPMANUT", nullable = false, length = 1)),
			@AttributeOverride(name = "cdusuresp", column = @Column(name = "CDUSURESP", nullable = false, length = 6)) })
	public IjtbjuplogId getId() {
		return this.id;
	}

	public void setId(IjtbjuplogId id) {
		this.id = id;
	}

}
