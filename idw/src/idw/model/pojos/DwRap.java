package idw.model.pojos;
//default package
//Generated 18/08/2011 14:08:40 by Hibernate Tools 3.4.0.CR1

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

import idw.model.pojos.template.DwRapTemplate;

/**
* DwRap generated by hbm2java
*/
@SuppressWarnings("serial")
@Entity
@Table(name = "DW_RAP")
public class DwRap extends DwRapTemplate implements java.io.Serializable {

	private Long idRap;
	private DwRap dwRap;
	private BigDecimal tpRap;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdRap;
	private Long revisao;
	private Date dtStativo;
	private Date dtRevisao;
	private Byte stAtivo;
	private String dsRap;
	private BigDecimal qtTotal;
	private BigDecimal qtAlocada;
	private String depara;
	private BigDecimal segTempoliberacao;
	
	private Integer qtCiclosEntreManutencao;
	private Integer qtAutoCiclosTotais;
	private Integer qtAutoCiclosDesdeultimaManutencao;
	
	private PpCliente ppCliente;
	private DwEstlocal dwEstlocal;
	private DwTprap dwTprap;
	
	private OmCc omCc;
	private OmGt omGt;
	private String proprietario;
	private String origem;
	private String versao;
	private String justificativaversao;
	private Date dtFabricacao;
	
	private Set<DwRappro> dwRappros = new HashSet<DwRappro>();
	private Set<PpIndispRappt> ppIndispRappts = new HashSet<PpIndispRappt>(0);
	private Set<DwFolharap> dwFolharaps = new HashSet<DwFolharap>(0);
	private Set<DwRapGrupo> dwRapGrupos = new HashSet<DwRapGrupo>(0);
	private Set<DwRap> dwRaps = new HashSet<DwRap>(0);

	public DwRap() {
	}

	public DwRap(Long idRap) {
		this.idRap = idRap;
	}

	public DwRap(Long idRap, DwRap dwRap, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdRap, Long revisao,
			Date dtStativo, Date dtRevisao, Byte stAtivo, String dsRap,
			BigDecimal qtTotal, BigDecimal qtAlocada, String depara,
			BigDecimal segTempoliberacao, Set<PpIndispRappt> ppIndispRappts,
			Set<DwFolharap> dwFolharaps, Set<DwRap> dwRaps) {
		this.idRap = idRap;
		this.dwRap = dwRap;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.cdRap = cdRap;
		this.revisao = revisao;
		this.dtStativo = dtStativo;
		this.dtRevisao = dtRevisao;
		this.stAtivo = stAtivo;
		this.dsRap = dsRap;
		this.qtTotal = qtTotal;
		this.qtAlocada = qtAlocada;
		this.depara = depara;
		this.segTempoliberacao = segTempoliberacao;
		this.ppIndispRappts = ppIndispRappts;
		this.dwFolharaps = dwFolharaps;
		this.dwRaps = dwRaps;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_RAP_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_RAP_SEQ", sequenceName = "DW_RAP_SEQ")
	@Column(name = "ID_RAP", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdRap() {
		return this.idRap;
	}

	public void setIdRap(Long idRap) {
		this.idRap = idRap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RAPTIPO")
	public DwRap getDwRap() {
		return this.dwRap;
	}

	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}

	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRSTATIVO")
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	@Override
	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}

	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRREVISAO")
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	@Override
	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Column(name = "CD_RAP", length = 30)
	public String getCdRap() {
		return this.cdRap;
	}

	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
	}

	@Override
	@Column(name = "REVISAO", precision = 63, scale = 0)
	public Long getRevisao() {
		return this.revisao;
	}

	@Override
	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_STATIVO", length = 10)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	@Override
	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_REVISAO", length = 10)
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	@Override
	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Override
	@Column(name = "ST_ATIVO")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	@Override
	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Column(name = "DS_RAP", length = 100)
	public String getDsRap() {
		return this.dsRap;
	}

	public void setDsRap(String dsRap) {
		this.dsRap = dsRap;
	}

	@Column(name = "QT_TOTAL", precision = 22, scale = 0)
	public BigDecimal getQtTotal() {
		return this.qtTotal;
	}

	public void setQtTotal(BigDecimal qtTotal) {
		this.qtTotal = qtTotal;
	}

	@Column(name = "QT_ALOCADA", precision = 22, scale = 0)
	public BigDecimal getQtAlocada() {
		return this.qtAlocada;
	}

	public void setQtAlocada(BigDecimal qtAlocada) {
		this.qtAlocada = qtAlocada;
	}

	@Column(name = "DEPARA", length = 100)
	public String getDepara() {
		return this.depara;
	}

	public void setDepara(String depara) {
		this.depara = depara;
	}

	@Column(name = "SEG_TEMPOLIBERACAO", precision = 20, scale = 10)
	public BigDecimal getSegTempoliberacao() {
		return this.segTempoliberacao;
	}

	public void setSegTempoliberacao(BigDecimal segTempoliberacao) {
		this.segTempoliberacao = segTempoliberacao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwRap")
	public Set<PpIndispRappt> getPpIndispRappts() {
		return this.ppIndispRappts;
	}

	public void setPpIndispRappts(Set<PpIndispRappt> ppIndispRappts) {
		this.ppIndispRappts = ppIndispRappts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwRap")
	public Set<DwFolharap> getDwFolharaps() {
		return this.dwFolharaps;
	}

	public void setDwFolharaps(Set<DwFolharap> dwFolharaps) {
		this.dwFolharaps = dwFolharaps;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dwRap")
	public Set<DwRapGrupo> getDwRapGrupos() {
		return this.dwRapGrupos;
	}

	public void setDwRapGrupos(Set<DwRapGrupo> dwRapGrupos) {
		this.dwRapGrupos = dwRapGrupos;
	}

	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY, mappedBy = "dwRap")
	public Set<DwRap> getDwRaps() {
		return this.dwRaps;
	}

	public void setDwRaps(Set<DwRap> dwRaps) {
		this.dwRaps = dwRaps;
	}
	
	
	@Column(name = "TP_RAP")
	public BigDecimal getTpRap() {
		return tpRap;
	}
	
	public void setTpRap(BigDecimal tpRap) {
		this.tpRap = tpRap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE")
	public PpCliente getPpCliente() {
		return this.ppCliente;
	}

	public void setPpCliente(PpCliente ppCliente) {
		this.ppCliente = ppCliente;
	}

	@Column(name = "QT_CICLOS_ENTRE_MANUTENCAO")
	public Integer getQtCiclosEntreManutencao() {
		return qtCiclosEntreManutencao;
	}

	public void setQtCiclosEntreManutencao(Integer qtCiclosEntreManutencao) {
		this.qtCiclosEntreManutencao = qtCiclosEntreManutencao;
	}

	@Column(name = "QT_AUTO_CICLOS_TOTAIS")
	public Integer getQtAutoCiclosTotais() {
		return qtAutoCiclosTotais;
	}

	public void setQtAutoCiclosTotais(Integer qtAutoCiclosTotais) {
		this.qtAutoCiclosTotais = qtAutoCiclosTotais;
	}

	@Column(name = "QT_AUTO_CICLOS_DESDEULT_MANUT")
	public Integer getQtAutoCiclosDesdeultimaManutencao() {
		return qtAutoCiclosDesdeultimaManutencao;
	}

	public void setQtAutoCiclosDesdeultimaManutencao(Integer qtAutoCiclosDesdeultimaManutencao) {
		this.qtAutoCiclosDesdeultimaManutencao = qtAutoCiclosDesdeultimaManutencao;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estlocal")
	public DwEstlocal getDwEstlocal() {
		return this.dwEstlocal;
	}

	public void setDwEstlocal(DwEstlocal dwEstlocal) {
		this.dwEstlocal = dwEstlocal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tprap")
	public DwTprap getDwTprap() {
		return dwTprap;
	}

	public void setDwTprap(DwTprap dwTprap) {
		this.dwTprap = dwTprap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cc")
	public OmCc getOmCc() {
		return omCc;
	}

	public void setOmCc(OmCc omCc) {
		this.omCc = omCc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gt")
	public OmGt getOmGt() {
		return omGt;
	}

	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}

	@Column(name = "PROPRIETARIO", length = 100)
	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	@Column(name = "ORIGEM", length = 100)
	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	@Column(name = "VERSAO", length = 60)
	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	@Column(name = "JUSTIFICATIVAVERSAO", length = 256)
	public String getJustificativaversao() {
		return justificativaversao;
	}

	public void setJustificativaversao(String justificativaversao) {
		this.justificativaversao = justificativaversao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_FABRICACAO", length = 10)
	public Date getDtFabricacao() {
		return dtFabricacao;
	}

	public void setDtFabricacao(Date dtFabricacao) {
		this.dtFabricacao = dtFabricacao;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dwRap")
	public Set<DwRappro> getDwRappros() {
		return dwRappros;
	}

	public void setDwRappros(Set<DwRappro> dwRappros) {
		this.dwRappros = dwRappros;
	}
}
