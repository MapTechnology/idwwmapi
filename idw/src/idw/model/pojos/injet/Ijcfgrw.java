package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijcfgrw generated by hbm2java
 */
@Entity
@Table(name = "IJCFGRW")
public class Ijcfgrw implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6841099698040726276L;
	private IjcfgrwId id;

	public Ijcfgrw() {
	}

	public Ijcfgrw(IjcfgrwId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "qtdmaxhrssemana", column = @Column(name = "QTDMAXHRSSEMANA", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "qtdmediahrssemana", column = @Column(name = "QTDMEDIAHRSSEMANA", nullable = false, precision = 126, scale = 0)) })
	public IjcfgrwId getId() {
		return this.id;
	}

	public void setId(IjcfgrwId id) {
		this.id = id;
	}

}