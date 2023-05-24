package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijespecinsppro generated by hbm2java
 */
@Entity
@Table(name = "IJESPECINSPPRO")
public class Ijespecinsppro implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1493241020161796968L;
	private IjespecinspproId id;
	private Ijtbusu ijtbusu;
	private Ijtbmetodocgq ijtbmetodocgq;
	private Ijtbpro ijtbpro;
	private Ijtbdrivers ijtbdrivers;
	private Date dthrfvalespecific;
	private BigDecimal tamamostra;
	private double especificbasevl;
	private double especificliaprvl;
	private double especificlsaprvl;
	private double especificliactvl;
	private double especificlsactvl;
	private double especificliaprperc;
	private double especificlsaprperc;
	private double especificliactperc;
	private double especificlsactperc;
	private char visperc;
	private char especificativa;
	private Character coletaamstrporcav;
	private Character tpespeclimites;
	private Double especificlvarapr;
	private Double especificlvaract;
	private BigDecimal calcpelamedia;
	private BigDecimal selecnocgq;
	private Double especiflvaractinf;
	private Double especiflvaraprinf;
	private BigDecimal habilitaact;
	private char tpespeclimite;
	private BigDecimal tpentradavlr;
	private Double liperctolerancia;
	private Double lsperctolerancia;
	private Set<Ijespecinspromedia> ijespecinspromedias = new HashSet<Ijespecinspromedia>(
			0);

	public Ijespecinsppro() {
	}

	public Ijespecinsppro(IjespecinspproId id, Ijtbpro ijtbpro,
			BigDecimal tamamostra, double especificbasevl,
			double especificliaprvl, double especificlsaprvl,
			double especificliactvl, double especificlsactvl,
			double especificliaprperc, double especificlsaprperc,
			double especificliactperc, double especificlsactperc, char visperc,
			char especificativa, BigDecimal calcpelamedia,
			BigDecimal selecnocgq, BigDecimal habilitaact, char tpespeclimite) {
		this.id = id;
		this.ijtbpro = ijtbpro;
		this.tamamostra = tamamostra;
		this.especificbasevl = especificbasevl;
		this.especificliaprvl = especificliaprvl;
		this.especificlsaprvl = especificlsaprvl;
		this.especificliactvl = especificliactvl;
		this.especificlsactvl = especificlsactvl;
		this.especificliaprperc = especificliaprperc;
		this.especificlsaprperc = especificlsaprperc;
		this.especificliactperc = especificliactperc;
		this.especificlsactperc = especificlsactperc;
		this.visperc = visperc;
		this.especificativa = especificativa;
		this.calcpelamedia = calcpelamedia;
		this.selecnocgq = selecnocgq;
		this.habilitaact = habilitaact;
		this.tpespeclimite = tpespeclimite;
	}

	public Ijespecinsppro(IjespecinspproId id, Ijtbusu ijtbusu,
			Ijtbmetodocgq ijtbmetodocgq, Ijtbpro ijtbpro,
			Ijtbdrivers ijtbdrivers, Date dthrfvalespecific,
			BigDecimal tamamostra, double especificbasevl,
			double especificliaprvl, double especificlsaprvl,
			double especificliactvl, double especificlsactvl,
			double especificliaprperc, double especificlsaprperc,
			double especificliactperc, double especificlsactperc, char visperc,
			char especificativa, Character coletaamstrporcav,
			Character tpespeclimites, Double especificlvarapr,
			Double especificlvaract, BigDecimal calcpelamedia,
			BigDecimal selecnocgq, Double especiflvaractinf,
			Double especiflvaraprinf, BigDecimal habilitaact,
			char tpespeclimite, BigDecimal tpentradavlr,
			Double liperctolerancia, Double lsperctolerancia,
			Set<Ijespecinspromedia> ijespecinspromedias) {
		this.id = id;
		this.ijtbusu = ijtbusu;
		this.ijtbmetodocgq = ijtbmetodocgq;
		this.ijtbpro = ijtbpro;
		this.ijtbdrivers = ijtbdrivers;
		this.dthrfvalespecific = dthrfvalespecific;
		this.tamamostra = tamamostra;
		this.especificbasevl = especificbasevl;
		this.especificliaprvl = especificliaprvl;
		this.especificlsaprvl = especificlsaprvl;
		this.especificliactvl = especificliactvl;
		this.especificlsactvl = especificlsactvl;
		this.especificliaprperc = especificliaprperc;
		this.especificlsaprperc = especificlsaprperc;
		this.especificliactperc = especificliactperc;
		this.especificlsactperc = especificlsactperc;
		this.visperc = visperc;
		this.especificativa = especificativa;
		this.coletaamstrporcav = coletaamstrporcav;
		this.tpespeclimites = tpespeclimites;
		this.especificlvarapr = especificlvarapr;
		this.especificlvaract = especificlvaract;
		this.calcpelamedia = calcpelamedia;
		this.selecnocgq = selecnocgq;
		this.especiflvaractinf = especiflvaractinf;
		this.especiflvaraprinf = especiflvaraprinf;
		this.habilitaact = habilitaact;
		this.tpespeclimite = tpespeclimite;
		this.tpentradavlr = tpentradavlr;
		this.liperctolerancia = liperctolerancia;
		this.lsperctolerancia = lsperctolerancia;
		this.ijespecinspromedias = ijespecinspromedias;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "idespecific", column = @Column(name = "IDESPECIFIC", nullable = false, length = 20)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "dthrivalespecific", column = @Column(name = "DTHRIVALESPECIFIC", nullable = false, length = 7)) })
	public IjespecinspproId getId() {
		return this.id;
	}

	public void setId(IjespecinspproId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSURESP")
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDMETODO")
	public Ijtbmetodocgq getIjtbmetodocgq() {
		return this.ijtbmetodocgq;
	}

	public void setIjtbmetodocgq(Ijtbmetodocgq ijtbmetodocgq) {
		this.ijtbmetodocgq = ijtbmetodocgq;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDPRODUTO", nullable = false, insertable = false, updatable = false)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDDRIVER")
	public Ijtbdrivers getIjtbdrivers() {
		return this.ijtbdrivers;
	}

	public void setIjtbdrivers(Ijtbdrivers ijtbdrivers) {
		this.ijtbdrivers = ijtbdrivers;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFVALESPECIFIC", length = 7)
	public Date getDthrfvalespecific() {
		return this.dthrfvalespecific;
	}

	public void setDthrfvalespecific(Date dthrfvalespecific) {
		this.dthrfvalespecific = dthrfvalespecific;
	}

	@Column(name = "TAMAMOSTRA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTamamostra() {
		return this.tamamostra;
	}

	public void setTamamostra(BigDecimal tamamostra) {
		this.tamamostra = tamamostra;
	}

	@Column(name = "ESPECIFICBASEVL", nullable = false, precision = 126, scale = 0)
	public double getEspecificbasevl() {
		return this.especificbasevl;
	}

	public void setEspecificbasevl(double especificbasevl) {
		this.especificbasevl = especificbasevl;
	}

	@Column(name = "ESPECIFICLIAPRVL", nullable = false, precision = 126, scale = 0)
	public double getEspecificliaprvl() {
		return this.especificliaprvl;
	}

	public void setEspecificliaprvl(double especificliaprvl) {
		this.especificliaprvl = especificliaprvl;
	}

	@Column(name = "ESPECIFICLSAPRVL", nullable = false, precision = 126, scale = 0)
	public double getEspecificlsaprvl() {
		return this.especificlsaprvl;
	}

	public void setEspecificlsaprvl(double especificlsaprvl) {
		this.especificlsaprvl = especificlsaprvl;
	}

	@Column(name = "ESPECIFICLIACTVL", nullable = false, precision = 126, scale = 0)
	public double getEspecificliactvl() {
		return this.especificliactvl;
	}

	public void setEspecificliactvl(double especificliactvl) {
		this.especificliactvl = especificliactvl;
	}

	@Column(name = "ESPECIFICLSACTVL", nullable = false, precision = 126, scale = 0)
	public double getEspecificlsactvl() {
		return this.especificlsactvl;
	}

	public void setEspecificlsactvl(double especificlsactvl) {
		this.especificlsactvl = especificlsactvl;
	}

	@Column(name = "ESPECIFICLIAPRPERC", nullable = false, precision = 126, scale = 0)
	public double getEspecificliaprperc() {
		return this.especificliaprperc;
	}

	public void setEspecificliaprperc(double especificliaprperc) {
		this.especificliaprperc = especificliaprperc;
	}

	@Column(name = "ESPECIFICLSAPRPERC", nullable = false, precision = 126, scale = 0)
	public double getEspecificlsaprperc() {
		return this.especificlsaprperc;
	}

	public void setEspecificlsaprperc(double especificlsaprperc) {
		this.especificlsaprperc = especificlsaprperc;
	}

	@Column(name = "ESPECIFICLIACTPERC", nullable = false, precision = 126, scale = 0)
	public double getEspecificliactperc() {
		return this.especificliactperc;
	}

	public void setEspecificliactperc(double especificliactperc) {
		this.especificliactperc = especificliactperc;
	}

	@Column(name = "ESPECIFICLSACTPERC", nullable = false, precision = 126, scale = 0)
	public double getEspecificlsactperc() {
		return this.especificlsactperc;
	}

	public void setEspecificlsactperc(double especificlsactperc) {
		this.especificlsactperc = especificlsactperc;
	}

	@Column(name = "VISPERC", nullable = false, length = 1)
	public char getVisperc() {
		return this.visperc;
	}

	public void setVisperc(char visperc) {
		this.visperc = visperc;
	}

	@Column(name = "ESPECIFICATIVA", nullable = false, length = 1)
	public char getEspecificativa() {
		return this.especificativa;
	}

	public void setEspecificativa(char especificativa) {
		this.especificativa = especificativa;
	}

	@Column(name = "COLETAAMSTRPORCAV", length = 1)
	public Character getColetaamstrporcav() {
		return this.coletaamstrporcav;
	}

	public void setColetaamstrporcav(Character coletaamstrporcav) {
		this.coletaamstrporcav = coletaamstrporcav;
	}

	@Column(name = "TPESPECLIMITES", length = 1)
	public Character getTpespeclimites() {
		return this.tpespeclimites;
	}

	public void setTpespeclimites(Character tpespeclimites) {
		this.tpespeclimites = tpespeclimites;
	}

	@Column(name = "ESPECIFICLVARAPR", precision = 126, scale = 0)
	public Double getEspecificlvarapr() {
		return this.especificlvarapr;
	}

	public void setEspecificlvarapr(Double especificlvarapr) {
		this.especificlvarapr = especificlvarapr;
	}

	@Column(name = "ESPECIFICLVARACT", precision = 126, scale = 0)
	public Double getEspecificlvaract() {
		return this.especificlvaract;
	}

	public void setEspecificlvaract(Double especificlvaract) {
		this.especificlvaract = especificlvaract;
	}

	@Column(name = "CALCPELAMEDIA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCalcpelamedia() {
		return this.calcpelamedia;
	}

	public void setCalcpelamedia(BigDecimal calcpelamedia) {
		this.calcpelamedia = calcpelamedia;
	}

	@Column(name = "SELECNOCGQ", nullable = false, precision = 22, scale = 0)
	public BigDecimal getSelecnocgq() {
		return this.selecnocgq;
	}

	public void setSelecnocgq(BigDecimal selecnocgq) {
		this.selecnocgq = selecnocgq;
	}

	@Column(name = "ESPECIFLVARACTINF", precision = 126, scale = 0)
	public Double getEspeciflvaractinf() {
		return this.especiflvaractinf;
	}

	public void setEspeciflvaractinf(Double especiflvaractinf) {
		this.especiflvaractinf = especiflvaractinf;
	}

	@Column(name = "ESPECIFLVARAPRINF", precision = 126, scale = 0)
	public Double getEspeciflvaraprinf() {
		return this.especiflvaraprinf;
	}

	public void setEspeciflvaraprinf(Double especiflvaraprinf) {
		this.especiflvaraprinf = especiflvaraprinf;
	}

	@Column(name = "HABILITAACT", nullable = false, precision = 22, scale = 0)
	public BigDecimal getHabilitaact() {
		return this.habilitaact;
	}

	public void setHabilitaact(BigDecimal habilitaact) {
		this.habilitaact = habilitaact;
	}

	@Column(name = "TPESPECLIMITE", nullable = false, length = 1)
	public char getTpespeclimite() {
		return this.tpespeclimite;
	}

	public void setTpespeclimite(char tpespeclimite) {
		this.tpespeclimite = tpespeclimite;
	}

	@Column(name = "TPENTRADAVLR", precision = 22, scale = 0)
	public BigDecimal getTpentradavlr() {
		return this.tpentradavlr;
	}

	public void setTpentradavlr(BigDecimal tpentradavlr) {
		this.tpentradavlr = tpentradavlr;
	}

	@Column(name = "LIPERCTOLERANCIA", precision = 126, scale = 0)
	public Double getLiperctolerancia() {
		return this.liperctolerancia;
	}

	public void setLiperctolerancia(Double liperctolerancia) {
		this.liperctolerancia = liperctolerancia;
	}

	@Column(name = "LSPERCTOLERANCIA", precision = 126, scale = 0)
	public Double getLsperctolerancia() {
		return this.lsperctolerancia;
	}

	public void setLsperctolerancia(Double lsperctolerancia) {
		this.lsperctolerancia = lsperctolerancia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijespecinsppro")
	public Set<Ijespecinspromedia> getIjespecinspromedias() {
		return this.ijespecinspromedias;
	}

	public void setIjespecinspromedias(
			Set<Ijespecinspromedia> ijespecinspromedias) {
		this.ijespecinspromedias = ijespecinspromedias;
	}

}
