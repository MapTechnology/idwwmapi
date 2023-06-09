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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Ijctrliniproc generated by hbm2java
 */
@Entity
@Table(name = "IJCTRLINIPROC", uniqueConstraints = @UniqueConstraint(columnNames = {
		"CDINJETORA", "DTHRINICTRLINIPROC" }))
public class Ijctrliniproc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8865996517323648654L;
	private String idctrlinicproc;
	private Ijop ijop;
	private Ijtbinj ijtbinj;
	private Ijtbusu ijtbusuByCdtecfinal;
	private Ijtbusu ijtbusuByCdtecinicio;
	private Date dthrinictrliniproc;
	private Date dthrfimctrliniproc;
	private Date dthriniparsaida;
	private Date dthriniparentrada;
	private Set<Ijctrliniprocprod> ijctrliniprocprods = new HashSet<Ijctrliniprocprod>(
			0);
	private Set<Ijctrliniproctroca> ijctrliniproctrocas = new HashSet<Ijctrliniproctroca>(
			0);
	private Set<Ijreapar> ijreapars = new HashSet<Ijreapar>(0);
	private Set<Ijrearef> ijrearefs = new HashSet<Ijrearef>(0);

	public Ijctrliniproc() {
	}

	public Ijctrliniproc(String idctrlinicproc, Ijop ijop, Ijtbinj ijtbinj,
			Date dthrinictrliniproc) {
		this.idctrlinicproc = idctrlinicproc;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.dthrinictrliniproc = dthrinictrliniproc;
	}

	public Ijctrliniproc(String idctrlinicproc, Ijop ijop, Ijtbinj ijtbinj,
			Ijtbusu ijtbusuByCdtecfinal, Ijtbusu ijtbusuByCdtecinicio,
			Date dthrinictrliniproc, Date dthrfimctrliniproc,
			Date dthriniparsaida, Date dthriniparentrada,
			Set<Ijctrliniprocprod> ijctrliniprocprods,
			Set<Ijctrliniproctroca> ijctrliniproctrocas,
			Set<Ijreapar> ijreapars, Set<Ijrearef> ijrearefs) {
		this.idctrlinicproc = idctrlinicproc;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.ijtbusuByCdtecfinal = ijtbusuByCdtecfinal;
		this.ijtbusuByCdtecinicio = ijtbusuByCdtecinicio;
		this.dthrinictrliniproc = dthrinictrliniproc;
		this.dthrfimctrliniproc = dthrfimctrliniproc;
		this.dthriniparsaida = dthriniparsaida;
		this.dthriniparentrada = dthriniparentrada;
		this.ijctrliniprocprods = ijctrliniprocprods;
		this.ijctrliniproctrocas = ijctrliniproctrocas;
		this.ijreapars = ijreapars;
		this.ijrearefs = ijrearefs;
	}

	@Id
	@Column(name = "IDCTRLINICPROC", unique = true, nullable = false, length = 15)
	public String getIdctrlinicproc() {
		return this.idctrlinicproc;
	}

	public void setIdctrlinicproc(String idctrlinicproc) {
		this.idctrlinicproc = idctrlinicproc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROP", nullable = false)
	public Ijop getIjop() {
		return this.ijop;
	}

	public void setIjop(Ijop ijop) {
		this.ijop = ijop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", nullable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDTECFINAL")
	public Ijtbusu getIjtbusuByCdtecfinal() {
		return this.ijtbusuByCdtecfinal;
	}

	public void setIjtbusuByCdtecfinal(Ijtbusu ijtbusuByCdtecfinal) {
		this.ijtbusuByCdtecfinal = ijtbusuByCdtecfinal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDTECINICIO")
	public Ijtbusu getIjtbusuByCdtecinicio() {
		return this.ijtbusuByCdtecinicio;
	}

	public void setIjtbusuByCdtecinicio(Ijtbusu ijtbusuByCdtecinicio) {
		this.ijtbusuByCdtecinicio = ijtbusuByCdtecinicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRINICTRLINIPROC", nullable = false, length = 7)
	public Date getDthrinictrliniproc() {
		return this.dthrinictrliniproc;
	}

	public void setDthrinictrliniproc(Date dthrinictrliniproc) {
		this.dthrinictrliniproc = dthrinictrliniproc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFIMCTRLINIPROC", length = 7)
	public Date getDthrfimctrliniproc() {
		return this.dthrfimctrliniproc;
	}

	public void setDthrfimctrliniproc(Date dthrfimctrliniproc) {
		this.dthrfimctrliniproc = dthrfimctrliniproc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRINIPARSAIDA", length = 7)
	public Date getDthriniparsaida() {
		return this.dthriniparsaida;
	}

	public void setDthriniparsaida(Date dthriniparsaida) {
		this.dthriniparsaida = dthriniparsaida;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRINIPARENTRADA", length = 7)
	public Date getDthriniparentrada() {
		return this.dthriniparentrada;
	}

	public void setDthriniparentrada(Date dthriniparentrada) {
		this.dthriniparentrada = dthriniparentrada;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijctrliniproc")
	public Set<Ijctrliniprocprod> getIjctrliniprocprods() {
		return this.ijctrliniprocprods;
	}

	public void setIjctrliniprocprods(Set<Ijctrliniprocprod> ijctrliniprocprods) {
		this.ijctrliniprocprods = ijctrliniprocprods;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijctrliniproc")
	public Set<Ijctrliniproctroca> getIjctrliniproctrocas() {
		return this.ijctrliniproctrocas;
	}

	public void setIjctrliniproctrocas(
			Set<Ijctrliniproctroca> ijctrliniproctrocas) {
		this.ijctrliniproctrocas = ijctrliniproctrocas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijctrliniproc")
	public Set<Ijreapar> getIjreapars() {
		return this.ijreapars;
	}

	public void setIjreapars(Set<Ijreapar> ijreapars) {
		this.ijreapars = ijreapars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijctrliniproc")
	public Set<Ijrearef> getIjrearefs() {
		return this.ijrearefs;
	}

	public void setIjrearefs(Set<Ijrearef> ijrearefs) {
		this.ijrearefs = ijrearefs;
	}

}
