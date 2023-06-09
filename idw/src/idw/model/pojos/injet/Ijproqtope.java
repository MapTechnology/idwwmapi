package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

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
 * Ijproqtope generated by hbm2java
 */
@Entity
@Table(name = "IJPROQTOPE")
public class Ijproqtope implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6932352408056924055L;
	private IjproqtopeId id;
	private Ijtbinj ijtbinj;
	private Ijtbpro ijtbpro;
	private BigDecimal qtope;

	public Ijproqtope() {
	}

	public Ijproqtope(IjproqtopeId id, Ijtbinj ijtbinj, Ijtbpro ijtbpro,
			BigDecimal qtope) {
		this.id = id;
		this.ijtbinj = ijtbinj;
		this.ijtbpro = ijtbpro;
		this.qtope = qtope;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)) })
	public IjproqtopeId getId() {
		return this.id;
	}

	public void setId(IjproqtopeId id) {
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
	@JoinColumn(name = "CDPRODUTO", nullable = false, insertable = false, updatable = false)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

	@Column(name = "QTOPE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtope() {
		return this.qtope;
	}

	public void setQtope(BigDecimal qtope) {
		this.qtope = qtope;
	}

}
