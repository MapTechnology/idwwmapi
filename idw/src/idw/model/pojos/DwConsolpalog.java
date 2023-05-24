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

import idw.model.pojos.template.DwConsolpalogTemplate;

@Entity
@Table(name = "DW_CONSOLPALOG")
public class DwConsolpalog extends DwConsolpalogTemplate implements java.io.Serializable {

	private static final long serialVersionUID = -1191263872820015977L;
	private Long idConsolpalog;
	private DwTJust dwTJust;
	private DwTAcao dwTAcao;
	private DwTCausa dwTCausa;
	private OmPt omPt;
	private PpCp ppCp;
	private DwTParada dwTParada;
	private Date dthrIparada;
	private Integer msDthriparada;
	private Date dthrFparada;
	private Integer msDthrfparada;
	private Date dthrFparadaAb;
	private Integer msDthrfparadaAb;
	private BigDecimal segAutoTempoparadaAb;
	private BigDecimal segAutoTempoparadaCp;
	private BigDecimal segAutoTempoparadaSp;
	private BigDecimal segManuTempoparadaCp;
	private BigDecimal segManuTempoparadaSp;
	private Boolean isVarritmo;
	private BigDecimal segAutoCta;
	private BigDecimal segManuCta;
	private Set<DwConsolpalogtec> dwConsolpalogtecs = new HashSet<DwConsolpalogtec>(0);
	private Set<DwRt> dwRts = new HashSet<DwRt>(0);
	private Set<DwConsolpaoco> dwConsolpaocos = new HashSet<DwConsolpaoco>(0);
	private Set<DwConsolpt> dwConsolpts = new HashSet<DwConsolpt>(0);
	
	public DwConsolpalog() {
	}

	public DwConsolpalog(long idConsolpalog, OmPt omPt, DwTParada dwTParada) {
		this.idConsolpalog = idConsolpalog;
		this.omPt = omPt;
		this.dwTParada = dwTParada;
	}

	public DwConsolpalog(long idConsolpalog, DwTJust dwTJust,
			DwTAcao dwTAcao, DwTCausa dwTCausa, OmPt omPt, DwTParada dwTParada,
			Date dthrIparada, Integer msDthriparada, Date dthrFparada,
			Integer msDthrfparada, Date dthrFparadaAb,
			Integer msDthrfparadaAb, BigDecimal segAutoTempoparadaAb,
			BigDecimal segAutoTempoparadaCp, BigDecimal segAutoTempoparadaSp,
			BigDecimal segManuTempoparadaCp, BigDecimal segManuTempoparadaSp,
			Boolean isVarritmo, BigDecimal segAutoCta, BigDecimal segManuCta,
			Set<DwConsolpalogtec> dwConsolpalogtecs, Set<DwRt> dwRts,
			Set<DwConsolpaoco> dwConsolpaocos) {
		this.idConsolpalog = idConsolpalog;
		this.dwTJust = dwTJust;
		this.dwTAcao = dwTAcao;
		this.dwTCausa = dwTCausa;
		this.omPt = omPt;
		this.dwTParada = dwTParada;
		this.dthrIparada = dthrIparada;
		this.msDthriparada = msDthriparada;
		this.dthrFparada = dthrFparada;
		this.msDthrfparada = msDthrfparada;
		this.dthrFparadaAb = dthrFparadaAb;
		this.msDthrfparadaAb = msDthrfparadaAb;
		this.segAutoTempoparadaAb = segAutoTempoparadaAb;
		this.segAutoTempoparadaCp = segAutoTempoparadaCp;
		this.segAutoTempoparadaSp = segAutoTempoparadaSp;
		this.segManuTempoparadaCp = segManuTempoparadaCp;
		this.segManuTempoparadaSp = segManuTempoparadaSp;
		this.dwConsolpalogtecs = dwConsolpalogtecs;
		this.dwRts = dwRts;
		this.dwConsolpaocos = dwConsolpaocos;
		this.isVarritmo = isVarritmo;
		this.segAutoCta = segAutoCta;
		this.segManuCta = segManuCta;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_CONSOLPALOG_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_CONSOLPALOG_SEQ", sequenceName = "DW_CONSOLPALOG_SEQ")			
	@Column(name = "ID_CONSOLPALOG", unique = true, nullable = false)
	public Long getIdConsolpalog() {
		return this.idConsolpalog;
	}

	public void setIdConsolpalog(Long idConsolpalog) {
		this.idConsolpalog = idConsolpalog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TJUST")
	public DwTJust getDwTJust() {
		return this.dwTJust;
	}

	public void setDwTJust(DwTJust dwTJust) {
		this.dwTJust = dwTJust;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TACAO")
	public DwTAcao getDwTAcao() {
		return this.dwTAcao;
	}

	public void setDwTAcao(DwTAcao dwTAcao) {
		this.dwTAcao = dwTAcao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TCAUSA")
	public DwTCausa getDwTCausa() {
		return this.dwTCausa;
	}

	public void setDwTCausa(DwTCausa dwTCausa) {
		this.dwTCausa = dwTCausa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PT", nullable = false)
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPARADA", nullable = false)
	public DwTParada getDwTParada() {
		return this.dwTParada;
	}

	public void setDwTParada(DwTParada dwTParada) {
		this.dwTParada = dwTParada;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_IPARADA")
	public Date getDthrIparada() {
		return this.dthrIparada;
	}

	public void setDthrIparada(Date dthrIparada) {
		this.dthrIparada = dthrIparada;
	}

	@Column(name = "MS_DTHRIPARADA", precision = 22, scale = 0)
	public Integer getMsDthriparada() {
		return this.msDthriparada;
	}

	public void setMsDthriparada(Integer msDthriparada) {
		this.msDthriparada = msDthriparada;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_FPARADA")
	public Date getDthrFparada() {
		return this.dthrFparada;
	}

	public void setDthrFparada(Date dthrFparada) {
		this.dthrFparada = dthrFparada;
	}

	@Column(name = "MS_DTHRFPARADA", precision = 22, scale = 0)
	public Integer getMsDthrfparada() {
		return this.msDthrfparada;
	}

	public void setMsDthrfparada(Integer msDthrfparada) {
		this.msDthrfparada = msDthrfparada;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_FPARADA_AB")
	public Date getDthrFparadaAb() {
		return this.dthrFparadaAb;
	}

	public void setDthrFparadaAb(Date dthrFparadaAb) {
		this.dthrFparadaAb = dthrFparadaAb;
	}

	@Column(name = "MS_DTHRFPARADA_AB", precision = 22, scale = 0)
	public Integer getMsDthrfparadaAb() {
		return this.msDthrfparadaAb;
	}

	public void setMsDthrfparadaAb(Integer msDthrfparadaAb) {
		this.msDthrfparadaAb = msDthrfparadaAb;
	}

	@Column(name = "SEG_AUTO_TEMPOPARADA_AB", precision = 20, scale = 10)
	public BigDecimal getSegAutoTempoparadaAb() {
		return this.segAutoTempoparadaAb;
	}

	public void setSegAutoTempoparadaAb(BigDecimal segAutoTempoparadaAb) {
		this.segAutoTempoparadaAb = segAutoTempoparadaAb;
	}

	@Column(name = "SEG_AUTO_TEMPOPARADA_CP", precision = 20, scale = 10)
	public BigDecimal getSegAutoTempoparadaCp() {
		return this.segAutoTempoparadaCp;
	}

	public void setSegAutoTempoparadaCp(BigDecimal segAutoTempoparadaCp) {
		this.segAutoTempoparadaCp = segAutoTempoparadaCp;
	}

	@Column(name = "SEG_AUTO_TEMPOPARADA_SP", precision = 20, scale = 10)
	public BigDecimal getSegAutoTempoparadaSp() {
		return this.segAutoTempoparadaSp;
	}

	public void setSegAutoTempoparadaSp(BigDecimal segAutoTempoparadaSp) {
		this.segAutoTempoparadaSp = segAutoTempoparadaSp;
	}

	@Column(name = "SEG_MANU_TEMPOPARADA_CP", precision = 20, scale = 10)
	public BigDecimal getSegManuTempoparadaCp() {
		return this.segManuTempoparadaCp;
	}

	public void setSegManuTempoparadaCp(BigDecimal segManuTempoparadaCp) {
		this.segManuTempoparadaCp = segManuTempoparadaCp;
	}

	@Column(name = "SEG_MANU_TEMPOPARADA_SP", precision = 20, scale = 10)
	public BigDecimal getSegManuTempoparadaSp() {
		return this.segManuTempoparadaSp;
	}

	public void setSegManuTempoparadaSp(BigDecimal segManuTempoparadaSp) {
		this.segManuTempoparadaSp = segManuTempoparadaSp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwConsolpalog")
	public Set<DwConsolpalogtec> getDwConsolpalogtecs() {
		return this.dwConsolpalogtecs;
	}

	public void setDwConsolpalogtecs(Set<DwConsolpalogtec> dwConsolpalogtecs) {
		this.dwConsolpalogtecs = dwConsolpalogtecs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwConsolpalog")
	public Set<DwRt> getDwRts() {
		return this.dwRts;
	}

	public void setDwRts(Set<DwRt> dwRts) {
		this.dwRts = dwRts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwConsolpalog")
	public Set<DwConsolpaoco> getDwConsolpaocos() {
		return this.dwConsolpaocos;
	}

	public void setDwConsolpaocos(Set<DwConsolpaoco> dwConsolpaocos) {
		this.dwConsolpaocos = dwConsolpaocos;
	}

	@Column(name = "is_varritmo")
	public Boolean getIsVarritmo() {
		return this.isVarritmo;
	}

	public void setIsVarritmo(Boolean isVarritmo) {
		this.isVarritmo = isVarritmo;
	}

	@Column(name = "seg_auto_cta", precision = 20, scale = 10)
	public BigDecimal getSegAutoCta() {
		return this.segAutoCta;
	}

	public void setSegAutoCta(BigDecimal segAutoCta) {
		this.segAutoCta = segAutoCta;
	}

	@Column(name = "seg_manu_cta", precision = 20, scale = 10)
	public BigDecimal getSegManuCta() {
		return this.segManuCta;
	}

	public void setSegManuCta(BigDecimal segManuCta) {
		this.segManuCta = segManuCta;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CP")
	public PpCp getPpCp() {
		return this.ppCp;
	}

	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwConsolpalog")
	public Set<DwConsolpt> getDwConsolpts() {
		return dwConsolpts;
	}

	public void setDwConsolpts(Set<DwConsolpt> dwConsolptsForIdRtcic) {
		this.dwConsolpts = dwConsolptsForIdRtcic;
	}	
}
