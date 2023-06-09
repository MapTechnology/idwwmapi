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
 * Ijtbclixcttcgq generated by hbm2java
 */
@Entity
@Table(name = "IJTBCLIXCTTCGQ")
public class Ijtbclixcttcgq implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4300827568541156381L;
	private IjtbclixcttcgqId id;
	private Ijtbclixplantas ijtbclixplantas;
	private String nomectt;
	private String depto;
	private char tpcontato;
	private char stativo;
	private char excluido;
	private Set<Ijctrlcgqxctts> ijctrlcgqxcttses = new HashSet<Ijctrlcgqxctts>(
			0);

	public Ijtbclixcttcgq() {
	}

	public Ijtbclixcttcgq(IjtbclixcttcgqId id, Ijtbclixplantas ijtbclixplantas,
			String nomectt, String depto, char tpcontato, char stativo,
			char excluido) {
		this.id = id;
		this.ijtbclixplantas = ijtbclixplantas;
		this.nomectt = nomectt;
		this.depto = depto;
		this.tpcontato = tpcontato;
		this.stativo = stativo;
		this.excluido = excluido;
	}

	public Ijtbclixcttcgq(IjtbclixcttcgqId id, Ijtbclixplantas ijtbclixplantas,
			String nomectt, String depto, char tpcontato, char stativo,
			char excluido, Set<Ijctrlcgqxctts> ijctrlcgqxcttses) {
		this.id = id;
		this.ijtbclixplantas = ijtbclixplantas;
		this.nomectt = nomectt;
		this.depto = depto;
		this.tpcontato = tpcontato;
		this.stativo = stativo;
		this.excluido = excluido;
		this.ijctrlcgqxcttses = ijctrlcgqxcttses;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdcliente", column = @Column(name = "CDCLIENTE", nullable = false, length = 6)),
			@AttributeOverride(name = "planta", column = @Column(name = "PLANTA", nullable = false, length = 50)),
			@AttributeOverride(name = "emailctt", column = @Column(name = "EMAILCTT", nullable = false, length = 50)) })
	public IjtbclixcttcgqId getId() {
		return this.id;
	}

	public void setId(IjtbclixcttcgqId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDCLIENTE", referencedColumnName = "CDCLIENTE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "PLANTA", referencedColumnName = "PLANTA", nullable = false, insertable = false, updatable = false) })
	public Ijtbclixplantas getIjtbclixplantas() {
		return this.ijtbclixplantas;
	}

	public void setIjtbclixplantas(Ijtbclixplantas ijtbclixplantas) {
		this.ijtbclixplantas = ijtbclixplantas;
	}

	@Column(name = "NOMECTT", nullable = false, length = 50)
	public String getNomectt() {
		return this.nomectt;
	}

	public void setNomectt(String nomectt) {
		this.nomectt = nomectt;
	}

	@Column(name = "DEPTO", nullable = false, length = 30)
	public String getDepto() {
		return this.depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	@Column(name = "TPCONTATO", nullable = false, length = 1)
	public char getTpcontato() {
		return this.tpcontato;
	}

	public void setTpcontato(char tpcontato) {
		this.tpcontato = tpcontato;
	}

	@Column(name = "STATIVO", nullable = false, length = 1)
	public char getStativo() {
		return this.stativo;
	}

	public void setStativo(char stativo) {
		this.stativo = stativo;
	}

	@Column(name = "EXCLUIDO", nullable = false, length = 1)
	public char getExcluido() {
		return this.excluido;
	}

	public void setExcluido(char excluido) {
		this.excluido = excluido;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbclixcttcgq")
	public Set<Ijctrlcgqxctts> getIjctrlcgqxcttses() {
		return this.ijctrlcgqxcttses;
	}

	public void setIjctrlcgqxcttses(Set<Ijctrlcgqxctts> ijctrlcgqxcttses) {
		this.ijctrlcgqxcttses = ijctrlcgqxcttses;
	}

}
