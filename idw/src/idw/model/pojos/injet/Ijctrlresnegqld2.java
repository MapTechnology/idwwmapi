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
 * Ijctrlresnegqld2 generated by hbm2java
 */
@Entity
@Table(name = "IJCTRLRESNEGQLD2")
public class Ijctrlresnegqld2 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2946249014140991311L;
	private Ijctrlresnegqld2Id id;
	private Ijop ijop;
	private Ijgrpparaminsp ijgrpparaminsp;
	private Ijtbinj ijtbinj;
	private Ijmolpro ijmolpro;
	private char resultadoinspecao;

	public Ijctrlresnegqld2() {
	}

	public Ijctrlresnegqld2(Ijctrlresnegqld2Id id, Ijop ijop,
			Ijgrpparaminsp ijgrpparaminsp, Ijtbinj ijtbinj, Ijmolpro ijmolpro,
			char resultadoinspecao) {
		this.id = id;
		this.ijop = ijop;
		this.ijgrpparaminsp = ijgrpparaminsp;
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
			@AttributeOverride(name = "cdgrpparam", column = @Column(name = "CDGRPPARAM", nullable = false, length = 6)),
			@AttributeOverride(name = "sequencia", column = @Column(name = "SEQUENCIA", nullable = false, precision = 126, scale = 0)) })
	public Ijctrlresnegqld2Id getId() {
		return this.id;
	}

	public void setId(Ijctrlresnegqld2Id id) {
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
	@JoinColumn(name = "CDGRPPARAM", nullable = false, insertable = false, updatable = false)
	public Ijgrpparaminsp getIjgrpparaminsp() {
		return this.ijgrpparaminsp;
	}

	public void setIjgrpparaminsp(Ijgrpparaminsp ijgrpparaminsp) {
		this.ijgrpparaminsp = ijgrpparaminsp;
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

	@Column(name = "RESULTADOINSPECAO", nullable = false, length = 1)
	public char getResultadoinspecao() {
		return this.resultadoinspecao;
	}

	public void setResultadoinspecao(char resultadoinspecao) {
		this.resultadoinspecao = resultadoinspecao;
	}

}
