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
 * Ijficinj generated by hbm2java
 */
@Entity
@Table(name = "IJFICINJ")
public class Ijficinj implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177917507773179953L;
	private IjficinjId id;
	private Ijtbinj ijtbinj;
	private Ijtbitemcnc ijtbitemcnc;

	public Ijficinj() {
	}

	public Ijficinj(IjficinjId id, Ijtbinj ijtbinj, Ijtbitemcnc ijtbitemcnc) {
		this.id = id;
		this.ijtbinj = ijtbinj;
		this.ijtbitemcnc = ijtbitemcnc;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cditemcnc", column = @Column(name = "CDITEMCNC", nullable = false, length = 6)),
			@AttributeOverride(name = "posicaoordinal", column = @Column(name = "POSICAOORDINAL", nullable = false, precision = 22, scale = 0)) })
	public IjficinjId getId() {
		return this.id;
	}

	public void setId(IjficinjId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDITEMCNC", nullable = false, insertable = false, updatable = false)
	public Ijtbitemcnc getIjtbitemcnc() {
		return this.ijtbitemcnc;
	}

	public void setIjtbitemcnc(Ijtbitemcnc ijtbitemcnc) {
		this.ijtbitemcnc = ijtbitemcnc;
	}

}