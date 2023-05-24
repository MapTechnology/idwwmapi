package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijtbcelula generated by hbm2java
 */
@Entity
@Table(name = "IJTBCELULA")
public class Ijtbcelula implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7232632611610594437L;
	private String cdcelula;
	private String dscelula;
	private BigDecimal qtoperadores;
	private Set<Ijficteccel> ijficteccels = new HashSet<Ijficteccel>(0);
	private Set<Ijgalobjcel> ijgalobjcels = new HashSet<Ijgalobjcel>(0);
	private Set<Ijcelxestagios> ijcelxestagioses = new HashSet<Ijcelxestagios>(
			0);
	private Set<Ijgalobjcelmtrz> ijgalobjcelmtrzs = new HashSet<Ijgalobjcelmtrz>(
			0);

	public Ijtbcelula() {
	}

	public Ijtbcelula(String cdcelula, String dscelula, BigDecimal qtoperadores) {
		this.cdcelula = cdcelula;
		this.dscelula = dscelula;
		this.qtoperadores = qtoperadores;
	}

	public Ijtbcelula(String cdcelula, String dscelula,
			BigDecimal qtoperadores, Set<Ijficteccel> ijficteccels,
			Set<Ijgalobjcel> ijgalobjcels,
			Set<Ijcelxestagios> ijcelxestagioses,
			Set<Ijgalobjcelmtrz> ijgalobjcelmtrzs) {
		this.cdcelula = cdcelula;
		this.dscelula = dscelula;
		this.qtoperadores = qtoperadores;
		this.ijficteccels = ijficteccels;
		this.ijgalobjcels = ijgalobjcels;
		this.ijcelxestagioses = ijcelxestagioses;
		this.ijgalobjcelmtrzs = ijgalobjcelmtrzs;
	}

	@Id
	@Column(name = "CDCELULA", unique = true, nullable = false, length = 6)
	public String getCdcelula() {
		return this.cdcelula;
	}

	public void setCdcelula(String cdcelula) {
		this.cdcelula = cdcelula;
	}

	@Column(name = "DSCELULA", nullable = false, length = 40)
	public String getDscelula() {
		return this.dscelula;
	}

	public void setDscelula(String dscelula) {
		this.dscelula = dscelula;
	}

	@Column(name = "QTOPERADORES", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtoperadores() {
		return this.qtoperadores;
	}

	public void setQtoperadores(BigDecimal qtoperadores) {
		this.qtoperadores = qtoperadores;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbcelula")
	public Set<Ijficteccel> getIjficteccels() {
		return this.ijficteccels;
	}

	public void setIjficteccels(Set<Ijficteccel> ijficteccels) {
		this.ijficteccels = ijficteccels;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbcelula")
	public Set<Ijgalobjcel> getIjgalobjcels() {
		return this.ijgalobjcels;
	}

	public void setIjgalobjcels(Set<Ijgalobjcel> ijgalobjcels) {
		this.ijgalobjcels = ijgalobjcels;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbcelula")
	public Set<Ijcelxestagios> getIjcelxestagioses() {
		return this.ijcelxestagioses;
	}

	public void setIjcelxestagioses(Set<Ijcelxestagios> ijcelxestagioses) {
		this.ijcelxestagioses = ijcelxestagioses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbcelula")
	public Set<Ijgalobjcelmtrz> getIjgalobjcelmtrzs() {
		return this.ijgalobjcelmtrzs;
	}

	public void setIjgalobjcelmtrzs(Set<Ijgalobjcelmtrz> ijgalobjcelmtrzs) {
		this.ijgalobjcelmtrzs = ijgalobjcelmtrzs;
	}

}