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
 * Ijtbgrpitemcnc generated by hbm2java
 */
@Entity
@Table(name = "IJTBGRPITEMCNC")
public class Ijtbgrpitemcnc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7625869397188949259L;
	private String cdgrpitemcnc;
	private String dsgrpitemcnc;
	private Set<Ijtbitemcnc> ijtbitemcncs = new HashSet<Ijtbitemcnc>(0);

	public Ijtbgrpitemcnc() {
	}

	public Ijtbgrpitemcnc(String cdgrpitemcnc) {
		this.cdgrpitemcnc = cdgrpitemcnc;
	}

	public Ijtbgrpitemcnc(String cdgrpitemcnc, String dsgrpitemcnc,
			Set<Ijtbitemcnc> ijtbitemcncs) {
		this.cdgrpitemcnc = cdgrpitemcnc;
		this.dsgrpitemcnc = dsgrpitemcnc;
		this.ijtbitemcncs = ijtbitemcncs;
	}

	@Id
	@Column(name = "CDGRPITEMCNC", unique = true, nullable = false, length = 6)
	public String getCdgrpitemcnc() {
		return this.cdgrpitemcnc;
	}

	public void setCdgrpitemcnc(String cdgrpitemcnc) {
		this.cdgrpitemcnc = cdgrpitemcnc;
	}

	@Column(name = "DSGRPITEMCNC", length = 40)
	public String getDsgrpitemcnc() {
		return this.dsgrpitemcnc;
	}

	public void setDsgrpitemcnc(String dsgrpitemcnc) {
		this.dsgrpitemcnc = dsgrpitemcnc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbgrpitemcnc")
	public Set<Ijtbitemcnc> getIjtbitemcncs() {
		return this.ijtbitemcncs;
	}

	public void setIjtbitemcncs(Set<Ijtbitemcnc> ijtbitemcncs) {
		this.ijtbitemcncs = ijtbitemcncs;
	}

}
