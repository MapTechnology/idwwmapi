package idw.model.pojos;
// Generated 28/07/2011 10:26:23 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
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

import idw.model.pojos.template.PpNecimpTemplate;

/**
 * PpNecimp generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PP_NECIMP")
public class PpNecimp extends PpNecimpTemplate implements java.io.Serializable {

	private Long idNecimp;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdNecimp;
	private Integer revisao;
	private String dsNecimp;
	private Byte stAtivo;
	private Date dtRevisao;
	private Date dtStativo;
	private BigDecimal tpNecimp;
	private Set<PpNecimpurl> ppNecimpurls = new HashSet<PpNecimpurl>(0);
	private Set<PpNecimplog> ppNecimplogs = new HashSet<PpNecimplog>(0);	

	public PpNecimp() {
	}

	public PpNecimp(Long idNecimp, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao) {
		this.idNecimp = idNecimp;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	public PpNecimp(Long idNecimp, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdNecimp, Integer revisao,
			String dsNecimp, Byte stAtivo, Date dtRevisao, Date dtStativo,
			BigDecimal tpNecimp, Set<PpNecimpurl> ppNecimpurls,
			Set<PpNecimplog> ppNecimplogs) {
		this.idNecimp = idNecimp;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.cdNecimp = cdNecimp;
		this.revisao = revisao;
		this.dsNecimp = dsNecimp;
		this.stAtivo = stAtivo;
		this.dtRevisao = dtRevisao;
		this.dtStativo = dtStativo;
		this.tpNecimp = tpNecimp;
		this.ppNecimpurls = ppNecimpurls;
		this.ppNecimplogs = ppNecimplogs;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "PP_NECIMP_SEQ")
	@javax.persistence.SequenceGenerator(name = "PP_NECIMP_SEQ", sequenceName = "PP_NECIMP_SEQ")
	@Column(name = "ID_NECIMP", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdNecimp() {
		return this.idNecimp;
	}

	public void setIdNecimp(Long idNecimp) {
		this.idNecimp = idNecimp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRSTATIVO", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRREVISAO", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Column(name = "CD_NECIMP", length = 30)
	public String getCdNecimp() {
		return this.cdNecimp;
	}

	public void setCdNecimp(String cdNecimp) {
		this.cdNecimp = cdNecimp;
	}

	@Column(name = "REVISAO", precision = 63, scale = 0)
	public Integer getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}

	@Column(name = "DS_NECIMP", length = 256)
	public String getDsNecimp() {
		return this.dsNecimp;
	}

	public void setDsNecimp(String dsNecimp) {
		this.dsNecimp = dsNecimp;
	}

	@Column(name = "ST_ATIVO", length = 1)
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_REVISAO", length = 7)
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_STATIVO", length = 7)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Column(name = "TP_NECIMP", precision = 22, scale = 0)
	public BigDecimal getTpNecimp() {
		return this.tpNecimp;
	}

	public void setTpNecimp(BigDecimal tpNecimp) {
		this.tpNecimp = tpNecimp;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ppNecimp")
	public Set<PpNecimpurl> getPpNecimpurls() {
		return this.ppNecimpurls;
	}

	public void setPpNecimpurls(Set<PpNecimpurl> ppNecimpurls) {
		this.ppNecimpurls = ppNecimpurls;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ppNecimp")
	public Set<PpNecimplog> getPpNecimplogs() {
		return this.ppNecimplogs;
	}

	public void setPpNecimplogs(Set<PpNecimplog> ppNecimplogs) {
		this.ppNecimplogs = ppNecimplogs;
	}
}