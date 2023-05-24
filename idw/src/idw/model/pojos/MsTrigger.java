package idw.model.pojos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.MsTriggerTemplate;

/**
 * MsTrigger generated by hbm2java
 */
@Entity
@Table(name = "MS_TRIGGER")
public class MsTrigger extends MsTriggerTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4697361609903013044L;
	private BigDecimal idTrigger;
	private OmTppt omTppt;
	private MsTpevt msTpevt;
	private MsDetector msDetector;
	private DwFolha dwFolha;
	private MsInd msInd;
	private OmPt omPt;
	private BigDecimal ordem;
	private BigDecimal operadorlogico;
	private BigDecimal vlInd;
	private BigDecimal qtCiclos;

	public MsTrigger() {
	}

	public MsTrigger(BigDecimal idTrigger, MsTpevt msTpevt,
			MsDetector msDetector) {
		this.idTrigger = idTrigger;
		this.msTpevt = msTpevt;
		this.msDetector = msDetector;
	}

	public MsTrigger(BigDecimal idTrigger, OmTppt omTppt, MsTpevt msTpevt,
			MsDetector msDetector, DwFolha dwFolha, MsInd msInd, OmPt omPt,
			BigDecimal ordem, BigDecimal operadorlogico, BigDecimal vlInd,
			BigDecimal qtCiclos) {
		this.idTrigger = idTrigger;
		this.omTppt = omTppt;
		this.msTpevt = msTpevt;
		this.msDetector = msDetector;
		this.dwFolha = dwFolha;
		this.msInd = msInd;
		this.omPt = omPt;
		this.ordem = ordem;
		this.operadorlogico = operadorlogico;
		this.vlInd = vlInd;
		this.qtCiclos = qtCiclos;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MS_TRIGGER_SEQ")
	@javax.persistence.SequenceGenerator(name = "MS_TRIGGER_SEQ", sequenceName = "MS_TRIGGER_SEQ")
	@Column(name = "ID_TRIGGER", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdTrigger() {
		return this.idTrigger;
	}

	public void setIdTrigger(BigDecimal idTrigger) {
		this.idTrigger = idTrigger;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPPT")
	public OmTppt getOmTppt() {
		return this.omTppt;
	}

	public void setOmTppt(OmTppt omTppt) {
		this.omTppt = omTppt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPEVT", nullable = false)
	public MsTpevt getMsTpevt() {
		return this.msTpevt;
	}

	public void setMsTpevt(MsTpevt msTpevt) {
		this.msTpevt = msTpevt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DETECTOR", nullable = false)
	public MsDetector getMsDetector() {
		return this.msDetector;
	}

	public void setMsDetector(MsDetector msDetector) {
		this.msDetector = msDetector;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FOLHA")
	public DwFolha getDwFolha() {
		return this.dwFolha;
	}

	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_IND")
	public MsInd getMsInd() {
		return this.msInd;
	}

	public void setMsInd(MsInd msInd) {
		this.msInd = msInd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PT")
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	@Column(name = "ORDEM", precision = 22, scale = 0)
	public BigDecimal getOrdem() {
		return this.ordem;
	}

	public void setOrdem(BigDecimal ordem) {
		this.ordem = ordem;
	}

	@Column(name = "OPERADORLOGICO", precision = 22, scale = 0)
	public BigDecimal getOperadorlogico() {
		return this.operadorlogico;
	}

	public void setOperadorlogico(BigDecimal operadorlogico) {
		this.operadorlogico = operadorlogico;
	}

	@Column(name = "VL_IND", precision = 6, scale = 3)
	public BigDecimal getVlInd() {
		return this.vlInd;
	}

	public void setVlInd(BigDecimal vlInd) {
		this.vlInd = vlInd;
	}

	@Column(name = "QT_CICLOS", precision = 22, scale = 0)
	public BigDecimal getQtCiclos() {
		return this.qtCiclos;
	}

	public void setQtCiclos(BigDecimal qtCiclos) {
		this.qtCiclos = qtCiclos;
	}

}
