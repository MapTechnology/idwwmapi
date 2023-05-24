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
 * Ijopnipponinsumo generated by hbm2java
 */
@Entity
@Table(name = "IJOPNIPPONINSUMO")
public class Ijopnipponinsumo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8557586578730737258L;
	private IjopnipponinsumoId id;
	private Ijtbmprima ijtbmprima;
	private Ijopprodutos ijopprodutos;

	public Ijopnipponinsumo() {
	}

	public Ijopnipponinsumo(IjopnipponinsumoId id, Ijtbmprima ijtbmprima,
			Ijopprodutos ijopprodutos) {
		this.id = id;
		this.ijtbmprima = ijtbmprima;
		this.ijopprodutos = ijopprodutos;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "cdmprima", column = @Column(name = "CDMPRIMA", nullable = false, length = 20)) })
	public IjopnipponinsumoId getId() {
		return this.id;
	}

	public void setId(IjopnipponinsumoId id) {
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
	@JoinColumns({
			@JoinColumn(name = "NROP", referencedColumnName = "NROP", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDPRODUTO", referencedColumnName = "CDPRODUTO", nullable = false, insertable = false, updatable = false) })
	public Ijopprodutos getIjopprodutos() {
		return this.ijopprodutos;
	}

	public void setIjopprodutos(Ijopprodutos ijopprodutos) {
		this.ijopprodutos = ijopprodutos;
	}

}
