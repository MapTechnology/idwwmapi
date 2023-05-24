package idw.model.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

import idw.model.pojos.template.OmJobTemplate;

/**
 * PpCp generated by hbm2java
 */
@Entity
@Table(name = "OM_JOB")
public class OmJob extends OmJobTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idJob;
	private String cdJob;
	private Long revisao;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;
	
	private String dsJob;
	private Integer tpIntegracao;
	private String padraoSchedule;

	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	
	private Set<OmJobdet> omJobdets = new HashSet<OmJobdet>(0);


	public OmJob() {
		super();
	}

	@Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "OM_JOB_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_JOB_SEQ", sequenceName = "OM_JOB_SEQ")
	@Column(name = "ID_JOB", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdJob() {
		return this.idJob;
	}

	public void setIdJob(Long id) {
		this.idJob = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRSTATIVO")
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}
	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRREVISAO")
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Column(name = "CD_JOB", length = 60)
	public String getCdJob() {
		return this.cdJob;
	}

	public void setCdJob(String cd) {
		this.cdJob = cd;
	}

	@Column(name = "REVISAO", precision = 63, scale = 0)
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_REVISAO")
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_STATIVO")
	public Date getDtStativo() {
		return this.dtStativo;
	}

	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Column(name = "ST_ATIVO", length = 1)
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Column(name = "TP_INTEGRACAO")
	public Integer getTpIntegracao() {
		return this.tpIntegracao;
	}

	public void setTpIntegracao(Integer tp) {
		this.tpIntegracao = tp;
	}

	@Column(name = "PADRAO_SCHEDULE")
	public String getPadraoSchedule() {
		return this.padraoSchedule;
	}
	public void setPadraoSchedule(String valor) {
		this.padraoSchedule = valor;
	}
	@Column(name = "DS_JOB")
	public String getDsJob() {
		return this.dsJob;
	}
	public void setDsJob(String valor) {
		this.dsJob = valor;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omJob")
	public Set<OmJobdet> getOmJobdets() {
		return this.omJobdets;
	}

	public void setOmJobdets(Set<OmJobdet> dets) {
		this.omJobdets = dets;
	}
}
