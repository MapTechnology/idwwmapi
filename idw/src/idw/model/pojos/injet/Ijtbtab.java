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
 * Ijtbtab generated by hbm2java
 */
@Entity
@Table(name = "IJTBTAB")
public class Ijtbtab implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5229414612922676415L;
	private String cdtabela;
	private String dstabela;
	private Set<Ijtbesttab> ijtbesttabs = new HashSet<Ijtbesttab>(0);

	public Ijtbtab() {
	}

	public Ijtbtab(String cdtabela, String dstabela) {
		this.cdtabela = cdtabela;
		this.dstabela = dstabela;
	}

	public Ijtbtab(String cdtabela, String dstabela, Set<Ijtbesttab> ijtbesttabs) {
		this.cdtabela = cdtabela;
		this.dstabela = dstabela;
		this.ijtbesttabs = ijtbesttabs;
	}

	@Id
	@Column(name = "CDTABELA", unique = true, nullable = false, length = 6)
	public String getCdtabela() {
		return this.cdtabela;
	}

	public void setCdtabela(String cdtabela) {
		this.cdtabela = cdtabela;
	}

	@Column(name = "DSTABELA", nullable = false, length = 40)
	public String getDstabela() {
		return this.dstabela;
	}

	public void setDstabela(String dstabela) {
		this.dstabela = dstabela;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbtab")
	public Set<Ijtbesttab> getIjtbesttabs() {
		return this.ijtbesttabs;
	}

	public void setIjtbesttabs(Set<Ijtbesttab> ijtbesttabs) {
		this.ijtbesttabs = ijtbesttabs;
	}

}
