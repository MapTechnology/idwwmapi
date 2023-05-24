package idw.model.pojos;

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

// Generated 29/04/2013 13:45:57 by Hibernate Tools 3.4.0.CR1

import idw.model.pojos.template.DwConsolptTemplate;

/**
 * DwConsolpt generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "dw_consolpt")
public class DwConsolpt extends DwConsolptTemplate implements java.io.Serializable {

	private Long idConsolpt;
	private DwCal dwCal;

	private DwConsolid dwConsolidByIdConsolidHora;
	private DwConsolid dwConsolidByIdConsolidTurno;
	private DwConsolid dwConsolidByIdConsolidMes;
	private DwConsolid dwConsolidByIdConsolidAcu;
	
	private DwFolha dwFolha;
	private PpCp ppCp;
	private OmPt omPt;
	private Date dthrInicio;
	private Date dthrFim;
	private DwRtcic dwRtcic;
	private DwConsolpalog dwConsolpalog;
	
	public DwConsolpt() {
	}

	public DwConsolpt(long idConsolpt, DwConsolid dwConsolidByIdConsolidMes,
			DwConsolid dwConsolidByIdConsolidTurno,
			DwConsolid dwConsolidByIdConsolidHora,
			DwConsolid dwConsolidByIdConsolidAcu, OmPt omPt) {
		this.idConsolpt = idConsolpt;
		this.dwConsolidByIdConsolidMes = dwConsolidByIdConsolidMes;
		this.dwConsolidByIdConsolidTurno = dwConsolidByIdConsolidTurno;
		this.dwConsolidByIdConsolidHora = dwConsolidByIdConsolidHora;
		this.dwConsolidByIdConsolidAcu = dwConsolidByIdConsolidAcu;
		this.omPt = omPt;
	}

	public DwConsolpt(long idConsolpt, DwConsolid dwConsolidByIdConsolidMes,
			DwCal dwCal, DwConsolid dwConsolidByIdConsolidTurno,
			DwConsolid dwConsolidByIdConsolidHora, DwFolha dwFolha,
			DwConsolid dwConsolidByIdConsolidAcu, PpCp ppCp, OmPt omPt,
			Date dthrInicio, Date dthrFim) {
		this.idConsolpt = idConsolpt;
		this.dwConsolidByIdConsolidMes = dwConsolidByIdConsolidMes;
		this.dwCal = dwCal;
		this.dwConsolidByIdConsolidTurno = dwConsolidByIdConsolidTurno;
		this.dwConsolidByIdConsolidHora = dwConsolidByIdConsolidHora;
		this.dwFolha = dwFolha;
		this.dwConsolidByIdConsolidAcu = dwConsolidByIdConsolidAcu;
		this.ppCp = ppCp;
		this.omPt = omPt;
		this.dthrInicio = dthrInicio;
		this.dthrFim = dthrFim;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_CONSOLPT_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_CONSOLPT_SEQ", sequenceName = "DW_CONSOLPT_SEQ")
	@Column(name = "id_consolpt", unique = true, nullable = false)
	public Long getIdConsolpt() {
		return this.idConsolpt;
	}

	public void setIdConsolpt(Long idConsolpt) {
		this.idConsolpt = idConsolpt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_consolid_mes")
	public DwConsolid getDwConsolidByIdConsolidMes() {
		return this.dwConsolidByIdConsolidMes;
	}

	public void setDwConsolidByIdConsolidMes(
			DwConsolid dwConsolidByIdConsolidMes) {
		this.dwConsolidByIdConsolidMes = dwConsolidByIdConsolidMes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cal")
	public DwCal getDwCal() {
		return this.dwCal;
	}

	public void setDwCal(DwCal dwCal) {
		this.dwCal = dwCal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_consolid_turno")
	public DwConsolid getDwConsolidByIdConsolidTurno() {
		return this.dwConsolidByIdConsolidTurno;
	}

	public void setDwConsolidByIdConsolidTurno(
			DwConsolid dwConsolidByIdConsolidTurno) {
		this.dwConsolidByIdConsolidTurno = dwConsolidByIdConsolidTurno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_consolid_hora")
	public DwConsolid getDwConsolidByIdConsolidHora() {
		return this.dwConsolidByIdConsolidHora;
	}

	public void setDwConsolidByIdConsolidHora(
			DwConsolid dwConsolidByIdConsolidHora) {
		this.dwConsolidByIdConsolidHora = dwConsolidByIdConsolidHora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_folha")
	public DwFolha getDwFolha() {
		return this.dwFolha;
	}

	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_consolid_acu")
	public DwConsolid getDwConsolidByIdConsolidAcu() {
		return this.dwConsolidByIdConsolidAcu;
	}

	public void setDwConsolidByIdConsolidAcu(
			DwConsolid dwConsolidByIdConsolidAcu) {
		this.dwConsolidByIdConsolidAcu = dwConsolidByIdConsolidAcu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cp")
	public PpCp getPpCp() {
		return this.ppCp;
	}

	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pt", nullable = false)
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_inicio", length = 23)
	public Date getDthrInicio() {
		return this.dthrInicio;
	}

	public void setDthrInicio(Date dthrInicio) {
		this.dthrInicio = dthrInicio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_fim", length = 23)
	public Date getDthrFim() {
		return this.dthrFim;
	}

	public void setDthrFim(Date dthrFim) {
		this.dthrFim = dthrFim;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rtcic")
	public DwRtcic getDwRtcic() {
		return dwRtcic;
	}

	public void setDwRtcic(DwRtcic dwRtcic) {
		this.dwRtcic = dwRtcic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_consolpalog")
	public DwConsolpalog getDwConsolpalog() {
		return dwConsolpalog;
	}

	public void setDwConsolpalog(DwConsolpalog dwConsolpalog) {
		this.dwConsolpalog = dwConsolpalog;
	}

}
