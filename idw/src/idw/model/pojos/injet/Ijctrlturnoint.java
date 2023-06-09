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
 * Ijctrlturnoint generated by hbm2java
 */
@Entity
@Table(name = "IJCTRLTURNOINT")
public class Ijctrlturnoint implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7844562707815342417L;
	private IjctrlturnointId id;
	private Ijtbinj ijtbinj;
	private String stexportacao;

	public Ijctrlturnoint() {
	}

	public Ijctrlturnoint(IjctrlturnointId id, Ijtbinj ijtbinj,
			String stexportacao) {
		this.id = id;
		this.ijtbinj = ijtbinj;
		this.stexportacao = stexportacao;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "dtturno", column = @Column(name = "DTTURNO", nullable = false, length = 7)),
			@AttributeOverride(name = "cdturno", column = @Column(name = "CDTURNO", nullable = false, length = 6)) })
	public IjctrlturnointId getId() {
		return this.id;
	}

	public void setId(IjctrlturnointId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@Column(name = "STEXPORTACAO", nullable = false, length = 1)
	public String getStexportacao() {
		return this.stexportacao;
	}

	public void setStexportacao(String stexportacao) {
		this.stexportacao = stexportacao;
	}

}
