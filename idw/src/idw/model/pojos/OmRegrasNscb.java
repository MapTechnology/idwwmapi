package idw.model.pojos;

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

import idw.model.pojos.template.OmRegrasNscbTemplate;

@Entity
@Table(name = "om_regras_nscb")
public class OmRegrasNscb extends OmRegrasNscbTemplate implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idRegrasNscb;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdRegrasNscb;
	private Long revisao;
	private String dsRegrasNscb;
	private Byte stAtivo;
	private Date dtStativo;
	private Date dtRevisao;
	private Set<OmRegrasTags> omRegrasTagses = new HashSet<OmRegrasTags>(0);
	private Set<OmCfg> omCfgsForIdRegrasCb = new HashSet<OmCfg>(0);
	private Set<OmCfg> omCfgsForIdRegrasNs = new HashSet<OmCfg>(0);

	public OmRegrasNscb() {
	}

	public OmRegrasNscb(Long idRegrasNscb, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao) {
		this.idRegrasNscb = idRegrasNscb;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	public OmRegrasNscb(Long idRegrasNscb, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdRegrasNscb, Long revisao,
			String dsRegrasNscb, Byte stAtivo, Date dtStativo, Date dtRevisao,
			Set<OmRegrasTags> omRegrasTagses, Set<OmCfg> omCfgsForIdRegrasCb,
			Set<OmCfg> omCfgsForIdRegrasNs) {
		this.idRegrasNscb = idRegrasNscb;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.cdRegrasNscb = cdRegrasNscb;
		this.revisao = revisao;
		this.dsRegrasNscb = dsRegrasNscb;
		this.stAtivo = stAtivo;
		this.dtStativo = dtStativo;
		this.dtRevisao = dtRevisao;
		this.omRegrasTagses = omRegrasTagses;
		this.omCfgsForIdRegrasCb = omCfgsForIdRegrasCb;
		this.omCfgsForIdRegrasNs = omCfgsForIdRegrasNs;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OMREGRAS_NSCB_SEQ")
	@javax.persistence.SequenceGenerator(name = "OMREGRAS_NSCB_SEQ", sequenceName = "OMREGRAS_NSCB_SEQ")
	@Column(name = "id_regras_nscb", unique = true, nullable = false)
	public Long getIdRegrasNscb() {
		return this.idRegrasNscb;
	}

	public void setIdRegrasNscb(Long idRegrasNscb) {
		this.idRegrasNscb = idRegrasNscb;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrstativo", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrrevisao", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Column(name = "cd_regras_nscb", length = 60)
	public String getCdRegrasNscb() {
		return this.cdRegrasNscb;
	}

	public void setCdRegrasNscb(String cdRegrasNscb) {
		this.cdRegrasNscb = cdRegrasNscb;
	}

	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Column(name = "ds_regras_nscb", length = 100)
	public String getDsRegrasNscb() {
		return this.dsRegrasNscb;
	}

	public void setDsRegrasNscb(String dsRegrasNscb) {
		this.dsRegrasNscb = dsRegrasNscb;
	}

	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_stativo", length = 23)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_revisao", length = 23)
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omRegrasNscb")
	public Set<OmRegrasTags> getOmRegrasTagses() {
		return this.omRegrasTagses;
	}

	public void setOmRegrasTagses(Set<OmRegrasTags> omRegrasTagses) {
		this.omRegrasTagses = omRegrasTagses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omRegrasNscbByIdRegrasCb")
	public Set<OmCfg> getOmCfgsForIdRegrasCb() {
		return this.omCfgsForIdRegrasCb;
	}

	public void setOmCfgsForIdRegrasCb(Set<OmCfg> omCfgsForIdRegrasCb) {
		this.omCfgsForIdRegrasCb = omCfgsForIdRegrasCb;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omRegrasNscbByIdRegrasNs")
	public Set<OmCfg> getOmCfgsForIdRegrasNs() {
		return this.omCfgsForIdRegrasNs;
	}

	public void setOmCfgsForIdRegrasNs(Set<OmCfg> omCfgsForIdRegrasNs) {
		this.omCfgsForIdRegrasNs = omCfgsForIdRegrasNs;
	}

}
