package idw.model.pojos;

import java.io.Serializable;
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

import idw.model.pojos.template.OmProdutoTemplate;

@SuppressWarnings("serial")
@Entity
@Table(name = "om_produto")
public class OmProduto extends OmProdutoTemplate implements Serializable {

	private long idProduto;
	private OmFor omFor;
	private PpCliente ppCliente;
	private OmProgrp omProgrp;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private DwEst dwEst;
	private OmCc omCc;
	private OmProduto omProdutoByIdProdutoagru;
	private String cdProduto;
	private Long revisao;
	private String dsProduto;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;
	private Byte tpProduto;
	private Byte tpSemiacabado;
	private Byte tpClasseabc;
	private BigDecimal minValposalim;
	private String dsComplemento;
	private String depara;
	private BigDecimal gPesoLiquido;
	private BigDecimal gPesoBruto;
	private BigDecimal hrLeadtimeentrada;
	private BigDecimal hrLeadtimesaida;
	private BigDecimal tpProducao;
	private BigDecimal indPerdaproducao;
	private BigDecimal indDefeito; // indice de defeito maximo de defeito para o produto
	private String dsCurta;
	private OmUnidmedida omUnidmedida;
	private Integer tpOrigem;
	private BigDecimal vlCustounit;
	private BigDecimal qtLoteminprod;
	private Boolean isConsumido;
	private Boolean isRastreabilidade;
	private Boolean isRequerroteiro;
	private Boolean isDat;
	private String cdSap;
	private String cdCaixa;
	private Integer qtEmpilhamento;
	private String cdModelo;
	private String cdPartnumber;

	private Set<PpCpproduto> ppCpprodutos = new HashSet<PpCpproduto>(0);
	private Set<DwExpcvs> dwExpcvses = new HashSet<DwExpcvs>(0);
	private Set<DwFolharapcom> dwFolharapcoms = new HashSet<DwFolharapcom>(0);
	private Set<OmPrg> omPrgs = new HashSet<OmPrg>(0);
	private Set<OmGarpro> omGarpros = new HashSet<OmGarpro>(0);
	private Set<PpCmcom> ppCmcomsForIdProdutoentra = new HashSet<PpCmcom>(0);
	private Set<PpCmcom> ppCmcomsForIdProdutosai = new HashSet<PpCmcom>(0);
	private Set<PpCmcom> ppCmcomsForFinal = new HashSet<PpCmcom>(0);
	private Set<PpNec> ppNecs = new HashSet<PpNec>(0);
	private Set<DwTDefeito> dwTDefeitos = new HashSet<DwTDefeito>(0);
	private Set<OmProduto> omProdutos = new HashSet<OmProduto>(0);
	private Set<OmProcomest> omProcomestsForIdProdutomp = new HashSet<OmProcomest>(0);
	private Set<OmProcomest> omProcomestsForIdProduto = new HashSet<OmProcomest>(0);
	private Set<OmProturno> omProturnos = new HashSet<OmProturno>(0);
	private Set<DwNserie> dwNseries = new HashSet<DwNserie>(0);
	private Set<DwFolhateste> dwFolhatestes = new HashSet<DwFolhateste>(0);
	private Set<OmPrgpos> omPrgposes = new HashSet<OmPrgpos>(0);
	private Set<DwPassmon> dwPassmons = new HashSet<DwPassmon>(0);
	private Set<OmProaltglo> omProaltglosForIdProdutoFilho = new HashSet<OmProaltglo>(0);
	private Set<OmProaltglo> omProaltglosForIdProdutoMae = new HashSet<OmProaltglo>(0);
	private Set<DwRota> dwRotas = new HashSet<DwRota>(0);
	private Set<DwConsolpr> dwConsolprs = new HashSet<DwConsolpr>(0);
	private Set<DwFolhamoncomp> dwFolhamoncomps = new HashSet<DwFolhamoncomp>(0);
	private Set<OmMapa> omMapas = new HashSet<OmMapa>(0);
	private Set<OmMapapa> omMapapas = new HashSet<OmMapapa>(0);
	private Set<OmCfg> omCfgs = new HashSet<OmCfg>(0);
	private Set<DwFolhamon> dwFolhamons = new HashSet<DwFolhamon>(0);
	private Set<DwFtSub> dwFtSubs = new HashSet<DwFtSub>(0);
	private Set<DwPasscau> dwPasscaus = new HashSet<DwPasscau>(0);
	private Set<DwFolhaiac> dwFolhaiacs = new HashSet<DwFolhaiac>(0);
	private Set<DwEstpro> dwEstpros = new HashSet<DwEstpro>(0);
	private Set<OmPropaihomo> omPropaihomosForIdProdutopai = new HashSet<OmPropaihomo>(0);
	private Set<OmPropaihomo> omPropaihomosForIdProduto = new HashSet<OmPropaihomo>(0);
	private Set<OmProrange> omProrange = new HashSet<OmProrange>();

	private Set<DwProdutoconjugado> dwProdutoconjugadosForIdProdutopai = new HashSet<DwProdutoconjugado>(0);
	private Set<DwProdutoconjugado> dwProdutoconjugadosForIdProdutofilho = new HashSet<DwProdutoconjugado>(0);
	private Set<OmPapro> omPapros = new HashSet<OmPapro>(0);

	private Set<IpBalanceamento> ipBalanceamentosForIdProdutosemiacabado = new HashSet<IpBalanceamento>(0);
	private Set<IpBalanceamento> ipBalanceamentosForIdProdutoacabado = new HashSet<IpBalanceamento>(0);
	private Set<DwOperacao> dwOperacaosForIdProdutoacabado = new HashSet<DwOperacao>(0);
	private Set<DwOperacao> dwOperacaosForIdProdutosemiacabado = new HashSet<DwOperacao>(0);
	private Set<DwOperacaocomp> dwOperacaocomps = new HashSet<DwOperacaocomp>(0);

	private Set<OmPromidia> omPromidias = new HashSet<OmPromidia>(0);

	public OmProduto() {
	}

	public OmProduto(long idProduto, OmUsr omUsrByIdUsrstativo,
			OmProgrp omProgrp, OmUsr omUsrByIdUsrrevisao, OmCc omCc) {
		this.idProduto = idProduto;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omProgrp = omProgrp;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.omCc = omCc;
	}

	public OmProduto(long idProduto, OmFor omFor, OmUsr omUsrByIdUsrstativo,
			OmProgrp omProgrp, OmUsr omUsrByIdUsrrevisao, OmCc omCc,
			String cdProduto, Long revisao, String dsProduto, Date dtRevisao,
			Date dtStativo, Byte stAtivo, Byte tpProduto, BigDecimal minValposalim,
			String dsComplemento, String depara, BigDecimal gPesoLiquido, BigDecimal gPesoBruto,
			OmUnidmedida omUnidmedida, Integer tpOrigem, BigDecimal vlCustounit, BigDecimal qtLoteminprod,
			Set<DwNserie> dwNseries,
			Set<DwFolhateste> dwFolhatestes, Set<OmPrgpos> omPrgposes,
			Set<DwPassmon> dwPassmons,
			Set<OmProaltglo> omProaltglosForIdProdutoFilho,
			Set<OmProaltglo> omProaltglosForIdProdutoMae, Set<DwRota> dwRotas,
			Set<DwConsolpr> dwConsolprs, Set<DwFolhamoncomp> dwFolhamoncomps,
			Set<OmMapapa> omMapapas, Set<OmCfg> omCfgs, Set<OmMapa> omMapas,
			Set<DwFolhamon> dwFolhamons, Set<DwFtSub> dwFtSubs) {
		this.idProduto = idProduto;
		this.omFor = omFor;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omProgrp = omProgrp;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.omCc = omCc;
		this.cdProduto = cdProduto;
		this.revisao = revisao;
		this.dsProduto = dsProduto;
		this.dtRevisao = dtRevisao;
		this.dtStativo = dtStativo;
		this.stAtivo = stAtivo;
		this.tpProduto = tpProduto;
		this.minValposalim = minValposalim;
		this.dsComplemento = dsComplemento;
		this.depara = depara;
		this.dwNseries = dwNseries;
		this.dwFolhatestes = dwFolhatestes;
		this.omPrgposes = omPrgposes;
		this.dwPassmons = dwPassmons;
		this.omProaltglosForIdProdutoFilho = omProaltglosForIdProdutoFilho;
		this.omProaltglosForIdProdutoMae = omProaltglosForIdProdutoMae;
		this.dwRotas = dwRotas;
		this.dwConsolprs = dwConsolprs;
		this.dwFolhamoncomps = dwFolhamoncomps;
		this.omMapapas = omMapapas;
		this.omCfgs = omCfgs;
		this.omMapas = omMapas;
		this.dwFolhamons = dwFolhamons;
		this.dwFtSubs = dwFtSubs;
		this.gPesoBruto = gPesoBruto;
		this.omUnidmedida = omUnidmedida;
		this.tpOrigem = tpOrigem;
		this.vlCustounit = vlCustounit;
		this.qtLoteminprod = qtLoteminprod;
		this.gPesoLiquido = gPesoLiquido;
	}


	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_PRODUTO_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_PRODUTO_SEQ", sequenceName = "OM_PRODUTO_SEQ")
	@Column(name = "id_produto", unique = true, nullable = false)
	public long getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_for")
	public OmFor getOmFor() {
		return this.omFor;
	}

	public void setOmFor(OmFor omFor) {
		this.omFor = omFor;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_progrp", nullable = true)
	public OmProgrp getOmProgrp() {
		return this.omProgrp;
	}

	public void setOmProgrp(OmProgrp omProgrp) {
		this.omProgrp = omProgrp;
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
	@JoinColumn(name = "ID_EST")
	public DwEst getDwEst() {
		return this.dwEst;
	}

	public void setDwEst(DwEst dwEst) {
		this.dwEst = dwEst;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PRODUTOAGRU")
	public OmProduto getOmProdutoByIdProdutoagru() {
		return this.omProdutoByIdProdutoagru;
	}

	public void setOmProdutoByIdProdutoagru(OmProduto omProdutoByIdProdutoagru) {
		this.omProdutoByIdProdutoagru = omProdutoByIdProdutoagru;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cc", nullable = true)
	public OmCc getOmCc() {
		return this.omCc;
	}

	public void setOmCc(OmCc omCc) {
		this.omCc = omCc;
	}

	@Column(name = "cd_produto", length = 60)
	public String getCdProduto() {
		return this.cdProduto;
	}

	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
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

	@Column(name = "ds_produto", length = 256)
	public String getDsProduto() {
		return this.dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
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

	@Column(name = "tp_produto")
	public Byte getTpProduto() {
		return this.tpProduto;
	}

	public void setTpProduto(Byte tpProduto) {
		this.tpProduto = tpProduto;
	}
	@Column(name = "tp_semiacabado")
	public Byte getTpSemiacabado() {
		return this.tpSemiacabado;
	}

	public void setTpSemiacabado(Byte tpSemiacabado) {
		this.tpSemiacabado = tpSemiacabado;
	}

	@Column(name = "min_valposalim", precision = 8, scale = 4)
	public BigDecimal getMinValposalim() {
		return this.minValposalim;
	}

	public void setMinValposalim(BigDecimal minValposalim) {
		this.minValposalim = minValposalim;
	}

	@Column(name = "ds_complemento", length = 100)
	public String getDsComplemento() {
		return this.dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	@Column(name = "depara", length = 256)
	public String getDepara() {
		return this.depara;
	}

	public void setDepara(String depara) {
		this.depara = depara;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwNserie> getDwNseries() {
		return this.dwNseries;
	}

	public void setDwNseries(Set<DwNserie> dwNseries) {
		this.dwNseries = dwNseries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwFolhateste> getDwFolhatestes() {
		return this.dwFolhatestes;
	}

	public void setDwFolhatestes(Set<DwFolhateste> dwFolhatestes) {
		this.dwFolhatestes = dwFolhatestes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<OmPrgpos> getOmPrgposes() {
		return this.omPrgposes;
	}

	public void setOmPrgposes(Set<OmPrgpos> omPrgposes) {
		this.omPrgposes = omPrgposes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwPassmon> getDwPassmons() {
		return this.dwPassmons;
	}

	public void setDwPassmons(Set<DwPassmon> dwPassmons) {
		this.dwPassmons = dwPassmons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutoFilho")
	public Set<OmProaltglo> getOmProaltglosForIdProdutoFilho() {
		return this.omProaltglosForIdProdutoFilho;
	}

	public void setOmProaltglosForIdProdutoFilho(
			Set<OmProaltglo> omProaltglosForIdProdutoFilho) {
		this.omProaltglosForIdProdutoFilho = omProaltglosForIdProdutoFilho;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutoMae")
	public Set<OmProaltglo> getOmProaltglosForIdProdutoMae() {
		return this.omProaltglosForIdProdutoMae;
	}

	public void setOmProaltglosForIdProdutoMae(
			Set<OmProaltglo> omProaltglosForIdProdutoMae) {
		this.omProaltglosForIdProdutoMae = omProaltglosForIdProdutoMae;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwRota> getDwRotas() {
		return this.dwRotas;
	}

	public void setDwRotas(Set<DwRota> dwRotas) {
		this.dwRotas = dwRotas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwConsolpr> getDwConsolprs() {
		return this.dwConsolprs;
	}

	public void setDwConsolprs(Set<DwConsolpr> dwConsolprs) {
		this.dwConsolprs = dwConsolprs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwFolhamoncomp> getDwFolhamoncomps() {
		return this.dwFolhamoncomps;
	}

	public void setDwFolhamoncomps(Set<DwFolhamoncomp> dwFolhamoncomps) {
		this.dwFolhamoncomps = dwFolhamoncomps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<OmMapapa> getOmMapapas() {
		return this.omMapapas;
	}

	public void setOmMapapas(Set<OmMapapa> omMapapas) {
		this.omMapapas = omMapapas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<OmCfg> getOmCfgs() {
		return this.omCfgs;
	}

	public void setOmCfgs(Set<OmCfg> omCfgs) {
		this.omCfgs = omCfgs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<OmMapa> getOmMapas() {
		return this.omMapas;
	}

	public void setOmMapas(Set<OmMapa> omMapas) {
		this.omMapas = omMapas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwFolhamon> getDwFolhamons() {
		return this.dwFolhamons;
	}

	public void setDwFolhamons(Set<DwFolhamon> dwFolhamons) {
		this.dwFolhamons = dwFolhamons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwFtSub> getDwFtSubs() {
		return this.dwFtSubs;
	}

	public void setDwFtSubs(Set<DwFtSub> dwFtSubs) {
		this.dwFtSubs = dwFtSubs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwPasscau> getDwPasscaus() {
		return this.dwPasscaus;
	}

	public void setDwPasscaus(Set<DwPasscau> dwPasscaus) {
		this.dwPasscaus = dwPasscaus;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProduto")
	public Set<OmProcomest> getOmProcomestsForIdProduto() {
		return this.omProcomestsForIdProduto;
	}

	public void setOmProcomestsForIdProduto(
			Set<OmProcomest> omProcomestsForIdProduto) {
		this.omProcomestsForIdProduto = omProcomestsForIdProduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE")
	public PpCliente getPpCliente() {
		return this.ppCliente;
	}

	public void setPpCliente(PpCliente ppCliente) {
		this.ppCliente = ppCliente;
	}


	@Column(name = "HR_LEADTIMEENTRADA", precision = 22, scale = 0)
	public BigDecimal getHrLeadtimeentrada() {
		return this.hrLeadtimeentrada;
	}

	public void setHrLeadtimeentrada(BigDecimal hrLeadtimeentrada) {
		this.hrLeadtimeentrada = hrLeadtimeentrada;
	}

	@Column(name = "HR_LEADTIMESAIDA", precision = 22, scale = 0)
	public BigDecimal getHrLeadtimesaida() {
		return this.hrLeadtimesaida;
	}

	public void setHrLeadtimesaida(BigDecimal hrLeadtimesaida) {
		this.hrLeadtimesaida = hrLeadtimesaida;
	}

	@Column(name = "TP_PRODUCAO", precision = 22, scale = 0)
	public BigDecimal getTpProducao() {
		return this.tpProducao;
	}

	public void setTpProducao(BigDecimal tpProducao) {
		this.tpProducao = tpProducao;
	}

	@Column(name = "IND_PERDAPRODUCAO", precision = 14, scale = 4)
	public BigDecimal getIndPerdaproducao() {
		return this.indPerdaproducao;
	}

	public void setIndPerdaproducao(BigDecimal indPerdaproducao) {
		this.indPerdaproducao = indPerdaproducao;
	}


	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<OmProturno> getOmProturnos() {
		return this.omProturnos;
	}

	public void setOmProturnos(Set<OmProturno> omProturnos) {
		this.omProturnos = omProturnos;
	}

	@Column(name = "DS_CURTA", length = 10)
	public String getDsCurta() {
		return this.dsCurta;
	}

	public void setDsCurta(String dsCurta) {
		this.dsCurta = dsCurta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unidmedida")
	public OmUnidmedida getOmUnidmedida() {
		return this.omUnidmedida;
	}

	public void setOmUnidmedida(OmUnidmedida omUnidmedida) {
		this.omUnidmedida = omUnidmedida;
	}

	@Column(name = "tp_origem")
	public Integer getTpOrigem() {
		return this.tpOrigem;
	}

	public void setTpOrigem(Integer tpOrigem) {
		this.tpOrigem = tpOrigem;
	}

	@Column(name = "vl_custounit", precision = 20, scale = 10)
	public BigDecimal getVlCustounit() {
		return this.vlCustounit;
	}

	public void setVlCustounit(BigDecimal vlCustounit) {
		this.vlCustounit = vlCustounit;
	}

	@Column(name = "qt_loteminprod", precision = 14, scale = 4)
	public BigDecimal getQtLoteminprod() {
		return this.qtLoteminprod;
	}

	public void setQtLoteminprod(BigDecimal qtLoteminprod) {
		this.qtLoteminprod = qtLoteminprod;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<PpCpproduto> getPpCpprodutos() {
		return this.ppCpprodutos;
	}

	public void setPpCpprodutos(Set<PpCpproduto> ppCpprodutos) {
		this.ppCpprodutos = ppCpprodutos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwExpcvs> getDwExpcvses() {
		return this.dwExpcvses;
	}

	public void setDwExpcvses(Set<DwExpcvs> dwExpcvses) {
		this.dwExpcvses = dwExpcvses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwFolharapcom> getDwFolharapcoms() {
		return this.dwFolharapcoms;
	}

	public void setDwFolharapcoms(Set<DwFolharapcom> dwFolharapcoms) {
		this.dwFolharapcoms = dwFolharapcoms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<OmPrg> getOmPrgs() {
		return this.omPrgs;
	}

	public void setOmPrgs(Set<OmPrg> omPrgs) {
		this.omPrgs = omPrgs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<OmGarpro> getOmGarpros() {
		return this.omGarpros;
	}

	public void setOmGarpros(Set<OmGarpro> omGarpros) {
		this.omGarpros = omGarpros;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutoentra")
	public Set<PpCmcom> getPpCmcomsForIdProdutoentra() {
		return this.ppCmcomsForIdProdutoentra;
	}

	public void setPpCmcomsForIdProdutoentra(
			Set<PpCmcom> ppCmcomsForIdProdutoentra) {
		this.ppCmcomsForIdProdutoentra = ppCmcomsForIdProdutoentra;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<PpNec> getPpNecs() {
		return this.ppNecs;
	}

	public void setPpNecs(Set<PpNec> ppNecs) {
		this.ppNecs = ppNecs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutomp")
	public Set<OmProcomest> getOmProcomestsForIdProdutomp() {
		return this.omProcomestsForIdProdutomp;
	}

	public void setOmProcomestsForIdProdutomp(
			Set<OmProcomest> omProcomestsForIdProdutomp) {
		this.omProcomestsForIdProdutomp = omProcomestsForIdProdutomp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwTDefeito> getDwTDefeitos() {
		return this.dwTDefeitos;
	}

	public void setDwTDefeitos(Set<DwTDefeito> dwTDefeitos) {
		this.dwTDefeitos = dwTDefeitos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutosai")
	public Set<PpCmcom> getPpCmcomsForIdProdutosai() {
		return this.ppCmcomsForIdProdutosai;
	}

	public void setPpCmcomsForIdProdutosai(Set<PpCmcom> ppCmcomsForIdProdutosai) {
		this.ppCmcomsForIdProdutosai = ppCmcomsForIdProdutosai;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByFinal")
	public Set<PpCmcom> getPpCmcomsForFinal() {
		return this.ppCmcomsForFinal;
	}

	public void setPpCmcomsForFinal(Set<PpCmcom> ppCmcomsForIdProduto) {
		this.ppCmcomsForFinal = ppCmcomsForIdProduto;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutoagru")
	public Set<OmProduto> getOmProdutos() {
		return this.omProdutos;
	}

	public void setOmProdutos(Set<OmProduto> omProdutos) {
		this.omProdutos = omProdutos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwFolhaiac> getDwFolhaiacs() {
		return this.dwFolhaiacs;
	}

	public void setDwFolhaiacs(Set<DwFolhaiac> dwFolhaiacs) {
		this.dwFolhaiacs = dwFolhaiacs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwEstpro> getDwEstpros() {
		return this.dwEstpros;
	}

	public void setDwEstpros(Set<DwEstpro> dwEstpros) {
		this.dwEstpros = dwEstpros;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutopai")
	public Set<OmPropaihomo> getOmPropaihomosForIdProdutopai() {
		return this.omPropaihomosForIdProdutopai;
	}

	public void setOmPropaihomosForIdProdutopai(
			Set<OmPropaihomo> omPropaihomosForIdProdutopai) {
		this.omPropaihomosForIdProdutopai = omPropaihomosForIdProdutopai;
	}

	@Column(name = "G_PESO_BRUTO", precision = 20, scale = 3)
	public BigDecimal getGPesoBruto() {
		return this.gPesoBruto;
	}

	public void setGPesoBruto(BigDecimal GPesoBruto) {
		this.gPesoBruto = GPesoBruto;
	}

	@Column(name = "G_PESO_LIQUIDO", precision = 20, scale = 3)
	public BigDecimal getGPesoLiquido() {
		return this.gPesoLiquido;
	}

	public void setGPesoLiquido(BigDecimal gPesoLiquido) {
		this.gPesoLiquido = gPesoLiquido;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProduto")
	public Set<OmPropaihomo> getOmPropaihomosForIdProduto() {
		return this.omPropaihomosForIdProduto;
	}

	public void setOmPropaihomosForIdProduto(
			Set<OmPropaihomo> omPropaihomosForIdProduto) {
		this.omPropaihomosForIdProduto = omPropaihomosForIdProduto;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutofilho")
	public Set<DwProdutoconjugado> getDwProdutoconjugadosForIdProdutofilho() {
		return this.dwProdutoconjugadosForIdProdutofilho;
	}

	public void setDwProdutoconjugadosForIdProdutofilho(
			Set<DwProdutoconjugado> dwProdutoconjugadosForIdProdutofilho) {
		this.dwProdutoconjugadosForIdProdutofilho = dwProdutoconjugadosForIdProdutofilho;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutopai")
	public Set<DwProdutoconjugado> getDwProdutoconjugadosForIdProdutopai() {
		return this.dwProdutoconjugadosForIdProdutopai;
	}

	public void setDwProdutoconjugadosForIdProdutopai(
			Set<DwProdutoconjugado> dwProdutoconjugadosForIdProdutopai) {
		this.dwProdutoconjugadosForIdProdutopai = dwProdutoconjugadosForIdProdutopai;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<OmPapro> getOmPapros() {
		return this.omPapros;
	}

	public void setOmPapros(Set<OmPapro> omPapros) {
		this.omPapros = omPapros;
	}

	@Column(name = "IS_DAT")
	public Boolean getIsDat() {
		return this.isDat;
	}

	public void setIsDat(Boolean isDat) {
		this.isDat = isDat;
	}

	@Column(name = "is_consumido")
	public Boolean getIsConsumido() {
		return this.isConsumido;
	}

	public void setIsConsumido(Boolean isConsumido) {
		this.isConsumido = isConsumido;
	}
	
	

	@Column(name = "is_rastreabilidade")
	public Boolean getIsRastreabilidade() {
		return isRastreabilidade;
	}

	public void setIsRastreabilidade(Boolean isRastreabilidade) {
		this.isRastreabilidade = isRastreabilidade;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutosemiacabado")
	public Set<IpBalanceamento> getIpBalanceamentosForIdProdutosemiacabado() {
		return this.ipBalanceamentosForIdProdutosemiacabado;
	}

	public void setIpBalanceamentosForIdProdutosemiacabado(
			Set<IpBalanceamento> ipBalanceamentosForIdProdutosemiacabado) {
		this.ipBalanceamentosForIdProdutosemiacabado = ipBalanceamentosForIdProdutosemiacabado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutoacabado")
	public Set<IpBalanceamento> getIpBalanceamentosForIdProdutoacabado() {
		return this.ipBalanceamentosForIdProdutoacabado;
	}

	public void setIpBalanceamentosForIdProdutoacabado(Set<IpBalanceamento> ipBalanceamentosForIdProdutoacabado) {
		this.ipBalanceamentosForIdProdutoacabado = ipBalanceamentosForIdProdutoacabado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutoacabado")
	public Set<DwOperacao> getDwOperacaosForIdProdutoacabado() {
		return this.dwOperacaosForIdProdutoacabado;
	}

	public void setDwOperacaosForIdProdutoacabado(Set<DwOperacao> dwOperacaosForIdProdutoacabado) {
		this.dwOperacaosForIdProdutoacabado = dwOperacaosForIdProdutoacabado;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProdutoByIdProdutosemiacabado")
	public Set<DwOperacao> getDwOperacaosForIdProdutosemiacabado() {
		return this.dwOperacaosForIdProdutosemiacabado;
	}

	public void setDwOperacaosForIdProdutosemiacabado(Set<DwOperacao> dwOperacaosForIdProdutosemiacabado) {
		this.dwOperacaosForIdProdutosemiacabado = dwOperacaosForIdProdutosemiacabado;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<DwOperacaocomp> getDwOperacaocomps() {
		return this.dwOperacaocomps;
	}

	public void setDwOperacaocomps(Set<DwOperacaocomp> dwOperacaocomps) {
		this.dwOperacaocomps = dwOperacaocomps;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<OmPromidia> getOmPromidias() {
		return this.omPromidias;
	}

	public void setOmPromidias(Set<OmPromidia> omPromidias) {
		this.omPromidias = omPromidias;
	}
	@Column(name = "tp_classeabc")
	public Byte getTpClasseabc() {
		return this.tpClasseabc;
	}

	public void setTpClasseabc(Byte tpClasseabc) {
		this.tpClasseabc = tpClasseabc;
	}

	@Column(name = "cd_sap")
	public String getCdSap() {
		return cdSap;
	}

	public void setCdSap(String cdSap) {
		this.cdSap = cdSap;
	}

	@Column(name = "cd_caixa")
	public String getCdCaixa() {
		return cdCaixa;
	}

	public void setCdCaixa(String cdCaixa) {
		this.cdCaixa = cdCaixa;
	}

	@Column(name = "qt_empilhamento")
	public Integer getQtEmpilhamento() {
		return qtEmpilhamento;
	}

	public void setQtEmpilhamento(Integer qtEmpilhamento) {
		this.qtEmpilhamento = qtEmpilhamento;
	}

	@Column(name = "cd_modelo")
	public String getCdModelo() {
		return cdModelo;
	}

	public void setCdModelo(String cdModelo) {
		this.cdModelo = cdModelo;
	}

	@Column(name = "cd_partnumber")
	public String getCdPartnumber() {
		return cdPartnumber;
	}

	public void setCdPartnumber(String cdPartnumber) {
		this.cdPartnumber = cdPartnumber;
	}

	@Column(name = "IND_DEFEITO", precision = 14, scale = 4)
	public BigDecimal getIndDefeito() {
		return indDefeito;
	}

	public void setIndDefeito(BigDecimal indDefeito) {
		this.indDefeito = indDefeito;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProduto")
	public Set<OmProrange> getOmProrange() {
		return omProrange;
	}

	public void setOmProrange(Set<OmProrange> omProrange) {
		this.omProrange = omProrange;
	}

	@Column(name = "is_requerroteiro")
	public Boolean getIsRequerroteiro() {
		return isRequerroteiro;
	}

	public void setIsRequerroteiro(Boolean isRequerroteiro) {
		this.isRequerroteiro = isRequerroteiro;
	}


}
