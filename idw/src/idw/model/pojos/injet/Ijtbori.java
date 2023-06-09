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
 * Ijtbori generated by hbm2java
 */
@Entity
@Table(name = "IJTBORI")
public class Ijtbori implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5869021523469350451L;
	private String cdorigem;
	private String dsorigem;
	private Set<Ijtbmol> ijtbmols = new HashSet<Ijtbmol>(0);

	public Ijtbori() {
	}

	public Ijtbori(String cdorigem) {
		this.cdorigem = cdorigem;
	}

	public Ijtbori(String cdorigem, String dsorigem, Set<Ijtbmol> ijtbmols) {
		this.cdorigem = cdorigem;
		this.dsorigem = dsorigem;
		this.ijtbmols = ijtbmols;
	}

	@Id
	@Column(name = "CDORIGEM", unique = true, nullable = false, length = 6)
	public String getCdorigem() {
		return this.cdorigem;
	}

	public void setCdorigem(String cdorigem) {
		this.cdorigem = cdorigem;
	}

	@Column(name = "DSORIGEM", length = 40)
	public String getDsorigem() {
		return this.dsorigem;
	}

	public void setDsorigem(String dsorigem) {
		this.dsorigem = dsorigem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbori")
	public Set<Ijtbmol> getIjtbmols() {
		return this.ijtbmols;
	}

	public void setIjtbmols(Set<Ijtbmol> ijtbmols) {
		this.ijtbmols = ijtbmols;
	}

}
