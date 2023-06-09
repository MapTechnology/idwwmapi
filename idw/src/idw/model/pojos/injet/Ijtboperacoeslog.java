package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijtboperacoeslog generated by hbm2java
 */
@Entity
@Table(name = "IJTBOPERACOESLOG")
public class Ijtboperacoeslog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783923748894331052L;
	private IjtboperacoeslogId id;

	public Ijtboperacoeslog() {
	}

	public Ijtboperacoeslog(IjtboperacoeslogId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdoperacao", column = @Column(name = "CDOPERACAO", nullable = false, length = 6)),
			@AttributeOverride(name = "dsoperacao", column = @Column(name = "DSOPERACAO", nullable = false, length = 40)),
			@AttributeOverride(name = "unidqtdproc", column = @Column(name = "UNIDQTDPROC", length = 6)),
			@AttributeOverride(name = "tpoperacao", column = @Column(name = "TPOPERACAO", precision = 22, scale = 0)),
			@AttributeOverride(name = "reqfim", column = @Column(name = "REQFIM", precision = 22, scale = 0)),
			@AttributeOverride(name = "reqqtd", column = @Column(name = "REQQTD", precision = 22, scale = 0)),
			@AttributeOverride(name = "reqmaq", column = @Column(name = "REQMAQ", precision = 22, scale = 0)),
			@AttributeOverride(name = "reqop", column = @Column(name = "REQOP", precision = 22, scale = 0)),
			@AttributeOverride(name = "reqoper", column = @Column(name = "REQOPER", precision = 22, scale = 0)),
			@AttributeOverride(name = "permiteopergrupo", column = @Column(name = "PERMITEOPERGRUPO", precision = 22, scale = 0)),
			@AttributeOverride(name = "dthrmanut", column = @Column(name = "DTHRMANUT", nullable = false, length = 7)),
			@AttributeOverride(name = "tpmanut", column = @Column(name = "TPMANUT", nullable = false, length = 1)),
			@AttributeOverride(name = "cdusuresp", column = @Column(name = "CDUSURESP", nullable = false, length = 6)) })
	public IjtboperacoeslogId getId() {
		return this.id;
	}

	public void setId(IjtboperacoeslogId id) {
		this.id = id;
	}

}
