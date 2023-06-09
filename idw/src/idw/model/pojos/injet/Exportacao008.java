package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Exportacao008 generated by hbm2java
 */
@Entity
@Table(name = "EXPORTACAO_008")
public class Exportacao008 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3278322478848773788L;
	private Exportacao008Id id;

	public Exportacao008() {
	}

	public Exportacao008(Exportacao008Id id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "qtdproduzida", column = @Column(name = "QTDPRODUZIDA", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "qtdrefugada", column = @Column(name = "QTDREFUGADA", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "status", column = @Column(name = "STATUS", nullable = false, length = 1)),
			@AttributeOverride(name = "dthrcriacao", column = @Column(name = "DTHRCRIACAO", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrleitura", column = @Column(name = "DTHRLEITURA", length = 7)) })
	public Exportacao008Id getId() {
		return this.id;
	}

	public void setId(Exportacao008Id id) {
		this.id = id;
	}

}
