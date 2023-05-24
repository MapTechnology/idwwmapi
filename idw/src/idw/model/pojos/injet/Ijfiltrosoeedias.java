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
 * Ijfiltrosoeedias generated by hbm2java
 */
@Entity
@Table(name = "IJFILTROSOEEDIAS")
public class Ijfiltrosoeedias implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2092262251529303190L;
	private IjfiltrosoeediasId id;
	private Ijfiltrosoee ijfiltrosoee;
	private double hrsciccomp;
	private double hrscicincomp;
	private double hrsparpeso;
	private double hrsctt;
	private double hrsrefugo;
	private double hrsritmo;
	private double hrsperdacav;

	public Ijfiltrosoeedias() {
	}

	public Ijfiltrosoeedias(IjfiltrosoeediasId id, Ijfiltrosoee ijfiltrosoee,
			double hrsciccomp, double hrscicincomp, double hrsparpeso,
			double hrsctt, double hrsrefugo, double hrsritmo, double hrsperdacav) {
		this.id = id;
		this.ijfiltrosoee = ijfiltrosoee;
		this.hrsciccomp = hrsciccomp;
		this.hrscicincomp = hrscicincomp;
		this.hrsparpeso = hrsparpeso;
		this.hrsctt = hrsctt;
		this.hrsrefugo = hrsrefugo;
		this.hrsritmo = hrsritmo;
		this.hrsperdacav = hrsperdacav;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idfiltrooee", column = @Column(name = "IDFILTROOEE", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "dataoee", column = @Column(name = "DATAOEE", nullable = false, length = 7)) })
	public IjfiltrosoeediasId getId() {
		return this.id;
	}

	public void setId(IjfiltrosoeediasId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDFILTROOEE", nullable = false, insertable = false, updatable = false)
	public Ijfiltrosoee getIjfiltrosoee() {
		return this.ijfiltrosoee;
	}

	public void setIjfiltrosoee(Ijfiltrosoee ijfiltrosoee) {
		this.ijfiltrosoee = ijfiltrosoee;
	}

	@Column(name = "HRSCICCOMP", nullable = false, precision = 126, scale = 0)
	public double getHrsciccomp() {
		return this.hrsciccomp;
	}

	public void setHrsciccomp(double hrsciccomp) {
		this.hrsciccomp = hrsciccomp;
	}

	@Column(name = "HRSCICINCOMP", nullable = false, precision = 126, scale = 0)
	public double getHrscicincomp() {
		return this.hrscicincomp;
	}

	public void setHrscicincomp(double hrscicincomp) {
		this.hrscicincomp = hrscicincomp;
	}

	@Column(name = "HRSPARPESO", nullable = false, precision = 126, scale = 0)
	public double getHrsparpeso() {
		return this.hrsparpeso;
	}

	public void setHrsparpeso(double hrsparpeso) {
		this.hrsparpeso = hrsparpeso;
	}

	@Column(name = "HRSCTT", nullable = false, precision = 126, scale = 0)
	public double getHrsctt() {
		return this.hrsctt;
	}

	public void setHrsctt(double hrsctt) {
		this.hrsctt = hrsctt;
	}

	@Column(name = "HRSREFUGO", nullable = false, precision = 126, scale = 0)
	public double getHrsrefugo() {
		return this.hrsrefugo;
	}

	public void setHrsrefugo(double hrsrefugo) {
		this.hrsrefugo = hrsrefugo;
	}

	@Column(name = "HRSRITMO", nullable = false, precision = 126, scale = 0)
	public double getHrsritmo() {
		return this.hrsritmo;
	}

	public void setHrsritmo(double hrsritmo) {
		this.hrsritmo = hrsritmo;
	}

	@Column(name = "HRSPERDACAV", nullable = false, precision = 126, scale = 0)
	public double getHrsperdacav() {
		return this.hrsperdacav;
	}

	public void setHrsperdacav(double hrsperdacav) {
		this.hrsperdacav = hrsperdacav;
	}

}