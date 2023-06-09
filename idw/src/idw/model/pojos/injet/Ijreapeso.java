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
 * Ijreapeso generated by hbm2java
 */
@Entity
@Table(name = "IJREAPESO")
public class Ijreapeso implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5018349840698595659L;
	private IjreapesoId id;
	private Ijop ijop;
	private Ijtbinj ijtbinj;
	private Ijmolpro ijmolpro;
	private double pesolido;

	public Ijreapeso() {
	}

	public Ijreapeso(IjreapesoId id, Ijop ijop, Ijtbinj ijtbinj,
			Ijmolpro ijmolpro, double pesolido) {
		this.id = id;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.ijmolpro = ijmolpro;
		this.pesolido = pesolido;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "dthrpesagem", column = @Column(name = "DTHRPESAGEM", nullable = false, length = 7)) })
	public IjreapesoId getId() {
		return this.id;
	}

	public void setId(IjreapesoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROP", nullable = false)
	public Ijop getIjop() {
		return this.ijop;
	}

	public void setIjop(Ijop ijop) {
		this.ijop = ijop;
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
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE", nullable = false),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA", nullable = false),
			@JoinColumn(name = "CDPRODUTO", referencedColumnName = "CDPRODUTO", nullable = false),
			@JoinColumn(name = "DTHRIVAL", referencedColumnName = "DTHRIVAL", nullable = false) })
	public Ijmolpro getIjmolpro() {
		return this.ijmolpro;
	}

	public void setIjmolpro(Ijmolpro ijmolpro) {
		this.ijmolpro = ijmolpro;
	}

	@Column(name = "PESOLIDO", nullable = false, precision = 126, scale = 0)
	public double getPesolido() {
		return this.pesolido;
	}

	public void setPesolido(double pesolido) {
		this.pesolido = pesolido;
	}

}
