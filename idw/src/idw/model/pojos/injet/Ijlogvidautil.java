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
 * Ijlogvidautil generated by hbm2java
 */
@Entity
@Table(name = "IJLOGVIDAUTIL")
public class Ijlogvidautil implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6791683799337980057L;
	private IjlogvidautilId id;
	private Ijtbusu ijtbusu;
	private Ijtbmol ijtbmol;

	public Ijlogvidautil() {
	}

	public Ijlogvidautil(IjlogvidautilId id, Ijtbusu ijtbusu) {
		this.id = id;
		this.ijtbusu = ijtbusu;
	}

	public Ijlogvidautil(IjlogvidautilId id, Ijtbusu ijtbusu, Ijtbmol ijtbmol) {
		this.id = id;
		this.ijtbusu = ijtbusu;
		this.ijtbmol = ijtbmol;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", length = 6)),
			@AttributeOverride(name = "dthralteracao", column = @Column(name = "DTHRALTERACAO", nullable = false, length = 7)),
			@AttributeOverride(name = "vidautil", column = @Column(name = "VIDAUTIL", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "percalevidautil", column = @Column(name = "PERCALEVIDAUTIL", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "qttotcicexec", column = @Column(name = "QTTOTCICEXEC", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "cdusualterou", column = @Column(name = "CDUSUALTEROU", nullable = false, length = 6)),
			@AttributeOverride(name = "justaltvidautil", column = @Column(name = "JUSTALTVIDAUTIL", nullable = false, length = 200)) })
	public IjlogvidautilId getId() {
		return this.id;
	}

	public void setId(IjlogvidautilId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUALTEROU", nullable = false, insertable = false, updatable = false)
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDMOLDE", insertable = false, updatable = false)
	public Ijtbmol getIjtbmol() {
		return this.ijtbmol;
	}

	public void setIjtbmol(Ijtbmol ijtbmol) {
		this.ijtbmol = ijtbmol;
	}

}