package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijselitensmen generated by hbm2java
 */
@Entity
@Table(name = "IJSELITENSMEN")
public class Ijselitensmen implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7564737543867704686L;
	private IjselitensmenId id;
	private Ijclassificcont ijclassificcont;
	private Ijselecao ijselecao;
	private Set<Ijfiltroitensmen> ijfiltroitensmens = new HashSet<Ijfiltroitensmen>(
			0);

	public Ijselitensmen() {
	}

	public Ijselitensmen(IjselitensmenId id, Ijclassificcont ijclassificcont,
			Ijselecao ijselecao) {
		this.id = id;
		this.ijclassificcont = ijclassificcont;
		this.ijselecao = ijselecao;
	}

	public Ijselitensmen(IjselitensmenId id, Ijclassificcont ijclassificcont,
			Ijselecao ijselecao, Set<Ijfiltroitensmen> ijfiltroitensmens) {
		this.id = id;
		this.ijclassificcont = ijclassificcont;
		this.ijselecao = ijselecao;
		this.ijfiltroitensmens = ijfiltroitensmens;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdselecao", column = @Column(name = "CDSELECAO", nullable = false, length = 6)),
			@AttributeOverride(name = "cdtipoinf", column = @Column(name = "CDTIPOINF", nullable = false, length = 6)),
			@AttributeOverride(name = "cdcont", column = @Column(name = "CDCONT", nullable = false, length = 6)) })
	public IjselitensmenId getId() {
		return this.id;
	}

	public void setId(IjselitensmenId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDTIPOINF", referencedColumnName = "CDTIPOINF", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDCONT", referencedColumnName = "CDCONT", nullable = false, insertable = false, updatable = false) })
	public Ijclassificcont getIjclassificcont() {
		return this.ijclassificcont;
	}

	public void setIjclassificcont(Ijclassificcont ijclassificcont) {
		this.ijclassificcont = ijclassificcont;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDSELECAO", nullable = false, insertable = false, updatable = false)
	public Ijselecao getIjselecao() {
		return this.ijselecao;
	}

	public void setIjselecao(Ijselecao ijselecao) {
		this.ijselecao = ijselecao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijselitensmen")
	public Set<Ijfiltroitensmen> getIjfiltroitensmens() {
		return this.ijfiltroitensmens;
	}

	public void setIjfiltroitensmens(Set<Ijfiltroitensmen> ijfiltroitensmens) {
		this.ijfiltroitensmens = ijfiltroitensmens;
	}

}