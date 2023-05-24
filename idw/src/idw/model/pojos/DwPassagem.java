package idw.model.pojos;

import java.math.BigDecimal;
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

// Generated 29/01/2010 13:18:21 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.DwPassagemTemplate;


/**
 * DwPassagem generated by hbm2java
 */
@Entity
@Table(name = "dw_passagem")
public class DwPassagem extends DwPassagemTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idPassagem;
	private OmUsr omUsrByIdUsrsupervisor;
	private OmUsr omUsrByIdUsroperador;
	private DwNserie dwNserie;
	private DwConsolid dwConsolid;
	private OmPt omPt;
	private DwEst dwEst;
	private Date dthr;
	private Integer msDthr;
	private Byte stNserie;
	private BigDecimal segCiclo;
	private Date dthrInicio;
	private Integer msDthrinicio;
	
	private DwTArea dwTArea;

	private Set<DwNserie> dwNseries = new HashSet<DwNserie>(0);
	private Set<DwPassmon> dwPassmons = new HashSet<DwPassmon>(0);
	private Set<DwPassdef> dwPassdefs = new HashSet<DwPassdef>(0);
	private Set<DwPasstf> dwPasstfs = new HashSet<DwPasstf>(0);
	private Set<DwPasscau> dwPasscaus = new HashSet<DwPasscau>(0);
	private Boolean is_tf_finalizado;
	private Boolean isMontagemfechadaantecipadamente;
	private String dsDiariobordo;
	
	private Long sequencial;
	
	private Byte stAtivo;

	public DwPassagem() {
	}

	public DwPassagem(long idPassagem, DwNserie dwNserie,
			DwConsolid dwConsolid, OmPt omPt) {
		this.idPassagem = idPassagem;
		this.dwNserie = dwNserie;
		this.dwConsolid = dwConsolid;
		this.omPt = omPt;
	}

	public DwPassagem(long idPassagem, OmUsr omUsrByIdUsrsupervisor,
			OmUsr omUsrByIdUsroperador, DwNserie dwNserie,
			DwConsolid dwConsolid, OmPt omPt, Date dthr, Integer msDthr,
			Byte stNserie, BigDecimal segCiclo, Date dthrInicio,
			Integer msDthrinicio, Set<DwNserie> dwNseries,
			Set<DwPassmon> dwPassmons, Set<DwPassdef> dwPassdefs) {
		this.idPassagem = idPassagem;
		this.omUsrByIdUsrsupervisor = omUsrByIdUsrsupervisor;
		this.omUsrByIdUsroperador = omUsrByIdUsroperador;
		this.dwNserie = dwNserie;
		this.dwConsolid = dwConsolid;
		this.omPt = omPt;
		this.dthr = dthr;
		this.msDthr = msDthr;
		this.stNserie = stNserie;
		this.segCiclo = segCiclo;
		this.dthrInicio = dthrInicio;
		this.msDthrinicio = msDthrinicio;
		this.dwNseries = dwNseries;
		this.dwPassmons = dwPassmons;
		this.dwPassdefs = dwPassdefs;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_PASSAGEM_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_PASSAGEM_SEQ", sequenceName = "DW_PASSAGEM_SEQ")
	@Column(name = "id_passagem", unique = true, nullable = false)
	public long getIdPassagem() {
		return this.idPassagem;
	}

	public void setIdPassagem(long idPassagem) {
		this.idPassagem = idPassagem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrsupervisor")
	public OmUsr getOmUsrByIdUsrsupervisor() {
		return this.omUsrByIdUsrsupervisor;
	}

	public void setOmUsrByIdUsrsupervisor(OmUsr omUsrByIdUsrsupervisor) {
		this.omUsrByIdUsrsupervisor = omUsrByIdUsrsupervisor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usroperador")
	public OmUsr getOmUsrByIdUsroperador() {
		return this.omUsrByIdUsroperador;
	}

	public void setOmUsrByIdUsroperador(OmUsr omUsrByIdUsroperador) {
		this.omUsrByIdUsroperador = omUsrByIdUsroperador;
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
	@JoinColumn(name = "id_consolid", nullable = false)
	public DwConsolid getDwConsolid() {
		return this.dwConsolid;
	}

	public void setDwConsolid(DwConsolid dwConsolid) {
		this.dwConsolid = dwConsolid;
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
	@Column(name = "dthr", length = 23)
	public Date getDthr() {
		return this.dthr;
	}

	public void setDthr(Date dthr) {
		this.dthr = dthr;
	}

	@Column(name = "ms_Dthr")
	public Integer getMsDthr() {
		return this.msDthr;
	}

	public void setMsDthr(Integer msDthr) {
		this.msDthr = msDthr;
	}

	@Column(name = "st_nserie")
	public Byte getStNserie() {
		return this.stNserie;
	}

	public void setStNserie(Byte stNserie) {
		this.stNserie = stNserie;
	}

	@Column(name = "seg_ciclo", precision = 20, scale = 10)
	public BigDecimal getSegCiclo() {
		return this.segCiclo;
	}

	public void setSegCiclo(BigDecimal segCiclo) {
		this.segCiclo = segCiclo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_inicio", length = 23)
	public Date getDthrInicio() {
		return this.dthrInicio;
	}

	public void setDthrInicio(Date dthrInicio) {
		this.dthrInicio = dthrInicio;
	}

	@Column(name = "ms_dthrinicio")
	public Integer getMsDthrinicio() {
		return this.msDthrinicio;
	}

	public void setMsDthrinicio(Integer msDthrinicio) {
		this.msDthrinicio = msDthrinicio;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwPassagem")
	public Set<DwNserie> getDwNseries() {
		return this.dwNseries;
	}

	public void setDwNseries(Set<DwNserie> dwNseries) {
		this.dwNseries = dwNseries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwPassagem")
	public Set<DwPassmon> getDwPassmons() {
		return this.dwPassmons;
	}

	public void setDwPassmons(Set<DwPassmon> dwPassmons) {
		this.dwPassmons = dwPassmons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwPassagem")
	public Set<DwPassdef> getDwPassdefs() {
		return this.dwPassdefs;
	}

	public void setDwPassdefs(Set<DwPassdef> dwPassdefs) {
		this.dwPassdefs = dwPassdefs;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EST")
	public DwEst getDwEst() {
		return this.dwEst;
	}

	public void setDwEst(DwEst dwEst) {
		this.dwEst = dwEst;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwPassagem")
	public Set<DwPasscau> getDwPasscaus() {
		return this.dwPasscaus;
	}

	public void setDwPasscaus(Set<DwPasscau> dwPasscaus) {
		this.dwPasscaus = dwPasscaus;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwPassagem")
	public Set<DwPasstf> getDwPasstfs() {
		return this.dwPasstfs;
	}

	public void setDwPasstfs(Set<DwPasstf> dwPasstfs) {
		this.dwPasstfs = dwPasstfs;
	}
	private DwPasscau dwPasscau;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PASSCAU")
	public DwPasscau getDwPasscau() {
		return this.dwPasscau;
	}

	public void setDwPasscau(DwPasscau dwPasscau) {
		this.dwPasscau = dwPasscau;
	}
	@Column(name = "is_tf_finalizado")
	public Boolean getIsTfFinalizado() {
		return this.is_tf_finalizado;
	}

	public void setIsTfFinalizado(Boolean IsTfFinalizado) {
		this.is_tf_finalizado = IsTfFinalizado;
	}
	
	@Column(name = "IS_MONTAGEMFECHADAANTECIP")
	public Boolean getIsMontagemfechadaantecipadamente() {
		return isMontagemfechadaantecipadamente;
	}

	public void setIsMontagemfechadaantecipadamente(Boolean isMontagemfechadaantecipadamente) {
		this.isMontagemfechadaantecipadamente = isMontagemfechadaantecipadamente;
	}

	@Column(name = "ds_diariobordo")
	public String getDsDiariobordo() {
		return this.dsDiariobordo;
	}

	public void setDsDiariobordo(String valor) {
		this.dsDiariobordo = valor;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AREA")
	public DwTArea getDwTArea() {
		return this.dwTArea;
	}

	public void setDwTArea(DwTArea dwTArea) {
		this.dwTArea = dwTArea;
	}
	
	@Column(name = "sequencial")
	public Long getSequencial() {
		return sequencial;
	}
	public void setSequencial(Long sequencial) {
		this.sequencial = sequencial;
	}
	
	@Column(name = "ST_ATIVO", length = 1)
	public Byte getStAtivo() {
		return this.stAtivo;
	}
	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}
}
