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
 * Ijenglogciclos generated by hbm2java
 */
@Entity
@Table(name = "IJENGLOGCICLOS")
public class Ijenglogciclos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7242733070229143225L;
	private IjenglogciclosId id;
	private Ijestmol ijestmol;
	private Ijtbinj ijtbinj;
	private Ijtbusu ijtbusu;

	public Ijenglogciclos() {
	}

	public Ijenglogciclos(IjenglogciclosId id) {
		this.id = id;
	}

	public Ijenglogciclos(IjenglogciclosId id, Ijestmol ijestmol,
			Ijtbinj ijtbinj, Ijtbusu ijtbusu) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijtbinj = ijtbinj;
		this.ijtbusu = ijtbusu;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", length = 6)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", length = 4)),
			@AttributeOverride(name = "cicloanterior", column = @Column(name = "CICLOANTERIOR", precision = 126, scale = 0)),
			@AttributeOverride(name = "ciclonovo", column = @Column(name = "CICLONOVO", precision = 126, scale = 0)),
			@AttributeOverride(name = "dthralteracao", column = @Column(name = "DTHRALTERACAO", length = 7)),
			@AttributeOverride(name = "cdusuario", column = @Column(name = "CDUSUARIO", length = 6)),
			@AttributeOverride(name = "observacao", column = @Column(name = "OBSERVACAO", length = 250)),
			@AttributeOverride(name = "tipoalteracao", column = @Column(name = "TIPOALTERACAO", length = 1)),
			@AttributeOverride(name = "anteriorvarmin", column = @Column(name = "ANTERIORVARMIN", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "anteriorvarmax", column = @Column(name = "ANTERIORVARMAX", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "novovarmin", column = @Column(name = "NOVOVARMIN", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "novovarmax", column = @Column(name = "NOVOVARMAX", nullable = false, precision = 126, scale = 0)) })
	public IjenglogciclosId getId() {
		return this.id;
	}

	public void setId(IjenglogciclosId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE", insertable = false, updatable = false),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA", insertable = false, updatable = false) })
	public Ijestmol getIjestmol() {
		return this.ijestmol;
	}

	public void setIjestmol(Ijestmol ijestmol) {
		this.ijestmol = ijestmol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUARIO", insertable = false, updatable = false)
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

}
