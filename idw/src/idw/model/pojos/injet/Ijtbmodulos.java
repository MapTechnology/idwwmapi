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
 * Ijtbmodulos generated by hbm2java
 */
@Entity
@Table(name = "IJTBMODULOS")
public class Ijtbmodulos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6677018252672150967L;
	private String cdmodulo;
	private String nmmodulo;
	private Set<Ijtbopcmenu> ijtbopcmenus = new HashSet<Ijtbopcmenu>(0);
	private Set<Ijtbidrpt> ijtbidrpts = new HashSet<Ijtbidrpt>(0);
	private Set<Ijtbidgraf> ijtbidgrafs = new HashSet<Ijtbidgraf>(0);
	private Set<Ijcaptionlinguas> ijcaptionlinguases = new HashSet<Ijcaptionlinguas>(
			0);

	public Ijtbmodulos() {
	}

	public Ijtbmodulos(String cdmodulo) {
		this.cdmodulo = cdmodulo;
	}

	public Ijtbmodulos(String cdmodulo, String nmmodulo,
			Set<Ijtbopcmenu> ijtbopcmenus, Set<Ijtbidrpt> ijtbidrpts,
			Set<Ijtbidgraf> ijtbidgrafs,
			Set<Ijcaptionlinguas> ijcaptionlinguases) {
		this.cdmodulo = cdmodulo;
		this.nmmodulo = nmmodulo;
		this.ijtbopcmenus = ijtbopcmenus;
		this.ijtbidrpts = ijtbidrpts;
		this.ijtbidgrafs = ijtbidgrafs;
		this.ijcaptionlinguases = ijcaptionlinguases;
	}

	@Id
	@Column(name = "CDMODULO", unique = true, nullable = false, length = 6)
	public String getCdmodulo() {
		return this.cdmodulo;
	}

	public void setCdmodulo(String cdmodulo) {
		this.cdmodulo = cdmodulo;
	}

	@Column(name = "NMMODULO", length = 30)
	public String getNmmodulo() {
		return this.nmmodulo;
	}

	public void setNmmodulo(String nmmodulo) {
		this.nmmodulo = nmmodulo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbmodulos")
	public Set<Ijtbopcmenu> getIjtbopcmenus() {
		return this.ijtbopcmenus;
	}

	public void setIjtbopcmenus(Set<Ijtbopcmenu> ijtbopcmenus) {
		this.ijtbopcmenus = ijtbopcmenus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbmodulos")
	public Set<Ijtbidrpt> getIjtbidrpts() {
		return this.ijtbidrpts;
	}

	public void setIjtbidrpts(Set<Ijtbidrpt> ijtbidrpts) {
		this.ijtbidrpts = ijtbidrpts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbmodulos")
	public Set<Ijtbidgraf> getIjtbidgrafs() {
		return this.ijtbidgrafs;
	}

	public void setIjtbidgrafs(Set<Ijtbidgraf> ijtbidgrafs) {
		this.ijtbidgrafs = ijtbidgrafs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbmodulos")
	public Set<Ijcaptionlinguas> getIjcaptionlinguases() {
		return this.ijcaptionlinguases;
	}

	public void setIjcaptionlinguases(Set<Ijcaptionlinguas> ijcaptionlinguases) {
		this.ijcaptionlinguases = ijcaptionlinguases;
	}

}
