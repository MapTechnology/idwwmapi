package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Ijamostragemdetctrl generated by hbm2java
 */
@Entity
@Table(name = "IJAMOSTRAGEMDETCTRL", uniqueConstraints = @UniqueConstraint(columnNames = {
		"IDAMOSTCTRL", "IDCAVIDADE", "AMOSTRA", "SUBAMOSTRA" }))
public class Ijamostragemdetctrl implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5461516501159865676L;
	private double idamostdetctrl;
	private Ijamostragemctrl ijamostragemctrl;
	private String dsespecific;
	private BigDecimal ordemleitura;
	private double idcavidade;
	private String nmcavidade;
	private BigDecimal amostra;
	private BigDecimal subamostra;
	private double vllido;
	private char stexecucao;
	private String idespecificcomp;
	private Date dthrivalespeccomp;

	public Ijamostragemdetctrl() {
	}

	public Ijamostragemdetctrl(double idamostdetctrl,
			Ijamostragemctrl ijamostragemctrl, String dsespecific,
			BigDecimal ordemleitura, double idcavidade, BigDecimal amostra,
			double vllido, char stexecucao) {
		this.idamostdetctrl = idamostdetctrl;
		this.ijamostragemctrl = ijamostragemctrl;
		this.dsespecific = dsespecific;
		this.ordemleitura = ordemleitura;
		this.idcavidade = idcavidade;
		this.amostra = amostra;
		this.vllido = vllido;
		this.stexecucao = stexecucao;
	}

	public Ijamostragemdetctrl(double idamostdetctrl,
			Ijamostragemctrl ijamostragemctrl, String dsespecific,
			BigDecimal ordemleitura, double idcavidade, String nmcavidade,
			BigDecimal amostra, BigDecimal subamostra, double vllido,
			char stexecucao, String idespecificcomp, Date dthrivalespeccomp) {
		this.idamostdetctrl = idamostdetctrl;
		this.ijamostragemctrl = ijamostragemctrl;
		this.dsespecific = dsespecific;
		this.ordemleitura = ordemleitura;
		this.idcavidade = idcavidade;
		this.nmcavidade = nmcavidade;
		this.amostra = amostra;
		this.subamostra = subamostra;
		this.vllido = vllido;
		this.stexecucao = stexecucao;
		this.idespecificcomp = idespecificcomp;
		this.dthrivalespeccomp = dthrivalespeccomp;
	}

	@Id
	@Column(name = "IDAMOSTDETCTRL", unique = true, nullable = false, precision = 126, scale = 0)
	public double getIdamostdetctrl() {
		return this.idamostdetctrl;
	}

	public void setIdamostdetctrl(double idamostdetctrl) {
		this.idamostdetctrl = idamostdetctrl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDAMOSTCTRL", nullable = false)
	public Ijamostragemctrl getIjamostragemctrl() {
		return this.ijamostragemctrl;
	}

	public void setIjamostragemctrl(Ijamostragemctrl ijamostragemctrl) {
		this.ijamostragemctrl = ijamostragemctrl;
	}

	@Column(name = "DSESPECIFIC", nullable = false, length = 60)
	public String getDsespecific() {
		return this.dsespecific;
	}

	public void setDsespecific(String dsespecific) {
		this.dsespecific = dsespecific;
	}

	@Column(name = "ORDEMLEITURA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOrdemleitura() {
		return this.ordemleitura;
	}

	public void setOrdemleitura(BigDecimal ordemleitura) {
		this.ordemleitura = ordemleitura;
	}

	@Column(name = "IDCAVIDADE", nullable = false, precision = 126, scale = 0)
	public double getIdcavidade() {
		return this.idcavidade;
	}

	public void setIdcavidade(double idcavidade) {
		this.idcavidade = idcavidade;
	}

	@Column(name = "NMCAVIDADE", length = 20)
	public String getNmcavidade() {
		return this.nmcavidade;
	}

	public void setNmcavidade(String nmcavidade) {
		this.nmcavidade = nmcavidade;
	}

	@Column(name = "AMOSTRA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getAmostra() {
		return this.amostra;
	}

	public void setAmostra(BigDecimal amostra) {
		this.amostra = amostra;
	}

	@Column(name = "SUBAMOSTRA", precision = 22, scale = 0)
	public BigDecimal getSubamostra() {
		return this.subamostra;
	}

	public void setSubamostra(BigDecimal subamostra) {
		this.subamostra = subamostra;
	}

	@Column(name = "VLLIDO", nullable = false, precision = 126, scale = 0)
	public double getVllido() {
		return this.vllido;
	}

	public void setVllido(double vllido) {
		this.vllido = vllido;
	}

	@Column(name = "STEXECUCAO", nullable = false, length = 1)
	public char getStexecucao() {
		return this.stexecucao;
	}

	public void setStexecucao(char stexecucao) {
		this.stexecucao = stexecucao;
	}

	@Column(name = "IDESPECIFICCOMP", length = 20)
	public String getIdespecificcomp() {
		return this.idespecificcomp;
	}

	public void setIdespecificcomp(String idespecificcomp) {
		this.idespecificcomp = idespecificcomp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRIVALESPECCOMP", length = 7)
	public Date getDthrivalespeccomp() {
		return this.dthrivalespeccomp;
	}

	public void setDthrivalespeccomp(Date dthrivalespeccomp) {
		this.dthrivalespeccomp = dthrivalespeccomp;
	}

}
