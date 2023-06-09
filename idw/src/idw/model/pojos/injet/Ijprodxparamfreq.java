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
 * Ijprodxparamfreq generated by hbm2java
 */
@Entity
@Table(name = "IJPRODXPARAMFREQ")
public class Ijprodxparamfreq implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4661276284725739318L;
	private IjprodxparamfreqId id;
	private Ijprodxgrpparam ijprodxgrpparam;

	public Ijprodxparamfreq() {
	}

	public Ijprodxparamfreq(IjprodxparamfreqId id,
			Ijprodxgrpparam ijprodxgrpparam) {
		this.id = id;
		this.ijprodxgrpparam = ijprodxgrpparam;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "cdgrpparam", column = @Column(name = "CDGRPPARAM", nullable = false, length = 6)),
			@AttributeOverride(name = "vlreferencia", column = @Column(name = "VLREFERENCIA", nullable = false, precision = 126, scale = 0)) })
	public IjprodxparamfreqId getId() {
		return this.id;
	}

	public void setId(IjprodxparamfreqId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDPRODUTO", referencedColumnName = "CDPRODUTO", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDGRPPARAM", referencedColumnName = "CDGRPPARAM", nullable = false, insertable = false, updatable = false) })
	public Ijprodxgrpparam getIjprodxgrpparam() {
		return this.ijprodxgrpparam;
	}

	public void setIjprodxgrpparam(Ijprodxgrpparam ijprodxgrpparam) {
		this.ijprodxgrpparam = ijprodxgrpparam;
	}

}
