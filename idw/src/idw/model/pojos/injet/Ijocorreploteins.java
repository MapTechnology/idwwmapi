package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijocorreploteins generated by hbm2java
 */
@Entity
@Table(name = "IJOCORREPLOTEINS")
public class Ijocorreploteins implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4444779052299317675L;
	private IjocorreploteinsId id;
	private Ijop ijop;
	private Ijtbinj ijtbinj;
	private Ijtbmotreploteins ijtbmotreploteins;
	private Ijlotenipponins ijlotenipponins;
	private double qtdapontada;
	private BigDecimal cancelada;
	private Date dthrcancelamento;
	private BigDecimal exportado;
	private BigDecimal exportadocancel;

	public Ijocorreploteins() {
	}

	public Ijocorreploteins(IjocorreploteinsId id, Ijop ijop, Ijtbinj ijtbinj,
			Ijtbmotreploteins ijtbmotreploteins,
			Ijlotenipponins ijlotenipponins, double qtdapontada,
			BigDecimal cancelada, BigDecimal exportado) {
		this.id = id;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.ijtbmotreploteins = ijtbmotreploteins;
		this.ijlotenipponins = ijlotenipponins;
		this.qtdapontada = qtdapontada;
		this.cancelada = cancelada;
		this.exportado = exportado;
	}

	public Ijocorreploteins(IjocorreploteinsId id, Ijop ijop, Ijtbinj ijtbinj,
			Ijtbmotreploteins ijtbmotreploteins,
			Ijlotenipponins ijlotenipponins, double qtdapontada,
			BigDecimal cancelada, Date dthrcancelamento, BigDecimal exportado,
			BigDecimal exportadocancel) {
		this.id = id;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.ijtbmotreploteins = ijtbmotreploteins;
		this.ijlotenipponins = ijlotenipponins;
		this.qtdapontada = qtdapontada;
		this.cancelada = cancelada;
		this.dthrcancelamento = dthrcancelamento;
		this.exportado = exportado;
		this.exportadocancel = exportadocancel;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "nrlote", column = @Column(name = "NRLOTE", nullable = false, length = 20)),
			@AttributeOverride(name = "dthrreploteinsumo", column = @Column(name = "DTHRREPLOTEINSUMO", nullable = false, length = 7)) })
	public IjocorreploteinsId getId() {
		return this.id;
	}

	public void setId(IjocorreploteinsId id) {
		this.id = id;
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
	@JoinColumn(name = "CDINJETORA", nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDMOTREPLOTEINS", nullable = false)
	public Ijtbmotreploteins getIjtbmotreploteins() {
		return this.ijtbmotreploteins;
	}

	public void setIjtbmotreploteins(Ijtbmotreploteins ijtbmotreploteins) {
		this.ijtbmotreploteins = ijtbmotreploteins;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NRLOTE", nullable = false, insertable = false, updatable = false)
	public Ijlotenipponins getIjlotenipponins() {
		return this.ijlotenipponins;
	}

	public void setIjlotenipponins(Ijlotenipponins ijlotenipponins) {
		this.ijlotenipponins = ijlotenipponins;
	}

	@Column(name = "QTDAPONTADA", nullable = false, precision = 126, scale = 0)
	public double getQtdapontada() {
		return this.qtdapontada;
	}

	public void setQtdapontada(double qtdapontada) {
		this.qtdapontada = qtdapontada;
	}

	@Column(name = "CANCELADA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCancelada() {
		return this.cancelada;
	}

	public void setCancelada(BigDecimal cancelada) {
		this.cancelada = cancelada;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRCANCELAMENTO", length = 7)
	public Date getDthrcancelamento() {
		return this.dthrcancelamento;
	}

	public void setDthrcancelamento(Date dthrcancelamento) {
		this.dthrcancelamento = dthrcancelamento;
	}

	@Column(name = "EXPORTADO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getExportado() {
		return this.exportado;
	}

	public void setExportado(BigDecimal exportado) {
		this.exportado = exportado;
	}

	@Column(name = "EXPORTADOCANCEL", precision = 22, scale = 0)
	public BigDecimal getExportadocancel() {
		return this.exportadocancel;
	}

	public void setExportadocancel(BigDecimal exportadocancel) {
		this.exportadocancel = exportadocancel;
	}

}
