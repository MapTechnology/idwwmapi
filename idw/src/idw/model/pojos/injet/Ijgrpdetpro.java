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
import javax.persistence.UniqueConstraint;

/**
 * Ijgrpdetpro generated by hbm2java
 */
@Entity
@Table(name = "IJGRPDETPRO", uniqueConstraints = @UniqueConstraint(columnNames = "CDPRODUTO"))
public class Ijgrpdetpro implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8547244264212064418L;
	private IjgrpdetproId id;
	private Ijtbpro ijtbpro;
	private Ijgrppro ijgrppro;

	public Ijgrpdetpro() {
	}

	public Ijgrpdetpro(IjgrpdetproId id, Ijtbpro ijtbpro, Ijgrppro ijgrppro) {
		this.id = id;
		this.ijtbpro = ijtbpro;
		this.ijgrppro = ijgrppro;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdgrppro", column = @Column(name = "CDGRPPRO", nullable = false, length = 6)),
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", unique = true, nullable = false, length = 20)) })
	public IjgrpdetproId getId() {
		return this.id;
	}

	public void setId(IjgrpdetproId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDPRODUTO", unique = true, nullable = false, insertable = false, updatable = false)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDGRPPRO", nullable = false, insertable = false, updatable = false)
	public Ijgrppro getIjgrppro() {
		return this.ijgrppro;
	}

	public void setIjgrppro(Ijgrppro ijgrppro) {
		this.ijgrppro = ijgrppro;
	}

}