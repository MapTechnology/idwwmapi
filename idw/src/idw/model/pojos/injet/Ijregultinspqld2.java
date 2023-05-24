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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijregultinspqld2 generated by hbm2java
 */
@Entity
@Table(name = "IJREGULTINSPQLD2")
public class Ijregultinspqld2 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6565674982163560637L;
	private Ijregultinspqld2Id id;
	private Ijop ijop;
	private Ijprodxgrpparam ijprodxgrpparam;
	private double tamminlote;
	private BigDecimal tpfrequencia;
	private double qtdprodaleiniop;
	private double qtdrejgeracaoale;
	private BigDecimal tmpliminspqld;
	private double qtdprodrefultale;
	private Date dthrrefultale;
	private double percrefultale;
	private char houvealertaini;
	private double qtdprodaposprobqld;
	private double qtprodultprobqld;
	private BigDecimal avaliandoprobqld;
	private BigDecimal cfgjustdbqld1;
	private BigDecimal qtdjustdbqld1;
	private BigDecimal cfgjustdbqld2;
	private BigDecimal qtdjustdbqld2;
	private BigDecimal cfgjustdbqld3;
	private BigDecimal qtdjustdbqld3;
	private Set<Ijregultinspqld2fr> ijregultinspqld2frs = new HashSet<Ijregultinspqld2fr>(
			0);

	public Ijregultinspqld2() {
	}

	public Ijregultinspqld2(Ijregultinspqld2Id id, Ijop ijop,
			Ijprodxgrpparam ijprodxgrpparam, double tamminlote,
			BigDecimal tpfrequencia, double qtdprodaleiniop,
			double qtdrejgeracaoale, BigDecimal tmpliminspqld,
			double qtdprodrefultale, Date dthrrefultale, double percrefultale,
			char houvealertaini, double qtdprodaposprobqld,
			double qtprodultprobqld, BigDecimal avaliandoprobqld,
			BigDecimal cfgjustdbqld1, BigDecimal qtdjustdbqld1,
			BigDecimal cfgjustdbqld2, BigDecimal qtdjustdbqld2,
			BigDecimal cfgjustdbqld3, BigDecimal qtdjustdbqld3) {
		this.id = id;
		this.ijop = ijop;
		this.ijprodxgrpparam = ijprodxgrpparam;
		this.tamminlote = tamminlote;
		this.tpfrequencia = tpfrequencia;
		this.qtdprodaleiniop = qtdprodaleiniop;
		this.qtdrejgeracaoale = qtdrejgeracaoale;
		this.tmpliminspqld = tmpliminspqld;
		this.qtdprodrefultale = qtdprodrefultale;
		this.dthrrefultale = dthrrefultale;
		this.percrefultale = percrefultale;
		this.houvealertaini = houvealertaini;
		this.qtdprodaposprobqld = qtdprodaposprobqld;
		this.qtprodultprobqld = qtprodultprobqld;
		this.avaliandoprobqld = avaliandoprobqld;
		this.cfgjustdbqld1 = cfgjustdbqld1;
		this.qtdjustdbqld1 = qtdjustdbqld1;
		this.cfgjustdbqld2 = cfgjustdbqld2;
		this.qtdjustdbqld2 = qtdjustdbqld2;
		this.cfgjustdbqld3 = cfgjustdbqld3;
		this.qtdjustdbqld3 = qtdjustdbqld3;
	}

	public Ijregultinspqld2(Ijregultinspqld2Id id, Ijop ijop,
			Ijprodxgrpparam ijprodxgrpparam, double tamminlote,
			BigDecimal tpfrequencia, double qtdprodaleiniop,
			double qtdrejgeracaoale, BigDecimal tmpliminspqld,
			double qtdprodrefultale, Date dthrrefultale, double percrefultale,
			char houvealertaini, double qtdprodaposprobqld,
			double qtprodultprobqld, BigDecimal avaliandoprobqld,
			BigDecimal cfgjustdbqld1, BigDecimal qtdjustdbqld1,
			BigDecimal cfgjustdbqld2, BigDecimal qtdjustdbqld2,
			BigDecimal cfgjustdbqld3, BigDecimal qtdjustdbqld3,
			Set<Ijregultinspqld2fr> ijregultinspqld2frs) {
		this.id = id;
		this.ijop = ijop;
		this.ijprodxgrpparam = ijprodxgrpparam;
		this.tamminlote = tamminlote;
		this.tpfrequencia = tpfrequencia;
		this.qtdprodaleiniop = qtdprodaleiniop;
		this.qtdrejgeracaoale = qtdrejgeracaoale;
		this.tmpliminspqld = tmpliminspqld;
		this.qtdprodrefultale = qtdprodrefultale;
		this.dthrrefultale = dthrrefultale;
		this.percrefultale = percrefultale;
		this.houvealertaini = houvealertaini;
		this.qtdprodaposprobqld = qtdprodaposprobqld;
		this.qtprodultprobqld = qtprodultprobqld;
		this.avaliandoprobqld = avaliandoprobqld;
		this.cfgjustdbqld1 = cfgjustdbqld1;
		this.qtdjustdbqld1 = qtdjustdbqld1;
		this.cfgjustdbqld2 = cfgjustdbqld2;
		this.qtdjustdbqld2 = qtdjustdbqld2;
		this.cfgjustdbqld3 = cfgjustdbqld3;
		this.qtdjustdbqld3 = qtdjustdbqld3;
		this.ijregultinspqld2frs = ijregultinspqld2frs;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "cdgrpparam", column = @Column(name = "CDGRPPARAM", nullable = false, length = 6)) })
	public Ijregultinspqld2Id getId() {
		return this.id;
	}

	public void setId(Ijregultinspqld2Id id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROP", nullable = false, insertable = false, updatable = false)
	public Ijop getIjop() {
		return this.ijop;
	}

	public void setIjop(Ijop ijop) {
		this.ijop = ijop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDPRODUTO", referencedColumnName = "CDPRODUTO", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDGRPPARAM", referencedColumnName = "CDGRPPARAM", nullable = false, insertable = false, updatable = false) })
	public Ijprodxgrpparam getIjprodxgrpparam() {
		return this.ijprodxgrpparam;
	}

	public void setIjprodxgrpparam(Ijprodxgrpparam ijprodxgrpparam) {
		this.ijprodxgrpparam = ijprodxgrpparam;
	}

	@Column(name = "TAMMINLOTE", nullable = false, precision = 126, scale = 0)
	public double getTamminlote() {
		return this.tamminlote;
	}

	public void setTamminlote(double tamminlote) {
		this.tamminlote = tamminlote;
	}

	@Column(name = "TPFREQUENCIA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTpfrequencia() {
		return this.tpfrequencia;
	}

	public void setTpfrequencia(BigDecimal tpfrequencia) {
		this.tpfrequencia = tpfrequencia;
	}

	@Column(name = "QTDPRODALEINIOP", nullable = false, precision = 126, scale = 0)
	public double getQtdprodaleiniop() {
		return this.qtdprodaleiniop;
	}

	public void setQtdprodaleiniop(double qtdprodaleiniop) {
		this.qtdprodaleiniop = qtdprodaleiniop;
	}

	@Column(name = "QTDREJGERACAOALE", nullable = false, precision = 126, scale = 0)
	public double getQtdrejgeracaoale() {
		return this.qtdrejgeracaoale;
	}

	public void setQtdrejgeracaoale(double qtdrejgeracaoale) {
		this.qtdrejgeracaoale = qtdrejgeracaoale;
	}

	@Column(name = "TMPLIMINSPQLD", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTmpliminspqld() {
		return this.tmpliminspqld;
	}

	public void setTmpliminspqld(BigDecimal tmpliminspqld) {
		this.tmpliminspqld = tmpliminspqld;
	}

	@Column(name = "QTDPRODREFULTALE", nullable = false, precision = 126, scale = 0)
	public double getQtdprodrefultale() {
		return this.qtdprodrefultale;
	}

	public void setQtdprodrefultale(double qtdprodrefultale) {
		this.qtdprodrefultale = qtdprodrefultale;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRREFULTALE", nullable = false, length = 7)
	public Date getDthrrefultale() {
		return this.dthrrefultale;
	}

	public void setDthrrefultale(Date dthrrefultale) {
		this.dthrrefultale = dthrrefultale;
	}

	@Column(name = "PERCREFULTALE", nullable = false, precision = 126, scale = 0)
	public double getPercrefultale() {
		return this.percrefultale;
	}

	public void setPercrefultale(double percrefultale) {
		this.percrefultale = percrefultale;
	}

	@Column(name = "HOUVEALERTAINI", nullable = false, length = 1)
	public char getHouvealertaini() {
		return this.houvealertaini;
	}

	public void setHouvealertaini(char houvealertaini) {
		this.houvealertaini = houvealertaini;
	}

	@Column(name = "QTDPRODAPOSPROBQLD", nullable = false, precision = 126, scale = 0)
	public double getQtdprodaposprobqld() {
		return this.qtdprodaposprobqld;
	}

	public void setQtdprodaposprobqld(double qtdprodaposprobqld) {
		this.qtdprodaposprobqld = qtdprodaposprobqld;
	}

	@Column(name = "QTPRODULTPROBQLD", nullable = false, precision = 126, scale = 0)
	public double getQtprodultprobqld() {
		return this.qtprodultprobqld;
	}

	public void setQtprodultprobqld(double qtprodultprobqld) {
		this.qtprodultprobqld = qtprodultprobqld;
	}

	@Column(name = "AVALIANDOPROBQLD", nullable = false, precision = 22, scale = 0)
	public BigDecimal getAvaliandoprobqld() {
		return this.avaliandoprobqld;
	}

	public void setAvaliandoprobqld(BigDecimal avaliandoprobqld) {
		this.avaliandoprobqld = avaliandoprobqld;
	}

	@Column(name = "CFGJUSTDBQLD1", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCfgjustdbqld1() {
		return this.cfgjustdbqld1;
	}

	public void setCfgjustdbqld1(BigDecimal cfgjustdbqld1) {
		this.cfgjustdbqld1 = cfgjustdbqld1;
	}

	@Column(name = "QTDJUSTDBQLD1", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtdjustdbqld1() {
		return this.qtdjustdbqld1;
	}

	public void setQtdjustdbqld1(BigDecimal qtdjustdbqld1) {
		this.qtdjustdbqld1 = qtdjustdbqld1;
	}

	@Column(name = "CFGJUSTDBQLD2", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCfgjustdbqld2() {
		return this.cfgjustdbqld2;
	}

	public void setCfgjustdbqld2(BigDecimal cfgjustdbqld2) {
		this.cfgjustdbqld2 = cfgjustdbqld2;
	}

	@Column(name = "QTDJUSTDBQLD2", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtdjustdbqld2() {
		return this.qtdjustdbqld2;
	}

	public void setQtdjustdbqld2(BigDecimal qtdjustdbqld2) {
		this.qtdjustdbqld2 = qtdjustdbqld2;
	}

	@Column(name = "CFGJUSTDBQLD3", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCfgjustdbqld3() {
		return this.cfgjustdbqld3;
	}

	public void setCfgjustdbqld3(BigDecimal cfgjustdbqld3) {
		this.cfgjustdbqld3 = cfgjustdbqld3;
	}

	@Column(name = "QTDJUSTDBQLD3", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtdjustdbqld3() {
		return this.qtdjustdbqld3;
	}

	public void setQtdjustdbqld3(BigDecimal qtdjustdbqld3) {
		this.qtdjustdbqld3 = qtdjustdbqld3;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijregultinspqld2")
	public Set<Ijregultinspqld2fr> getIjregultinspqld2frs() {
		return this.ijregultinspqld2frs;
	}

	public void setIjregultinspqld2frs(
			Set<Ijregultinspqld2fr> ijregultinspqld2frs) {
		this.ijregultinspqld2frs = ijregultinspqld2frs;
	}

}