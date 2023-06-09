package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijgrppar generated by hbm2java
 */
@Entity
@Table(name = "IJGRPPAR")
public class Ijgrppar implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1886865055807435539L;
	private String cdgrupopar;
	private String dsgrupopar;
	private Set<Ijgrpparaux> ijgrpparauxes = new HashSet<Ijgrpparaux>(0);
	private Set<Ijgrpinjpar> ijgrpinjpars = new HashSet<Ijgrpinjpar>(0);
	private Set<Ijgrpdetpar> ijgrpdetpars = new HashSet<Ijgrpdetpar>(0);

	public Ijgrppar() {
	}

	public Ijgrppar(String cdgrupopar, String dsgrupopar) {
		this.cdgrupopar = cdgrupopar;
		this.dsgrupopar = dsgrupopar;
	}

	public Ijgrppar(String cdgrupopar, String dsgrupopar,
			Set<Ijgrpparaux> ijgrpparauxes, Set<Ijgrpinjpar> ijgrpinjpars,
			Set<Ijgrpdetpar> ijgrpdetpars) {
		this.cdgrupopar = cdgrupopar;
		this.dsgrupopar = dsgrupopar;
		this.ijgrpparauxes = ijgrpparauxes;
		this.ijgrpinjpars = ijgrpinjpars;
		this.ijgrpdetpars = ijgrpdetpars;
	}

	@Id
	@Column(name = "CDGRUPOPAR", unique = true, nullable = false, length = 6)
	public String getCdgrupopar() {
		return this.cdgrupopar;
	}

	public void setCdgrupopar(String cdgrupopar) {
		this.cdgrupopar = cdgrupopar;
	}

	@Column(name = "DSGRUPOPAR", nullable = false, length = 40)
	public String getDsgrupopar() {
		return this.dsgrupopar;
	}

	public void setDsgrupopar(String dsgrupopar) {
		this.dsgrupopar = dsgrupopar;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijgrppar")
	public Set<Ijgrpparaux> getIjgrpparauxes() {
		return this.ijgrpparauxes;
	}

	public void setIjgrpparauxes(Set<Ijgrpparaux> ijgrpparauxes) {
		this.ijgrpparauxes = ijgrpparauxes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijgrppar")
	public Set<Ijgrpinjpar> getIjgrpinjpars() {
		return this.ijgrpinjpars;
	}

	public void setIjgrpinjpars(Set<Ijgrpinjpar> ijgrpinjpars) {
		this.ijgrpinjpars = ijgrpinjpars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijgrppar")
	public Set<Ijgrpdetpar> getIjgrpdetpars() {
		return this.ijgrpdetpars;
	}

	public void setIjgrpdetpars(Set<Ijgrpdetpar> ijgrpdetpars) {
		this.ijgrpdetpars = ijgrpdetpars;
	}

}
