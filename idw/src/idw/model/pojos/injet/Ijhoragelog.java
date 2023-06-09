package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijhoragelog generated by hbm2java
 */
@Entity
@Table(name = "IJHORAGELOG")
public class Ijhoragelog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6340515644853948378L;
	private IjhoragelogId id;

	public Ijhoragelog() {
	}

	public Ijhoragelog(IjhoragelogId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdagenda", column = @Column(name = "CDAGENDA", nullable = false, length = 6)),
			@AttributeOverride(name = "dsagenda", column = @Column(name = "DSAGENDA", length = 40)),
			@AttributeOverride(name = "dtivagenda", column = @Column(name = "DTIVAGENDA", nullable = false, length = 7)),
			@AttributeOverride(name = "dtfvagenda", column = @Column(name = "DTFVAGENDA", length = 7)),
			@AttributeOverride(name = "hriseg", column = @Column(name = "HRISEG", length = 7)),
			@AttributeOverride(name = "hrfseg", column = @Column(name = "HRFSEG", length = 7)),
			@AttributeOverride(name = "sitiniciofimseg", column = @Column(name = "SITINICIOFIMSEG", precision = 22, scale = 0)),
			@AttributeOverride(name = "hriter", column = @Column(name = "HRITER", length = 7)),
			@AttributeOverride(name = "hrfter", column = @Column(name = "HRFTER", length = 7)),
			@AttributeOverride(name = "sitiniciofimter", column = @Column(name = "SITINICIOFIMTER", precision = 22, scale = 0)),
			@AttributeOverride(name = "hriqua", column = @Column(name = "HRIQUA", length = 7)),
			@AttributeOverride(name = "hrfqua", column = @Column(name = "HRFQUA", length = 7)),
			@AttributeOverride(name = "sitiniciofimqua", column = @Column(name = "SITINICIOFIMQUA", precision = 22, scale = 0)),
			@AttributeOverride(name = "hriqui", column = @Column(name = "HRIQUI", length = 7)),
			@AttributeOverride(name = "hrfqui", column = @Column(name = "HRFQUI", length = 7)),
			@AttributeOverride(name = "sitiniciofimqui", column = @Column(name = "SITINICIOFIMQUI", precision = 22, scale = 0)),
			@AttributeOverride(name = "hrisex", column = @Column(name = "HRISEX", length = 7)),
			@AttributeOverride(name = "hrfsex", column = @Column(name = "HRFSEX", length = 7)),
			@AttributeOverride(name = "sitiniciofimsex", column = @Column(name = "SITINICIOFIMSEX", precision = 22, scale = 0)),
			@AttributeOverride(name = "hrisab", column = @Column(name = "HRISAB", length = 7)),
			@AttributeOverride(name = "hrfsab", column = @Column(name = "HRFSAB", length = 7)),
			@AttributeOverride(name = "sitiniciofimsab", column = @Column(name = "SITINICIOFIMSAB", precision = 22, scale = 0)),
			@AttributeOverride(name = "hridom", column = @Column(name = "HRIDOM", length = 7)),
			@AttributeOverride(name = "hrfdom", column = @Column(name = "HRFDOM", length = 7)),
			@AttributeOverride(name = "sitiniciofimdom", column = @Column(name = "SITINICIOFIMDOM", precision = 22, scale = 0)),
			@AttributeOverride(name = "dthrmanut", column = @Column(name = "DTHRMANUT", nullable = false, length = 7)),
			@AttributeOverride(name = "tpmanut", column = @Column(name = "TPMANUT", nullable = false, length = 1)),
			@AttributeOverride(name = "cdusuresp", column = @Column(name = "CDUSURESP", nullable = false, length = 6)) })
	public IjhoragelogId getId() {
		return this.id;
	}

	public void setId(IjhoragelogId id) {
		this.id = id;
	}

}
