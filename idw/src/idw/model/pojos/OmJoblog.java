package idw.model.pojos;

import java.io.Serializable;
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

import idw.model.pojos.template.OmJoblogTemplate;

@Entity
@Table(name = "OM_JOBLOG")
public class OmJoblog extends OmJoblogTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idJoblog;
	private Date dthrIexecucao;
	private Date dthrFexecucao;
	private Byte stExecucao;
	private String dsExecucao;
	
	private OmJob omJob = new OmJob();

	public OmJoblog() {
		super();
	}

	@Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "OM_JOBLOG_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_JOBLOG_SEQ", sequenceName = "OM_JOBLOG_SEQ")
	@Column(name = "ID_JOBLOG", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdJoblog() {
		return this.idJoblog;
	}

	public void setIdJoblog(Long id) {
		this.idJoblog = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JOB")
	public OmJob getOmJob() {
		return this.omJob;
	}
	public void setOmJob(OmJob omjob) {
		this.omJob = omjob;
	}

	@Column(name = "DS_EXECUCAO", length = 100)
	public String getDsExecucao() {
		return this.dsExecucao;
	}

	public void setDsExecucao(String ds) {
		this.dsExecucao = ds;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_IEXECUCAO")
	public Date getDthrIexecucao() {
		return this.dthrIexecucao;
	}

	public void setDthrIexecucao(Date dthr) {
		this.dthrIexecucao = dthr;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_FEXECUCAO")
	public Date getDthrFexecucao() {
		return this.dthrFexecucao;
	}

	public void setDthrFexecucao(Date dthr) {
		this.dthrFexecucao = dthr;
	}

	@Column(name = "ST_EXECUCAO", length = 1)
	public Byte getStExecucao() {
		return this.stExecucao;
	}

	public void setStExecucao(Byte st) {
		this.stExecucao = st;
	}
}
