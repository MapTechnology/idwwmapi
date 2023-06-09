package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijtbfablog generated by hbm2java
 */
@Entity
@Table(name = "IJTBFABLOG")
public class Ijtbfablog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6196325262459095669L;
	private IjtbfablogId id;

	public Ijtbfablog() {
	}

	public Ijtbfablog(IjtbfablogId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdfabricante", column = @Column(name = "CDFABRICANTE", nullable = false, length = 6)),
			@AttributeOverride(name = "dsfabricante", column = @Column(name = "DSFABRICANTE", length = 40)),
			@AttributeOverride(name = "dthrmanut", column = @Column(name = "DTHRMANUT", nullable = false, length = 7)),
			@AttributeOverride(name = "tpmanut", column = @Column(name = "TPMANUT", nullable = false, length = 1)),
			@AttributeOverride(name = "cdusuresp", column = @Column(name = "CDUSURESP", nullable = false, length = 6)) })
	public IjtbfablogId getId() {
		return this.id;
	}

	public void setId(IjtbfablogId id) {
		this.id = id;
	}

}
