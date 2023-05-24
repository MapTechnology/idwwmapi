package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Exportacao011 generated by hbm2java
 */
@Entity
@Table(name = "EXPORTACAO_011")
public class Exportacao011 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5745911161969787283L;
	private Exportacao011Id id;

	public Exportacao011() {
	}

	public Exportacao011(Exportacao011Id id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "dtturno", column = @Column(name = "DTTURNO", nullable = false, length = 7)),
			@AttributeOverride(name = "cdturno", column = @Column(name = "CDTURNO", nullable = false, length = 6)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdoperador", column = @Column(name = "CDOPERADOR", length = 6)),
			@AttributeOverride(name = "cdparada", column = @Column(name = "CDPARADA", nullable = false, length = 6)),
			@AttributeOverride(name = "dthrinipar", column = @Column(name = "DTHRINIPAR", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrfimpar", column = @Column(name = "DTHRFIMPAR", nullable = false, length = 7)),
			@AttributeOverride(name = "duracao", column = @Column(name = "DURACAO", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "stpar", column = @Column(name = "STPAR", nullable = false, length = 1)),
			@AttributeOverride(name = "dthrcriacao", column = @Column(name = "DTHRCRIACAO", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrleitura", column = @Column(name = "DTHRLEITURA", length = 7)),
			@AttributeOverride(name = "stexportacao", column = @Column(name = "STEXPORTACAO", nullable = false, length = 1)) })
	public Exportacao011Id getId() {
		return this.id;
	}

	public void setId(Exportacao011Id id) {
		this.id = id;
	}

}