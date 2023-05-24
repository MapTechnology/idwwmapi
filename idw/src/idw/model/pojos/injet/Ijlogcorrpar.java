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
 * Ijlogcorrpar generated by hbm2java
 */
@Entity
@Table(name = "IJLOGCORRPAR")
public class Ijlogcorrpar implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4597170210732466812L;
	private IjlogcorrparId id;
	private Ijtbinj ijtbinj;
	private Ijtbusu ijtbusu;

	public Ijlogcorrpar() {
	}

	public Ijlogcorrpar(IjlogcorrparId id, Ijtbinj ijtbinj, Ijtbusu ijtbusu) {
		this.id = id;
		this.ijtbinj = ijtbinj;
		this.ijtbusu = ijtbusu;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdusuario", column = @Column(name = "CDUSUARIO", nullable = false, length = 6)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "dthriparada", column = @Column(name = "DTHRIPARADA", nullable = false, length = 7)),
			@AttributeOverride(name = "dthralteracao", column = @Column(name = "DTHRALTERACAO", nullable = false, length = 7)) })
	public IjlogcorrparId getId() {
		return this.id;
	}

	public void setId(IjlogcorrparId id) {
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
	@JoinColumn(name = "CDUSUARIO", nullable = false, insertable = false, updatable = false)
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

}