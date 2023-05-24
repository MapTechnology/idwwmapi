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
 * Ijaleinj generated by hbm2java
 */
@Entity
@Table(name = "IJALEINJ")
public class Ijaleinj implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6248898678902330064L;
	private IjaleinjId id;
	private Ijtbinj ijtbinj;
	private Ijtbaleauto ijtbaleauto;

	public Ijaleinj() {
	}

	public Ijaleinj(IjaleinjId id, Ijtbinj ijtbinj, Ijtbaleauto ijtbaleauto) {
		this.id = id;
		this.ijtbinj = ijtbinj;
		this.ijtbaleauto = ijtbaleauto;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "idequipamento", column = @Column(name = "IDEQUIPAMENTO", nullable = false, length = 20)),
			@AttributeOverride(name = "cdalertaauto", column = @Column(name = "CDALERTAAUTO", nullable = false, length = 10)) })
	public IjaleinjId getId() {
		return this.id;
	}

	public void setId(IjaleinjId id) {
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
	@JoinColumns({
			@JoinColumn(name = "IDEQUIPAMENTO", referencedColumnName = "IDEQUIPAMENTO", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDALERTAAUTO", referencedColumnName = "CDALERTAAUTO", nullable = false, insertable = false, updatable = false) })
	public Ijtbaleauto getIjtbaleauto() {
		return this.ijtbaleauto;
	}

	public void setIjtbaleauto(Ijtbaleauto ijtbaleauto) {
		this.ijtbaleauto = ijtbaleauto;
	}

}