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

// Generated 20/01/2010 15:07:16 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.DwRtTemplate;

/**
 * DwRt generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "dw_rt")
public class DwRt extends DwRtTemplate implements java.io.Serializable {

	private long idRt;
	private Long idRtbase;
	private DwConsolpalog dwConsolpalog;
	private PpCp ppCp;
	private OmPt omPt;
	private DwTurno dwTurno;
	private Boolean isSemplanejamento;
	private Boolean isOperador;
	private Byte stFuncionamento;
	private Boolean isManutencaopre;
	private Boolean isVidautilmolde;
	private Byte stQualidade;
	private Boolean isParadapeso;
	private Date dthrIciclo;
	private Date dthrCadastro;
	private Integer msDthriciclo;
	private BigDecimal segParadaparcial;
	private int ordemCiclos;
	private Boolean isRegulagem;
	private Boolean isParadafechaciclo;
	private BigDecimal segCiclopadraominimo;
	private BigDecimal segUltimociclo;
	private BigDecimal pcsProducaoplanejadaOp;
	private BigDecimal pcsProducaoliquidaOp;
	private Date dtReferencia;
	private Boolean isConforme;
	private Boolean isAlerta;
	private Boolean isCip;
	private Boolean isGargaloteorico;
	private Boolean isGargalodinamico;
	private BigDecimal ulttemperaturalida;
	private Set<DwConsolid> dwConsolids = new HashSet<DwConsolid>(0);
	private Set<DwRtcic> dwRtcics = new HashSet<DwRtcic>(0);
	
	private Boolean isOffline;
	private Date dthrHeartbeat;
	private Date dthrEvento;

	public DwRt() {
	}

	public DwRt(long idRt, OmPt omPt, DwTurno dwTurno) {
		this.idRt = idRt;
		this.omPt = omPt;
		this.dwTurno = dwTurno;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_RT_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_RT_SEQ", sequenceName = "DW_RT_SEQ")
	@Column(name = "ID_RT", unique = true, nullable = false)
	public long getIdRt() {
		return this.idRt;
	}

	public void setIdRt(long idRt) {
		this.idRt = idRt;
	}

	@Column(name = "ID_RTBASE")
	public Long getIdRtbase() {
		return this.idRtbase;
	}

	public void setIdRtbase(Long id) {
		this.idRtbase = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONSOLPALOG")
	public DwConsolpalog getDwConsolpalog() {
		return this.dwConsolpalog;
	}

	public void setDwConsolpalog(DwConsolpalog dwConsolpalog) {
		this.dwConsolpalog = dwConsolpalog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CP")
	public PpCp getPpCp() {
		return this.ppCp;
	}

	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
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
	@JoinColumn(name = "ID_TURNO", nullable = false)
	public DwTurno getDwTurno() {
		return this.dwTurno;
	}

	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}

	@Column(name = "IS_SEMPLANEJAMENTO")
	public Boolean getIsSemplanejamento() {
		return this.isSemplanejamento;
	}

	public void setIsSemplanejamento(Boolean isSemplanejamento) {
		this.isSemplanejamento = isSemplanejamento;
	}

	@Column(name = "IS_OPERADOR")
	public Boolean getIsOperador() {
		return this.isOperador;
	}

	public void setIsOperador(Boolean isOperador) {
		this.isOperador = isOperador;
	}

	@Column(name = "ST_FUNCIONAMENTO")
	public Byte getStFuncionamento() {
		return this.stFuncionamento;
	}

	public void setStFuncionamento(Byte stFuncionamento) {
		this.stFuncionamento = stFuncionamento;
	}

	@Column(name = "IS_MANUTENCAOPRE")
	public Boolean getIsManutencaopre() {
		return this.isManutencaopre;
	}

	public void setIsManutencaopre(Boolean isManutencaopre) {
		this.isManutencaopre = isManutencaopre;
	}

	@Column(name = "IS_VIDAUTILMOLDE")
	public Boolean getIsVidautilmolde() {
		return this.isVidautilmolde;
	}

	public void setIsVidautilmolde(Boolean isVidautilmolde) {
		this.isVidautilmolde = isVidautilmolde;
	}

	@Column(name = "ST_QUALIDADE")
	public Byte getStQualidade() {
		return this.stQualidade;
	}

	public void setStQualidade(Byte stQualidade) {
		this.stQualidade = stQualidade;
	}

	@Column(name = "IS_PARADAPESO")
	public Boolean getIsParadapeso() {
		return this.isParadapeso;
	}

	public void setIsParadapeso(Boolean isParadapeso) {
		this.isParadapeso = isParadapeso;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_ICICLO")
	public Date getDthrIciclo() {
		return this.dthrIciclo;
	}

	public void setDthrIciclo(Date dthrIciclo) {
		this.dthrIciclo = dthrIciclo;
	}

	@Column(name = "MS_DTHRICICLO")
	public Integer getMsDthriciclo() {
		return this.msDthriciclo;
	}

	public void setMsDthriciclo(Integer msDthriciclo) {
		this.msDthriciclo = msDthriciclo;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_REFERENCIA")
	public Date getDtReferencia() {
		return this.dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	

	@Column(name = "SEG_PARADAPARCIAL")
	public BigDecimal getSegParadaparcial() {
		return this.segParadaparcial;
	}

	public void setSegParadaparcial(BigDecimal segParadaparcial) {
		this.segParadaparcial = segParadaparcial;
	}

	@Column(name = "ORDEM_CICLOS")
	public Integer getOrdemCiclos() {
		return this.ordemCiclos;
	}

	public void setOrdemCiclos(Integer ordemCiclos) {
		this.ordemCiclos = ordemCiclos;
	}

	@Column(name = "IS_REGULAGEM")
	public Boolean getIsRegulagem() {
		return this.isRegulagem;
	}

	public void setIsRegulagem(Boolean isRegulagem) {
		this.isRegulagem = isRegulagem;
	}

	@Column(name = "IS_PARADAFECHACICLO")
	public Boolean getIsParadafechaciclo() {
		return this.isParadafechaciclo;
	}

	public void setIsParadafechaciclo(Boolean isParadafechaciclo) {
		this.isParadafechaciclo = isParadafechaciclo;
	}

	@Column(name = "SEG_CICLOPADRAOMINIMO", precision = 20, scale = 10)
	public BigDecimal getSegCiclopadraominimo() {
		return this.segCiclopadraominimo;
	}

	public void setSegCiclopadraominimo(BigDecimal segCiclopadraominimo) {
		this.segCiclopadraominimo = segCiclopadraominimo;
	}

	@Column(name = "SEG_ULTIMOCICLO", precision = 20, scale = 10)
	public BigDecimal getSegUltimociclo() {
		return this.segUltimociclo;
	}

	public void setSegUltimociclo(BigDecimal segUltimociclo) {
		this.segUltimociclo = segUltimociclo;
	}

	@Column(name = "PCS_PRODUCAOPLANEJADA_OP", precision = 22, scale = 0)
	public BigDecimal getPcsProducaoplanejadaOp() {
		return this.pcsProducaoplanejadaOp;
	}

	public void setPcsProducaoplanejadaOp(BigDecimal pcsProducaoplanejadaOp) {
		this.pcsProducaoplanejadaOp = pcsProducaoplanejadaOp;
	}

	@Column(name = "PCS_PRODUCAOLIQUIDA_OP", precision = 22, scale = 0)
	public BigDecimal getPcsProducaoliquidaOp() {
		return this.pcsProducaoliquidaOp;
	}

	public void setPcsProducaoliquidaOp(BigDecimal pcsProducaoliquidaOp) {
		this.pcsProducaoliquidaOp = pcsProducaoliquidaOp;
	}

	@Column(name = "IS_CONFORME")
	public Boolean getIsConforme() {
		return this.isConforme;
	}

	public void setIsConforme(Boolean isConforme) {
		this.isConforme = isConforme;
	}

	@Column(name = "IS_ALERTA")
	public Boolean getIsAlerta() {
		return this.isAlerta;
	}

	public void setIsAlerta(Boolean isAlerta) {
		this.isAlerta = isAlerta;
	}

	@Column(name = "IS_CIP")
	public Boolean getIsCip() {
		return this.isCip;
	}

	public void setIsCip(Boolean isCip) {
		this.isCip = isCip;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwRt")
	public Set<DwConsolid> getDwConsolids() {
		return this.dwConsolids;
	}

	public void setDwConsolids(Set<DwConsolid> dwConsolids) {
		this.dwConsolids = dwConsolids;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwRt")
	public Set<DwRtcic> getDwRtcics() {
		return this.dwRtcics;
	}

	public void setDwRtcics(Set<DwRtcic> dwRtcics) {
		this.dwRtcics = dwRtcics;
	}
	
	@Column(name = "ULTTEMPERATURALIDA", precision = 20, scale = 10)
	public BigDecimal getUlttemperaturalida() {
		return this.ulttemperaturalida;
	}

	public void setUlttemperaturalida(BigDecimal ulttemperaturalida) {
		this.ulttemperaturalida = ulttemperaturalida;
	}

	@Column(name = "IS_GARGALOTEORICO")
	public Boolean getIsGargaloteorico() {
		return this.isGargaloteorico;
	}

	public void setIsGargaloteorico(Boolean isGargaloteorico) {
		this.isGargaloteorico= isGargaloteorico;
	}
	@Column(name = "IS_GARGALODINAMICO")
	public Boolean getIsGargalodinamico() {
		return this.isGargalodinamico;
	}

	public void setIsGargalodinamico(Boolean isGargalodinamico) {
		this.isGargalodinamico= isGargalodinamico;
	}
	@Column(name = "IS_OFFLINE")
	public Boolean getIsOffline() {
		return this.isOffline;
	}

	public void setIsOffline(Boolean isOffline) {
		this.isOffline = isOffline;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_HEARTBEAT")
	public Date getDthrHeartbeat() {
		return this.dthrHeartbeat;
	}

	public void setDthrHeartbeat(Date dthrHeartbeat) {
		this.dthrHeartbeat = dthrHeartbeat;
	}
	
	
	/**
	 * Guarda a data/hora do último evento processado pela consolidação no {@code DwRt}
	 * @return
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_EVENTO")
	public Date getDthrEvento() {
		return this.dthrEvento;
	}

	public void setDthrEvento(Date dthrEvento) {
		this.dthrEvento = dthrEvento;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_CADASTRO")
	public Date getDthrCadastro() {
		return this.dthrCadastro;
	}

	public void setDthrCadastro(Date valor) {
		this.dthrCadastro = valor;
	}
}
