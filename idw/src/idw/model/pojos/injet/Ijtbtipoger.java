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
 * Ijtbtipoger generated by hbm2java
 */
@Entity
@Table(name = "IJTBTIPOGER")
public class Ijtbtipoger implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3195950369610457944L;
	private String cdtipoger;
	private String dstipoger;
	private String indgrafico;
	private String nomeicone;
	private String cdinterno;
	private Set<Ijtbcont> ijtbconts = new HashSet<Ijtbcont>(0);
	private Set<Ijtbinf> ijtbinfs = new HashSet<Ijtbinf>(0);

	public Ijtbtipoger() {
	}

	public Ijtbtipoger(String cdtipoger, String dstipoger, String indgrafico,
			String nomeicone, String cdinterno) {
		this.cdtipoger = cdtipoger;
		this.dstipoger = dstipoger;
		this.indgrafico = indgrafico;
		this.nomeicone = nomeicone;
		this.cdinterno = cdinterno;
	}

	public Ijtbtipoger(String cdtipoger, String dstipoger, String indgrafico,
			String nomeicone, String cdinterno, Set<Ijtbcont> ijtbconts,
			Set<Ijtbinf> ijtbinfs) {
		this.cdtipoger = cdtipoger;
		this.dstipoger = dstipoger;
		this.indgrafico = indgrafico;
		this.nomeicone = nomeicone;
		this.cdinterno = cdinterno;
		this.ijtbconts = ijtbconts;
		this.ijtbinfs = ijtbinfs;
	}

	@Id
	@Column(name = "CDTIPOGER", unique = true, nullable = false, length = 6)
	public String getCdtipoger() {
		return this.cdtipoger;
	}

	public void setCdtipoger(String cdtipoger) {
		this.cdtipoger = cdtipoger;
	}

	@Column(name = "DSTIPOGER", nullable = false, length = 30)
	public String getDstipoger() {
		return this.dstipoger;
	}

	public void setDstipoger(String dstipoger) {
		this.dstipoger = dstipoger;
	}

	@Column(name = "INDGRAFICO", nullable = false, length = 1)
	public String getIndgrafico() {
		return this.indgrafico;
	}

	public void setIndgrafico(String indgrafico) {
		this.indgrafico = indgrafico;
	}

	@Column(name = "NOMEICONE", nullable = false, length = 20)
	public String getNomeicone() {
		return this.nomeicone;
	}

	public void setNomeicone(String nomeicone) {
		this.nomeicone = nomeicone;
	}

	@Column(name = "CDINTERNO", nullable = false, length = 20)
	public String getCdinterno() {
		return this.cdinterno;
	}

	public void setCdinterno(String cdinterno) {
		this.cdinterno = cdinterno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbtipoger")
	public Set<Ijtbcont> getIjtbconts() {
		return this.ijtbconts;
	}

	public void setIjtbconts(Set<Ijtbcont> ijtbconts) {
		this.ijtbconts = ijtbconts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbtipoger")
	public Set<Ijtbinf> getIjtbinfs() {
		return this.ijtbinfs;
	}

	public void setIjtbinfs(Set<Ijtbinf> ijtbinfs) {
		this.ijtbinfs = ijtbinfs;
	}

}
