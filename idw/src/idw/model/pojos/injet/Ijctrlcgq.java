package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijctrlcgq generated by hbm2java
 */
@Entity
@Table(name = "IJCTRLCGQ")
public class Ijctrlcgq implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2125124105351636976L;
	private IjctrlcgqId id;
	private Ijop ijop;
	private Ijtbpro ijtbpro;
	private String nrnota;
	private char resultadoinspecao;
	private String observacao;
	private Character tpobservacao;
	private char aplresultmod;
	private Double du;
	private BigDecimal revisao;
	private Set<Ijctrlcgqalt> ijctrlcgqalts = new HashSet<Ijctrlcgqalt>(0);

	public Ijctrlcgq() {
	}

	public Ijctrlcgq(IjctrlcgqId id, Ijop ijop, Ijtbpro ijtbpro,
			char resultadoinspecao, char aplresultmod) {
		this.id = id;
		this.ijop = ijop;
		this.ijtbpro = ijtbpro;
		this.resultadoinspecao = resultadoinspecao;
		this.aplresultmod = aplresultmod;
	}

	public Ijctrlcgq(IjctrlcgqId id, Ijop ijop, Ijtbpro ijtbpro, String nrnota,
			char resultadoinspecao, String observacao, Character tpobservacao,
			char aplresultmod, Double du, BigDecimal revisao,
			Set<Ijctrlcgqalt> ijctrlcgqalts) {
		this.id = id;
		this.ijop = ijop;
		this.ijtbpro = ijtbpro;
		this.nrnota = nrnota;
		this.resultadoinspecao = resultadoinspecao;
		this.observacao = observacao;
		this.tpobservacao = tpobservacao;
		this.aplresultmod = aplresultmod;
		this.du = du;
		this.revisao = revisao;
		this.ijctrlcgqalts = ijctrlcgqalts;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)) })
	public IjctrlcgqId getId() {
		return this.id;
	}

	public void setId(IjctrlcgqId id) {
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
	@JoinColumn(name = "CDPRODUTO", nullable = false, insertable = false, updatable = false)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

	@Column(name = "NRNOTA", length = 10)
	public String getNrnota() {
		return this.nrnota;
	}

	public void setNrnota(String nrnota) {
		this.nrnota = nrnota;
	}

	@Column(name = "RESULTADOINSPECAO", nullable = false, length = 1)
	public char getResultadoinspecao() {
		return this.resultadoinspecao;
	}

	public void setResultadoinspecao(char resultadoinspecao) {
		this.resultadoinspecao = resultadoinspecao;
	}

	@Column(name = "OBSERVACAO", length = 250)
	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column(name = "TPOBSERVACAO", length = 1)
	public Character getTpobservacao() {
		return this.tpobservacao;
	}

	public void setTpobservacao(Character tpobservacao) {
		this.tpobservacao = tpobservacao;
	}

	@Column(name = "APLRESULTMOD", nullable = false, length = 1)
	public char getAplresultmod() {
		return this.aplresultmod;
	}

	public void setAplresultmod(char aplresultmod) {
		this.aplresultmod = aplresultmod;
	}

	@Column(name = "DU", precision = 126, scale = 0)
	public Double getDu() {
		return this.du;
	}

	public void setDu(Double du) {
		this.du = du;
	}

	@Column(name = "REVISAO", precision = 22, scale = 0)
	public BigDecimal getRevisao() {
		return this.revisao;
	}

	public void setRevisao(BigDecimal revisao) {
		this.revisao = revisao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijctrlcgq")
	public Set<Ijctrlcgqalt> getIjctrlcgqalts() {
		return this.ijctrlcgqalts;
	}

	public void setIjctrlcgqalts(Set<Ijctrlcgqalt> ijctrlcgqalts) {
		this.ijctrlcgqalts = ijctrlcgqalts;
	}

}
