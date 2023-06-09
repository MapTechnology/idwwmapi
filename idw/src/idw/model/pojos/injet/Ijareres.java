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
 * Ijareres generated by hbm2java
 */
@Entity
@Table(name = "IJARERES")
public class Ijareres implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7227085878425616327L;
	private String cdarea;
	private String dsarea;
	private Character tipoarearesp;
	private Set<Ijpdcapadrao> ijpdcapadraos = new HashSet<Ijpdcapadrao>(0);
	private Set<Ijtbpar> ijtbpars = new HashSet<Ijtbpar>(0);
	private Set<Ijtbref> ijtbrefs = new HashSet<Ijtbref>(0);
	private Set<Ijpdcaacao> ijpdcaacaos = new HashSet<Ijpdcaacao>(0);
	private Set<Ijmanut> ijmanuts = new HashSet<Ijmanut>(0);

	public Ijareres() {
	}

	public Ijareres(String cdarea) {
		this.cdarea = cdarea;
	}

	public Ijareres(String cdarea, String dsarea, Character tipoarearesp,
			Set<Ijpdcapadrao> ijpdcapadraos, Set<Ijtbpar> ijtbpars,
			Set<Ijtbref> ijtbrefs, Set<Ijpdcaacao> ijpdcaacaos,
			Set<Ijmanut> ijmanuts) {
		this.cdarea = cdarea;
		this.dsarea = dsarea;
		this.tipoarearesp = tipoarearesp;
		this.ijpdcapadraos = ijpdcapadraos;
		this.ijtbpars = ijtbpars;
		this.ijtbrefs = ijtbrefs;
		this.ijpdcaacaos = ijpdcaacaos;
		this.ijmanuts = ijmanuts;
	}

	@Id
	@Column(name = "CDAREA", unique = true, nullable = false, length = 6)
	public String getCdarea() {
		return this.cdarea;
	}

	public void setCdarea(String cdarea) {
		this.cdarea = cdarea;
	}

	@Column(name = "DSAREA", length = 40)
	public String getDsarea() {
		return this.dsarea;
	}

	public void setDsarea(String dsarea) {
		this.dsarea = dsarea;
	}

	@Column(name = "TIPOAREARESP", length = 1)
	public Character getTipoarearesp() {
		return this.tipoarearesp;
	}

	public void setTipoarearesp(Character tipoarearesp) {
		this.tipoarearesp = tipoarearesp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijareres")
	public Set<Ijpdcapadrao> getIjpdcapadraos() {
		return this.ijpdcapadraos;
	}

	public void setIjpdcapadraos(Set<Ijpdcapadrao> ijpdcapadraos) {
		this.ijpdcapadraos = ijpdcapadraos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijareres")
	public Set<Ijtbpar> getIjtbpars() {
		return this.ijtbpars;
	}

	public void setIjtbpars(Set<Ijtbpar> ijtbpars) {
		this.ijtbpars = ijtbpars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijareres")
	public Set<Ijtbref> getIjtbrefs() {
		return this.ijtbrefs;
	}

	public void setIjtbrefs(Set<Ijtbref> ijtbrefs) {
		this.ijtbrefs = ijtbrefs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijareres")
	public Set<Ijpdcaacao> getIjpdcaacaos() {
		return this.ijpdcaacaos;
	}

	public void setIjpdcaacaos(Set<Ijpdcaacao> ijpdcaacaos) {
		this.ijpdcaacaos = ijpdcaacaos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijareres")
	public Set<Ijmanut> getIjmanuts() {
		return this.ijmanuts;
	}

	public void setIjmanuts(Set<Ijmanut> ijmanuts) {
		this.ijmanuts = ijmanuts;
	}

}
