package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijtreal generated by hbm2java
 */
@Entity
@Table(name = "IJTREAL")
public class Ijtreal implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8855216930455985413L;
	private IjtrealId id;

	public Ijtreal() {
	}

	public Ijtreal(IjtrealId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dtrefturno", column = @Column(name = "DTREFTURNO", nullable = false, length = 7)),
			@AttributeOverride(name = "cdturno", column = @Column(name = "CDTURNO", nullable = false, length = 6)),
			@AttributeOverride(name = "dthriturno", column = @Column(name = "DTHRITURNO", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrfturno", column = @Column(name = "DTHRFTURNO", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrsistema", column = @Column(name = "DTHRSISTEMA", nullable = false, length = 7)) })
	public IjtrealId getId() {
		return this.id;
	}

	public void setId(IjtrealId id) {
		this.id = id;
	}

}
