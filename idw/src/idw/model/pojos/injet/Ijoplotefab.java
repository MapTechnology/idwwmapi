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
 * Ijoplotefab generated by hbm2java
 */
@Entity
@Table(name = "IJOPLOTEFAB")
public class Ijoplotefab implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6968754401736422143L;
	private IjoplotefabId id;
	private Ijop ijop;
	private double qtplanejada;

	public Ijoplotefab() {
	}

	public Ijoplotefab(IjoplotefabId id, Ijop ijop, double qtplanejada) {
		this.id = id;
		this.ijop = ijop;
		this.qtplanejada = qtplanejada;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "nrlotefabricacao", column = @Column(name = "NRLOTEFABRICACAO", nullable = false, length = 20)) })
	public IjoplotefabId getId() {
		return this.id;
	}

	public void setId(IjoplotefabId id) {
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

	@Column(name = "QTPLANEJADA", nullable = false, precision = 126, scale = 0)
	public double getQtplanejada() {
		return this.qtplanejada;
	}

	public void setQtplanejada(double qtplanejada) {
		this.qtplanejada = qtplanejada;
	}

}
