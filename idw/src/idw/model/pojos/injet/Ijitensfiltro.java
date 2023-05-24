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
 * Ijitensfiltro generated by hbm2java
 */
@Entity
@Table(name = "IJITENSFILTRO")
public class Ijitensfiltro implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7546946815789396166L;
	private IjitensfiltroId id;
	private Ijtbtipofiltro ijtbtipofiltro;
	private Ijfiltroitensmen ijfiltroitensmen;

	public Ijitensfiltro() {
	}

	public Ijitensfiltro(IjitensfiltroId id, Ijtbtipofiltro ijtbtipofiltro,
			Ijfiltroitensmen ijfiltroitensmen) {
		this.id = id;
		this.ijtbtipofiltro = ijtbtipofiltro;
		this.ijfiltroitensmen = ijfiltroitensmen;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdfiltroitensmen", column = @Column(name = "CDFILTROITENSMEN", nullable = false, length = 6)),
			@AttributeOverride(name = "cdtipofiltro", column = @Column(name = "CDTIPOFILTRO", nullable = false, length = 6)),
			@AttributeOverride(name = "itemsel", column = @Column(name = "ITEMSEL", nullable = false, length = 6)) })
	public IjitensfiltroId getId() {
		return this.id;
	}

	public void setId(IjitensfiltroId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDTIPOFILTRO", nullable = false, insertable = false, updatable = false)
	public Ijtbtipofiltro getIjtbtipofiltro() {
		return this.ijtbtipofiltro;
	}

	public void setIjtbtipofiltro(Ijtbtipofiltro ijtbtipofiltro) {
		this.ijtbtipofiltro = ijtbtipofiltro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDFILTROITENSMEN", nullable = false, insertable = false, updatable = false)
	public Ijfiltroitensmen getIjfiltroitensmen() {
		return this.ijfiltroitensmen;
	}

	public void setIjfiltroitensmen(Ijfiltroitensmen ijfiltroitensmen) {
		this.ijfiltroitensmen = ijfiltroitensmen;
	}

}