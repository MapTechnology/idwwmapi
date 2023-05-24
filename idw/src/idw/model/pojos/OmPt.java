package idw.model.pojos;

import java.math.BigDecimal;
import java.util.Collections;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// Generated 20/01/2010 15:07:16 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.OmPtTemplate;


/**
 * OmPt generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "om_pt")
public class OmPt extends OmPtTemplate implements java.io.Serializable {

	private Long idPt;
	private OmClp omClp;
	private OmTppt omTppt;
	private OmAlim omAlimByIdAlimpre;
	private OmAlim omAlimByIdAlim;
	private OmAlim omAlimByIdAlimcorrente;
	private OmGt omGt;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private OmCc omCc;
	private String cdPt;
	private Long revisao;
	private Date dtRevisao;
	private Date dtStativo;
	private String urlConexao;
	private String dsPt;
	private String dsCurta;
	private String depara;
	private Byte tpImpprog;
	private Byte stAtivo;
	private Byte tpClasseabc;
	private Integer ordemnogt;

	private Integer modulo;
	private Integer estagio;
	private Boolean isAlimcorexc;
	private BigDecimal indOee;
	private Boolean isCipAtivado;
	private Boolean isSemop;
	private Boolean isSolicitaqtde;
	private Boolean isDevepassarns;
	private Boolean isConsolpendente;
	private Boolean isPerdasinc;
	private Boolean isHabilitaCip;
	private Boolean isCiclocomrefugo;
	private Boolean isHabilitaVaritmo;
	private Boolean isLogingt;
	private Boolean isParadaFechaciclo;
	private Boolean isApontarposicaomecanica;
	
	private BigDecimal percVaritmo;
	private Integer qtVaritmo;
	private Integer qtEventosnoclp;
	
	private String urlImpressoracb;
	private String urlImpressoradoc;

	private PpCp ppCp;
	
	private Byte tpProducao;
	private Byte tpColeta;


	private Set<OmPtcp> omPtcps = new HashSet<OmPtcp>(0);
	private Set<OmHomopt> omHomopts = new HashSet<OmHomopt>(0);
	private Set<PpCp> ppCps = new HashSet<PpCp>(0);
	private Set<PpCpentsai> ppCpentsais = new HashSet<PpCpentsai>(0);
	private Set<OmObj> omObjs = new HashSet<OmObj>(0);
	private Set<DwPassagem> dwPassagems = new HashSet<DwPassagem>(0);
	private Set<DwExpcvs> dwExpcvses = new HashSet<DwExpcvs>(0);
	private Set<DwRotapassoPt> dwRotapassoPts = new HashSet<DwRotapassoPt>(0);
	private Set<DwRotapasso> dwRotapassos = new HashSet<DwRotapasso>(0);
	private Set<DwConsolid> dwConsolids = new HashSet<DwConsolid>(0);
	private Set<PpIndispRappt> ppIndispRappts = new HashSet<PpIndispRappt>(0);
	private Set<DwRt> dwRts = new HashSet<DwRt>(0);
	//private Set<PpNec> ppNecs = new HashSet<PpNec>(0);
	private Set<MsTrigger> msTriggers = new HashSet<MsTrigger>(0);
	private Set<OmCfgptdetcoleta> omCfgptdetcoletas = new HashSet<OmCfgptdetcoleta>(0);
	private Set<PpPlanptgt> ppPlanptgts = new HashSet<PpPlanptgt>(0);
	private Set<OmPa> omPas = new HashSet<OmPa>(0);
	private Set<OmPrg> omPrgs = new HashSet<OmPrg>(0);
	private Set<DwConsolpalog> dwConsolpalogs = new HashSet<DwConsolpalog>(0);
	private Set<DwCalpt> dwCalpts = new HashSet<DwCalpt>(0);
	private Set<DwConsolmolog> dwConsolmologs = new HashSet<DwConsolmolog>(0);
	private Set<DwConsolatlog> dwConsolatlogs = new HashSet<DwConsolatlog>(0);
	private Set<OmIndpt> omIndpts = new HashSet<OmIndpt>(0);
	private Set<OmMapa> omMapas = new HashSet<OmMapa>(0);
	private Set<DwConsolpt> dwConsolpts = new HashSet<DwConsolpt>(0);
	private Set<OmPapro> omPapros = new HashSet<OmPapro>(0);
	private Set<DwEstlocal> dwEstlocals = new HashSet<DwEstlocal>(0);
	private Set<OmPtcnc> omPtcncsForIdPt = Collections.synchronizedSet(new HashSet<OmPtcnc>(0));
	private Set<OmPtcnc> omPtcncsForIdPtFilho = Collections.synchronizedSet(new HashSet<OmPtcnc>(0));
	private DwFolha dwFolha;
	
    private MsPtColeta msPtColeta;
    private OmPtPa omPtPa;

	
	private Boolean isPlangt;
	private Boolean isApongt;
	private Boolean isAponparadagt;
	private Boolean isParadalinha;
	private Boolean isTrocaopgt;
	
	private Byte tpSessao;
	private String dsSessao; 
	
	private BigDecimal segAutoTempoparadanociclo;
	
	private Set<DwOperacao> dwOperacaos = new HashSet<DwOperacao>(0);
	
	public OmPt() {
	}

	public OmPt(Long idPt, OmTppt omTppt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, OmCc omCc, Byte tpImpprog) {
		this.idPt = idPt;
		this.omTppt = omTppt;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.omCc = omCc;
		this.tpImpprog = tpImpprog;
	}

	public OmPt(Long idPt, OmClp omClp, OmTppt omTppt,
			OmAlim omAlimByIdAlimpre, OmAlim omAlimByIdAlim,
			OmAlim omAlimByIdAlimcorrente, OmGt omGt,
			OmUsr omUsrByIdUsrstativo, OmUsr omUsrByIdUsrrevisao, OmCc omCc,
			String cdPt, Long revisao, Date dtRevisao, Date dtStativo,
			String urlConexao, String dsPt, String dsCurta, String depara,
			Byte tpImpprog, Byte stAtivo, Set<OmHomopt> omHomopts,
			Set<OmObj> omObjs, Set<DwPassagem> dwPassagems,
			Set<DwRotapasso> dwRotapassos, Set<DwConsolid> dwConsolids,
			Set<DwRt> dwRts, Set<OmPa> omPas, Set<OmPrg> omPrgs,
			Set<DwConsolpalog> dwConsolpalogs, Set<DwCalpt> dwCalpts,
			Set<DwConsolmolog> dwConsolmologs,
			Set<DwConsolatlog> dwConsolatlogs, Set<OmIndpt> omIndpts,
			Set<OmMapa> omMapas, Set<DwConsolpt> dwConsolpts) {
		this.idPt = idPt;
		this.omClp = omClp;
		this.omTppt = omTppt;
		this.omAlimByIdAlimpre = omAlimByIdAlimpre;
		this.omAlimByIdAlim = omAlimByIdAlim;
		this.omAlimByIdAlimcorrente = omAlimByIdAlimcorrente;
		this.omGt = omGt;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.omCc = omCc;
		this.cdPt = cdPt;
		this.revisao = revisao;
		this.dtRevisao = dtRevisao;
		this.dtStativo = dtStativo;
		this.urlConexao = urlConexao;
		this.dsPt = dsPt;
		this.dsCurta = dsCurta;
		this.depara = depara;
		this.tpImpprog = tpImpprog;
		this.stAtivo = stAtivo;
		this.omHomopts = omHomopts;
		this.omObjs = omObjs;
		this.dwPassagems = dwPassagems;
		this.dwRotapassos = dwRotapassos;
		this.dwConsolids = dwConsolids;
		this.dwRts = dwRts;
		this.omPas = omPas;
		this.omPrgs = omPrgs;
		this.dwConsolpalogs = dwConsolpalogs;
		this.dwCalpts = dwCalpts;
		this.dwConsolmologs = dwConsolmologs;
		this.dwConsolatlogs = dwConsolatlogs;
		this.omIndpts = omIndpts;
		this.omMapas = omMapas;
		this.dwConsolpts = dwConsolpts;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_PT_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_PT_SEQ", sequenceName = "OM_PT_SEQ")
	@Column(name = "id_pt", unique = true, nullable = false)
	public Long getIdPt() {
		return this.idPt;
	}

	public void setIdPt(Long idPt) {
		this.idPt = idPt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_clp")
	public OmClp getOmClp() {
		return this.omClp;
	}

	public void setOmClp(OmClp omClp) {
		this.omClp = omClp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tppt", nullable = false)
	public OmTppt getOmTppt() {
		return this.omTppt;
	}

	public void setOmTppt(OmTppt omTppt) {
		this.omTppt = omTppt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alimpre")
	public OmAlim getOmAlimByIdAlimpre() {
		return this.omAlimByIdAlimpre;
	}

	public void setOmAlimByIdAlimpre(OmAlim omAlimByIdAlimpre) {
		this.omAlimByIdAlimpre = omAlimByIdAlimpre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alim")
	public OmAlim getOmAlimByIdAlim() {
		return this.omAlimByIdAlim;
	}

	public void setOmAlimByIdAlim(OmAlim omAlimByIdAlim) {
		this.omAlimByIdAlim = omAlimByIdAlim;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alimcorrente")
	public OmAlim getOmAlimByIdAlimcorrente() {
		return this.omAlimByIdAlimcorrente;
	}

	public void setOmAlimByIdAlimcorrente(OmAlim omAlimByIdAlimcorrente) {
		this.omAlimByIdAlimcorrente = omAlimByIdAlimcorrente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gt")
	public OmGt getOmGt() {
		return this.omGt;
	}

	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cc", nullable = true)
	public OmCc getOmCc() {
		return this.omCc;
	}

	public void setOmCc(OmCc omCc) {
		this.omCc = omCc;
	}

	@Column(name = "cd_pt", length = 60)
	public String getCdPt() {
		return this.cdPt;
	}

	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
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

	@Column(name = "url_conexao")
	public String getUrlConexao() {
		return this.urlConexao;
	}

	public void setUrlConexao(String urlConexao) {
		this.urlConexao = urlConexao;
	}

	@Column(name = "ds_pt", length = 100)
	public String getDsPt() {
		return this.dsPt;
	}

	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}

	@Column(name = "ds_curta", length = 10)
	public String getDsCurta() {
		return this.dsCurta;
	}

	public void setDsCurta(String dsCurta) {
		this.dsCurta = dsCurta;
	}

	@Column(name = "depara", length = 10)
	public String getDepara() {
		return this.depara;
	}

	public void setDepara(String depara) {
		this.depara = depara;
	}

	@Column(name = "tp_impprog", nullable = false)
	public Byte getTpImpprog() {
		return this.tpImpprog;
	}

	public void setTpImpprog(Byte tpImpprog) {
		this.tpImpprog = tpImpprog;
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

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<OmHomopt> getOmHomopts() {
		return this.omHomopts;
	}

	public void setOmHomopts(Set<OmHomopt> omHomopts) {
		this.omHomopts = omHomopts;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<PpCp> getPpCps() {
		return this.ppCps;
	}

	public void setPpCps(Set<PpCp> ppCps) {
		this.ppCps = ppCps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<PpCpentsai> getPpCpentsais() {
		return this.ppCpentsais;
	}

	public void setPpCpentsais(Set<PpCpentsai> ppCpentsais) {
		this.ppCpentsais = ppCpentsais;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<OmObj> getOmObjs() {
		return this.omObjs;
	}

	public void setOmObjs(Set<OmObj> omObjs) {
		this.omObjs = omObjs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwPassagem> getDwPassagems() {
		return this.dwPassagems;
	}

	public void setDwPassagems(Set<DwPassagem> dwPassagems) {
		this.dwPassagems = dwPassagems;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwExpcvs> getDwExpcvses() {
		return this.dwExpcvses;
	}

	public void setDwExpcvses(Set<DwExpcvs> dwExpcvses) {
		this.dwExpcvses = dwExpcvses;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwRotapassoPt> getDwRotapassoPts() {
		return this.dwRotapassoPts;
	}

	public void setDwRotapassoPts(Set<DwRotapassoPt> dwRotapassoPts) {
		this.dwRotapassoPts = dwRotapassoPts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwRotapasso> getDwRotapassos() {
		return this.dwRotapassos;
	}

	public void setDwRotapassos(Set<DwRotapasso> dwRotapassos) {
		this.dwRotapassos = dwRotapassos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwConsolid> getDwConsolids() {
		return this.dwConsolids;
	}

	public void setDwConsolids(Set<DwConsolid> dwConsolids) {
		this.dwConsolids = dwConsolids;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<PpIndispRappt> getPpIndispRappts() {
		return this.ppIndispRappts;
	}

	public void setPpIndispRappts(Set<PpIndispRappt> ppIndispRappts) {
		this.ppIndispRappts = ppIndispRappts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwRt> getDwRts() {
		return this.dwRts;
	}

	public void setDwRts(Set<DwRt> dwRts) {
		this.dwRts = dwRts;

	}

	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<PpNec> getPpNecs() {
		return this.ppNecs;
	}

	public void setPpNecs(Set<PpNec> ppNecs) {
		this.ppNecs = ppNecs;
	}*/
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<MsTrigger> getMsTriggers() {
		return this.msTriggers;
	}

	public void setMsTriggers(Set<MsTrigger> msTriggers) {
		this.msTriggers = msTriggers;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<OmCfgptdetcoleta> getOmCfgptdetcoletas() {
		return this.omCfgptdetcoletas;
	}

	public void setOmCfgptdetcoletas(Set<OmCfgptdetcoleta> omCfgptdetcoletas) {
		this.omCfgptdetcoletas = omCfgptdetcoletas;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<PpPlanptgt> getPpPlanptgts() {
		return this.ppPlanptgts;
	}

	public void setPpPlanptgts(Set<PpPlanptgt> ppPlanptgts) {
		this.ppPlanptgts = ppPlanptgts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<OmPa> getOmPas() {
		return this.omPas;
	}

	public void setOmPas(Set<OmPa> omPas) {
		this.omPas = omPas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<OmPrg> getOmPrgs() {
		return this.omPrgs;
	}

	public void setOmPrgs(Set<OmPrg> omPrgs) {
		this.omPrgs = omPrgs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwConsolpalog> getDwConsolpalogs() {
		return this.dwConsolpalogs;
	}

	public void setDwConsolpalogs(Set<DwConsolpalog> dwConsolpalogs) {
		this.dwConsolpalogs = dwConsolpalogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwCalpt> getDwCalpts() {
		return this.dwCalpts;
	}

	public void setDwCalpts(Set<DwCalpt> dwCalpts) {
		this.dwCalpts = dwCalpts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwConsolmolog> getDwConsolmologs() {
		return this.dwConsolmologs;
	}

	public void setDwConsolmologs(Set<DwConsolmolog> dwConsolmologs) {
		this.dwConsolmologs = dwConsolmologs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwConsolatlog> getDwConsolatlogs() {
		return this.dwConsolatlogs;
	}

	public void setDwConsolatlogs(Set<DwConsolatlog> dwConsolatlogs) {
		this.dwConsolatlogs = dwConsolatlogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<OmIndpt> getOmIndpts() {
		return this.omIndpts;
	}

	public void setOmIndpts(Set<OmIndpt> omIndpts) {
		this.omIndpts = omIndpts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<OmMapa> getOmMapas() {
		return this.omMapas;
	}

	public void setOmMapas(Set<OmMapa> omMapas) {
		this.omMapas = omMapas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_folha")
	public DwFolha getDwFolha() {
		return dwFolha;
	}
	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}

	@Column(name = "IS_PLANGT", precision = 1)
	public Boolean getIsPlangt() {
		return isPlangt;
	}

	public void setIsPlangt(Boolean isPlangt) {
		this.isPlangt = isPlangt;
	}

	@Column(name = "ESTAGIO", precision = 3)
	public Integer getEstagio() {
		return this.estagio;
	}

	public void setEstagio(Integer estagio) {
		this.estagio = estagio;
	}

	
	@Column(name = "MODULO", precision = 3)
	public Integer getModulo() {
		return this.modulo;
	}

	public void setModulo(Integer modulo) {
		this.modulo = modulo;
	}

	
	@Column(name = "IS_APONGT", precision = 1)
	public Boolean getIsApongt() {
		return isApongt;
	}

	public void setIsApongt(Boolean isApongt) {
		this.isApongt = isApongt;
	}
	
	@Column(name = "IS_APONPARADAGT", precision = 1)
	public Boolean getIsAponparadagt() {
		return isAponparadagt;
	}

	public void setIsAponparadagt(Boolean isAponparadagt) {
		this.isAponparadagt = isAponparadagt;
	}

	@Column(name = "IS_PARALINHA", precision = 1)
	public Boolean getIsParadalinha() {
		return isParadalinha;
	}

	public void setIsParadalinha(Boolean isParadalinha) {
		this.isParadalinha = isParadalinha;
	}
	
	
	@Column(name = "is_alimcorexc")
	public Boolean getIsAlimcorexc() {
		return isAlimcorexc;
	}

	public void setIsAlimcorexc(Boolean isAlimcorexc) {
		this.isAlimcorexc = isAlimcorexc;
	}
	@Column(name = "IND_OEE", precision = 6, scale = 3)
	public BigDecimal getIndOee() {
		return this.indOee;
	}

	public void setIndOee(BigDecimal indOee) {
		this.indOee = indOee;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwConsolpt> getDwConsolpts() {
		return this.dwConsolpts;
	}

	public void setDwConsolpts(Set<DwConsolpt> dwConsolpts) {
		this.dwConsolpts = dwConsolpts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<OmPapro> getOmPapros() {
		return this.omPapros;
	}

	public void setOmPapros(Set<OmPapro> omPapros) {
		this.omPapros = omPapros;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwOperacao> getDwOperacaos() {
		return this.dwOperacaos;
	}

	public void setDwOperacaos(Set<DwOperacao> dwOperacaos) {
		this.dwOperacaos = dwOperacaos;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<DwEstlocal> getDwEstlocals() {
		return this.dwEstlocals;
	}

	public void setDwEstlocals(Set<DwEstlocal> dwEstlocals) {
		this.dwEstlocals = dwEstlocals;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omPtByIdPt")
	public Set<OmPtcnc> getOmPtcncsForIdPt() {
		return this.omPtcncsForIdPt;
	}

	public void setOmPtcncsForIdPt(Set<OmPtcnc> omPtcncsForIdPt) {
		this.omPtcncsForIdPt = omPtcncsForIdPt;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPtByIdPtFilho")
	public Set<OmPtcnc> getOmPtcncsForIdPtFilho() {
		return this.omPtcncsForIdPtFilho;
	}

	public void setOmPtcncsForIdPtFilho(Set<OmPtcnc> omPtcncsForIdPtFilho) {
		this.omPtcncsForIdPtFilho = omPtcncsForIdPtFilho;
	}
	
	@Column(name = "IS_SEMOP")
	public Boolean getIsSemop() {
		return this.isSemop;
	}

	public void setIsSemop(Boolean valor) {
		this.isSemop = valor;
	}
	
	@Column(name = "IS_SOLICITAQTDE")
	public Boolean getIsSolicitaqtde() {
		return this.isSolicitaqtde;
	}
	public void setIsSolicitaqtde(Boolean valor) {
		this.isSolicitaqtde = valor;
	}
	
	@Column(name = "IS_DEVEPASSARNS")
	public Boolean getIsDevepassarns() {
		return this.isDevepassarns;
	}
	public void setIsDevepassarns(Boolean valor) {
		this.isDevepassarns = valor;
	}

	@Column(name = "SEG_AUTO_TEMPOPARADANOCICLO", precision = 20, scale = 10)
	public BigDecimal getSegAutoTempoparadanociclo() {
		return this.segAutoTempoparadanociclo;
	}

	public void setSegAutoTempoparadanociclo(BigDecimal valor) {
		this.segAutoTempoparadanociclo= valor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cp")
	public PpCp getPpCp() {
		return this.ppCp;
	}

	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omPt")
	public Set<OmPtcp> getOmPtcps() {
		return this.omPtcps;
	}

	public void setOmPtcps(Set<OmPtcp> omPtcps) {
		this.omPtcps = omPtcps;
	}

	@Column(name = "tp_sessao")
	public Byte getTpSessao() {
		return tpSessao;
	}

	public void setTpSessao(Byte tpSessao) {
		this.tpSessao = tpSessao;
	}

	@Column(name = "ds_sessao", length = 40)
	public String getDsSessao() {
		return dsSessao;
	}

	public void setDsSessao(String dsSessao) {
		this.dsSessao = dsSessao;
	}
	
	@Column(name = "IS_CONSOLPENDENTE")
	public Boolean getIsConsolpendente() {
		return this.isConsolpendente;
	}
	public void setIsConsolpendente(Boolean valor) {
		this.isConsolpendente = valor;
	}

	@Column(name = "IS_PERDASINC")
	public Boolean getIsPerdasinc() {
		return this.isPerdasinc;
	}
	public void setIsPerdasinc(Boolean valor) {
		this.isPerdasinc = valor;
	}

	@Column(name = "is_habilita_cip")
	public Boolean getIsHabilitaCip() {
		return this.isHabilitaCip;
	}

	public void setIsHabilitaCip(Boolean isHabilitaCip) {
		this.isHabilitaCip = isHabilitaCip;
	}

	@Column(name = "is_ciclocomrefugo")
	public Boolean getIsCiclocomrefugo() {
		return isCiclocomrefugo;
	}

	public void setIsCiclocomrefugo(Boolean isCiclocomrefugo) {
		this.isCiclocomrefugo = isCiclocomrefugo;
	}

	@Column(name = "is_logingt")
	public Boolean getIsLogingt() {
		return this.isLogingt;
	}

	public void setIsLogingt(Boolean isvalor) {
		this.isLogingt = isvalor;
	}

	@Column(name = "is_parada_fechaciclo")
	public Boolean getIsParadaFechaciclo() {
		return this.isParadaFechaciclo;
	}

	public void setIsParadaFechaciclo(Boolean isvalor) {
		this.isParadaFechaciclo = isvalor;
	}

	@Column(name = "is_habilita_varitmo")
	public Boolean getIsHabilitaVaritmo() {
		return this.isHabilitaVaritmo;
	}

	public void setIsHabilitaVaritmo(Boolean isHabilitaVaritmo) {
		this.isHabilitaVaritmo = isHabilitaVaritmo;
	}

	@Column(name = "perc_varitmo", precision = 7, scale = 3)
	public BigDecimal getPercVaritmo() {
		return this.percVaritmo;
	}

	public void setPercVaritmo(BigDecimal percVaritmo) {
		this.percVaritmo = percVaritmo;
	}

	@Column(name = "qt_varitmo")
	public Integer getQtVaritmo() {
		return this.qtVaritmo;
	}

	public void setQtVaritmo(Integer qtVaritmo) {
		this.qtVaritmo = qtVaritmo;
	}

	@Column(name = "tp_classeabc")
	public Byte getTpClasseabc() {
		return this.tpClasseabc;
	}

	public void setTpClasseabc(Byte tpClasseabc) {
		this.tpClasseabc = tpClasseabc;
	}
	@Column(name = "IS_CIP_ATIVADO")
	public Boolean getIsCipAtivado() {
		return this.isCipAtivado;
	}

	public void setIsCipAtivado(Boolean valor) {
		this.isCipAtivado = valor;
	}

	@Column(name = "qt_eventosnoclp")
	public Integer getQtEventosnoclp() {
		return this.qtEventosnoclp;
	}

	public void setQtEventosnoclp(Integer valor) {
		this.qtEventosnoclp = valor;
	}

	@Column(name = "url_impressoracb")
	public String getUrlImpressoracb() {
		return this.urlImpressoracb;
	}

	public void setUrlImpressoracb(String valor) {
		this.urlImpressoracb = valor;
	}

	@Column(name = "url_impressoradoc")
	public String getUrlImpressoradoc() {
		return this.urlImpressoradoc;
	}

	public void setUrlImpressoradoc(String valor) {
		this.urlImpressoradoc = valor;
	}

	@OneToOne(fetch=FetchType.LAZY, mappedBy="omPt")
    public MsPtColeta getMsPtColeta() {
        return this.msPtColeta;
    }
    
    public void setMsPtColeta(MsPtColeta msPtColeta) {
        this.msPtColeta = msPtColeta;
    }

	@Column(name = "is_apontarposicaomecanica")
	public Boolean getIsApontarposicaomecanica() {
		return isApontarposicaomecanica;
	}

	public void setIsApontarposicaomecanica(Boolean isApontarposicaomecanica) {
		this.isApontarposicaomecanica = isApontarposicaomecanica;
	}

	@Column(name = "ordemnogt")
	public Integer getOrdemnogt() {
		return ordemnogt;
	}

	public void setOrdemnogt(Integer ordemnogt) {
		this.ordemnogt = ordemnogt;
	}

	@Column(name = "IS_TROCAOPGT", precision = 1)
	public Boolean getIsTrocaopgt() {
		return isTrocaopgt;
	}

	public void setIsTrocaopgt(Boolean isTrocaopgt) {
		this.isTrocaopgt = isTrocaopgt;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="omPt")
	public OmPtPa getOmPtPa() {
		return omPtPa;
	}

	public void setOmPtPa(OmPtPa omPtPa) {
		this.omPtPa = omPtPa;
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