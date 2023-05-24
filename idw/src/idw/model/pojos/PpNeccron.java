package idw.model.pojos;
// Generated 28/07/2011 10:26:23 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
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

import idw.model.pojos.template.PpNeccronTemplate;

/**
 * PpNeccron generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PP_NECCRON")
public class PpNeccron extends PpNeccronTemplate implements java.io.Serializable {

	private Long idNeccron;
	private PpNec ppNec;
	private Date dtDesejada;
	private BigDecimal qtDesejada;
	private Date dtEstimada;
	private Set<PpPlaneccron> ppPlaneccrons = new HashSet<PpPlaneccron>(0);

	public PpNeccron() {
	}

	public PpNeccron(Long idNeccron, PpNec ppNec) {
		this.idNeccron = idNeccron;
		this.ppNec = ppNec;
	}

	public PpNeccron(Long idNeccron, PpNec ppNec, Date dtDesejada,
			BigDecimal qtDesejada) {
		this.idNeccron = idNeccron;
		this.ppNec = ppNec;
		this.dtDesejada = dtDesejada;
		this.qtDesejada = qtDesejada;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "PP_NECCRON_SEQ")
	@javax.persistence.SequenceGenerator(name = "PP_NECCRON_SEQ", sequenceName = "PP_NECCRON_SEQ")	
	@Column(name = "ID_NECCRON", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdNeccron() {
		return this.idNeccron;
	}

	public void setIdNeccron(Long idNeccron) {
		this.idNeccron = idNeccron;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NEC", nullable = false)
	public PpNec getPpNec() {
		return this.ppNec;
	}

	public void setPpNec(PpNec ppNec) {
		this.ppNec = ppNec;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_DESEJADA")
	public Date getDtDesejada() {
		return this.dtDesejada;
	}

	public void setDtDesejada(Date dtDesejada) {
		this.dtDesejada = dtDesejada;
	}

	@Column(name = "QT_DESEJADA", precision = 63, scale = 0)
	public BigDecimal getQtDesejada() {
		return this.qtDesejada;
	}

	public void setQtDesejada(BigDecimal qtDesejada) {
		this.qtDesejada = qtDesejada;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_ESTIMADA", length = 7)
	public Date getDtEstimada() {
		return this.dtEstimada;
	}

	public void setDtEstimada(Date dtEstimada) {
		this.dtEstimada = dtEstimada;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ppNeccron")
	public Set<PpPlaneccron> getPpPlaneccrons() {
		return this.ppPlaneccrons;
	}

	public void setPpPlaneccrons(Set<PpPlaneccron> ppPlaneccrons) {
		this.ppPlaneccrons = ppPlaneccrons;
	}
}