package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Ijreaparcnstur generated by hbm2java
 */
@Entity
@Table(name = "IJREAPARCNSTUR", uniqueConstraints = @UniqueConstraint(columnNames = {
		"DTTURNO", "CDTURNO", "CDINJETORA", "CDMOLDE", "CDESTRUTURA",
		"DTHRIVALESTRU", "DTHRIVALCIC", "NROP", "CDPARADA" }))
public class Ijreaparcnstur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1653402135143528925L;
	private IjreaparcnsturId id;

	public Ijreaparcnstur() {
	}

	public Ijreaparcnstur(IjreaparcnsturId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "dtturno", column = @Column(name = "DTTURNO", nullable = false, length = 7)),
			@AttributeOverride(name = "cdturno", column = @Column(name = "CDTURNO", nullable = false, length = 6)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "dthrivalestru", column = @Column(name = "DTHRIVALESTRU", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrivalcic", column = @Column(name = "DTHRIVALCIC", nullable = false, length = 7)),
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdparada", column = @Column(name = "CDPARADA", nullable = false, length = 6)),
			@AttributeOverride(name = "tmpparadas", column = @Column(name = "TMPPARADAS", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "qtdparadas", column = @Column(name = "QTDPARADAS", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "tmpparadassempeso", column = @Column(name = "TMPPARADASSEMPESO", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "qtdparadassempeso", column = @Column(name = "QTDPARADASSEMPESO", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "tmpparadaprep", column = @Column(name = "TMPPARADAPREP", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "qtdparadaprep", column = @Column(name = "QTDPARADAPREP", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "tmpparprev", column = @Column(name = "TMPPARPREV", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "tmpparnaoprev", column = @Column(name = "TMPPARNAOPREV", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "tmppcta", column = @Column(name = "TMPPCTA", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "tmppao", column = @Column(name = "TMPPAO", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "tmppa", column = @Column(name = "TMPPA", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "tmpptp", column = @Column(name = "TMPPTP", nullable = false, precision = 126, scale = 0)) })
	public IjreaparcnsturId getId() {
		return this.id;
	}

	public void setId(IjreaparcnsturId id) {
		this.id = id;
	}

}
