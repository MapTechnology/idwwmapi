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
 * Ijmdoalocop generated by hbm2java
 */
@Entity
@Table(name = "IJMDOALOCOP")
public class Ijmdoalocop implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2183111725115872853L;
	private IjmdoalocopId id;
	private Ijop ijop;
	private Ijmdoaloc ijmdoaloc;

	public Ijmdoalocop() {
	}

	public Ijmdoalocop(IjmdoalocopId id, Ijop ijop, Ijmdoaloc ijmdoaloc) {
		this.id = id;
		this.ijop = ijop;
		this.ijmdoaloc = ijmdoaloc;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "idmdoaloc", column = @Column(name = "IDMDOALOC", nullable = false, length = 12)) })
	public IjmdoalocopId getId() {
		return this.id;
	}

	public void setId(IjmdoalocopId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROP", nullable = false, insertable = false, updatable = false)
	public Ijop getIjop() {
		return this.ijop;
	}

	public void setIjop(Ijop ijop) {
		this.ijop = ijop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDMDOALOC", nullable = false, insertable = false, updatable = false)
	public Ijmdoaloc getIjmdoaloc() {
		return this.ijmdoaloc;
	}

	public void setIjmdoaloc(Ijmdoaloc ijmdoaloc) {
		this.ijmdoaloc = ijmdoaloc;
	}

}
