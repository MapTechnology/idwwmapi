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
 * Ijtbgru generated by hbm2java
 */
@Entity
@Table(name = "IJTBGRU")
public class Ijtbgru implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2749723962116190286L;
	private String cdgrupo;
	private String dsgrupo;
	private Set<Ijdirace> ijdiraces = new HashSet<Ijdirace>(0);
	private Set<Ijgruusu> ijgruusus = new HashSet<Ijgruusu>(0);

	public Ijtbgru() {
	}

	public Ijtbgru(String cdgrupo) {
		this.cdgrupo = cdgrupo;
	}

	public Ijtbgru(String cdgrupo, String dsgrupo, Set<Ijdirace> ijdiraces,
			Set<Ijgruusu> ijgruusus) {
		this.cdgrupo = cdgrupo;
		this.dsgrupo = dsgrupo;
		this.ijdiraces = ijdiraces;
		this.ijgruusus = ijgruusus;
	}

	@Id
	@Column(name = "CDGRUPO", unique = true, nullable = false, length = 6)
	public String getCdgrupo() {
		return this.cdgrupo;
	}

	public void setCdgrupo(String cdgrupo) {
		this.cdgrupo = cdgrupo;
	}

	@Column(name = "DSGRUPO", length = 40)
	public String getDsgrupo() {
		return this.dsgrupo;
	}

	public void setDsgrupo(String dsgrupo) {
		this.dsgrupo = dsgrupo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbgru")
	public Set<Ijdirace> getIjdiraces() {
		return this.ijdiraces;
	}

	public void setIjdiraces(Set<Ijdirace> ijdiraces) {
		this.ijdiraces = ijdiraces;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbgru")
	public Set<Ijgruusu> getIjgruusus() {
		return this.ijgruusus;
	}

	public void setIjgruusus(Set<Ijgruusu> ijgruusus) {
		this.ijgruusus = ijgruusus;
	}

}
