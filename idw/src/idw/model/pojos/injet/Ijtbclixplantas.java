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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijtbclixplantas generated by hbm2java
 */
@Entity
@Table(name = "IJTBCLIXPLANTAS")
public class Ijtbclixplantas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 718521563109736981L;
	private IjtbclixplantasId id;
	private Ijtbcli ijtbcli;
	private char stativo;
	private char excluido;
	private Set<Ijctrlcgqxplantas> ijctrlcgqxplantases = new HashSet<Ijctrlcgqxplantas>(
			0);
	private Set<Ijtbclixcttcgq> ijtbclixcttcgqs = new HashSet<Ijtbclixcttcgq>(0);

	public Ijtbclixplantas() {
	}

	public Ijtbclixplantas(IjtbclixplantasId id, Ijtbcli ijtbcli, char stativo,
			char excluido) {
		this.id = id;
		this.ijtbcli = ijtbcli;
		this.stativo = stativo;
		this.excluido = excluido;
	}

	public Ijtbclixplantas(IjtbclixplantasId id, Ijtbcli ijtbcli, char stativo,
			char excluido, Set<Ijctrlcgqxplantas> ijctrlcgqxplantases,
			Set<Ijtbclixcttcgq> ijtbclixcttcgqs) {
		this.id = id;
		this.ijtbcli = ijtbcli;
		this.stativo = stativo;
		this.excluido = excluido;
		this.ijctrlcgqxplantases = ijctrlcgqxplantases;
		this.ijtbclixcttcgqs = ijtbclixcttcgqs;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdcliente", column = @Column(name = "CDCLIENTE", nullable = false, length = 6)),
			@AttributeOverride(name = "planta", column = @Column(name = "PLANTA", nullable = false, length = 50)) })
	public IjtbclixplantasId getId() {
		return this.id;
	}

	public void setId(IjtbclixplantasId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDCLIENTE", nullable = false, insertable = false, updatable = false)
	public Ijtbcli getIjtbcli() {
		return this.ijtbcli;
	}

	public void setIjtbcli(Ijtbcli ijtbcli) {
		this.ijtbcli = ijtbcli;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbclixplantas")
	public Set<Ijctrlcgqxplantas> getIjctrlcgqxplantases() {
		return this.ijctrlcgqxplantases;
	}

	public void setIjctrlcgqxplantases(
			Set<Ijctrlcgqxplantas> ijctrlcgqxplantases) {
		this.ijctrlcgqxplantases = ijctrlcgqxplantases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbclixplantas")
	public Set<Ijtbclixcttcgq> getIjtbclixcttcgqs() {
		return this.ijtbclixcttcgqs;
	}

	public void setIjtbclixcttcgqs(Set<Ijtbclixcttcgq> ijtbclixcttcgqs) {
		this.ijtbclixcttcgqs = ijtbclixcttcgqs;
	}

}
