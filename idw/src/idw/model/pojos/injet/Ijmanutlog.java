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
 * Ijmanutlog generated by hbm2java
 */
@Entity
@Table(name = "IJMANUTLOG")
public class Ijmanutlog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2100761625248338282L;
	private IjmanutlogId id;
	private Ijmanut ijmanut;

	public Ijmanutlog() {
	}

	public Ijmanutlog(IjmanutlogId id) {
		this.id = id;
	}

	public Ijmanutlog(IjmanutlogId id, Ijmanut ijmanut) {
		this.id = id;
		this.ijmanut = ijmanut;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dthrlog", column = @Column(name = "DTHRLOG", nullable = false, length = 7)),
			@AttributeOverride(name = "dslog", column = @Column(name = "DSLOG", nullable = false)),
			@AttributeOverride(name = "nros", column = @Column(name = "NROS", length = 12)),
			@AttributeOverride(name = "seqitem", column = @Column(name = "SEQITEM", precision = 22, scale = 0)) })
	public IjmanutlogId getId() {
		return this.id;
	}

	public void setId(IjmanutlogId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROS", insertable = false, updatable = false)
	public Ijmanut getIjmanut() {
		return this.ijmanut;
	}

	public void setIjmanut(Ijmanut ijmanut) {
		this.ijmanut = ijmanut;
	}

}
