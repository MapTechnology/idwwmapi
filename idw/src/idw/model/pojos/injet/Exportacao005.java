package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Exportacao005 generated by hbm2java
 */
@Entity
@Table(name = "EXPORTACAO_005")
public class Exportacao005 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6991042410798612737L;
	private Exportacao005Id id;

	public Exportacao005() {
	}

	public Exportacao005(Exportacao005Id id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "dthriparada", column = @Column(name = "DTHRIPARADA", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrcriacaoevento", column = @Column(name = "DTHRCRIACAOEVENTO", nullable = false, length = 7)),
			@AttributeOverride(name = "stexportacao", column = @Column(name = "STEXPORTACAO", nullable = false, length = 1)),
			@AttributeOverride(name = "dthrsitexportacao", column = @Column(name = "DTHRSITEXPORTACAO", nullable = false, length = 7)) })
	public Exportacao005Id getId() {
		return this.id;
	}

	public void setId(Exportacao005Id id) {
		this.id = id;
	}

}