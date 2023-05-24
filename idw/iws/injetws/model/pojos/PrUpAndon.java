package injetws.model.pojos;

// Generated 27/08/2012 21:36:08 by Hibernate Tools 3.4.0.CR1

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
 * PrUpAndon generated by hbm2java
 */
@Entity
@Table(name = "PR_UP_ANDON")
public class PrUpAndon implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7530272992711785708L;
	private PrUpAndonId id;
	private PrUp prUp;
	private BigDecimal tpeventoandon;
	private BigDecimal idrele;
	private String idreleaux;
	private BigDecimal prioridade;
	private BigDecimal stintermitente;
	private BigDecimal tmpsinalalto;
	private BigDecimal tmpsinalbaixo;
	private BigDecimal stativo;
	private Set<PrUpAndonArg> prUpAndonArgs = new HashSet<PrUpAndonArg>(0);

	public PrUpAndon() {
	}

	public PrUpAndon(PrUpAndonId id, PrUp prUp, BigDecimal tpeventoandon,
			BigDecimal idrele, BigDecimal prioridade,
			BigDecimal stintermitente, BigDecimal stativo) {
		this.id = id;
		this.prUp = prUp;
		this.tpeventoandon = tpeventoandon;
		this.idrele = idrele;
		this.prioridade = prioridade;
		this.stintermitente = stintermitente;
		this.stativo = stativo;
	}

	public PrUpAndon(PrUpAndonId id, PrUp prUp, BigDecimal tpeventoandon,
			BigDecimal idrele, String idreleaux, BigDecimal prioridade,
			BigDecimal stintermitente, BigDecimal tmpsinalalto,
			BigDecimal tmpsinalbaixo, BigDecimal stativo,
			Set<PrUpAndonArg> prUpAndonArgs) {
		this.id = id;
		this.prUp = prUp;
		this.tpeventoandon = tpeventoandon;
		this.idrele = idrele;
		this.idreleaux = idreleaux;
		this.prioridade = prioridade;
		this.stintermitente = stintermitente;
		this.tmpsinalalto = tmpsinalalto;
		this.tmpsinalbaixo = tmpsinalbaixo;
		this.stativo = stativo;
		this.prUpAndonArgs = prUpAndonArgs;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "ideventoandon", column = @Column(name = "IDEVENTOANDON", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "idup", column = @Column(name = "IDUP", nullable = false, length = 36)) })
	public PrUpAndonId getId() {
		return this.id;
	}

	public void setId(PrUpAndonId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUP", nullable = false, insertable = false, updatable = false)
	public PrUp getPrUp() {
		return this.prUp;
	}

	public void setPrUp(PrUp prUp) {
		this.prUp = prUp;
	}

	@Column(name = "TPEVENTOANDON", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTpeventoandon() {
		return this.tpeventoandon;
	}

	public void setTpeventoandon(BigDecimal tpeventoandon) {
		this.tpeventoandon = tpeventoandon;
	}

	@Column(name = "IDRELE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdrele() {
		return this.idrele;
	}

	public void setIdrele(BigDecimal idrele) {
		this.idrele = idrele;
	}

	@Column(name = "IDRELEAUX", length = 20)
	public String getIdreleaux() {
		return this.idreleaux;
	}

	public void setIdreleaux(String idreleaux) {
		this.idreleaux = idreleaux;
	}

	@Column(name = "PRIORIDADE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(BigDecimal prioridade) {
		this.prioridade = prioridade;
	}

	@Column(name = "STINTERMITENTE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStintermitente() {
		return this.stintermitente;
	}

	public void setStintermitente(BigDecimal stintermitente) {
		this.stintermitente = stintermitente;
	}

	@Column(name = "TMPSINALALTO", precision = 22, scale = 0)
	public BigDecimal getTmpsinalalto() {
		return this.tmpsinalalto;
	}

	public void setTmpsinalalto(BigDecimal tmpsinalalto) {
		this.tmpsinalalto = tmpsinalalto;
	}

	@Column(name = "TMPSINALBAIXO", precision = 22, scale = 0)
	public BigDecimal getTmpsinalbaixo() {
		return this.tmpsinalbaixo;
	}

	public void setTmpsinalbaixo(BigDecimal tmpsinalbaixo) {
		this.tmpsinalbaixo = tmpsinalbaixo;
	}

	@Column(name = "STATIVO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStativo() {
		return this.stativo;
	}

	public void setStativo(BigDecimal stativo) {
		this.stativo = stativo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prUpAndon")
	public Set<PrUpAndonArg> getPrUpAndonArgs() {
		return this.prUpAndonArgs;
	}

	public void setPrUpAndonArgs(Set<PrUpAndonArg> prUpAndonArgs) {
		this.prUpAndonArgs = prUpAndonArgs;
	}

}
