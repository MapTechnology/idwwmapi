package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijengleituraciclos generated by hbm2java
 */
@Entity
@Table(name = "IJENGLEITURACICLOS")
public class Ijengleituraciclos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6609767661835211377L;
	private IjengleituraciclosId id;
	private Ijestmol ijestmol;
	private Ijtbinj ijtbinj;
	private Ijtbusu ijtbusu;
	private Date periodofinal;
	private double ciclomediolido;
	private double ciclopadraodef;
	private String nrop;
	private Date dthrivalestrumolde;
	private double indref;
	private double indpar;
	private Date dthrgeracao;
	private Date dthrintervusu;
	private String status;
	private String observacao;

	public Ijengleituraciclos() {
	}

	public Ijengleituraciclos(IjengleituraciclosId id, Ijestmol ijestmol,
			Ijtbinj ijtbinj, Date periodofinal, double ciclomediolido,
			double ciclopadraodef, String nrop, Date dthrivalestrumolde,
			double indref, double indpar, Date dthrgeracao, String status) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijtbinj = ijtbinj;
		this.periodofinal = periodofinal;
		this.ciclomediolido = ciclomediolido;
		this.ciclopadraodef = ciclopadraodef;
		this.nrop = nrop;
		this.dthrivalestrumolde = dthrivalestrumolde;
		this.indref = indref;
		this.indpar = indpar;
		this.dthrgeracao = dthrgeracao;
		this.status = status;
	}

	public Ijengleituraciclos(IjengleituraciclosId id, Ijestmol ijestmol,
			Ijtbinj ijtbinj, Ijtbusu ijtbusu, Date periodofinal,
			double ciclomediolido, double ciclopadraodef, String nrop,
			Date dthrivalestrumolde, double indref, double indpar,
			Date dthrgeracao, Date dthrintervusu, String status,
			String observacao) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijtbinj = ijtbinj;
		this.ijtbusu = ijtbusu;
		this.periodofinal = periodofinal;
		this.ciclomediolido = ciclomediolido;
		this.ciclopadraodef = ciclopadraodef;
		this.nrop = nrop;
		this.dthrivalestrumolde = dthrivalestrumolde;
		this.indref = indref;
		this.indpar = indpar;
		this.dthrgeracao = dthrgeracao;
		this.dthrintervusu = dthrintervusu;
		this.status = status;
		this.observacao = observacao;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "periodoinicial", column = @Column(name = "PERIODOINICIAL", nullable = false, length = 7)) })
	public IjengleituraciclosId getId() {
		return this.id;
	}

	public void setId(IjengleituraciclosId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA", nullable = false, insertable = false, updatable = false) })
	public Ijestmol getIjestmol() {
		return this.ijestmol;
	}

	public void setIjestmol(Ijestmol ijestmol) {
		this.ijestmol = ijestmol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUARIOINTERV")
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PERIODOFINAL", nullable = false, length = 7)
	public Date getPeriodofinal() {
		return this.periodofinal;
	}

	public void setPeriodofinal(Date periodofinal) {
		this.periodofinal = periodofinal;
	}

	@Column(name = "CICLOMEDIOLIDO", nullable = false, precision = 126, scale = 0)
	public double getCiclomediolido() {
		return this.ciclomediolido;
	}

	public void setCiclomediolido(double ciclomediolido) {
		this.ciclomediolido = ciclomediolido;
	}

	@Column(name = "CICLOPADRAODEF", nullable = false, precision = 126, scale = 0)
	public double getCiclopadraodef() {
		return this.ciclopadraodef;
	}

	public void setCiclopadraodef(double ciclopadraodef) {
		this.ciclopadraodef = ciclopadraodef;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRIVALESTRUMOLDE", nullable = false, length = 7)
	public Date getDthrivalestrumolde() {
		return this.dthrivalestrumolde;
	}

	public void setDthrivalestrumolde(Date dthrivalestrumolde) {
		this.dthrivalestrumolde = dthrivalestrumolde;
	}

	@Column(name = "INDREF", nullable = false, precision = 126, scale = 0)
	public double getIndref() {
		return this.indref;
	}

	public void setIndref(double indref) {
		this.indref = indref;
	}

	@Column(name = "INDPAR", nullable = false, precision = 126, scale = 0)
	public double getIndpar() {
		return this.indpar;
	}

	public void setIndpar(double indpar) {
		this.indpar = indpar;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRGERACAO", nullable = false, length = 7)
	public Date getDthrgeracao() {
		return this.dthrgeracao;
	}

	public void setDthrgeracao(Date dthrgeracao) {
		this.dthrgeracao = dthrgeracao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRINTERVUSU", length = 7)
	public Date getDthrintervusu() {
		return this.dthrintervusu;
	}

	public void setDthrintervusu(Date dthrintervusu) {
		this.dthrintervusu = dthrintervusu;
	}

	@Column(name = "STATUS", nullable = false, length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "OBSERVACAO", length = 250)
	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
