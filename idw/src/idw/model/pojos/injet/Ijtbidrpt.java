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
 * Ijtbidrpt generated by hbm2java
 */
@Entity
@Table(name = "IJTBIDRPT")
public class Ijtbidrpt implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1830471674138870762L;
	private IjtbidrptId id;
	private Ijtbmodulos ijtbmodulos;
	private String cdrpt;

	public Ijtbidrpt() {
	}

	public Ijtbidrpt(IjtbidrptId id, Ijtbmodulos ijtbmodulos, String cdrpt) {
		this.id = id;
		this.ijtbmodulos = ijtbmodulos;
		this.cdrpt = cdrpt;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdmodulo", column = @Column(name = "CDMODULO", nullable = false, length = 6)),
			@AttributeOverride(name = "nmform", column = @Column(name = "NMFORM", nullable = false, length = 40)),
			@AttributeOverride(name = "nmmenurpt", column = @Column(name = "NMMENURPT", nullable = false, length = 40)) })
	public IjtbidrptId getId() {
		return this.id;
	}

	public void setId(IjtbidrptId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDMODULO", nullable = false, insertable = false, updatable = false)
	public Ijtbmodulos getIjtbmodulos() {
		return this.ijtbmodulos;
	}

	public void setIjtbmodulos(Ijtbmodulos ijtbmodulos) {
		this.ijtbmodulos = ijtbmodulos;
	}

	@Column(name = "CDRPT", nullable = false, length = 6)
	public String getCdrpt() {
		return this.cdrpt;
	}

	public void setCdrpt(String cdrpt) {
		this.cdrpt = cdrpt;
	}

}
