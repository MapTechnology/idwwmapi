package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijtbemplog generated by hbm2java
 */
@Entity
@Table(name = "IJTBEMPLOG")
public class Ijtbemplog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -937798765890910757L;
	private IjtbemplogId id;

	public Ijtbemplog() {
	}

	public Ijtbemplog(IjtbemplogId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdempresa", column = @Column(name = "CDEMPRESA", nullable = false, length = 6)),
			@AttributeOverride(name = "dsempresa", column = @Column(name = "DSEMPRESA", length = 40)),
			@AttributeOverride(name = "endereco", column = @Column(name = "ENDERECO", length = 40)),
			@AttributeOverride(name = "cgc", column = @Column(name = "CGC", length = 14)),
			@AttributeOverride(name = "bairro", column = @Column(name = "BAIRRO", length = 30)),
			@AttributeOverride(name = "cep", column = @Column(name = "CEP", length = 8)),
			@AttributeOverride(name = "dtcadastro", column = @Column(name = "DTCADASTRO", length = 7)),
			@AttributeOverride(name = "pabx1", column = @Column(name = "PABX1", length = 10)),
			@AttributeOverride(name = "pabx2", column = @Column(name = "PABX2", length = 10)),
			@AttributeOverride(name = "dthrmanut", column = @Column(name = "DTHRMANUT", nullable = false, length = 7)),
			@AttributeOverride(name = "tpmanut", column = @Column(name = "TPMANUT", nullable = false, length = 1)),
			@AttributeOverride(name = "cdusuresp", column = @Column(name = "CDUSURESP", nullable = false, length = 6)) })
	public IjtbemplogId getId() {
		return this.id;
	}

	public void setId(IjtbemplogId id) {
		this.id = id;
	}

}