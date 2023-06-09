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
 * Ijprodxfreq generated by hbm2java
 */
@Entity
@Table(name = "IJPRODXFREQ")
public class Ijprodxfreq implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8790362129623984562L;
	private IjprodxfreqId id;
	private Ijprodinspfreq ijprodinspfreq;

	public Ijprodxfreq() {
	}

	public Ijprodxfreq(IjprodxfreqId id, Ijprodinspfreq ijprodinspfreq) {
		this.id = id;
		this.ijprodinspfreq = ijprodinspfreq;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "vlreferencia", column = @Column(name = "VLREFERENCIA", nullable = false, precision = 126, scale = 0)) })
	public IjprodxfreqId getId() {
		return this.id;
	}

	public void setId(IjprodxfreqId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDPRODUTO", nullable = false, insertable = false, updatable = false)
	public Ijprodinspfreq getIjprodinspfreq() {
		return this.ijprodinspfreq;
	}

	public void setIjprodinspfreq(Ijprodinspfreq ijprodinspfreq) {
		this.ijprodinspfreq = ijprodinspfreq;
	}

}
