package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Exportacao009 generated by hbm2java
 */
@Entity
@Table(name = "EXPORTACAO_009")
public class Exportacao009 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4967314905163077332L;
	private Exportacao009Id id;

	public Exportacao009() {
	}

	public Exportacao009(Exportacao009Id id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "dthriniplan", column = @Column(name = "DTHRINIPLAN", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrfimplan", column = @Column(name = "DTHRFIMPLAN", nullable = false, length = 7)),
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "qtplan", column = @Column(name = "QTPLAN", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "stop", column = @Column(name = "STOP", nullable = false, length = 1)),
			@AttributeOverride(name = "dthrcriacao", column = @Column(name = "DTHRCRIACAO", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrleitura", column = @Column(name = "DTHRLEITURA", length = 7)),
			@AttributeOverride(name = "stexportacao", column = @Column(name = "STEXPORTACAO", nullable = false, length = 1)) })
	public Exportacao009Id getId() {
		return this.id;
	}

	public void setId(Exportacao009Id id) {
		this.id = id;
	}

}
