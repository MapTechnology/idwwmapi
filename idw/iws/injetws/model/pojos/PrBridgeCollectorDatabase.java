package injetws.model.pojos;
// default package
// Generated 16/10/2008 15:14:14 by Hibernate Tools 3.2.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PrBridgeCollectorDatabase generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PR_BRIDGE_COLLECTOR_DATABASE")
public class PrBridgeCollectorDatabase implements java.io.Serializable {

	private String idmasterbridgecollecdatabase;
	private char stonline;
	private Date dthrultacessobd;
	private double msdthrultacessobd;
	private double tmptimeoutmaster;
	private Set<PrConexoesInjet> prConexoesInjets = new HashSet<PrConexoesInjet>(
			0);

	public PrBridgeCollectorDatabase() {
	}

	public PrBridgeCollectorDatabase(String idmasterbridgecollecdatabase,
			char stonline, Date dthrultacessobd, double msdthrultacessobd,
			double tmptimeoutmaster) {
		this.idmasterbridgecollecdatabase = idmasterbridgecollecdatabase;
		this.stonline = stonline;
		this.dthrultacessobd = dthrultacessobd;
		this.msdthrultacessobd = msdthrultacessobd;
		this.tmptimeoutmaster = tmptimeoutmaster;
	}

	public PrBridgeCollectorDatabase(String idmasterbridgecollecdatabase,
			char stonline, Date dthrultacessobd, double msdthrultacessobd,
			double tmptimeoutmaster, Set<PrConexoesInjet> prConexoesInjets) {
		this.idmasterbridgecollecdatabase = idmasterbridgecollecdatabase;
		this.stonline = stonline;
		this.dthrultacessobd = dthrultacessobd;
		this.msdthrultacessobd = msdthrultacessobd;
		this.tmptimeoutmaster = tmptimeoutmaster;
		this.prConexoesInjets = prConexoesInjets;
	}

	@Id
	@Column(name = "IDMASTERBRIDGECOLLECDATABASE", unique = true, nullable = false, length = 6)
	public String getIdmasterbridgecollecdatabase() {
		return this.idmasterbridgecollecdatabase;
	}

	public void setIdmasterbridgecollecdatabase(
			String idmasterbridgecollecdatabase) {
		this.idmasterbridgecollecdatabase = idmasterbridgecollecdatabase;
	}

	@Column(name = "STONLINE", nullable = false, length = 1)
	public char getStonline() {
		return this.stonline;
	}

	public void setStonline(char stonline) {
		this.stonline = stonline;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHRULTACESSOBD", nullable = false)
	public Date getDthrultacessobd() {
		return this.dthrultacessobd;
	}

	public void setDthrultacessobd(Date dthrultacessobd) {
		this.dthrultacessobd = dthrultacessobd;
	}

	@Column(name = "MSDTHRULTACESSOBD", nullable = false, precision = 126, scale = 0)
	public double getMsdthrultacessobd() {
		return this.msdthrultacessobd;
	}

	public void setMsdthrultacessobd(double msdthrultacessobd) {
		this.msdthrultacessobd = msdthrultacessobd;
	}

	@Column(name = "TMPTIMEOUTMASTER", nullable = false, precision = 126, scale = 0)
	public double getTmptimeoutmaster() {
		return this.tmptimeoutmaster;
	}

	public void setTmptimeoutmaster(double tmptimeoutmaster) {
		this.tmptimeoutmaster = tmptimeoutmaster;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prBridgeCollectorDatabase")
	public Set<PrConexoesInjet> getPrConexoesInjets() {
		return this.prConexoesInjets;
	}

	public void setPrConexoesInjets(Set<PrConexoesInjet> prConexoesInjets) {
		this.prConexoesInjets = prConexoesInjets;
	}

}