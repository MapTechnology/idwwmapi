package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijcfgmodulomanut generated by hbm2java
 */
@Entity
@Table(name = "IJCFGMODULOMANUT")
public class Ijcfgmodulomanut implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3096653564594454817L;
	private IjcfgmodulomanutId id;

	public Ijcfgmodulomanut() {
	}

	public Ijcfgmodulomanut(IjcfgmodulomanutId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "metamanutcorr", column = @Column(name = "METAMANUTCORR", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "bloqreccomalerta", column = @Column(name = "BLOQRECCOMALERTA", nullable = false, precision = 22, scale = 0)) })
	public IjcfgmodulomanutId getId() {
		return this.id;
	}

	public void setId(IjcfgmodulomanutId id) {
		this.id = id;
	}

}
