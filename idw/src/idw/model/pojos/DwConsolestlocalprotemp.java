package idw.model.pojos;

import java.io.Serializable;
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

import idw.model.pojos.template.DwConsolestlocalproTemplate;

@SuppressWarnings("serial")
@Entity
@Table(name = "dw_consolestlocalprotemp")
public class DwConsolestlocalprotemp extends DwConsolestlocalproTemplate implements Serializable {

	private long idConsolestlocalprotemp;
	private DwCal dwCal;
	private DwEstlocalpro dwEstlocalpro;
	private DwTurno dwTurno;
	private Date dtReferencia;
	private Date dthrIturno;
	private Date dthrFturno;
	private Integer ano;
	private Integer mes;
	private Byte tpAjusteEstoque;
	private BigDecimal qt;
	private OmUsr omUsr;
	private Date dthr;

	public DwConsolestlocalprotemp() {
	}

	public DwConsolestlocalprotemp(long idConsolestlocalpro, DwCal dwCal,
			DwEstlocalpro dwEstlocalpro, DwTurno dwTurno, Date dtReferencia,
			Date dthrIturno, Date dthrFturno, Integer ano, Integer mes,
			Byte tpEstoque, BigDecimal qt, OmUsr omUsr, Date dthr) {
		this.idConsolestlocalprotemp = idConsolestlocalpro;
		this.dwCal = dwCal;
		this.dwEstlocalpro = dwEstlocalpro;
		this.dwTurno = dwTurno;
		this.dtReferencia = dtReferencia;
		this.dthrIturno = dthrIturno;
		this.dthrFturno = dthrFturno;
		this.ano = ano;
		this.mes = mes;
		this.tpAjusteEstoque = tpEstoque;
		this.qt = qt;
		this.omUsr = omUsr;
		this.dthr = dthr;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_CONSOLESTLOCALPROTEMP_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_CONSOLESTLOCALPROTEMP_SEQ", sequenceName = "DW_CONSOLESTLOCALPROTEMP_SEQ")
	@Column(name = "id_consolestlocalprotemp", unique = true, nullable = false)
	public long getIdConsolestlocalprotemp() {
		return this.idConsolestlocalprotemp;
	}

	public void setIdConsolestlocalprotemp(long idConsolestlocalprotemp) {
		this.idConsolestlocalprotemp = idConsolestlocalprotemp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cal", nullable = false)
	public DwCal getDwCal() {
		return this.dwCal;
	}

	public void setDwCal(DwCal dwCal) {
		this.dwCal = dwCal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estlocalpro", nullable = false)
	public DwEstlocalpro getDwEstlocalpro() {
		return this.dwEstlocalpro;
	}

	public void setDwEstlocalpro(DwEstlocalpro dwEstlocalpro) {
		this.dwEstlocalpro = dwEstlocalpro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_turno", nullable = false)
	public DwTurno getDwTurno() {
		return this.dwTurno;
	}

	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usr", nullable = false)
	public OmUsr getOmUsr() {
		return this.omUsr;
	}

	public void setOmUsr(OmUsr omUsr) {
		this.omUsr = omUsr;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_referencia", nullable = false, length = 23)
	public Date getDtReferencia() {
		return this.dtReferencia;
	}

	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_iturno", nullable = false, length = 23)
	public Date getDthrIturno() {
		return this.dthrIturno;
	}

	public void setDthrIturno(Date dthrIturno) {
		this.dthrIturno = dthrIturno;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_fturno", nullable = false, length = 23)
	public Date getDthrFturno() {
		return this.dthrFturno;
	}

	public void setDthrFturno(Date dthrFturno) {
		this.dthrFturno = dthrFturno;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr", nullable = false, length = 23)
	public Date getDthr() {
		return this.dthr;
	}

	public void setDthr(Date dthr) {
		this.dthr = dthr;
	}

	@Column(name = "ano", nullable = false)
	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Column(name = "mes", nullable = false)
	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	@Column(name = "tp_ajusteestoque", nullable = false)
	public Byte getTpAjusteestoque() {
		return this.tpAjusteEstoque;
	}

	public void setTpAjusteestoque(Byte tpAjusteestoque) {
		this.tpAjusteEstoque = tpAjusteestoque;
	}

	@Column(name = "qt", nullable = false, precision = 14, scale = 4)
	public BigDecimal getQt() {
		return this.qt;
	}

	public void setQt(BigDecimal qt) {
		this.qt = qt;
	}

}
