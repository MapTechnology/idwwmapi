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
 * Ijrearefintbet generated by hbm2java
 */
@Entity
@Table(name = "IJREAREFINTBET")
public class Ijrearefintbet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4486767615448026136L;
	private IjrearefintbetId id;
	private Ijrearef ijrearef;
	private String nrOrdProd;

	public Ijrearefintbet() {
	}

	public Ijrearefintbet(IjrearefintbetId id, Ijrearef ijrearef,
			String nrOrdProd) {
		this.id = id;
		this.ijrearef = ijrearef;
		this.nrOrdProd = nrOrdProd;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dthrirefugo", column = @Column(name = "DTHRIREFUGO", nullable = false, length = 7)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdidentificacao", column = @Column(name = "CDIDENTIFICACAO", nullable = false, length = 1)) })
	public IjrearefintbetId getId() {
		return this.id;
	}

	public void setId(IjrearefintbetId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "DTHRIREFUGO", referencedColumnName = "DTHRIREFUGO", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDINJETORA", referencedColumnName = "CDINJETORA", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDIDENTIFICACAO", referencedColumnName = "CDIDENTIFICACAO", nullable = false, insertable = false, updatable = false) })
	public Ijrearef getIjrearef() {
		return this.ijrearef;
	}

	public void setIjrearef(Ijrearef ijrearef) {
		this.ijrearef = ijrearef;
	}

	@Column(name = "NR_ORD_PROD", nullable = false, length = 10)
	public String getNrOrdProd() {
		return this.nrOrdProd;
	}

	public void setNrOrdProd(String nrOrdProd) {
		this.nrOrdProd = nrOrdProd;
	}

}
