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
 * Ijbroneproseccomp generated by hbm2java
 */
@Entity
@Table(name = "IJBRONEPROSECCOMP")
public class Ijbroneproseccomp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1190585684808577609L;
	private IjbroneproseccompId id;
	private Ijtbmprima ijtbmprima;
	private Ijtbpro ijtbpro;
	private double quantidade;

	public Ijbroneproseccomp() {
	}

	public Ijbroneproseccomp(IjbroneproseccompId id, Ijtbmprima ijtbmprima,
			Ijtbpro ijtbpro, double quantidade) {
		this.id = id;
		this.ijtbmprima = ijtbmprima;
		this.ijtbpro = ijtbpro;
		this.quantidade = quantidade;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdprodutocomp", column = @Column(name = "CDPRODUTOCOMP", nullable = false, length = 20)),
			@AttributeOverride(name = "cdmprima", column = @Column(name = "CDMPRIMA", nullable = false, length = 20)),
			@AttributeOverride(name = "dthrinicomp", column = @Column(name = "DTHRINICOMP", nullable = false, length = 7)) })
	public IjbroneproseccompId getId() {
		return this.id;
	}

	public void setId(IjbroneproseccompId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDMPRIMA", nullable = false, insertable = false, updatable = false)
	public Ijtbmprima getIjtbmprima() {
		return this.ijtbmprima;
	}

	public void setIjtbmprima(Ijtbmprima ijtbmprima) {
		this.ijtbmprima = ijtbmprima;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDPRODUTOCOMP", nullable = false, insertable = false, updatable = false)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

	@Column(name = "QUANTIDADE", nullable = false, precision = 126, scale = 0)
	public double getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

}
