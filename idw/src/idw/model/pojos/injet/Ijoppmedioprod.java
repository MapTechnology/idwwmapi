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
 * Ijoppmedioprod generated by hbm2java
 */
@Entity
@Table(name = "IJOPPMEDIOPROD")
public class Ijoppmedioprod implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2029859753720495662L;
	private IjoppmedioprodId id;
	private Ijop ijop;
	private Ijtbpro ijtbpro;
	private double pesolidoacum;
	private double qtpesoslidos;

	public Ijoppmedioprod() {
	}

	public Ijoppmedioprod(IjoppmedioprodId id, Ijop ijop, Ijtbpro ijtbpro,
			double pesolidoacum, double qtpesoslidos) {
		this.id = id;
		this.ijop = ijop;
		this.ijtbpro = ijtbpro;
		this.pesolidoacum = pesolidoacum;
		this.qtpesoslidos = qtpesoslidos;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)) })
	public IjoppmedioprodId getId() {
		return this.id;
	}

	public void setId(IjoppmedioprodId id) {
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
	@JoinColumn(name = "CDPRODUTO", nullable = false, insertable = false, updatable = false)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

	@Column(name = "PESOLIDOACUM", nullable = false, precision = 126, scale = 0)
	public double getPesolidoacum() {
		return this.pesolidoacum;
	}

	public void setPesolidoacum(double pesolidoacum) {
		this.pesolidoacum = pesolidoacum;
	}

	@Column(name = "QTPESOSLIDOS", nullable = false, precision = 126, scale = 0)
	public double getQtpesoslidos() {
		return this.qtpesoslidos;
	}

	public void setQtpesoslidos(double qtpesoslidos) {
		this.qtpesoslidos = qtpesoslidos;
	}

}
