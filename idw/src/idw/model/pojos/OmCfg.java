package idw.model.pojos;

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

import idw.model.pojos.template.OmCfgTemplate;

@Entity
@Table(name = "OM_CFG")
public class OmCfg extends OmCfgTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idCfg;
	private OmUsr omUsrimpprog;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private DwCal dwCal;
	private OmCfgabc omCfgabc;
	private OmTppt omTpptByIdTpptinsersora;
	private OmTpgt omTpgtByIdTpgtlogsuper;
	private DwEst dwEstByIdEstliberado;
	private OmEmpresa omEmpresa;
	private DwRap dwRap;
	private DwEst dwEstByIdEstexpedicao;
	private DwEst dwEstByIdEstrefugo;
	private DwEst dwEstByIdEstproducao;
	private DwTRitmo dwTRitmo;

	private DwFtParam dwFtParamByIdFtParamfluxoe;
	private DwFtParam dwFtParamByIdFtParamTemp;
	private DwFtParam dwFtParamByIdFtParamfp;
	private DwFtParam dwFtParamByIdFtParamec;
	private DwPepro dwPeproByIdPepronormal;
	private OmTpgt omTpgtByIdTpgtfabrica;
	private DwPepro dwPeproByIdPeproctreproc;
	private OmUsrgrp omUsrgrpByIdUsrgrpsupervisor;
	private OmTppt omTpptByIdTpptptscd;
	private OmTppt omTpptByIdTpptptf;
	private DwFtParam dwFtParamByIdFtParamcorrente;
	private DwFtParam dwFtParamByIdFtParamtensao;
	private OmProduto omProduto;
	private OmTppt omTpptByIdTpptpm;
	private OmCc omCcDefault;
	private OmAlgocor omAlgocor;
	private OmResgui omResgui;
	private OmUsrgrp omUsrgrpByIdUsrgrpoperador;
	private OmUsrgrp omUsrgrpByIdUsrgrptecnico;
	private OmUsrgrp omUsrgrpByIdUsrgrpmonitor;
	private OmTppt omTpptByIdTpptppass;
	private OmTppt omTpptByIdTpptprepro;
	private OmTppt omTpptByIdTpptpts;
	private DwFtParam dwFtParamByIdFtParamflusos;
	private Boolean isNivelfeeder;
	private Boolean isIhmtrocaop;
	private Boolean isImpMapaQtUnica;
	private Long revisao;
	private Byte stAtivo;
	private BigDecimal segFeedbacklogin;
	private BigDecimal segAutologout;
	private BigDecimal qtMaxptcoletafull;
	private BigDecimal qtMaxetapateste;
	private BigDecimal qtMaxsubetapas;
	private BigDecimal segHeartbeat;
	private Boolean isLogonobrigatorio;
	private DwTParada dwTParada;
	private DwTParada dwTParadasemconexao;
	private DwTRefugo dwTRefugo;
	private OmRegrasNscb omRegrasNscbByIdRegrasNs;
	private OmRegrasNscb omRegrasNscbByIdRegrasCb;
	private Set<OmCfgscrpimp> omCfgscrpimps = new HashSet<OmCfgscrpimp>(0);
	private Set<OmCfgptdetcoleta> omCfgptdetcoletas = new HashSet<OmCfgptdetcoleta>(0);
	private Set<OmCfgind> omCfginds = new HashSet<OmCfgind>(0);
	private Set<OmCfgurl> omCfgurls = new HashSet<OmCfgurl>(0);

	private String dsMensagemsobretensao;
	private String dsMensagemsubtensao;
	private Date dtRevisao;
	private Date dtStativo;
	private DwEst dwEstByIdEstmp;
	private OmGt omGtimpcic;
	private DwEstlocal dwEstlocalorigalim;
	private DwEst dwEstByIdEstAlimentacao;

	private Boolean isCompensaapont;
	private Integer tpLayoutplano;
	
	private Date dthrEstliberado;
	
	private String mascaracb; // mascara para filtrar o o codigo de barras principal.Nao serve para obter nenhuma informacao especifica (op, produto, etc)
	private String mascaraQtd; // mascara para obter a quantidade de produtos
	private String mascarafolha;
	private String mascaracdprodutoCF;
	private String mascaracdprodutomp;
	private String mascaraop;

	private String mascaracdprodutoCB;

	private Boolean isProcessaiacinsert;
	private Boolean isProcessaiacidw;
	private Boolean isContacicloimprodutivoregula; //Sem uso no momento
	
	private Boolean isLogoutautomatico;
	
	private BigDecimal segLogoutautomatico;
	
	private DwTAlerta dwTAlerta;
	private DwTParada dwTParadaByIdTparadacip;
	private Boolean isRequerTecnicoInicioCip;
	private Boolean isRequerTecnicoFimCip;

	private Boolean isRitmosempreNasHrsprod;
	
	private String login;
	private String senha;
	private String emailsscriptpadraonc;
	private String emailaoi;

	
	private Integer tpWhatsapp;
	private String idWhatsapp;
	private String pwWhatsapp;
	private String telWhatsapp;
	
	public OmCfg() {
	}

	public OmCfg(long idCfg, OmUsr omUsr, DwCal dwCal,
			DwPepro dwPeproByIdPepronormal, DwPepro dwPeproByIdPeproctreproc,
			OmCc omCc) {
		this.idCfg = idCfg;
		this.omUsrimpprog = omUsr;
		this.dwCal = dwCal;
		this.dwPeproByIdPepronormal = dwPeproByIdPepronormal;
		this.dwPeproByIdPeproctreproc = dwPeproByIdPeproctreproc;
		this.omCcDefault = omCc;
	}

	public OmCfg(long idCfg, OmUsr omUsr, DwCal dwCal,
			OmTppt omTpptByIdTpptinsersora, OmTpgt omTpgtByIdTpgtlogsuper,
			DwEst dwEstByIdEstliberado, DwEst dwEstByIdEstexpedicao,
			DwFtParam dwFtParamByIdFtParamfluxoe,
			DwPepro dwPeproByIdPepronormal, OmTpgt omTpgtByIdTpgtfabrica,
			DwPepro dwPeproByIdPeproctreproc,
			OmUsrgrp omUsrgrpByIdUsrgrpsupervisor, OmTppt omTpptByIdTpptptscd,
			OmTppt omTpptByIdTpptptf, DwFtParam dwFtParamByIdFtParamcorrente,
			OmProduto omProduto, OmTppt omTpptByIdTpptpm, OmCc omCc,
			OmAlgocor omAlgocor,
			OmResgui omResgui, OmUsrgrp omUsrgrpByIdUsrgrpoperador,
			OmTppt omTpptByIdTpptppass, OmTppt omTpptByIdTpptprepro,
			OmTppt omTpptByIdTpptpts, DwFtParam dwFtParamByIdFtParamflusos,
			Boolean isNivelfeeder, BigDecimal revisao, BigDecimal stAtivo,
			BigDecimal segFeedbacklogin, BigDecimal segAutologout,
			BigDecimal qtMaxptcoletafull, BigDecimal qtMaxetapateste,
			BigDecimal segHeartbeat, String mascaracdprodutopai,
			String mascaracdprodutofilho,String mascaraQtd, Boolean isLogonobrigatorio,
			DwTParada dwTParada,
			Date dthrEstliberado,
			Set<OmCfgscrpimp> omCfgscrpimps,
			Set<OmCfgptdetcoleta> omCfgptdetcoletas) {
		this.idCfg = idCfg;
		this.omUsrimpprog = omUsr;
		this.dwCal = dwCal;
		this.omTpptByIdTpptinsersora = omTpptByIdTpptinsersora;
		this.omTpgtByIdTpgtlogsuper = omTpgtByIdTpgtlogsuper;
		this.dwEstByIdEstliberado = dwEstByIdEstliberado;
		this.dwEstByIdEstexpedicao = dwEstByIdEstexpedicao;
		this.dwFtParamByIdFtParamfluxoe = dwFtParamByIdFtParamfluxoe;
		this.dwPeproByIdPepronormal = dwPeproByIdPepronormal;
		this.omTpgtByIdTpgtfabrica = omTpgtByIdTpgtfabrica;
		this.dwPeproByIdPeproctreproc = dwPeproByIdPeproctreproc;
		this.omUsrgrpByIdUsrgrpsupervisor = omUsrgrpByIdUsrgrpsupervisor;
		this.omTpptByIdTpptptscd = omTpptByIdTpptptscd;
		this.omTpptByIdTpptptf = omTpptByIdTpptptf;
		this.dwFtParamByIdFtParamcorrente = dwFtParamByIdFtParamcorrente;
		this.omProduto = omProduto;
		this.omTpptByIdTpptpm = omTpptByIdTpptpm;		
		this.omCcDefault = omCc;
		this.omAlgocor = omAlgocor;
		this.omResgui = omResgui;
		this.omUsrgrpByIdUsrgrpoperador = omUsrgrpByIdUsrgrpoperador;
		this.omTpptByIdTpptppass = omTpptByIdTpptppass;
		this.omTpptByIdTpptprepro = omTpptByIdTpptprepro;
		this.omTpptByIdTpptpts = omTpptByIdTpptpts;
		this.dwFtParamByIdFtParamflusos = dwFtParamByIdFtParamflusos;
		this.isNivelfeeder = isNivelfeeder;
		this.segFeedbacklogin = segFeedbacklogin;
		this.segAutologout = segAutologout;
		this.qtMaxptcoletafull = qtMaxptcoletafull;
		this.qtMaxetapateste = qtMaxetapateste;
		this.segHeartbeat = segHeartbeat;
		this.mascaracdprodutoCF = mascaracdprodutopai;
		this.mascaracdprodutomp = mascaracdprodutofilho;
		this.mascaraQtd = mascaraQtd;
		this.isLogonobrigatorio = isLogonobrigatorio;
		this.omCfgscrpimps = omCfgscrpimps;
		this.omCfgptdetcoletas = omCfgptdetcoletas;		
		this.dwTParada = dwTParada;
		this.dthrEstliberado = dthrEstliberado;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_CFG_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_CFG_SEQ", sequenceName = "OM_CFG_SEQ")
	@Column(name = "ID_CFG", nullable = false)
	public long getIdCfg() {
		return this.idCfg;
	}

	public void setIdCfg(long idCfg) {
		this.idCfg = idCfg;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRIMPPROG", nullable = false)
	public OmUsr getOmUsrimpprog() {
		return this.omUsrimpprog;
	}

	public void setOmUsrimpprog(OmUsr omUsr) {
		this.omUsrimpprog = omUsr;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CAL", nullable = false)
	public DwCal getDwCal() {
		return this.dwCal;
	}

	public void setDwCal(DwCal dwCal) {
		this.dwCal = dwCal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPPTINSERSORA")
	public OmTppt getOmTpptByIdTpptinsersora() {
		return this.omTpptByIdTpptinsersora;
	}

	public void setOmTpptByIdTpptinsersora(OmTppt omTpptByIdTpptinsersora) {
		this.omTpptByIdTpptinsersora = omTpptByIdTpptinsersora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPGTLOGSUPER")
	public OmTpgt getOmTpgtByIdTpgtlogsuper() {
		return this.omTpgtByIdTpgtlogsuper;
	}

	public void setOmTpgtByIdTpgtlogsuper(OmTpgt omTpgtByIdTpgtlogsuper) {
		this.omTpgtByIdTpgtlogsuper = omTpgtByIdTpgtlogsuper;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTLIBERADO")
	public DwEst getDwEstByIdEstliberado() {
		return this.dwEstByIdEstliberado;
	}

	public void setDwEstByIdEstliberado(DwEst dwEstByIdEstliberado) {
		this.dwEstByIdEstliberado = dwEstByIdEstliberado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTEXPEDICAO")
	public DwEst getDwEstByIdEstexpedicao() {
		return this.dwEstByIdEstexpedicao;
	}

	public void setDwEstByIdEstexpedicao(DwEst dwEstByIdEstexpedicao) {
		this.dwEstByIdEstexpedicao = dwEstByIdEstexpedicao;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTREFUGO")
	public DwEst getDwEstByIdEstrefugo() {
		return this.dwEstByIdEstrefugo;
	}

	public void setDwEstByIdEstrefugo(DwEst dwEstByIdEstrefugo) {
		this.dwEstByIdEstrefugo = dwEstByIdEstrefugo;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTPRODUCAO")
	public DwEst getDwEstByIdEstproducao() {
		return this.dwEstByIdEstproducao;
	}

	public void setDwEstByIdEstproducao(DwEst dwEstByIdEstproducao) {
		this.dwEstByIdEstproducao = dwEstByIdEstproducao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FT_PARAMFLUXOE")
	public DwFtParam getDwFtParamByIdFtParamfluxoe() {
		return this.dwFtParamByIdFtParamfluxoe;
	}

	public void setDwFtParamByIdFtParamfluxoe(
			DwFtParam dwFtParamByIdFtParamfluxoe) {
		this.dwFtParamByIdFtParamfluxoe = dwFtParamByIdFtParamfluxoe;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FT_PARAMFP")
	public DwFtParam getDwFtParamByIdFtParamfp() {
		return this.dwFtParamByIdFtParamfp;
	}

	public void setDwFtParamByIdFtParamfp(
			DwFtParam dwFtParamByIdFtParamfp) {
		this.dwFtParamByIdFtParamfp = dwFtParamByIdFtParamfp;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FT_PARAMEC")
	public DwFtParam getDwFtParamByIdFtParamec() {
		return this.dwFtParamByIdFtParamec;
	}

	public void setDwFtParamByIdFtParamec(
			DwFtParam dwFtParamByIdFtParamec) {
		this.dwFtParamByIdFtParamec = dwFtParamByIdFtParamec;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ft_paramTemp")
	public DwFtParam getDwFtParamByIdFtParamTemp() {
		return this.dwFtParamByIdFtParamTemp;
	}

	public void setDwFtParamByIdFtParamTemp(DwFtParam dwFtParamByIdFtParamTemp) {
		this.dwFtParamByIdFtParamTemp = dwFtParamByIdFtParamTemp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PEPRONORMAL", nullable = false)
	public DwPepro getDwPeproByIdPepronormal() {
		return this.dwPeproByIdPepronormal;
	}

	public void setDwPeproByIdPepronormal(DwPepro dwPeproByIdPepronormal) {
		this.dwPeproByIdPepronormal = dwPeproByIdPepronormal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPGTFABRICA")
	public OmTpgt getOmTpgtByIdTpgtfabrica() {
		return this.omTpgtByIdTpgtfabrica;
	}

	public void setOmTpgtByIdTpgtfabrica(OmTpgt omTpgtByIdTpgtfabrica) {
		this.omTpgtByIdTpgtfabrica = omTpgtByIdTpgtfabrica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PEPROCTREPROC", nullable = false)
	public DwPepro getDwPeproByIdPeproctreproc() {
		return this.dwPeproByIdPeproctreproc;
	}

	public void setDwPeproByIdPeproctreproc(DwPepro dwPeproByIdPeproctreproc) {
		this.dwPeproByIdPeproctreproc = dwPeproByIdPeproctreproc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRGRPSUPERVISOR")
	public OmUsrgrp getOmUsrgrpByIdUsrgrpsupervisor() {
		return this.omUsrgrpByIdUsrgrpsupervisor;
	}

	public void setOmUsrgrpByIdUsrgrpsupervisor(
			OmUsrgrp omUsrgrpByIdUsrgrpsupervisor) {
		this.omUsrgrpByIdUsrgrpsupervisor = omUsrgrpByIdUsrgrpsupervisor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPPTPTSCD")
	public OmTppt getOmTpptByIdTpptptscd() {
		return this.omTpptByIdTpptptscd;
	}

	public void setOmTpptByIdTpptptscd(OmTppt omTpptByIdTpptptscd) {
		this.omTpptByIdTpptptscd = omTpptByIdTpptptscd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPPTPTF")
	public OmTppt getOmTpptByIdTpptptf() {
		return this.omTpptByIdTpptptf;
	}

	public void setOmTpptByIdTpptptf(OmTppt omTpptByIdTpptptf) {
		this.omTpptByIdTpptptf = omTpptByIdTpptptf;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FT_PARAMCORRENTE")
	public DwFtParam getDwFtParamByIdFtParamcorrente() {
		return this.dwFtParamByIdFtParamcorrente;
	}

	public void setDwFtParamByIdFtParamcorrente(
			DwFtParam dwFtParamByIdFtParamcorrente) {
		this.dwFtParamByIdFtParamcorrente = dwFtParamByIdFtParamcorrente;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FT_PARAMTENSAO")
	public DwFtParam getDwFtParamByIdFtParamtensao() {
		return this.dwFtParamByIdFtParamtensao;
	}

	public void setDwFtParamByIdFtParamtensao(
			DwFtParam dwFtParamByIdFtParamtensao) {
		this.dwFtParamByIdFtParamtensao = dwFtParamByIdFtParamtensao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTO")
	public OmProduto getOmProduto() {
		return this.omProduto;
	}

	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPPTPM")
	public OmTppt getOmTpptByIdTpptpm() {
		return this.omTpptByIdTpptpm;
	}

	public void setOmTpptByIdTpptpm(OmTppt omTpptByIdTpptpm) {
		this.omTpptByIdTpptpm = omTpptByIdTpptpm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CCDEFAULT", nullable = false)
	public OmCc getOmCcdefault() {
		return this.omCcDefault;
	}

	public void setOmCcdefault(OmCc omCc) {
		this.omCcDefault = omCc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ALGOCOR")
	public OmAlgocor getOmAlgocor() {
		return this.omAlgocor;
	}

	public void setOmAlgocor(OmAlgocor omAlgocor) {
		this.omAlgocor = omAlgocor;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RESGUIALIMENTA")
	public OmResgui getOmResgui() {
		return this.omResgui;
	}

	public void setOmResgui(OmResgui omResgui) {
		this.omResgui = omResgui;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRGRPOPERADOR")
	public OmUsrgrp getOmUsrgrpByIdUsrgrpoperador() {
		return this.omUsrgrpByIdUsrgrpoperador;
	}

	public void setOmUsrgrpByIdUsrgrpoperador(
			OmUsrgrp omUsrgrpByIdUsrgrpoperador) {
		this.omUsrgrpByIdUsrgrpoperador = omUsrgrpByIdUsrgrpoperador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPPTPPASS")
	public OmTppt getOmTpptByIdTpptppass() {
		return this.omTpptByIdTpptppass;
	}

	public void setOmTpptByIdTpptppass(OmTppt omTpptByIdTpptppass) {
		this.omTpptByIdTpptppass = omTpptByIdTpptppass;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPPTPREPRO")
	public OmTppt getOmTpptByIdTpptprepro() {
		return this.omTpptByIdTpptprepro;
	}

	public void setOmTpptByIdTpptprepro(OmTppt omTpptByIdTpptprepro) {
		this.omTpptByIdTpptprepro = omTpptByIdTpptprepro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPPTPTS")
	public OmTppt getOmTpptByIdTpptpts() {
		return this.omTpptByIdTpptpts;
	}

	public void setOmTpptByIdTpptpts(OmTppt omTpptByIdTpptpts) {
		this.omTpptByIdTpptpts = omTpptByIdTpptpts;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FT_PARAMFLUSOS")
	public DwFtParam getDwFtParamByIdFtParamflusos() {
		return this.dwFtParamByIdFtParamflusos;
	}

	public void setDwFtParamByIdFtParamflusos(
			DwFtParam dwFtParamByIdFtParamflusos) {
		this.dwFtParamByIdFtParamflusos = dwFtParamByIdFtParamflusos;
	}

	@Column(name = "IS_NIVELFEEDER", precision = 1, scale = 0)
	public Boolean getIsNivelfeeder() {
		return this.isNivelfeeder;
	}

	public void setIsNivelfeeder(Boolean isNivelfeeder) {
		this.isNivelfeeder = isNivelfeeder;
	}

	@Column(name = "IS_IHMTROCAOP", precision = 1, scale = 0)
	public Boolean getIsIhmtrocaop() {
		return this.isIhmtrocaop;
	}

	public void setIsIhmtrocaop(Boolean isValor) {
		this.isIhmtrocaop = isValor;
	}
	@Column(name = "IS_IMP_MAPA_QT_UNICA", precision = 1, scale = 0)
	public Boolean getIsImpMapaQtUnica() {
		return this.isImpMapaQtUnica;
	}

	public void setIsImpMapaQtUnica(Boolean isValor) {
		this.isImpMapaQtUnica = isValor;
	}

	@Override
	@Column(name = "REVISAO", precision = 22, scale = 0)
	public Long getRevisao() {
		return this.revisao;
	}

	@Override
	public void setRevisao(Long revisao) {
		this.revisao = revisao;
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

	@Column(name = "SEG_FEEDBACKLOGIN", precision = 20, scale = 10)
	public BigDecimal getSegFeedbacklogin() {
		return this.segFeedbacklogin;
	}

	public void setSegFeedbacklogin(BigDecimal segFeedbacklogin) {
		this.segFeedbacklogin = segFeedbacklogin;
	}
	
	

	@Column(name = "SEG_LOGOUTAUTOMATICO", precision = 20, scale = 10)
	public BigDecimal getSegLogoutautomatico() {
		return segLogoutautomatico;
	}

	public void setSegLogoutautomatico(BigDecimal segLogoutautomatico) {
		this.segLogoutautomatico = segLogoutautomatico;
	}

	@Column(name = "SEG_AUTOLOGOUT", precision = 20, scale = 10)
	public BigDecimal getSegAutologout() {
		return this.segAutologout;
	}

	public void setSegAutologout(BigDecimal segAutologout) {
		this.segAutologout = segAutologout;
	}

	@Column(name = "QT_MAXPTCOLETAFULL", precision = 22, scale = 0)
	public BigDecimal getQtMaxptcoletafull() {
		return this.qtMaxptcoletafull;
	}

	public void setQtMaxptcoletafull(BigDecimal qtMaxptcoletafull) {
		this.qtMaxptcoletafull = qtMaxptcoletafull;
	}



	@Column(name = "QT_MAXETAPATESTE", precision = 22, scale = 0)
	public BigDecimal getQtMaxetapateste() {
		return this.qtMaxetapateste;
	}

	public void setQtMaxetapateste(BigDecimal qtMaxetapateste) {
		this.qtMaxetapateste = qtMaxetapateste;
	}

	@Column(name = "qt_maxsubetapas", precision = 22, scale = 0)
	public BigDecimal getQtMaxsubetapas() {
		return this.qtMaxsubetapas;
	}

	public void setQtMaxsubetapas(BigDecimal qtMaxsubetapas) {
		this.qtMaxsubetapas = qtMaxsubetapas;
	}

	@Column(name = "SEG_HEARTBEAT", precision = 20, scale = 10)
	public BigDecimal getSegHeartbeat() {
		return this.segHeartbeat;
	}

	public void setSegHeartbeat(BigDecimal segHeartbeat) {
		this.segHeartbeat = segHeartbeat;
	}


	
	@Column(name = "DS_MENSAGEMSOBRETENSAO", length = 100)
	public String getDsMensagemsobretensao() {
		return this.dsMensagemsobretensao;
	}

	public void setDsMensagemsobretensao(String dsMensagemsobretensao) {
		this.dsMensagemsobretensao = dsMensagemsobretensao;
	}
	@Column(name = "DS_MENSAGEMSUBTENSAO", length = 100)
	public String getDsMensagemsubtensao() {
		return this.dsMensagemsubtensao;
	}

	public void setDsMensagemsubtensao(String dsMensagemsubtensao) {
		this.dsMensagemsubtensao = dsMensagemsubtensao;
	}

	@Column(name = "MASCARACDPRODUTOMP", length = 256)
	public String getMascaracdprodutomp() {
		return this.mascaracdprodutomp;
	}

	public void setMascaracdprodutomp(String mascaracdprodutofilho) {
		this.mascaracdprodutomp = mascaracdprodutofilho;
	}

	@Column(name = "IS_LOGONOBRIGATORIO", precision = 1, scale = 0)
	public Boolean getIsLogonobrigatorio() {
		return this.isLogonobrigatorio;
	}

	public void setIsLogonobrigatorio(Boolean isLogonobrigatorio) {
		this.isLogonobrigatorio = isLogonobrigatorio;
	}

	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "omCfg")
	public Set<OmCfgscrpimp> getOmCfgscrpimps() {
		return this.omCfgscrpimps;
	}

	public void setOmCfgscrpimps(Set<OmCfgscrpimp> omCfgscrpimps) {
		this.omCfgscrpimps = omCfgscrpimps;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omCfg")
	public Set<OmCfgptdetcoleta> getOmCfgptdetcoletas() {
		return this.omCfgptdetcoletas;
	}

	public void setOmCfgptdetcoletas(Set<OmCfgptdetcoleta> omCfgptdetcoletas) {
		this.omCfgptdetcoletas = omCfgptdetcoletas;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RAPMAGAZINE")
	public DwRap getDwRap() {
		return this.dwRap;
	}

	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTMP")
	public DwEst getDwEstByIdEstmp() {
		return this.dwEstByIdEstmp;
	}

	public void setDwEstByIdEstmp(DwEst dwEstByIdEstmp) {
		this.dwEstByIdEstmp = dwEstByIdEstmp;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GTIMPCIC")
	public OmGt getOmGtimpcic() {
		return this.omGtimpcic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPARADA")
	public DwTParada getDwTParada() {
		return this.dwTParada;
	}

	public void setDwTParada(DwTParada dwTParada) {
		this.dwTParada = dwTParada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TREFUGO")
	public DwTRefugo getDwTRefugo() {
		return this.dwTRefugo;
	}

	public void setDwTRefugo(DwTRefugo valor) {
		this.dwTRefugo = valor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_regras_ns")
	public OmRegrasNscb getOmRegrasNscbByIdRegrasNs() {
		return this.omRegrasNscbByIdRegrasNs;
	}

	public void setOmRegrasNscbByIdRegrasNs(
			OmRegrasNscb omRegrasNscbByIdRegrasNs) {
		this.omRegrasNscbByIdRegrasNs = omRegrasNscbByIdRegrasNs;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_regras_cb")
	public OmRegrasNscb getOmRegrasNscbByIdRegrasCb() {
		return this.omRegrasNscbByIdRegrasCb;
	}

	public void setOmRegrasNscbByIdRegrasCb(
			OmRegrasNscb omRegrasNscbByIdRegrasCb) {
		this.omRegrasNscbByIdRegrasCb = omRegrasNscbByIdRegrasCb;
	}
	
	public void setOmGtimpcic(OmGt omGt) {
		this.omGtimpcic = omGt;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omCfg")
	public Set<OmCfgind> getOmCfginds() {
		return this.omCfginds;
	}

	public void setOmCfginds(Set<OmCfgind> omCfginds) {
		this.omCfginds = omCfginds;
	}
	
	@Column(name = "IS_COMPENSAAPONT")
	public Boolean getIsCompensaapont() {
		return this.isCompensaapont;
	}

	public void setIsCompensaapont(Boolean isCompensaapont) {
		this.isCompensaapont = isCompensaapont;
	}

	@Column(name = "TP_LAYOUTPLANO", precision = 1)
	public Integer getTpLayoutplano() {
		return this.tpLayoutplano;
	}

	public void setTpLayoutplano(Integer tpLayoutplano) {
		this.tpLayoutplano = tpLayoutplano;
	}

	@Column(name = "IS_PROCESSAIACINSERT")
	public Boolean getIsProcessaiacinsert() {
		return this.isProcessaiacinsert;
	}

	public void setIsProcessaiacinsert(Boolean isProcessaiacinsert) {
		this.isProcessaiacinsert = isProcessaiacinsert;
	}
	
	

	@Column(name = "IS_LOGOUTAUTOMATICO")
	public Boolean getIsLogoutautomatico() {
		return isLogoutautomatico;
	}

	public void setIsLogoutautomatico(Boolean isLogoutautomatico) {
		this.isLogoutautomatico = isLogoutautomatico;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_ESTLIBERADO", length = 23)
	public Date getDthrEstliberado(){
		return this.dthrEstliberado;
	}
	
	public void setDthrEstliberado(Date dthrEstliberado){
		this.dthrEstliberado = dthrEstliberado;
	}
	
	@Column(name = "IS_PROCESSAIACIDW")
	public Boolean getIsProcessaiacidw() {
		return this.isProcessaiacidw;
	}

	public void setIsProcessaiacidw(Boolean isProcessaiacidw) {
		this.isProcessaiacidw = isProcessaiacidw;
	}

	/*
	 * O objetivo era criar uma configuracao para informar ao sistema que deixasse de contar os ciclos dentro da regulagem. Entretanto ela ja nao contava
	 */
	@Column(name = "IS_CONTACICLOIMPRODUTIVOREGULA")
	public Boolean getIsContacicloimprodutivoregula() {
		return this.isContacicloimprodutivoregula;
	}

	public void setIsContacicloimprodutivoregula(Boolean valor) {
		this.isContacicloimprodutivoregula = valor;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	public OmEmpresa getOmEmpresa() {
		return this.omEmpresa;
	}

	public void setOmEmpresa(OmEmpresa omEmpresa) {
		this.omEmpresa = omEmpresa;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omCfg")
	public Set<OmCfgurl> getOmCfgurls() {
		return this.omCfgurls;
	}

	public void setOmCfgurls(Set<OmCfgurl> omCfgurls) {
		this.omCfgurls = omCfgurls;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estAlimentacao")
	public DwEst getDwEstByIdEstAlimentacao() {
		return this.dwEstByIdEstAlimentacao;
	}

	public void setDwEstByIdEstAlimentacao(DwEst dwEstByIdEstAlimentacao) {
		this.dwEstByIdEstAlimentacao = dwEstByIdEstAlimentacao;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estlocalorigalim")
	public DwEstlocal getDwEstlocalorigalim() {
		return this.dwEstlocalorigalim;
	}

	public void setDwEstlocalorigalim(DwEstlocal dwEstlocalorigalim) {
		this.dwEstlocalorigalim = dwEstlocalorigalim;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cfgabc")
	public OmCfgabc getOmCfgabc() {
		return this.omCfgabc;
	}

	public void setOmCfgabc(OmCfgabc omCfgabc) {
		this.omCfgabc = omCfgabc;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_talerta")
	public DwTAlerta getDwTAlerta() {
		return this.dwTAlerta;
	}

	public void setDwTAlerta(DwTAlerta dwTAlerta) {
		this.dwTAlerta = dwTAlerta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tparadacip")
	public DwTParada getDwTParadaByIdTparadacip() {
		return this.dwTParadaByIdTparadacip;
	}

	public void setDwTParadaByIdTparadacip(DwTParada dwTParadaByIdTparadacip) {
		this.dwTParadaByIdTparadacip = dwTParadaByIdTparadacip;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tparadasemconexao")
	public DwTParada getDwTParadasemconexao() {
		return this.dwTParadasemconexao;
	}

	public void setDwTParadasemconexao(DwTParada valor) {
		this.dwTParadasemconexao = valor;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tritmo")
	public DwTRitmo getDwTRitmo() {
		return this.dwTRitmo;
	}

	public void setDwTRitmo(DwTRitmo dwTRitmo) {
		this.dwTRitmo = dwTRitmo;
	}

	@Column(name = "MASCARAOP", length = 256)
	public String getMascaraop() {
		return this.mascaraop;
	}

	public void setMascaraop(String mascaracdprogramaiac) {
		this.mascaraop = mascaracdprogramaiac;
	}

	@Column(name = "MASCARACDPRODUTOCB", length = 256)
	public String getMascaracdprodutoCB() {
		return this.mascaracdprodutoCB;
	}

	public void setMascaracdprodutoCB(String mascaracdprodutoiac) {
		this.mascaracdprodutoCB = mascaracdprodutoiac;
	}

	@Column(name = "MASCARACDPRODUTOCF", length = 256)
	public String getMascaracdprodutoCF() {
		return this.mascaracdprodutoCF;
	}

	public void setMascaracdprodutoCF(String mascaracdprodutopai) {
		this.mascaracdprodutoCF = mascaracdprodutopai;
	}
	
	@Column(name = "MASCARAQTD", length = 256)
	public String getMascaraQtd() {
		return this.mascaraQtd;
	}

	public void setMascaraQtd(String mascaraQtd) {
		this.mascaraQtd = mascaraQtd;
	}
	
	
	@Column(name = "MASCARACB", length = 256)
	public String getMascaracb() {
		return this.mascaracb;
	}

	public void setMascaracb(String mascaracb) {
		this.mascaracb = mascaracb;
	}

	@Column(name = "MASCARAFOLHA", length = 256)
	public String getMascarafolha() {
		return this.mascarafolha;
	}

	public void setMascarafolha(String mascara) {
		this.mascarafolha = mascara;
	}
	
	@Column(name = "is_ritmosempre_nas_hrsprod")
	public Boolean getIsRitmosempreNasHrsprod() {
		return this.isRitmosempreNasHrsprod;
	}

	public void setIsRitmosempreNasHrsprod(Boolean isRitmosempreNasHrsprod) {
		this.isRitmosempreNasHrsprod = isRitmosempreNasHrsprod;
	}

	@Column(name = "LOGIN")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "SENHA")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "emailsscriptpadraonc")
	public String getEmailsscriptpadraonc() {
		return emailsscriptpadraonc;
	}

	public void setEmailsscriptpadraonc(String emailsscriptpadraonc) {
		this.emailsscriptpadraonc = emailsscriptpadraonc;
	}


	
	@Column(name = "emailaoi")
	public String getEmailaoi() {
		return emailaoi;
	}

	public void setEmailaoi(String emailaoi) {
		this.emailaoi = emailaoi;
	}

	@Column(name = "TP_WHATSAPP", precision = 1)
	public Integer getTpWhatsapp() {
		return tpWhatsapp;
	}

	public void setTpWhatsapp(Integer tpWhatsapp) {
		this.tpWhatsapp = tpWhatsapp;
	}

	@Column(name = "ID_WHATSAPP")
	public String getIdWhatsapp() {
		return idWhatsapp;
	}

	public void setIdWhatsapp(String idWhatsapp) {
		this.idWhatsapp = idWhatsapp;
	}

	@Column(name = "PW_WHATSAPP")
	public String getPwWhatsapp() {
		return pwWhatsapp;
	}

	public void setPwWhatsapp(String pwWhatsapp) {
		this.pwWhatsapp = pwWhatsapp;
	}

	@Column(name = "TEL_WHATSAPP")
	public String getTelWhatsapp() {
		return telWhatsapp;
	}

	public void setTelWhatsapp(String telWhatsapp) {
		this.telWhatsapp = telWhatsapp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRGRPTECNICO")
	public OmUsrgrp getOmUsrgrpByIdUsrgrptecnico() {
		return omUsrgrpByIdUsrgrptecnico;
	}

	public void setOmUsrgrpByIdUsrgrptecnico(OmUsrgrp omUsrgrpByIdUsrgrptecnico) {
		this.omUsrgrpByIdUsrgrptecnico = omUsrgrpByIdUsrgrptecnico;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRGRPMONITOR")
	public OmUsrgrp getOmUsrgrpByIdUsrgrpmonitor() {
		return omUsrgrpByIdUsrgrpmonitor;
	}

	public void setOmUsrgrpByIdUsrgrpmonitor(OmUsrgrp omUsrgrpByIdUsrgrpmonitor) {
		this.omUsrgrpByIdUsrgrpmonitor = omUsrgrpByIdUsrgrpmonitor;
	}	
}
