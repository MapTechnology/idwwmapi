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
 * Ijroteiroprod generated by hbm2java
 */
@Entity
@Table(name = "IJROTEIROPROD")
public class Ijroteiroprod implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4999858242088006518L;
	private IjroteiroprodId id;
	private Ijtbpro ijtbpro;
	private Ijtboperacoes ijtboperacoes;

	public Ijroteiroprod() {
	}

	public Ijroteiroprod(IjroteiroprodId id, Ijtbpro ijtbpro,
			Ijtboperacoes ijtboperacoes) {
		this.id = id;
		this.ijtbpro = ijtbpro;
		this.ijtboperacoes = ijtboperacoes;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "estagio", column = @Column(name = "ESTAGIO", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "cdoperacao", column = @Column(name = "CDOPERACAO", nullable = false, length = 6)) })
	public IjroteiroprodId getId() {
		return this.id;
	}

	public void setId(IjroteiroprodId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDPRODUTO", nullable = false, insertable = false, updatable = false)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDOPERACAO", nullable = false, insertable = false, updatable = false)
	public Ijtboperacoes getIjtboperacoes() {
		return this.ijtboperacoes;
	}

	public void setIjtboperacoes(Ijtboperacoes ijtboperacoes) {
		this.ijtboperacoes = ijtboperacoes;
	}

}
