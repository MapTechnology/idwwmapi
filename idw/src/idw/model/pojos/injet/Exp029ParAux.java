package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Exp029ParAux generated by hbm2java
 */
@Entity
@Table(name = "EXP_029_PAR_AUX")
public class Exp029ParAux implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -53548971181546086L;
	private Exp029ParAuxId id;
	private double tempoparada;

	public Exp029ParAux() {
	}

	public Exp029ParAux(Exp029ParAuxId id, double tempoparada) {
		this.id = id;
		this.tempoparada = tempoparada;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dthriparada", column = @Column(name = "DTHRIPARADA", nullable = false, length = 7)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdparada", column = @Column(name = "CDPARADA", nullable = false, length = 6)) })
	public Exp029ParAuxId getId() {
		return this.id;
	}

	public void setId(Exp029ParAuxId id) {
		this.id = id;
	}

	@Column(name = "TEMPOPARADA", nullable = false, precision = 126, scale = 0)
	public double getTempoparada() {
		return this.tempoparada;
	}

	public void setTempoparada(double tempoparada) {
		this.tempoparada = tempoparada;
	}

}