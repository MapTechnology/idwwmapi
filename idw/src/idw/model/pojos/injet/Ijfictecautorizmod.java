package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijfictecautorizmod generated by hbm2java
 */
@Entity
@Table(name = "IJFICTECAUTORIZMOD")
public class Ijfictecautorizmod implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2080486436039679541L;
	private String nrsolicmodificcic;
	private Ijtbusu ijtbusu;
	private Ijfictec ijfictec;
	private Date dthrsolicmodific;
	private double ciclopadrao;
	private double varmin;
	private double varmax;
	private char stsolicmodific;
	private Date dthrstsolic;
	private Set<Ijfictecautorizusu> ijfictecautorizusus = new HashSet<Ijfictecautorizusu>(
			0);

	public Ijfictecautorizmod() {
	}

	public Ijfictecautorizmod(String nrsolicmodificcic, Ijtbusu ijtbusu,
			Ijfictec ijfictec, Date dthrsolicmodific, double ciclopadrao,
			double varmin, double varmax, char stsolicmodific, Date dthrstsolic) {
		this.nrsolicmodificcic = nrsolicmodificcic;
		this.ijtbusu = ijtbusu;
		this.ijfictec = ijfictec;
		this.dthrsolicmodific = dthrsolicmodific;
		this.ciclopadrao = ciclopadrao;
		this.varmin = varmin;
		this.varmax = varmax;
		this.stsolicmodific = stsolicmodific;
		this.dthrstsolic = dthrstsolic;
	}

	public Ijfictecautorizmod(String nrsolicmodificcic, Ijtbusu ijtbusu,
			Ijfictec ijfictec, Date dthrsolicmodific, double ciclopadrao,
			double varmin, double varmax, char stsolicmodific,
			Date dthrstsolic, Set<Ijfictecautorizusu> ijfictecautorizusus) {
		this.nrsolicmodificcic = nrsolicmodificcic;
		this.ijtbusu = ijtbusu;
		this.ijfictec = ijfictec;
		this.dthrsolicmodific = dthrsolicmodific;
		this.ciclopadrao = ciclopadrao;
		this.varmin = varmin;
		this.varmax = varmax;
		this.stsolicmodific = stsolicmodific;
		this.dthrstsolic = dthrstsolic;
		this.ijfictecautorizusus = ijfictecautorizusus;
	}

	@Id
	@Column(name = "NRSOLICMODIFICCIC", unique = true, nullable = false, length = 12)
	public String getNrsolicmodificcic() {
		return this.nrsolicmodificcic;
	}

	public void setNrsolicmodificcic(String nrsolicmodificcic) {
		this.nrsolicmodificcic = nrsolicmodificcic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUSOLIC", nullable = false)
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDINJETORA", referencedColumnName = "CDINJETORA", nullable = false),
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE", nullable = false),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA", nullable = false),
			@JoinColumn(name = "DTHRIVALCIC", referencedColumnName = "DTHRIVALCIC", nullable = false) })
	public Ijfictec getIjfictec() {
		return this.ijfictec;
	}

	public void setIjfictec(Ijfictec ijfictec) {
		this.ijfictec = ijfictec;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRSOLICMODIFIC", nullable = false, length = 7)
	public Date getDthrsolicmodific() {
		return this.dthrsolicmodific;
	}

	public void setDthrsolicmodific(Date dthrsolicmodific) {
		this.dthrsolicmodific = dthrsolicmodific;
	}

	@Column(name = "CICLOPADRAO", nullable = false, precision = 126, scale = 0)
	public double getCiclopadrao() {
		return this.ciclopadrao;
	}

	public void setCiclopadrao(double ciclopadrao) {
		this.ciclopadrao = ciclopadrao;
	}

	@Column(name = "VARMIN", nullable = false, precision = 126, scale = 0)
	public double getVarmin() {
		return this.varmin;
	}

	public void setVarmin(double varmin) {
		this.varmin = varmin;
	}

	@Column(name = "VARMAX", nullable = false, precision = 126, scale = 0)
	public double getVarmax() {
		return this.varmax;
	}

	public void setVarmax(double varmax) {
		this.varmax = varmax;
	}

	@Column(name = "STSOLICMODIFIC", nullable = false, length = 1)
	public char getStsolicmodific() {
		return this.stsolicmodific;
	}

	public void setStsolicmodific(char stsolicmodific) {
		this.stsolicmodific = stsolicmodific;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRSTSOLIC", nullable = false, length = 7)
	public Date getDthrstsolic() {
		return this.dthrstsolic;
	}

	public void setDthrstsolic(Date dthrstsolic) {
		this.dthrstsolic = dthrstsolic;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijfictecautorizmod")
	public Set<Ijfictecautorizusu> getIjfictecautorizusus() {
		return this.ijfictecautorizusus;
	}

	public void setIjfictecautorizusus(
			Set<Ijfictecautorizusu> ijfictecautorizusus) {
		this.ijfictecautorizusus = ijfictecautorizusus;
	}

}
