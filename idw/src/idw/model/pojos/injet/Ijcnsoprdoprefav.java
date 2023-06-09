package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijcnsoprdoprefav generated by hbm2java
 */
@Entity
@Table(name = "IJCNSOPRDOPREFAV")
public class Ijcnsoprdoprefav implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 519226561305053295L;
	private IjcnsoprdoprefavId id;
	private Double qtpcsref;

	public Ijcnsoprdoprefav() {
	}

	public Ijcnsoprdoprefav(IjcnsoprdoprefavId id) {
		this.id = id;
	}

	public Ijcnsoprdoprefav(IjcnsoprdoprefavId id, Double qtpcsref) {
		this.id = id;
		this.qtpcsref = qtpcsref;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "cdoperador", column = @Column(name = "CDOPERADOR", nullable = false, length = 6)),
			@AttributeOverride(name = "dthrivalestru", column = @Column(name = "DTHRIVALESTRU", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrivalcic", column = @Column(name = "DTHRIVALCIC", nullable = false, length = 7)),
			@AttributeOverride(name = "cdidentificacao", column = @Column(name = "CDIDENTIFICACAO", nullable = false, length = 1)) })
	public IjcnsoprdoprefavId getId() {
		return this.id;
	}

	public void setId(IjcnsoprdoprefavId id) {
		this.id = id;
	}

	@Column(name = "QTPCSREF", precision = 126, scale = 0)
	public Double getQtpcsref() {
		return this.qtpcsref;
	}

	public void setQtpcsref(Double qtpcsref) {
		this.qtpcsref = qtpcsref;
	}

}
