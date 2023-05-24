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

import idw.model.pojos.template.DwLogvalroteiroTemplate;


@SuppressWarnings("serial")
@Entity
@Table(name = "dw_logvalroteiro")
public class DwLogvalroteiro  extends DwLogvalroteiroTemplate  implements java.io.Serializable {

	private long idLogvalroteiro;
	private DwNserie dwNserie;
	private OmPt omPt;
	private DwTDefeito dwTDefeito;
	private DwTurno dwTurno;
	private PpCp ppCp;
	private OmProduto omProduto;
	private Date dthrLog;
	private String cb;
	private String cdPtDef;

	public DwLogvalroteiro() {
	}

	public DwLogvalroteiro(long idLogvalroteiro) {
		this.idLogvalroteiro = idLogvalroteiro;
	}

	public DwLogvalroteiro(long idLogvalroteiro, DwNserie dwNserie, OmPt omPt, DwTDefeito dwTDefeito, DwTurno dwTurno,
			PpCp ppCp, OmProduto omProduto, Date dthrLog, String cb) {
		this.idLogvalroteiro = idLogvalroteiro;
		this.dwNserie = dwNserie;
		this.omPt = omPt;
		this.dwTDefeito = dwTDefeito;
		this.dwTurno = dwTurno;
		this.ppCp = ppCp;
		this.omProduto = omProduto;
		this.dthrLog = dthrLog;
		this.cb = cb;
	}


	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_LOGVROT_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_LOGVROT_SEQ", sequenceName = "DW_LOGVROT_SEQ")
	@Column(name = "id_logvalroteiro", unique = true, nullable = false)	
	public long getIdLogvalroteiro() {
		return this.idLogvalroteiro;
	}
	public void setIdLogvalroteiro(long idLogvalroteiro) {
		this.idLogvalroteiro = idLogvalroteiro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_nserie", nullable = false)
	public DwNserie getDwNserie() {
		return this.dwNserie;
	}
	public void setDwNserie(DwNserie dwNserie) {
		this.dwNserie = dwNserie;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pt", nullable = false)
	public OmPt getOmPt() {
		return this.omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tdefeito", nullable = false)
	public DwTDefeito getDwTDefeito() {
		return this.dwTDefeito;
	}
	public void setDwTDefeito(DwTDefeito dwTDefeito) {
		this.dwTDefeito = dwTDefeito;
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
	@JoinColumn(name = "id_cp", nullable = false)
	public PpCp getPpCp() {
		return this.ppCp;
	}
	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto", nullable = false)
	public OmProduto getOmProduto() {
		return this.omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_log", length = 23)
	public Date getDthrLog() {
		return this.dthrLog;
	}
	public void setDthrLog(Date dthrLog) {
		this.dthrLog = dthrLog;
	}


	@Column(name = "cb", length = 256)
	public String getCb() {
		return this.cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}


	@Column(name = "cd_ptdef", length = 60)
	public String getCdPtDef() {
		return this.cdPtDef;
	}
	public void setCdPtDef(String cdPtDef) {
		this.cdPtDef = cdPtDef;
	}

}
