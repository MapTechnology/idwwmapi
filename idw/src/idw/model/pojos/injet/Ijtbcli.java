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
 * Ijtbcli generated by hbm2java
 */
@Entity
@Table(name = "IJTBCLI")
public class Ijtbcli implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8081455273523285626L;
	private String cdcliente;
	private String dscliente;
	private Set<Ijcarteira> ijcarteiras = new HashSet<Ijcarteira>(0);
	private Set<Ijtbclierp> ijtbclierps = new HashSet<Ijtbclierp>(0);
	private Set<Ijtbclixplantas> ijtbclixplantases = new HashSet<Ijtbclixplantas>(
			0);
	private Set<Ijtblicfgenviarcgq> ijtblicfgenviarcgqs = new HashSet<Ijtblicfgenviarcgq>(
			0);
	private Set<Ijtbmol> ijtbmols = new HashSet<Ijtbmol>(0);

	public Ijtbcli() {
	}

	public Ijtbcli(String cdcliente) {
		this.cdcliente = cdcliente;
	}

	public Ijtbcli(String cdcliente, String dscliente,
			Set<Ijcarteira> ijcarteiras, Set<Ijtbclierp> ijtbclierps,
			Set<Ijtbclixplantas> ijtbclixplantases,
			Set<Ijtblicfgenviarcgq> ijtblicfgenviarcgqs, Set<Ijtbmol> ijtbmols) {
		this.cdcliente = cdcliente;
		this.dscliente = dscliente;
		this.ijcarteiras = ijcarteiras;
		this.ijtbclierps = ijtbclierps;
		this.ijtbclixplantases = ijtbclixplantases;
		this.ijtblicfgenviarcgqs = ijtblicfgenviarcgqs;
		this.ijtbmols = ijtbmols;
	}

	@Id
	@Column(name = "CDCLIENTE", unique = true, nullable = false, length = 6)
	public String getCdcliente() {
		return this.cdcliente;
	}

	public void setCdcliente(String cdcliente) {
		this.cdcliente = cdcliente;
	}

	@Column(name = "DSCLIENTE", length = 40)
	public String getDscliente() {
		return this.dscliente;
	}

	public void setDscliente(String dscliente) {
		this.dscliente = dscliente;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbcli")
	public Set<Ijcarteira> getIjcarteiras() {
		return this.ijcarteiras;
	}

	public void setIjcarteiras(Set<Ijcarteira> ijcarteiras) {
		this.ijcarteiras = ijcarteiras;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbcli")
	public Set<Ijtbclierp> getIjtbclierps() {
		return this.ijtbclierps;
	}

	public void setIjtbclierps(Set<Ijtbclierp> ijtbclierps) {
		this.ijtbclierps = ijtbclierps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbcli")
	public Set<Ijtbclixplantas> getIjtbclixplantases() {
		return this.ijtbclixplantases;
	}

	public void setIjtbclixplantases(Set<Ijtbclixplantas> ijtbclixplantases) {
		this.ijtbclixplantases = ijtbclixplantases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbcli")
	public Set<Ijtblicfgenviarcgq> getIjtblicfgenviarcgqs() {
		return this.ijtblicfgenviarcgqs;
	}

	public void setIjtblicfgenviarcgqs(
			Set<Ijtblicfgenviarcgq> ijtblicfgenviarcgqs) {
		this.ijtblicfgenviarcgqs = ijtblicfgenviarcgqs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbcli")
	public Set<Ijtbmol> getIjtbmols() {
		return this.ijtbmols;
	}

	public void setIjtbmols(Set<Ijtbmol> ijtbmols) {
		this.ijtbmols = ijtbmols;
	}

}
