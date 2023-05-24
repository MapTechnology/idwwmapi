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
@Table(name = "dw_consolestlocalpro")
public class DwConsolestlocalpro extends DwConsolestlocalproTemplate implements Serializable {

	private long idConsolestlocalpro;
	private DwCal dwCal;
	private DwEstlocalpro dwEstlocalpro;
	private DwTurno dwTurno;
	private Date dtReferencia;
	private Date dthrIturno;
	private Date dthrFturno;
	private BigDecimal ano;
	private BigDecimal mes;
	private BigDecimal qtEntrada;
	private BigDecimal qtSaida;
	private BigDecimal qtPerda;
	private BigDecimal qtConsumida;
	private BigDecimal qtAjuste;
	private BigDecimal qtTotal;

	public DwConsolestlocalpro() {
	}

	public DwConsolestlocalpro(long idConsolestlocalpro, DwCal dwCal,
			DwEstlocalpro dwEstlocalpro, DwTurno dwTurno, Date dtReferencia,
			Date dthrIturno, Date dthrFturno, BigDecimal ano, BigDecimal mes,
			BigDecimal qtEntrada, BigDecimal qtSaida, BigDecimal qtPerda,
			BigDecimal qtConsumida, BigDecimal qtAjuste, BigDecimal qtTotal) {
		this.idConsolestlocalpro = idConsolestlocalpro;
		this.dwCal = dwCal;
		this.dwEstlocalpro = dwEstlocalpro;
		this.dwTurno = dwTurno;
		this.dtReferencia = dtReferencia;
		this.dthrIturno = dthrIturno;
		this.dthrFturno = dthrFturno;
		this.ano = ano;
		this.mes = mes;
		this.qtEntrada = qtEntrada;
		this.qtSaida = qtSaida;
		this.qtPerda = qtPerda;
		this.qtConsumida = qtConsumida;
		this.qtAjuste = qtAjuste;
		this.qtTotal = qtTotal;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_CONSOLESTLOCALPRO_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_CONSOLESTLOCALPRO_SEQ", sequenceName = "DW_CONSOLESTLOCALPRO_SEQ")
	@Column(name = "id_consolestlocalpro", unique = true, nullable = false)
	public long getIdConsolestlocalpro() {
		return this.idConsolestlocalpro;
	}

	public void setIdConsolestlocalpro(long idConsolestlocalpro) {
		this.idConsolestlocalpro = idConsolestlocalpro;
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

	@Column(name = "ano", nullable = false, precision = 20, scale = 10)
	public BigDecimal getAno() {
		return this.ano;
	}

	public void setAno(BigDecimal ano) {
		this.ano = ano;
	}

	@Column(name = "mes", nullable = false, precision = 20, scale = 10)
	public BigDecimal getMes() {
		return this.mes;
	}

	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}

	@Column(name = "qt_entrada", nullable = false, precision = 14, scale = 4)
	public BigDecimal getQtEntrada() {
		return this.qtEntrada;
	}

	public void setQtEntrada(BigDecimal qtEntrada) {
		this.qtEntrada = qtEntrada;
	}

	@Column(name = "qt_saida", nullable = false, precision = 14, scale = 4)
	public BigDecimal getQtSaida() {
		return this.qtSaida;
	}

	public void setQtSaida(BigDecimal qtSaida) {
		this.qtSaida = qtSaida;
	}

	@Column(name = "qt_perda", nullable = false, precision = 14, scale = 4)
	public BigDecimal getQtPerda() {
		return this.qtPerda;
	}

	public void setQtPerda(BigDecimal qtPerda) {
		this.qtPerda = qtPerda;
	}

	@Column(name = "qt_consumida", nullable = false, precision = 14, scale = 4)
	public BigDecimal getQtConsumida() {
		return this.qtConsumida;
	}

	public void setQtConsumida(BigDecimal qtConsumida) {
		this.qtConsumida = qtConsumida;
	}

	@Column(name = "qt_ajuste", nullable = false, precision = 14, scale = 4)
	public BigDecimal getQtAjuste() {
		return this.qtAjuste;
	}

	public void setQtAjuste(BigDecimal qtAjuste) {
		this.qtAjuste = qtAjuste;
	}

	@Column(name = "qt_total", nullable = false, precision = 14, scale = 4)
	public BigDecimal getQtTotal() {
		return this.qtTotal;
	}

	public void setQtTotal(BigDecimal qtTotal) {
		this.qtTotal = qtTotal;
	}

}
