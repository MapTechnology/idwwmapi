package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijficcnc generated by hbm2java
 */
@Entity
@Table(name = "IJFICCNC")
public class Ijficcnc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -40267293301601026L;
	private IjficcncId id;
	private Ijestmol ijestmol;
	private Ijtbinj ijtbinj;
	private Ijtbitemcnc ijtbitemcnc;
	private Double vlmindefinido;
	private Double vlmaxdefinido;
	private Double vlidealdefinido;

	public Ijficcnc() {
	}

	public Ijficcnc(IjficcncId id, Ijestmol ijestmol, Ijtbinj ijtbinj,
			Ijtbitemcnc ijtbitemcnc) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijtbinj = ijtbinj;
		this.ijtbitemcnc = ijtbitemcnc;
	}

	public Ijficcnc(IjficcncId id, Ijestmol ijestmol, Ijtbinj ijtbinj,
			Ijtbitemcnc ijtbitemcnc, Double vlmindefinido,
			Double vlmaxdefinido, Double vlidealdefinido) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijtbinj = ijtbinj;
		this.ijtbitemcnc = ijtbitemcnc;
		this.vlmindefinido = vlmindefinido;
		this.vlmaxdefinido = vlmaxdefinido;
		this.vlidealdefinido = vlidealdefinido;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "cditemcnc", column = @Column(name = "CDITEMCNC", nullable = false, length = 6)) })
	public IjficcncId getId() {
		return this.id;
	}

	public void setId(IjficcncId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA", nullable = false, insertable = false, updatable = false) })
	public Ijestmol getIjestmol() {
		return this.ijestmol;
	}

	public void setIjestmol(Ijestmol ijestmol) {
		this.ijestmol = ijestmol;
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

	@Column(name = "VLMINDEFINIDO", precision = 126, scale = 0)
	public Double getVlmindefinido() {
		return this.vlmindefinido;
	}

	public void setVlmindefinido(Double vlmindefinido) {
		this.vlmindefinido = vlmindefinido;
	}

	@Column(name = "VLMAXDEFINIDO", precision = 126, scale = 0)
	public Double getVlmaxdefinido() {
		return this.vlmaxdefinido;
	}

	public void setVlmaxdefinido(Double vlmaxdefinido) {
		this.vlmaxdefinido = vlmaxdefinido;
	}

	@Column(name = "VLIDEALDEFINIDO", precision = 126, scale = 0)
	public Double getVlidealdefinido() {
		return this.vlidealdefinido;
	}

	public void setVlidealdefinido(Double vlidealdefinido) {
		this.vlidealdefinido = vlidealdefinido;
	}

}
