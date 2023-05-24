package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VCnsrefturanomes generated by hbm2java
 */
@Entity
@Table(name = "V_CNSREFTURANOMES")
public class VCnsrefturanomes implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5634585059616770022L;
	private VCnsrefturanomesId id;

	public VCnsrefturanomes() {
	}

	public VCnsrefturanomes(VCnsrefturanomesId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "ano", column = @Column(name = "ANO", length = 4)),
			@AttributeOverride(name = "mes", column = @Column(name = "MES", length = 2)),
			@AttributeOverride(name = "cdturno", column = @Column(name = "CDTURNO", nullable = false, length = 6)),
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "dthrivalestru", column = @Column(name = "DTHRIVALESTRU", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrivalcic", column = @Column(name = "DTHRIVALCIC", nullable = false, length = 7)),
			@AttributeOverride(name = "cdidentificacao", column = @Column(name = "CDIDENTIFICACAO", nullable = false, length = 1)),
			@AttributeOverride(name = "qtpcsref", column = @Column(name = "QTPCSREF", precision = 22, scale = 0)) })
	public VCnsrefturanomesId getId() {
		return this.id;
	}

	public void setId(VCnsrefturanomesId id) {
		this.id = id;
	}

}