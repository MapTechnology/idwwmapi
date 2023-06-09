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
 * Ijtbcentrocusto generated by hbm2java
 */
@Entity
@Table(name = "IJTBCENTROCUSTO")
public class Ijtbcentrocusto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1841330216015935909L;
	private String cdcentrocusto;
	private String dscentrocusto;
	private Set<Ijcentrocustoxmaq> ijcentrocustoxmaqs = new HashSet<Ijcentrocustoxmaq>(
			0);

	public Ijtbcentrocusto() {
	}

	public Ijtbcentrocusto(String cdcentrocusto, String dscentrocusto) {
		this.cdcentrocusto = cdcentrocusto;
		this.dscentrocusto = dscentrocusto;
	}

	public Ijtbcentrocusto(String cdcentrocusto, String dscentrocusto,
			Set<Ijcentrocustoxmaq> ijcentrocustoxmaqs) {
		this.cdcentrocusto = cdcentrocusto;
		this.dscentrocusto = dscentrocusto;
		this.ijcentrocustoxmaqs = ijcentrocustoxmaqs;
	}

	@Id
	@Column(name = "CDCENTROCUSTO", unique = true, nullable = false, length = 10)
	public String getCdcentrocusto() {
		return this.cdcentrocusto;
	}

	public void setCdcentrocusto(String cdcentrocusto) {
		this.cdcentrocusto = cdcentrocusto;
	}

	@Column(name = "DSCENTROCUSTO", nullable = false, length = 40)
	public String getDscentrocusto() {
		return this.dscentrocusto;
	}

	public void setDscentrocusto(String dscentrocusto) {
		this.dscentrocusto = dscentrocusto;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbcentrocusto")
	public Set<Ijcentrocustoxmaq> getIjcentrocustoxmaqs() {
		return this.ijcentrocustoxmaqs;
	}

	public void setIjcentrocustoxmaqs(Set<Ijcentrocustoxmaq> ijcentrocustoxmaqs) {
		this.ijcentrocustoxmaqs = ijcentrocustoxmaqs;
	}

}
