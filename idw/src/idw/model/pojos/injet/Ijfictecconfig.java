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
 * Ijfictecconfig generated by hbm2java
 */
@Entity
@Table(name = "IJFICTECCONFIG")
public class Ijfictecconfig implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3377068431676770744L;
	private IjfictecconfigId id;
	private Ijestmol ijestmol;
	private Ijtbinj ijtbinj;
	private double ciclopadrao;
	private char stsincronismo;

	public Ijfictecconfig() {
	}

	public Ijfictecconfig(IjfictecconfigId id, Ijestmol ijestmol,
			Ijtbinj ijtbinj, double ciclopadrao, char stsincronismo) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijtbinj = ijtbinj;
		this.ciclopadrao = ciclopadrao;
		this.stsincronismo = stsincronismo;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)) })
	public IjfictecconfigId getId() {
		return this.id;
	}

	public void setId(IjfictecconfigId id) {
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

	@Column(name = "CICLOPADRAO", nullable = false, precision = 126, scale = 0)
	public double getCiclopadrao() {
		return this.ciclopadrao;
	}

	public void setCiclopadrao(double ciclopadrao) {
		this.ciclopadrao = ciclopadrao;
	}

	@Column(name = "STSINCRONISMO", nullable = false, length = 1)
	public char getStsincronismo() {
		return this.stsincronismo;
	}

	public void setStsincronismo(char stsincronismo) {
		this.stsincronismo = stsincronismo;
	}

}