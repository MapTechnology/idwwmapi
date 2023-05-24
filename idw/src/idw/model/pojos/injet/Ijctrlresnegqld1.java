package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijctrlresnegqld1 generated by hbm2java
 */
@Entity
@Table(name = "IJCTRLRESNEGQLD1")
public class Ijctrlresnegqld1 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1658531284385864119L;
	private Ijctrlresnegqld1Id id;
	private Ijop ijop;
	private Ijtbinj ijtbinj;
	private Ijmolpro ijmolpro;
	private String resultadoinspecao;

	public Ijctrlresnegqld1() {
	}

	public Ijctrlresnegqld1(Ijctrlresnegqld1Id id, Ijop ijop, Ijtbinj ijtbinj,
			Ijmolpro ijmolpro, String resultadoinspecao) {
		this.id = id;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.ijmolpro = ijmolpro;
		this.resultadoinspecao = resultadoinspecao;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "dthrivalestru", column = @Column(name = "DTHRIVALESTRU", nullable = false, length = 7)),
			@AttributeOverride(name = "sequencia", column = @Column(name = "SEQUENCIA", nullable = false, precision = 126, scale = 0)) })
	public Ijctrlresnegqld1Id getId() {
		return this.id;
	}

	public void setId(Ijctrlresnegqld1Id id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROP", nullable = false, insertable = false, updatable = false)
	public Ijop getIjop() {
		return this.ijop;
	}

	public void setIjop(Ijop ijop) {
		this.ijop = ijop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDPRODUTO", referencedColumnName = "CDPRODUTO", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "DTHRIVALESTRU", referencedColumnName = "DTHRIVAL", nullable = false, insertable = false, updatable = false) })
	public Ijmolpro getIjmolpro() {
		return this.ijmolpro;
	}

	public void setIjmolpro(Ijmolpro ijmolpro) {
		this.ijmolpro = ijmolpro;
	}

	@Column(name = "RESULTADOINSPECAO", nullable = false, length = 20)
	public String getResultadoinspecao() {
		return this.resultadoinspecao;
	}

	public void setResultadoinspecao(String resultadoinspecao) {
		this.resultadoinspecao = resultadoinspecao;
	}

}