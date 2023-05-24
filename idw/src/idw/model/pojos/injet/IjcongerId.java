package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjcongerId generated by hbm2java
 */
@Embeddable
public class IjcongerId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8439617967968345843L;
	private double qtcicmon;
	private double qtcicarm;
	private String tecontagememuso;
	private String lrefugartodaspecas;
	private double hrreferencia;
	private BigDecimal tempotimeoutescr;
	private Double indrefmaiorque;
	private BigDecimal padraomediosetup;
	private Double metaefisetup;
	private Double metaatendimento;
	private Double metautilizacao;
	private Double metaeficiencia;
	private Double metaprodutividade;
	private Double metappmil;
	private Double univamostraqld;
	private Double tmpsetuppadrao;
	private Double efireapadrao;
	private Double relctrlprodefirea;
	private Double relctrlprodindref;
	private BigDecimal maxtmpmicroparada;
	private Character tpverifconcop;
	private Double vlverifconcop;
	private String idplanta;
	private String idareaproducao;
	private Character libaramreqsup;
	private Double tampulmaopadrao;
	private Double tampulmaomax;
	private Double tampulmaomin;
	private double tmptimeoutcolet;
	private BigDecimal tamamostra;
	private Character coletaamstrporcav;
	private Character tpespeclimites;
	private char tpmedinspqld;
	private char exclistedicaostd;
	private char exibebkgclraleinsp;
	private String obsdefrelcgq;
	private Character refamostfespec;
	private String cdrfgamostabxespcf;
	private String cdrfgamostacmespcf;
	private BigDecimal ctrlaleprobqld;
	private BigDecimal bloqcgqitemforaesp;

	public IjcongerId() {
	}

	public IjcongerId(double qtcicmon, double qtcicarm, String tecontagememuso,
			String lrefugartodaspecas, double hrreferencia,
			BigDecimal tempotimeoutescr, double tmptimeoutcolet,
			char tpmedinspqld, char exclistedicaostd, char exibebkgclraleinsp,
			BigDecimal ctrlaleprobqld, BigDecimal bloqcgqitemforaesp) {
		this.qtcicmon = qtcicmon;
		this.qtcicarm = qtcicarm;
		this.tecontagememuso = tecontagememuso;
		this.lrefugartodaspecas = lrefugartodaspecas;
		this.hrreferencia = hrreferencia;
		this.tempotimeoutescr = tempotimeoutescr;
		this.tmptimeoutcolet = tmptimeoutcolet;
		this.tpmedinspqld = tpmedinspqld;
		this.exclistedicaostd = exclistedicaostd;
		this.exibebkgclraleinsp = exibebkgclraleinsp;
		this.ctrlaleprobqld = ctrlaleprobqld;
		this.bloqcgqitemforaesp = bloqcgqitemforaesp;
	}

	public IjcongerId(double qtcicmon, double qtcicarm, String tecontagememuso,
			String lrefugartodaspecas, double hrreferencia,
			BigDecimal tempotimeoutescr, Double indrefmaiorque,
			BigDecimal padraomediosetup, Double metaefisetup,
			Double metaatendimento, Double metautilizacao,
			Double metaeficiencia, Double metaprodutividade, Double metappmil,
			Double univamostraqld, Double tmpsetuppadrao, Double efireapadrao,
			Double relctrlprodefirea, Double relctrlprodindref,
			BigDecimal maxtmpmicroparada, Character tpverifconcop,
			Double vlverifconcop, String idplanta, String idareaproducao,
			Character libaramreqsup, Double tampulmaopadrao,
			Double tampulmaomax, Double tampulmaomin, double tmptimeoutcolet,
			BigDecimal tamamostra, Character coletaamstrporcav,
			Character tpespeclimites, char tpmedinspqld, char exclistedicaostd,
			char exibebkgclraleinsp, String obsdefrelcgq,
			Character refamostfespec, String cdrfgamostabxespcf,
			String cdrfgamostacmespcf, BigDecimal ctrlaleprobqld,
			BigDecimal bloqcgqitemforaesp) {
		this.qtcicmon = qtcicmon;
		this.qtcicarm = qtcicarm;
		this.tecontagememuso = tecontagememuso;
		this.lrefugartodaspecas = lrefugartodaspecas;
		this.hrreferencia = hrreferencia;
		this.tempotimeoutescr = tempotimeoutescr;
		this.indrefmaiorque = indrefmaiorque;
		this.padraomediosetup = padraomediosetup;
		this.metaefisetup = metaefisetup;
		this.metaatendimento = metaatendimento;
		this.metautilizacao = metautilizacao;
		this.metaeficiencia = metaeficiencia;
		this.metaprodutividade = metaprodutividade;
		this.metappmil = metappmil;
		this.univamostraqld = univamostraqld;
		this.tmpsetuppadrao = tmpsetuppadrao;
		this.efireapadrao = efireapadrao;
		this.relctrlprodefirea = relctrlprodefirea;
		this.relctrlprodindref = relctrlprodindref;
		this.maxtmpmicroparada = maxtmpmicroparada;
		this.tpverifconcop = tpverifconcop;
		this.vlverifconcop = vlverifconcop;
		this.idplanta = idplanta;
		this.idareaproducao = idareaproducao;
		this.libaramreqsup = libaramreqsup;
		this.tampulmaopadrao = tampulmaopadrao;
		this.tampulmaomax = tampulmaomax;
		this.tampulmaomin = tampulmaomin;
		this.tmptimeoutcolet = tmptimeoutcolet;
		this.tamamostra = tamamostra;
		this.coletaamstrporcav = coletaamstrporcav;
		this.tpespeclimites = tpespeclimites;
		this.tpmedinspqld = tpmedinspqld;
		this.exclistedicaostd = exclistedicaostd;
		this.exibebkgclraleinsp = exibebkgclraleinsp;
		this.obsdefrelcgq = obsdefrelcgq;
		this.refamostfespec = refamostfespec;
		this.cdrfgamostabxespcf = cdrfgamostabxespcf;
		this.cdrfgamostacmespcf = cdrfgamostacmespcf;
		this.ctrlaleprobqld = ctrlaleprobqld;
		this.bloqcgqitemforaesp = bloqcgqitemforaesp;
	}

	@Column(name = "QTCICMON", nullable = false, precision = 126, scale = 0)
	public double getQtcicmon() {
		return this.qtcicmon;
	}

	public void setQtcicmon(double qtcicmon) {
		this.qtcicmon = qtcicmon;
	}

	@Column(name = "QTCICARM", nullable = false, precision = 126, scale = 0)
	public double getQtcicarm() {
		return this.qtcicarm;
	}

	public void setQtcicarm(double qtcicarm) {
		this.qtcicarm = qtcicarm;
	}

	@Column(name = "TECONTAGEMEMUSO", nullable = false, length = 18)
	public String getTecontagememuso() {
		return this.tecontagememuso;
	}

	public void setTecontagememuso(String tecontagememuso) {
		this.tecontagememuso = tecontagememuso;
	}

	@Column(name = "LREFUGARTODASPECAS", nullable = false, length = 18)
	public String getLrefugartodaspecas() {
		return this.lrefugartodaspecas;
	}

	public void setLrefugartodaspecas(String lrefugartodaspecas) {
		this.lrefugartodaspecas = lrefugartodaspecas;
	}

	@Column(name = "HRREFERENCIA", nullable = false, precision = 126, scale = 0)
	public double getHrreferencia() {
		return this.hrreferencia;
	}

	public void setHrreferencia(double hrreferencia) {
		this.hrreferencia = hrreferencia;
	}

	@Column(name = "TEMPOTIMEOUTESCR", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTempotimeoutescr() {
		return this.tempotimeoutescr;
	}

	public void setTempotimeoutescr(BigDecimal tempotimeoutescr) {
		this.tempotimeoutescr = tempotimeoutescr;
	}

	@Column(name = "INDREFMAIORQUE", precision = 126, scale = 0)
	public Double getIndrefmaiorque() {
		return this.indrefmaiorque;
	}

	public void setIndrefmaiorque(Double indrefmaiorque) {
		this.indrefmaiorque = indrefmaiorque;
	}

	@Column(name = "PADRAOMEDIOSETUP", precision = 22, scale = 0)
	public BigDecimal getPadraomediosetup() {
		return this.padraomediosetup;
	}

	public void setPadraomediosetup(BigDecimal padraomediosetup) {
		this.padraomediosetup = padraomediosetup;
	}

	@Column(name = "METAEFISETUP", precision = 126, scale = 0)
	public Double getMetaefisetup() {
		return this.metaefisetup;
	}

	public void setMetaefisetup(Double metaefisetup) {
		this.metaefisetup = metaefisetup;
	}

	@Column(name = "METAATENDIMENTO", precision = 126, scale = 0)
	public Double getMetaatendimento() {
		return this.metaatendimento;
	}

	public void setMetaatendimento(Double metaatendimento) {
		this.metaatendimento = metaatendimento;
	}

	@Column(name = "METAUTILIZACAO", precision = 126, scale = 0)
	public Double getMetautilizacao() {
		return this.metautilizacao;
	}

	public void setMetautilizacao(Double metautilizacao) {
		this.metautilizacao = metautilizacao;
	}

	@Column(name = "METAEFICIENCIA", precision = 126, scale = 0)
	public Double getMetaeficiencia() {
		return this.metaeficiencia;
	}

	public void setMetaeficiencia(Double metaeficiencia) {
		this.metaeficiencia = metaeficiencia;
	}

	@Column(name = "METAPRODUTIVIDADE", precision = 126, scale = 0)
	public Double getMetaprodutividade() {
		return this.metaprodutividade;
	}

	public void setMetaprodutividade(Double metaprodutividade) {
		this.metaprodutividade = metaprodutividade;
	}

	@Column(name = "METAPPMIL", precision = 126, scale = 0)
	public Double getMetappmil() {
		return this.metappmil;
	}

	public void setMetappmil(Double metappmil) {
		this.metappmil = metappmil;
	}

	@Column(name = "UNIVAMOSTRAQLD", precision = 126, scale = 0)
	public Double getUnivamostraqld() {
		return this.univamostraqld;
	}

	public void setUnivamostraqld(Double univamostraqld) {
		this.univamostraqld = univamostraqld;
	}

	@Column(name = "TMPSETUPPADRAO", precision = 126, scale = 0)
	public Double getTmpsetuppadrao() {
		return this.tmpsetuppadrao;
	}

	public void setTmpsetuppadrao(Double tmpsetuppadrao) {
		this.tmpsetuppadrao = tmpsetuppadrao;
	}

	@Column(name = "EFIREAPADRAO", precision = 126, scale = 0)
	public Double getEfireapadrao() {
		return this.efireapadrao;
	}

	public void setEfireapadrao(Double efireapadrao) {
		this.efireapadrao = efireapadrao;
	}

	@Column(name = "RELCTRLPRODEFIREA", precision = 126, scale = 0)
	public Double getRelctrlprodefirea() {
		return this.relctrlprodefirea;
	}

	public void setRelctrlprodefirea(Double relctrlprodefirea) {
		this.relctrlprodefirea = relctrlprodefirea;
	}

	@Column(name = "RELCTRLPRODINDREF", precision = 126, scale = 0)
	public Double getRelctrlprodindref() {
		return this.relctrlprodindref;
	}

	public void setRelctrlprodindref(Double relctrlprodindref) {
		this.relctrlprodindref = relctrlprodindref;
	}

	@Column(name = "MAXTMPMICROPARADA", precision = 22, scale = 0)
	public BigDecimal getMaxtmpmicroparada() {
		return this.maxtmpmicroparada;
	}

	public void setMaxtmpmicroparada(BigDecimal maxtmpmicroparada) {
		this.maxtmpmicroparada = maxtmpmicroparada;
	}

	@Column(name = "TPVERIFCONCOP", length = 1)
	public Character getTpverifconcop() {
		return this.tpverifconcop;
	}

	public void setTpverifconcop(Character tpverifconcop) {
		this.tpverifconcop = tpverifconcop;
	}

	@Column(name = "VLVERIFCONCOP", precision = 126, scale = 0)
	public Double getVlverifconcop() {
		return this.vlverifconcop;
	}

	public void setVlverifconcop(Double vlverifconcop) {
		this.vlverifconcop = vlverifconcop;
	}

	@Column(name = "IDPLANTA", length = 10)
	public String getIdplanta() {
		return this.idplanta;
	}

	public void setIdplanta(String idplanta) {
		this.idplanta = idplanta;
	}

	@Column(name = "IDAREAPRODUCAO", length = 10)
	public String getIdareaproducao() {
		return this.idareaproducao;
	}

	public void setIdareaproducao(String idareaproducao) {
		this.idareaproducao = idareaproducao;
	}

	@Column(name = "LIBARAMREQSUP", length = 1)
	public Character getLibaramreqsup() {
		return this.libaramreqsup;
	}

	public void setLibaramreqsup(Character libaramreqsup) {
		this.libaramreqsup = libaramreqsup;
	}

	@Column(name = "TAMPULMAOPADRAO", precision = 126, scale = 0)
	public Double getTampulmaopadrao() {
		return this.tampulmaopadrao;
	}

	public void setTampulmaopadrao(Double tampulmaopadrao) {
		this.tampulmaopadrao = tampulmaopadrao;
	}

	@Column(name = "TAMPULMAOMAX", precision = 126, scale = 0)
	public Double getTampulmaomax() {
		return this.tampulmaomax;
	}

	public void setTampulmaomax(Double tampulmaomax) {
		this.tampulmaomax = tampulmaomax;
	}

	@Column(name = "TAMPULMAOMIN", precision = 126, scale = 0)
	public Double getTampulmaomin() {
		return this.tampulmaomin;
	}

	public void setTampulmaomin(Double tampulmaomin) {
		this.tampulmaomin = tampulmaomin;
	}

	@Column(name = "TMPTIMEOUTCOLET", nullable = false, precision = 126, scale = 0)
	public double getTmptimeoutcolet() {
		return this.tmptimeoutcolet;
	}

	public void setTmptimeoutcolet(double tmptimeoutcolet) {
		this.tmptimeoutcolet = tmptimeoutcolet;
	}

	@Column(name = "TAMAMOSTRA", precision = 22, scale = 0)
	public BigDecimal getTamamostra() {
		return this.tamamostra;
	}

	public void setTamamostra(BigDecimal tamamostra) {
		this.tamamostra = tamamostra;
	}

	@Column(name = "COLETAAMSTRPORCAV", length = 1)
	public Character getColetaamstrporcav() {
		return this.coletaamstrporcav;
	}

	public void setColetaamstrporcav(Character coletaamstrporcav) {
		this.coletaamstrporcav = coletaamstrporcav;
	}

	@Column(name = "TPESPECLIMITES", length = 1)
	public Character getTpespeclimites() {
		return this.tpespeclimites;
	}

	public void setTpespeclimites(Character tpespeclimites) {
		this.tpespeclimites = tpespeclimites;
	}

	@Column(name = "TPMEDINSPQLD", nullable = false, length = 1)
	public char getTpmedinspqld() {
		return this.tpmedinspqld;
	}

	public void setTpmedinspqld(char tpmedinspqld) {
		this.tpmedinspqld = tpmedinspqld;
	}

	@Column(name = "EXCLISTEDICAOSTD", nullable = false, length = 1)
	public char getExclistedicaostd() {
		return this.exclistedicaostd;
	}

	public void setExclistedicaostd(char exclistedicaostd) {
		this.exclistedicaostd = exclistedicaostd;
	}

	@Column(name = "EXIBEBKGCLRALEINSP", nullable = false, length = 1)
	public char getExibebkgclraleinsp() {
		return this.exibebkgclraleinsp;
	}

	public void setExibebkgclraleinsp(char exibebkgclraleinsp) {
		this.exibebkgclraleinsp = exibebkgclraleinsp;
	}

	@Column(name = "OBSDEFRELCGQ", length = 250)
	public String getObsdefrelcgq() {
		return this.obsdefrelcgq;
	}

	public void setObsdefrelcgq(String obsdefrelcgq) {
		this.obsdefrelcgq = obsdefrelcgq;
	}

	@Column(name = "REFAMOSTFESPEC", length = 1)
	public Character getRefamostfespec() {
		return this.refamostfespec;
	}

	public void setRefamostfespec(Character refamostfespec) {
		this.refamostfespec = refamostfespec;
	}

	@Column(name = "CDRFGAMOSTABXESPCF", length = 20)
	public String getCdrfgamostabxespcf() {
		return this.cdrfgamostabxespcf;
	}

	public void setCdrfgamostabxespcf(String cdrfgamostabxespcf) {
		this.cdrfgamostabxespcf = cdrfgamostabxespcf;
	}

	@Column(name = "CDRFGAMOSTACMESPCF", length = 20)
	public String getCdrfgamostacmespcf() {
		return this.cdrfgamostacmespcf;
	}

	public void setCdrfgamostacmespcf(String cdrfgamostacmespcf) {
		this.cdrfgamostacmespcf = cdrfgamostacmespcf;
	}

	@Column(name = "CTRLALEPROBQLD", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCtrlaleprobqld() {
		return this.ctrlaleprobqld;
	}

	public void setCtrlaleprobqld(BigDecimal ctrlaleprobqld) {
		this.ctrlaleprobqld = ctrlaleprobqld;
	}

	@Column(name = "BLOQCGQITEMFORAESP", nullable = false, precision = 22, scale = 0)
	public BigDecimal getBloqcgqitemforaesp() {
		return this.bloqcgqitemforaesp;
	}

	public void setBloqcgqitemforaesp(BigDecimal bloqcgqitemforaesp) {
		this.bloqcgqitemforaesp = bloqcgqitemforaesp;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjcongerId))
			return false;
		IjcongerId castOther = (IjcongerId) other;

		return (this.getQtcicmon() == castOther.getQtcicmon())
				&& (this.getQtcicarm() == castOther.getQtcicarm())
				&& ((this.getTecontagememuso() == castOther
						.getTecontagememuso()) || (this.getTecontagememuso() != null
						&& castOther.getTecontagememuso() != null && this
						.getTecontagememuso().equals(
								castOther.getTecontagememuso())))
				&& ((this.getLrefugartodaspecas() == castOther
						.getLrefugartodaspecas()) || (this
						.getLrefugartodaspecas() != null
						&& castOther.getLrefugartodaspecas() != null && this
						.getLrefugartodaspecas().equals(
								castOther.getLrefugartodaspecas())))
				&& (this.getHrreferencia() == castOther.getHrreferencia())
				&& ((this.getTempotimeoutescr() == castOther
						.getTempotimeoutescr()) || (this.getTempotimeoutescr() != null
						&& castOther.getTempotimeoutescr() != null && this
						.getTempotimeoutescr().equals(
								castOther.getTempotimeoutescr())))
				&& ((this.getIndrefmaiorque() == castOther.getIndrefmaiorque()) || (this
						.getIndrefmaiorque() != null
						&& castOther.getIndrefmaiorque() != null && this
						.getIndrefmaiorque().equals(
								castOther.getIndrefmaiorque())))
				&& ((this.getPadraomediosetup() == castOther
						.getPadraomediosetup()) || (this.getPadraomediosetup() != null
						&& castOther.getPadraomediosetup() != null && this
						.getPadraomediosetup().equals(
								castOther.getPadraomediosetup())))
				&& ((this.getMetaefisetup() == castOther.getMetaefisetup()) || (this
						.getMetaefisetup() != null
						&& castOther.getMetaefisetup() != null && this
						.getMetaefisetup().equals(castOther.getMetaefisetup())))
				&& ((this.getMetaatendimento() == castOther
						.getMetaatendimento()) || (this.getMetaatendimento() != null
						&& castOther.getMetaatendimento() != null && this
						.getMetaatendimento().equals(
								castOther.getMetaatendimento())))
				&& ((this.getMetautilizacao() == castOther.getMetautilizacao()) || (this
						.getMetautilizacao() != null
						&& castOther.getMetautilizacao() != null && this
						.getMetautilizacao().equals(
								castOther.getMetautilizacao())))
				&& ((this.getMetaeficiencia() == castOther.getMetaeficiencia()) || (this
						.getMetaeficiencia() != null
						&& castOther.getMetaeficiencia() != null && this
						.getMetaeficiencia().equals(
								castOther.getMetaeficiencia())))
				&& ((this.getMetaprodutividade() == castOther
						.getMetaprodutividade()) || (this
						.getMetaprodutividade() != null
						&& castOther.getMetaprodutividade() != null && this
						.getMetaprodutividade().equals(
								castOther.getMetaprodutividade())))
				&& ((this.getMetappmil() == castOther.getMetappmil()) || (this
						.getMetappmil() != null
						&& castOther.getMetappmil() != null && this
						.getMetappmil().equals(castOther.getMetappmil())))
				&& ((this.getUnivamostraqld() == castOther.getUnivamostraqld()) || (this
						.getUnivamostraqld() != null
						&& castOther.getUnivamostraqld() != null && this
						.getUnivamostraqld().equals(
								castOther.getUnivamostraqld())))
				&& ((this.getTmpsetuppadrao() == castOther.getTmpsetuppadrao()) || (this
						.getTmpsetuppadrao() != null
						&& castOther.getTmpsetuppadrao() != null && this
						.getTmpsetuppadrao().equals(
								castOther.getTmpsetuppadrao())))
				&& ((this.getEfireapadrao() == castOther.getEfireapadrao()) || (this
						.getEfireapadrao() != null
						&& castOther.getEfireapadrao() != null && this
						.getEfireapadrao().equals(castOther.getEfireapadrao())))
				&& ((this.getRelctrlprodefirea() == castOther
						.getRelctrlprodefirea()) || (this
						.getRelctrlprodefirea() != null
						&& castOther.getRelctrlprodefirea() != null && this
						.getRelctrlprodefirea().equals(
								castOther.getRelctrlprodefirea())))
				&& ((this.getRelctrlprodindref() == castOther
						.getRelctrlprodindref()) || (this
						.getRelctrlprodindref() != null
						&& castOther.getRelctrlprodindref() != null && this
						.getRelctrlprodindref().equals(
								castOther.getRelctrlprodindref())))
				&& ((this.getMaxtmpmicroparada() == castOther
						.getMaxtmpmicroparada()) || (this
						.getMaxtmpmicroparada() != null
						&& castOther.getMaxtmpmicroparada() != null && this
						.getMaxtmpmicroparada().equals(
								castOther.getMaxtmpmicroparada())))
				&& ((this.getTpverifconcop() == castOther.getTpverifconcop()) || (this
						.getTpverifconcop() != null
						&& castOther.getTpverifconcop() != null && this
						.getTpverifconcop()
						.equals(castOther.getTpverifconcop())))
				&& ((this.getVlverifconcop() == castOther.getVlverifconcop()) || (this
						.getVlverifconcop() != null
						&& castOther.getVlverifconcop() != null && this
						.getVlverifconcop()
						.equals(castOther.getVlverifconcop())))
				&& ((this.getIdplanta() == castOther.getIdplanta()) || (this
						.getIdplanta() != null
						&& castOther.getIdplanta() != null && this
						.getIdplanta().equals(castOther.getIdplanta())))
				&& ((this.getIdareaproducao() == castOther.getIdareaproducao()) || (this
						.getIdareaproducao() != null
						&& castOther.getIdareaproducao() != null && this
						.getIdareaproducao().equals(
								castOther.getIdareaproducao())))
				&& ((this.getLibaramreqsup() == castOther.getLibaramreqsup()) || (this
						.getLibaramreqsup() != null
						&& castOther.getLibaramreqsup() != null && this
						.getLibaramreqsup()
						.equals(castOther.getLibaramreqsup())))
				&& ((this.getTampulmaopadrao() == castOther
						.getTampulmaopadrao()) || (this.getTampulmaopadrao() != null
						&& castOther.getTampulmaopadrao() != null && this
						.getTampulmaopadrao().equals(
								castOther.getTampulmaopadrao())))
				&& ((this.getTampulmaomax() == castOther.getTampulmaomax()) || (this
						.getTampulmaomax() != null
						&& castOther.getTampulmaomax() != null && this
						.getTampulmaomax().equals(castOther.getTampulmaomax())))
				&& ((this.getTampulmaomin() == castOther.getTampulmaomin()) || (this
						.getTampulmaomin() != null
						&& castOther.getTampulmaomin() != null && this
						.getTampulmaomin().equals(castOther.getTampulmaomin())))
				&& (this.getTmptimeoutcolet() == castOther.getTmptimeoutcolet())
				&& ((this.getTamamostra() == castOther.getTamamostra()) || (this
						.getTamamostra() != null
						&& castOther.getTamamostra() != null && this
						.getTamamostra().equals(castOther.getTamamostra())))
				&& ((this.getColetaamstrporcav() == castOther
						.getColetaamstrporcav()) || (this
						.getColetaamstrporcav() != null
						&& castOther.getColetaamstrporcav() != null && this
						.getColetaamstrporcav().equals(
								castOther.getColetaamstrporcav())))
				&& ((this.getTpespeclimites() == castOther.getTpespeclimites()) || (this
						.getTpespeclimites() != null
						&& castOther.getTpespeclimites() != null && this
						.getTpespeclimites().equals(
								castOther.getTpespeclimites())))
				&& (this.getTpmedinspqld() == castOther.getTpmedinspqld())
				&& (this.getExclistedicaostd() == castOther
						.getExclistedicaostd())
				&& (this.getExibebkgclraleinsp() == castOther
						.getExibebkgclraleinsp())
				&& ((this.getObsdefrelcgq() == castOther.getObsdefrelcgq()) || (this
						.getObsdefrelcgq() != null
						&& castOther.getObsdefrelcgq() != null && this
						.getObsdefrelcgq().equals(castOther.getObsdefrelcgq())))
				&& ((this.getRefamostfespec() == castOther.getRefamostfespec()) || (this
						.getRefamostfespec() != null
						&& castOther.getRefamostfespec() != null && this
						.getRefamostfespec().equals(
								castOther.getRefamostfespec())))
				&& ((this.getCdrfgamostabxespcf() == castOther
						.getCdrfgamostabxespcf()) || (this
						.getCdrfgamostabxespcf() != null
						&& castOther.getCdrfgamostabxespcf() != null && this
						.getCdrfgamostabxespcf().equals(
								castOther.getCdrfgamostabxespcf())))
				&& ((this.getCdrfgamostacmespcf() == castOther
						.getCdrfgamostacmespcf()) || (this
						.getCdrfgamostacmespcf() != null
						&& castOther.getCdrfgamostacmespcf() != null && this
						.getCdrfgamostacmespcf().equals(
								castOther.getCdrfgamostacmespcf())))
				&& ((this.getCtrlaleprobqld() == castOther.getCtrlaleprobqld()) || (this
						.getCtrlaleprobqld() != null
						&& castOther.getCtrlaleprobqld() != null && this
						.getCtrlaleprobqld().equals(
								castOther.getCtrlaleprobqld())))
				&& ((this.getBloqcgqitemforaesp() == castOther
						.getBloqcgqitemforaesp()) || (this
						.getBloqcgqitemforaesp() != null
						&& castOther.getBloqcgqitemforaesp() != null && this
						.getBloqcgqitemforaesp().equals(
								castOther.getBloqcgqitemforaesp())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getQtcicmon();
		result = 37 * result + (int) this.getQtcicarm();
		result = 37
				* result
				+ (getTecontagememuso() == null ? 0 : this.getTecontagememuso()
						.hashCode());
		result = 37
				* result
				+ (getLrefugartodaspecas() == null ? 0 : this
						.getLrefugartodaspecas().hashCode());
		result = 37 * result + (int) this.getHrreferencia();
		result = 37
				* result
				+ (getTempotimeoutescr() == null ? 0 : this
						.getTempotimeoutescr().hashCode());
		result = 37
				* result
				+ (getIndrefmaiorque() == null ? 0 : this.getIndrefmaiorque()
						.hashCode());
		result = 37
				* result
				+ (getPadraomediosetup() == null ? 0 : this
						.getPadraomediosetup().hashCode());
		result = 37
				* result
				+ (getMetaefisetup() == null ? 0 : this.getMetaefisetup()
						.hashCode());
		result = 37
				* result
				+ (getMetaatendimento() == null ? 0 : this.getMetaatendimento()
						.hashCode());
		result = 37
				* result
				+ (getMetautilizacao() == null ? 0 : this.getMetautilizacao()
						.hashCode());
		result = 37
				* result
				+ (getMetaeficiencia() == null ? 0 : this.getMetaeficiencia()
						.hashCode());
		result = 37
				* result
				+ (getMetaprodutividade() == null ? 0 : this
						.getMetaprodutividade().hashCode());
		result = 37 * result
				+ (getMetappmil() == null ? 0 : this.getMetappmil().hashCode());
		result = 37
				* result
				+ (getUnivamostraqld() == null ? 0 : this.getUnivamostraqld()
						.hashCode());
		result = 37
				* result
				+ (getTmpsetuppadrao() == null ? 0 : this.getTmpsetuppadrao()
						.hashCode());
		result = 37
				* result
				+ (getEfireapadrao() == null ? 0 : this.getEfireapadrao()
						.hashCode());
		result = 37
				* result
				+ (getRelctrlprodefirea() == null ? 0 : this
						.getRelctrlprodefirea().hashCode());
		result = 37
				* result
				+ (getRelctrlprodindref() == null ? 0 : this
						.getRelctrlprodindref().hashCode());
		result = 37
				* result
				+ (getMaxtmpmicroparada() == null ? 0 : this
						.getMaxtmpmicroparada().hashCode());
		result = 37
				* result
				+ (getTpverifconcop() == null ? 0 : this.getTpverifconcop()
						.hashCode());
		result = 37
				* result
				+ (getVlverifconcop() == null ? 0 : this.getVlverifconcop()
						.hashCode());
		result = 37 * result
				+ (getIdplanta() == null ? 0 : this.getIdplanta().hashCode());
		result = 37
				* result
				+ (getIdareaproducao() == null ? 0 : this.getIdareaproducao()
						.hashCode());
		result = 37
				* result
				+ (getLibaramreqsup() == null ? 0 : this.getLibaramreqsup()
						.hashCode());
		result = 37
				* result
				+ (getTampulmaopadrao() == null ? 0 : this.getTampulmaopadrao()
						.hashCode());
		result = 37
				* result
				+ (getTampulmaomax() == null ? 0 : this.getTampulmaomax()
						.hashCode());
		result = 37
				* result
				+ (getTampulmaomin() == null ? 0 : this.getTampulmaomin()
						.hashCode());
		result = 37 * result + (int) this.getTmptimeoutcolet();
		result = 37
				* result
				+ (getTamamostra() == null ? 0 : this.getTamamostra()
						.hashCode());
		result = 37
				* result
				+ (getColetaamstrporcav() == null ? 0 : this
						.getColetaamstrporcav().hashCode());
		result = 37
				* result
				+ (getTpespeclimites() == null ? 0 : this.getTpespeclimites()
						.hashCode());
		result = 37 * result + this.getTpmedinspqld();
		result = 37 * result + this.getExclistedicaostd();
		result = 37 * result + this.getExibebkgclraleinsp();
		result = 37
				* result
				+ (getObsdefrelcgq() == null ? 0 : this.getObsdefrelcgq()
						.hashCode());
		result = 37
				* result
				+ (getRefamostfespec() == null ? 0 : this.getRefamostfespec()
						.hashCode());
		result = 37
				* result
				+ (getCdrfgamostabxespcf() == null ? 0 : this
						.getCdrfgamostabxespcf().hashCode());
		result = 37
				* result
				+ (getCdrfgamostacmespcf() == null ? 0 : this
						.getCdrfgamostacmespcf().hashCode());
		result = 37
				* result
				+ (getCtrlaleprobqld() == null ? 0 : this.getCtrlaleprobqld()
						.hashCode());
		result = 37
				* result
				+ (getBloqcgqitemforaesp() == null ? 0 : this
						.getBloqcgqitemforaesp().hashCode());
		return result;
	}

}
