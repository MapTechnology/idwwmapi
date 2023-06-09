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

// Generated 11/01/2010 15:35:09 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.OmTpptTemplate;


/**
 * OmTppt generated by hbm2java
 */
@Entity
@Table(name = "om_tppt")
public class OmTppt extends OmTpptTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idTppt;
	private OmAlgocor omAlgocor;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdTppt;
	private Long revisao;
	private String dsTppt;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;
	private Boolean isIhmtrocaop;
	private Boolean isRequerTecnicoInicioCip;
	private Boolean isRequerTecnicoFimCip;
	
	private Byte tpProducao;
	private Byte tpColeta;

	private Set<DwTAcao> dwTAcaos = new HashSet<DwTAcao>(0);
	private Set<DwTParada> dwTParadas = new HashSet<DwTParada>(0);
	private Set<OmCfg> omCfgsForIdTpptPts = new HashSet<OmCfg>(0);
	private Set<OmCfg> omCfgsForIdTpptPtscd = new HashSet<OmCfg>(0);
	private Set<DwTDefeito> dwTDefeitos = new HashSet<DwTDefeito>(0);
	private Set<DwFolha> dwFolhas = new HashSet<DwFolha>(0);
	private Set<OmCfg> omCfgsForIdTpptPpass = new HashSet<OmCfg>(0);
	private Set<OmIndtppt> omIndtppts = new HashSet<OmIndtppt>(0);
	private Set<OmCfg> omCfgsForIdTpptPtf = new HashSet<OmCfg>(0);
	private Set<OmPt> omPts = new HashSet<OmPt>(0);
	private Set<OmCfg> omCfgsForIdTpptPm = new HashSet<OmCfg>(0);
	private Set<OmCfg> omCfgsForIdTpptPrepro = new HashSet<OmCfg>(0);
	private Set<OmCfg> omCfgsForIdTpptInsersora = new HashSet<OmCfg>(0);
	private Set<DwTAlerta> dwTAlertas = new HashSet<DwTAlerta>(0);
	private Set<DwTRefugo> dwTRefugos = new HashSet<DwTRefugo>(0);

	public OmTppt() {
	}

	public OmTppt(long idTppt, OmAlgocor omAlgocor, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao) {
		this.idTppt = idTppt;
		this.omAlgocor = omAlgocor;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	public OmTppt(long idTppt, OmAlgocor omAlgocor, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdTppt, Long revisao,
			String dsTppt, Date dtRevisao, Date dtStativo, Byte stAtivo,
			Set<DwTAcao> dwTAcaos, Set<DwTParada> dwTParadas,
			Set<OmCfg> omCfgsForIdTpptPts, Set<OmCfg> omCfgsForIdTpptPtscd,
			Set<DwTDefeito> dwTDefeitos, Set<DwFolha> dwFolhas,
			Set<OmCfg> omCfgsForIdTpptPpass, Set<OmIndtppt> omIndtppts,
			Set<OmCfg> omCfgsForIdTpptPtf, Set<OmPt> omPts,
			Set<OmCfg> omCfgsForIdTpptPm, Set<OmCfg> omCfgsForIdTpptPrepro,
			Set<OmCfg> omCfgsForIdTpptInsersora, Set<DwTAlerta> dwTAlertas,
			Set<DwTRefugo> dwTRefugos) {
		this.idTppt = idTppt;
		this.omAlgocor = omAlgocor;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.cdTppt = cdTppt;
		this.revisao = revisao;
		this.dsTppt = dsTppt;
		this.dtRevisao = dtRevisao;
		this.dtStativo = dtStativo;
		this.stAtivo = stAtivo;
		this.dwTAcaos = dwTAcaos;
		this.dwTParadas = dwTParadas;
		this.omCfgsForIdTpptPts = omCfgsForIdTpptPts;
		this.omCfgsForIdTpptPtscd = omCfgsForIdTpptPtscd;
		this.dwTDefeitos = dwTDefeitos;
		this.dwFolhas = dwFolhas;
		this.omCfgsForIdTpptPpass = omCfgsForIdTpptPpass;
		this.omIndtppts = omIndtppts;
		this.omCfgsForIdTpptPtf = omCfgsForIdTpptPtf;
		this.omPts = omPts;
		this.omCfgsForIdTpptPm = omCfgsForIdTpptPm;
		this.omCfgsForIdTpptPrepro = omCfgsForIdTpptPrepro;
		this.omCfgsForIdTpptInsersora = omCfgsForIdTpptInsersora;
		this.dwTAlertas = dwTAlertas;
		this.dwTRefugos = dwTRefugos;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_TPPT_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_TPPT_SEQ", sequenceName = "OM_TPPT_SEQ")
	@Column(name = "id_tppt", unique = true, nullable = false)
	public Long getIdTppt() {
		return this.idTppt;
	}

	public void setIdTppt(Long idTppt) {
		this.idTppt = idTppt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_algocor", nullable = false)
	public OmAlgocor getOmAlgocor() {
		return this.omAlgocor;
	}

	public void setOmAlgocor(OmAlgocor omAlgocor) {
		this.omAlgocor = omAlgocor;
	}

	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrstativo", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	@Override
	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}

	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrrevisao", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	@Override
	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Column(name = "cd_tppt", length = 30)
	public String getCdTppt() {
		return this.cdTppt;
	}

	public void setCdTppt(String cdTppt) {
		this.cdTppt = cdTppt;
	}

	@Override
	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	@Override
	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Column(name = "ds_tppt", length = 100)
	public String getDsTppt() {
		return this.dsTppt;
	}

	public void setDsTppt(String dsTppt) {
		this.dsTppt = dsTppt;
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_revisao", length = 23)
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	@Override
	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_stativo", length = 23)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	@Override
	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Override
	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	@Override
	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTppt")
	public Set<DwTAcao> getDwTAcaos() {
		return this.dwTAcaos;
	}

	public void setDwTAcaos(Set<DwTAcao> dwTAcaos) {
		this.dwTAcaos = dwTAcaos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTppt")
	public Set<DwTParada> getDwTParadas() {
		return this.dwTParadas;
	}

	public void setDwTParadas(Set<DwTParada> dwTParadas) {
		this.dwTParadas = dwTParadas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTpptByIdTpptpts")
	public Set<OmCfg> getOmCfgsForIdTpptPts() {
		return this.omCfgsForIdTpptPts;
	}

	public void setOmCfgsForIdTpptPts(Set<OmCfg> omCfgsForIdTpptPts) {
		this.omCfgsForIdTpptPts = omCfgsForIdTpptPts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTpptByIdTpptptscd")
	public Set<OmCfg> getOmCfgsForIdTpptPtscd() {
		return this.omCfgsForIdTpptPtscd;
	}

	public void setOmCfgsForIdTpptPtscd(Set<OmCfg> omCfgsForIdTpptPtscd) {
		this.omCfgsForIdTpptPtscd = omCfgsForIdTpptPtscd;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTppt")
	public Set<DwTDefeito> getDwTDefeitos() {
		return this.dwTDefeitos;
	}

	public void setDwTDefeitos(Set<DwTDefeito> dwTDefeitos) {
		this.dwTDefeitos = dwTDefeitos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTppt")
	public Set<DwFolha> getDwFolhas() {
		return this.dwFolhas;
	}

	public void setDwFolhas(Set<DwFolha> dwFolhas) {
		this.dwFolhas = dwFolhas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTpptByIdTpptppass")
	public Set<OmCfg> getOmCfgsForIdTpptPpass() {
		return this.omCfgsForIdTpptPpass;
	}

	public void setOmCfgsForIdTpptPpass(Set<OmCfg> omCfgsForIdTpptPpass) {
		this.omCfgsForIdTpptPpass = omCfgsForIdTpptPpass;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTppt")
	public Set<OmIndtppt> getOmIndtppts() {
		return this.omIndtppts;
	}

	public void setOmIndtppts(Set<OmIndtppt> omIndtppts) {
		this.omIndtppts = omIndtppts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTpptByIdTpptptf")
	public Set<OmCfg> getOmCfgsForIdTpptPtf() {
		return this.omCfgsForIdTpptPtf;
	}

	public void setOmCfgsForIdTpptPtf(Set<OmCfg> omCfgsForIdTpptPtf) {
		this.omCfgsForIdTpptPtf = omCfgsForIdTpptPtf;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTppt")
	public Set<OmPt> getOmPts() {
		return this.omPts;
	}

	public void setOmPts(Set<OmPt> omPts) {
		this.omPts = omPts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTpptByIdTpptpm")
	public Set<OmCfg> getOmCfgsForIdTpptPm() {
		return this.omCfgsForIdTpptPm;
	}

	public void setOmCfgsForIdTpptPm(Set<OmCfg> omCfgsForIdTpptPm) {
		this.omCfgsForIdTpptPm = omCfgsForIdTpptPm;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTpptByIdTpptprepro")
	public Set<OmCfg> getOmCfgsForIdTpptPrepro() {
		return this.omCfgsForIdTpptPrepro;
	}

	public void setOmCfgsForIdTpptPrepro(Set<OmCfg> omCfgsForIdTpptPrepro) {
		this.omCfgsForIdTpptPrepro = omCfgsForIdTpptPrepro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTpptByIdTpptinsersora")
	public Set<OmCfg> getOmCfgsForIdTpptInsersora() {
		return this.omCfgsForIdTpptInsersora;
	}

	public void setOmCfgsForIdTpptInsersora(Set<OmCfg> omCfgsForIdTpptInsersora) {
		this.omCfgsForIdTpptInsersora = omCfgsForIdTpptInsersora;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTppt")
	public Set<DwTAlerta> getDwTAlertas() {
		return this.dwTAlertas;
	}

	public void setDwTAlertas(Set<DwTAlerta> dwTAlertas) {
		this.dwTAlertas = dwTAlertas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTppt")
	public Set<DwTRefugo> getDwTRefugos() {
		return this.dwTRefugos;
	}

	public void setDwTRefugos(Set<DwTRefugo> dwTRefugos) {
		this.dwTRefugos = dwTRefugos;
	}

	@Column(name = "IS_IHMTROCAOP", precision = 1, scale = 0)
	public Boolean getIsIhmtrocaop() {
		return this.isIhmtrocaop;
	}

	public void setIsIhmtrocaop(Boolean isValor) {
		this.isIhmtrocaop = isValor;
	}
	@Column(name = "is_requerTecnicoInicioCIP")
	public Boolean getIsRequerTecnicoInicioCip() {
		return this.isRequerTecnicoInicioCip;
	}

	public void setIsRequerTecnicoInicioCip(Boolean isRequerTecnicoInicioCip) {
		this.isRequerTecnicoInicioCip = isRequerTecnicoInicioCip;
	}

	@Column(name = "is_requerTecnicoFimCIP")
	public Boolean getIsRequerTecnicoFimCip() {
		return this.isRequerTecnicoFimCip;
	}

	public void setIsRequerTecnicoFimCip(Boolean isRequerTecnicoFimCip) {
		this.isRequerTecnicoFimCip = isRequerTecnicoFimCip;
	}

	@Column(name = "tp_producao")
	public Byte getTpProducao() {
		return tpProducao;
	}

	public void setTpProducao(Byte tpProducao) {
		this.tpProducao = tpProducao;
	}

	@Column(name = "tp_coleta")
	public Byte getTpColeta() {
		return tpColeta;
	}

	public void setTpColeta(Byte tpColeta) {
		this.tpColeta = tpColeta;
	}

}
