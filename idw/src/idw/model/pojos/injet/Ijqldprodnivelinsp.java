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
 * Ijqldprodnivelinsp generated by hbm2java
 */
@Entity
@Table(name = "IJQLDPRODNIVELINSP")
public class Ijqldprodnivelinsp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7483019325780293754L;
	private IjqldprodnivelinspId id;
	private Ijtbpro ijtbpro;

	public Ijqldprodnivelinsp() {
	}

	public Ijqldprodnivelinsp(IjqldprodnivelinspId id, Ijtbpro ijtbpro) {
		this.id = id;
		this.ijtbpro = ijtbpro;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "tamminlote", column = @Column(name = "TAMMINLOTE", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "tammaxlote", column = @Column(name = "TAMMAXLOTE", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "tamamostra", column = @Column(name = "TAMAMOSTRA", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "nivelnormalact", column = @Column(name = "NIVELNORMALACT", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "nivelseveraact", column = @Column(name = "NIVELSEVERAACT", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "nivelinspaaplicar", column = @Column(name = "NIVELINSPAAPLICAR", nullable = false, length = 1)) })
	public IjqldprodnivelinspId getId() {
		return this.id;
	}

	public void setId(IjqldprodnivelinspId id) {
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

}