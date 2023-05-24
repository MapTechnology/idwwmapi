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
 * Ijtbfab generated by hbm2java
 */
@Entity
@Table(name = "IJTBFAB")
public class Ijtbfab implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8555539910569778767L;
	private String cdfabricante;
	private String dsfabricante;
	private Set<Ijtbmprima> ijtbmprimas = new HashSet<Ijtbmprima>(0);
	private Set<Ijtbmol> ijtbmols = new HashSet<Ijtbmol>(0);
	private Set<Ijtbinj> ijtbinjs = new HashSet<Ijtbinj>(0);

	public Ijtbfab() {
	}

	public Ijtbfab(String cdfabricante) {
		this.cdfabricante = cdfabricante;
	}

	public Ijtbfab(String cdfabricante, String dsfabricante,
			Set<Ijtbmprima> ijtbmprimas, Set<Ijtbmol> ijtbmols,
			Set<Ijtbinj> ijtbinjs) {
		this.cdfabricante = cdfabricante;
		this.dsfabricante = dsfabricante;
		this.ijtbmprimas = ijtbmprimas;
		this.ijtbmols = ijtbmols;
		this.ijtbinjs = ijtbinjs;
	}

	@Id
	@Column(name = "CDFABRICANTE", unique = true, nullable = false, length = 6)
	public String getCdfabricante() {
		return this.cdfabricante;
	}

	public void setCdfabricante(String cdfabricante) {
		this.cdfabricante = cdfabricante;
	}

	@Column(name = "DSFABRICANTE", length = 40)
	public String getDsfabricante() {
		return this.dsfabricante;
	}

	public void setDsfabricante(String dsfabricante) {
		this.dsfabricante = dsfabricante;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbfab")
	public Set<Ijtbmprima> getIjtbmprimas() {
		return this.ijtbmprimas;
	}

	public void setIjtbmprimas(Set<Ijtbmprima> ijtbmprimas) {
		this.ijtbmprimas = ijtbmprimas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbfab")
	public Set<Ijtbmol> getIjtbmols() {
		return this.ijtbmols;
	}

	public void setIjtbmols(Set<Ijtbmol> ijtbmols) {
		this.ijtbmols = ijtbmols;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbfab")
	public Set<Ijtbinj> getIjtbinjs() {
		return this.ijtbinjs;
	}

	public void setIjtbinjs(Set<Ijtbinj> ijtbinjs) {
		this.ijtbinjs = ijtbinjs;
	}

}