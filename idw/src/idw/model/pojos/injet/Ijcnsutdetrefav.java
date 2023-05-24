package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijcnsutdetrefav generated by hbm2java
 */
@Entity
@Table(name = "IJCNSUTDETREFAV")
public class Ijcnsutdetrefav implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7802461908719218541L;
	private IjcnsutdetrefavId id;
	private Double qtpcsref;

	public Ijcnsutdetrefav() {
	}

	public Ijcnsutdetrefav(IjcnsutdetrefavId id) {
		this.id = id;
	}

	public Ijcnsutdetrefav(IjcnsutdetrefavId id, Double qtpcsref) {
		this.id = id;
		this.qtpcsref = qtpcsref;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dthriniintervalo", column = @Column(name = "DTHRINIINTERVALO", nullable = false, length = 7)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "dthrivalestru", column = @Column(name = "DTHRIVALESTRU", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrivalcic", column = @Column(name = "DTHRIVALCIC", nullable = false, length = 7)),
			@AttributeOverride(name = "cdidentificacao", column = @Column(name = "CDIDENTIFICACAO", nullable = false, length = 1)) })
	public IjcnsutdetrefavId getId() {
		return this.id;
	}

	public void setId(IjcnsutdetrefavId id) {
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