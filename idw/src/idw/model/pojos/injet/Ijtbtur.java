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
 * Ijtbtur generated by hbm2java
 */
@Entity
@Table(name = "IJTBTUR")
public class Ijtbtur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8073839619904880259L;
	private String cdturno;
	private String dsturno;
	private Set<Ijhortur> ijhorturs = new HashSet<Ijhortur>(0);
	private Set<Exportacao001> exportacao001s = new HashSet<Exportacao001>(0);
	private Set<Ijrefman> ijrefmans = new HashSet<Ijrefman>(0);
	private Set<Ijreprodt> ijreprodts = new HashSet<Ijreprodt>(0);
	private Set<Ijtbmodisp> ijtbmodisps = new HashSet<Ijtbmodisp>(0);
	private Set<Ijcncturno> ijcncturnos = new HashSet<Ijcncturno>(0);

	public Ijtbtur() {
	}

	public Ijtbtur(String cdturno) {
		this.cdturno = cdturno;
	}

	public Ijtbtur(String cdturno, String dsturno, Set<Ijhortur> ijhorturs,
			Set<Exportacao001> exportacao001s, Set<Ijrefman> ijrefmans,
			Set<Ijreprodt> ijreprodts, Set<Ijtbmodisp> ijtbmodisps,
			Set<Ijcncturno> ijcncturnos) {
		this.cdturno = cdturno;
		this.dsturno = dsturno;
		this.ijhorturs = ijhorturs;
		this.exportacao001s = exportacao001s;
		this.ijrefmans = ijrefmans;
		this.ijreprodts = ijreprodts;
		this.ijtbmodisps = ijtbmodisps;
		this.ijcncturnos = ijcncturnos;
	}

	@Id
	@Column(name = "CDTURNO", unique = true, nullable = false, length = 6)
	public String getCdturno() {
		return this.cdturno;
	}

	public void setCdturno(String cdturno) {
		this.cdturno = cdturno;
	}

	@Column(name = "DSTURNO", length = 20)
	public String getDsturno() {
		return this.dsturno;
	}

	public void setDsturno(String dsturno) {
		this.dsturno = dsturno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbtur")
	public Set<Ijhortur> getIjhorturs() {
		return this.ijhorturs;
	}

	public void setIjhorturs(Set<Ijhortur> ijhorturs) {
		this.ijhorturs = ijhorturs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbtur")
	public Set<Exportacao001> getExportacao001s() {
		return this.exportacao001s;
	}

	public void setExportacao001s(Set<Exportacao001> exportacao001s) {
		this.exportacao001s = exportacao001s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbtur")
	public Set<Ijrefman> getIjrefmans() {
		return this.ijrefmans;
	}

	public void setIjrefmans(Set<Ijrefman> ijrefmans) {
		this.ijrefmans = ijrefmans;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbtur")
	public Set<Ijreprodt> getIjreprodts() {
		return this.ijreprodts;
	}

	public void setIjreprodts(Set<Ijreprodt> ijreprodts) {
		this.ijreprodts = ijreprodts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbtur")
	public Set<Ijtbmodisp> getIjtbmodisps() {
		return this.ijtbmodisps;
	}

	public void setIjtbmodisps(Set<Ijtbmodisp> ijtbmodisps) {
		this.ijtbmodisps = ijtbmodisps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbtur")
	public Set<Ijcncturno> getIjcncturnos() {
		return this.ijcncturnos;
	}

	public void setIjcncturnos(Set<Ijcncturno> ijcncturnos) {
		this.ijcncturnos = ijcncturnos;
	}

}
