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
 * Ijgruusu generated by hbm2java
 */
@Entity
@Table(name = "IJGRUUSU")
public class Ijgruusu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8729494811019052286L;
	private IjgruusuId id;
	private Ijtbgru ijtbgru;
	private Ijtbusu ijtbusu;

	public Ijgruusu() {
	}

	public Ijgruusu(IjgruusuId id, Ijtbgru ijtbgru, Ijtbusu ijtbusu) {
		this.id = id;
		this.ijtbgru = ijtbgru;
		this.ijtbusu = ijtbusu;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdgrupo", column = @Column(name = "CDGRUPO", nullable = false, length = 6)),
			@AttributeOverride(name = "cdusuario", column = @Column(name = "CDUSUARIO", nullable = false, length = 6)) })
	public IjgruusuId getId() {
		return this.id;
	}

	public void setId(IjgruusuId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDGRUPO", nullable = false, insertable = false, updatable = false)
	public Ijtbgru getIjtbgru() {
		return this.ijtbgru;
	}

	public void setIjtbgru(Ijtbgru ijtbgru) {
		this.ijtbgru = ijtbgru;
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
