package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbmollogId generated by hbm2java
 */
@Embeddable
public class IjtbmollogId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5997339061604733077L;
	private String cdmolde;
	private String cdcliente;
	private String cdorigem;
	private String cdfabricante;
	private String cdglobal;
	private String localizacao;
	private Date dtcompra;
	private Date dtchegada;
	private Date dtinstalacao;
	private Date dtsaida;
	private Double altura;
	private Double profundidade;
	private Double largura;
	private String tpextracao;
	private BigDecimal qtinjreset;
	private String tpentrada;
	private BigDecimal qtinjman;
	private String tpinjecao;
	private String pistoes;
	private BigDecimal qtinjecoes;
	private double qtcavidades;
	private double qtcavativas;
	private String dsmolde;
	private Double freqmanutprev;
	private Character tpvalconflitoplng;
	private String cdmaqpreferencial;
	private Character stagrup;
	private Double qtciclosexecutados;
	private String cdoperacao;
	private BigDecimal qtoperadores;
	private String cdmolestendido;
	private double vidautil;
	private double percalevidautil;
	private double qttotcicexec;
	private Date dthrmanut;
	private char tpmanut;
	private String cdusuresp;

	public IjtbmollogId() {
	}

	public IjtbmollogId(String cdmolde, String cdcliente, String cdorigem,
			String cdfabricante, double qtcavidades, double qtcavativas,
			BigDecimal qtoperadores, String cdmolestendido, double vidautil,
			double percalevidautil, double qttotcicexec, Date dthrmanut,
			char tpmanut, String cdusuresp) {
		this.cdmolde = cdmolde;
		this.cdcliente = cdcliente;
		this.cdorigem = cdorigem;
		this.cdfabricante = cdfabricante;
		this.qtcavidades = qtcavidades;
		this.qtcavativas = qtcavativas;
		this.qtoperadores = qtoperadores;
		this.cdmolestendido = cdmolestendido;
		this.vidautil = vidautil;
		this.percalevidautil = percalevidautil;
		this.qttotcicexec = qttotcicexec;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	public IjtbmollogId(String cdmolde, String cdcliente, String cdorigem,
			String cdfabricante, String cdglobal, String localizacao,
			Date dtcompra, Date dtchegada, Date dtinstalacao, Date dtsaida,
			Double altura, Double profundidade, Double largura,
			String tpextracao, BigDecimal qtinjreset, String tpentrada,
			BigDecimal qtinjman, String tpinjecao, String pistoes,
			BigDecimal qtinjecoes, double qtcavidades, double qtcavativas,
			String dsmolde, Double freqmanutprev, Character tpvalconflitoplng,
			String cdmaqpreferencial, Character stagrup,
			Double qtciclosexecutados, String cdoperacao,
			BigDecimal qtoperadores, String cdmolestendido, double vidautil,
			double percalevidautil, double qttotcicexec, Date dthrmanut,
			char tpmanut, String cdusuresp) {
		this.cdmolde = cdmolde;
		this.cdcliente = cdcliente;
		this.cdorigem = cdorigem;
		this.cdfabricante = cdfabricante;
		this.cdglobal = cdglobal;
		this.localizacao = localizacao;
		this.dtcompra = dtcompra;
		this.dtchegada = dtchegada;
		this.dtinstalacao = dtinstalacao;
		this.dtsaida = dtsaida;
		this.altura = altura;
		this.profundidade = profundidade;
		this.largura = largura;
		this.tpextracao = tpextracao;
		this.qtinjreset = qtinjreset;
		this.tpentrada = tpentrada;
		this.qtinjman = qtinjman;
		this.tpinjecao = tpinjecao;
		this.pistoes = pistoes;
		this.qtinjecoes = qtinjecoes;
		this.qtcavidades = qtcavidades;
		this.qtcavativas = qtcavativas;
		this.dsmolde = dsmolde;
		this.freqmanutprev = freqmanutprev;
		this.tpvalconflitoplng = tpvalconflitoplng;
		this.cdmaqpreferencial = cdmaqpreferencial;
		this.stagrup = stagrup;
		this.qtciclosexecutados = qtciclosexecutados;
		this.cdoperacao = cdoperacao;
		this.qtoperadores = qtoperadores;
		this.cdmolestendido = cdmolestendido;
		this.vidautil = vidautil;
		this.percalevidautil = percalevidautil;
		this.qttotcicexec = qttotcicexec;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	@Column(name = "CDMOLDE", nullable = false, length = 6)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Column(name = "CDCLIENTE", nullable = false, length = 6)
	public String getCdcliente() {
		return this.cdcliente;
	}

	public void setCdcliente(String cdcliente) {
		this.cdcliente = cdcliente;
	}

	@Column(name = "CDORIGEM", nullable = false, length = 6)
	public String getCdorigem() {
		return this.cdorigem;
	}

	public void setCdorigem(String cdorigem) {
		this.cdorigem = cdorigem;
	}

	@Column(name = "CDFABRICANTE", nullable = false, length = 6)
	public String getCdfabricante() {
		return this.cdfabricante;
	}

	public void setCdfabricante(String cdfabricante) {
		this.cdfabricante = cdfabricante;
	}

	@Column(name = "CDGLOBAL", length = 20)
	public String getCdglobal() {
		return this.cdglobal;
	}

	public void setCdglobal(String cdglobal) {
		this.cdglobal = cdglobal;
	}

	@Column(name = "LOCALIZACAO", length = 20)
	public String getLocalizacao() {
		return this.localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	@Column(name = "DTCOMPRA", length = 7)
	public Date getDtcompra() {
		return this.dtcompra;
	}

	public void setDtcompra(Date dtcompra) {
		this.dtcompra = dtcompra;
	}

	@Column(name = "DTCHEGADA", length = 7)
	public Date getDtchegada() {
		return this.dtchegada;
	}

	public void setDtchegada(Date dtchegada) {
		this.dtchegada = dtchegada;
	}

	@Column(name = "DTINSTALACAO", length = 7)
	public Date getDtinstalacao() {
		return this.dtinstalacao;
	}

	public void setDtinstalacao(Date dtinstalacao) {
		this.dtinstalacao = dtinstalacao;
	}

	@Column(name = "DTSAIDA", length = 7)
	public Date getDtsaida() {
		return this.dtsaida;
	}

	public void setDtsaida(Date dtsaida) {
		this.dtsaida = dtsaida;
	}

	@Column(name = "ALTURA", precision = 126, scale = 0)
	public Double getAltura() {
		return this.altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Column(name = "PROFUNDIDADE", precision = 126, scale = 0)
	public Double getProfundidade() {
		return this.profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}

	@Column(name = "LARGURA", precision = 126, scale = 0)
	public Double getLargura() {
		return this.largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	@Column(name = "TPEXTRACAO", length = 20)
	public String getTpextracao() {
		return this.tpextracao;
	}

	public void setTpextracao(String tpextracao) {
		this.tpextracao = tpextracao;
	}

	@Column(name = "QTINJRESET", precision = 22, scale = 0)
	public BigDecimal getQtinjreset() {
		return this.qtinjreset;
	}

	public void setQtinjreset(BigDecimal qtinjreset) {
		this.qtinjreset = qtinjreset;
	}

	@Column(name = "TPENTRADA", length = 20)
	public String getTpentrada() {
		return this.tpentrada;
	}

	public void setTpentrada(String tpentrada) {
		this.tpentrada = tpentrada;
	}

	@Column(name = "QTINJMAN", precision = 22, scale = 0)
	public BigDecimal getQtinjman() {
		return this.qtinjman;
	}

	public void setQtinjman(BigDecimal qtinjman) {
		this.qtinjman = qtinjman;
	}

	@Column(name = "TPINJECAO", length = 20)
	public String getTpinjecao() {
		return this.tpinjecao;
	}

	public void setTpinjecao(String tpinjecao) {
		this.tpinjecao = tpinjecao;
	}

	@Column(name = "PISTOES", length = 20)
	public String getPistoes() {
		return this.pistoes;
	}

	public void setPistoes(String pistoes) {
		this.pistoes = pistoes;
	}

	@Column(name = "QTINJECOES", precision = 22, scale = 0)
	public BigDecimal getQtinjecoes() {
		return this.qtinjecoes;
	}

	public void setQtinjecoes(BigDecimal qtinjecoes) {
		this.qtinjecoes = qtinjecoes;
	}

	@Column(name = "QTCAVIDADES", nullable = false, precision = 126, scale = 0)
	public double getQtcavidades() {
		return this.qtcavidades;
	}

	public void setQtcavidades(double qtcavidades) {
		this.qtcavidades = qtcavidades;
	}

	@Column(name = "QTCAVATIVAS", nullable = false, precision = 126, scale = 0)
	public double getQtcavativas() {
		return this.qtcavativas;
	}

	public void setQtcavativas(double qtcavativas) {
		this.qtcavativas = qtcavativas;
	}

	@Column(name = "DSMOLDE", length = 30)
	public String getDsmolde() {
		return this.dsmolde;
	}

	public void setDsmolde(String dsmolde) {
		this.dsmolde = dsmolde;
	}

	@Column(name = "FREQMANUTPREV", precision = 126, scale = 0)
	public Double getFreqmanutprev() {
		return this.freqmanutprev;
	}

	public void setFreqmanutprev(Double freqmanutprev) {
		this.freqmanutprev = freqmanutprev;
	}

	@Column(name = "TPVALCONFLITOPLNG", length = 1)
	public Character getTpvalconflitoplng() {
		return this.tpvalconflitoplng;
	}

	public void setTpvalconflitoplng(Character tpvalconflitoplng) {
		this.tpvalconflitoplng = tpvalconflitoplng;
	}

	@Column(name = "CDMAQPREFERENCIAL", length = 6)
	public String getCdmaqpreferencial() {
		return this.cdmaqpreferencial;
	}

	public void setCdmaqpreferencial(String cdmaqpreferencial) {
		this.cdmaqpreferencial = cdmaqpreferencial;
	}

	@Column(name = "STAGRUP", length = 1)
	public Character getStagrup() {
		return this.stagrup;
	}

	public void setStagrup(Character stagrup) {
		this.stagrup = stagrup;
	}

	@Column(name = "QTCICLOSEXECUTADOS", precision = 126, scale = 0)
	public Double getQtciclosexecutados() {
		return this.qtciclosexecutados;
	}

	public void setQtciclosexecutados(Double qtciclosexecutados) {
		this.qtciclosexecutados = qtciclosexecutados;
	}

	@Column(name = "CDOPERACAO", length = 6)
	public String getCdoperacao() {
		return this.cdoperacao;
	}

	public void setCdoperacao(String cdoperacao) {
		this.cdoperacao = cdoperacao;
	}

	@Column(name = "QTOPERADORES", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtoperadores() {
		return this.qtoperadores;
	}

	public void setQtoperadores(BigDecimal qtoperadores) {
		this.qtoperadores = qtoperadores;
	}

	@Column(name = "CDMOLESTENDIDO", nullable = false, length = 18)
	public String getCdmolestendido() {
		return this.cdmolestendido;
	}

	public void setCdmolestendido(String cdmolestendido) {
		this.cdmolestendido = cdmolestendido;
	}

	@Column(name = "VIDAUTIL", nullable = false, precision = 126, scale = 0)
	public double getVidautil() {
		return this.vidautil;
	}

	public void setVidautil(double vidautil) {
		this.vidautil = vidautil;
	}

	@Column(name = "PERCALEVIDAUTIL", nullable = false, precision = 126, scale = 0)
	public double getPercalevidautil() {
		return this.percalevidautil;
	}

	public void setPercalevidautil(double percalevidautil) {
		this.percalevidautil = percalevidautil;
	}

	@Column(name = "QTTOTCICEXEC", nullable = false, precision = 126, scale = 0)
	public double getQttotcicexec() {
		return this.qttotcicexec;
	}

	public void setQttotcicexec(double qttotcicexec) {
		this.qttotcicexec = qttotcicexec;
	}

	@Column(name = "DTHRMANUT", nullable = false, length = 7)
	public Date getDthrmanut() {
		return this.dthrmanut;
	}

	public void setDthrmanut(Date dthrmanut) {
		this.dthrmanut = dthrmanut;
	}

	@Column(name = "TPMANUT", nullable = false, length = 1)
	public char getTpmanut() {
		return this.tpmanut;
	}

	public void setTpmanut(char tpmanut) {
		this.tpmanut = tpmanut;
	}

	@Column(name = "CDUSURESP", nullable = false, length = 6)
	public String getCdusuresp() {
		return this.cdusuresp;
	}

	public void setCdusuresp(String cdusuresp) {
		this.cdusuresp = cdusuresp;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjtbmollogId))
			return false;
		IjtbmollogId castOther = (IjtbmollogId) other;

		return ((this.getCdmolde() == castOther.getCdmolde()) || (this
				.getCdmolde() != null && castOther.getCdmolde() != null && this
				.getCdmolde().equals(castOther.getCdmolde())))
				&& ((this.getCdcliente() == castOther.getCdcliente()) || (this
						.getCdcliente() != null
						&& castOther.getCdcliente() != null && this
						.getCdcliente().equals(castOther.getCdcliente())))
				&& ((this.getCdorigem() == castOther.getCdorigem()) || (this
						.getCdorigem() != null
						&& castOther.getCdorigem() != null && this
						.getCdorigem().equals(castOther.getCdorigem())))
				&& ((this.getCdfabricante() == castOther.getCdfabricante()) || (this
						.getCdfabricante() != null
						&& castOther.getCdfabricante() != null && this
						.getCdfabricante().equals(castOther.getCdfabricante())))
				&& ((this.getCdglobal() == castOther.getCdglobal()) || (this
						.getCdglobal() != null
						&& castOther.getCdglobal() != null && this
						.getCdglobal().equals(castOther.getCdglobal())))
				&& ((this.getLocalizacao() == castOther.getLocalizacao()) || (this
						.getLocalizacao() != null
						&& castOther.getLocalizacao() != null && this
						.getLocalizacao().equals(castOther.getLocalizacao())))
				&& ((this.getDtcompra() == castOther.getDtcompra()) || (this
						.getDtcompra() != null
						&& castOther.getDtcompra() != null && this
						.getDtcompra().equals(castOther.getDtcompra())))
				&& ((this.getDtchegada() == castOther.getDtchegada()) || (this
						.getDtchegada() != null
						&& castOther.getDtchegada() != null && this
						.getDtchegada().equals(castOther.getDtchegada())))
				&& ((this.getDtinstalacao() == castOther.getDtinstalacao()) || (this
						.getDtinstalacao() != null
						&& castOther.getDtinstalacao() != null && this
						.getDtinstalacao().equals(castOther.getDtinstalacao())))
				&& ((this.getDtsaida() == castOther.getDtsaida()) || (this
						.getDtsaida() != null && castOther.getDtsaida() != null && this
						.getDtsaida().equals(castOther.getDtsaida())))
				&& ((this.getAltura() == castOther.getAltura()) || (this
						.getAltura() != null && castOther.getAltura() != null && this
						.getAltura().equals(castOther.getAltura())))
				&& ((this.getProfundidade() == castOther.getProfundidade()) || (this
						.getProfundidade() != null
						&& castOther.getProfundidade() != null && this
						.getProfundidade().equals(castOther.getProfundidade())))
				&& ((this.getLargura() == castOther.getLargura()) || (this
						.getLargura() != null && castOther.getLargura() != null && this
						.getLargura().equals(castOther.getLargura())))
				&& ((this.getTpextracao() == castOther.getTpextracao()) || (this
						.getTpextracao() != null
						&& castOther.getTpextracao() != null && this
						.getTpextracao().equals(castOther.getTpextracao())))
				&& ((this.getQtinjreset() == castOther.getQtinjreset()) || (this
						.getQtinjreset() != null
						&& castOther.getQtinjreset() != null && this
						.getQtinjreset().equals(castOther.getQtinjreset())))
				&& ((this.getTpentrada() == castOther.getTpentrada()) || (this
						.getTpentrada() != null
						&& castOther.getTpentrada() != null && this
						.getTpentrada().equals(castOther.getTpentrada())))
				&& ((this.getQtinjman() == castOther.getQtinjman()) || (this
						.getQtinjman() != null
						&& castOther.getQtinjman() != null && this
						.getQtinjman().equals(castOther.getQtinjman())))
				&& ((this.getTpinjecao() == castOther.getTpinjecao()) || (this
						.getTpinjecao() != null
						&& castOther.getTpinjecao() != null && this
						.getTpinjecao().equals(castOther.getTpinjecao())))
				&& ((this.getPistoes() == castOther.getPistoes()) || (this
						.getPistoes() != null && castOther.getPistoes() != null && this
						.getPistoes().equals(castOther.getPistoes())))
				&& ((this.getQtinjecoes() == castOther.getQtinjecoes()) || (this
						.getQtinjecoes() != null
						&& castOther.getQtinjecoes() != null && this
						.getQtinjecoes().equals(castOther.getQtinjecoes())))
				&& (this.getQtcavidades() == castOther.getQtcavidades())
				&& (this.getQtcavativas() == castOther.getQtcavativas())
				&& ((this.getDsmolde() == castOther.getDsmolde()) || (this
						.getDsmolde() != null && castOther.getDsmolde() != null && this
						.getDsmolde().equals(castOther.getDsmolde())))
				&& ((this.getFreqmanutprev() == castOther.getFreqmanutprev()) || (this
						.getFreqmanutprev() != null
						&& castOther.getFreqmanutprev() != null && this
						.getFreqmanutprev()
						.equals(castOther.getFreqmanutprev())))
				&& ((this.getTpvalconflitoplng() == castOther
						.getTpvalconflitoplng()) || (this
						.getTpvalconflitoplng() != null
						&& castOther.getTpvalconflitoplng() != null && this
						.getTpvalconflitoplng().equals(
								castOther.getTpvalconflitoplng())))
				&& ((this.getCdmaqpreferencial() == castOther
						.getCdmaqpreferencial()) || (this
						.getCdmaqpreferencial() != null
						&& castOther.getCdmaqpreferencial() != null && this
						.getCdmaqpreferencial().equals(
								castOther.getCdmaqpreferencial())))
				&& ((this.getStagrup() == castOther.getStagrup()) || (this
						.getStagrup() != null && castOther.getStagrup() != null && this
						.getStagrup().equals(castOther.getStagrup())))
				&& ((this.getQtciclosexecutados() == castOther
						.getQtciclosexecutados()) || (this
						.getQtciclosexecutados() != null
						&& castOther.getQtciclosexecutados() != null && this
						.getQtciclosexecutados().equals(
								castOther.getQtciclosexecutados())))
				&& ((this.getCdoperacao() == castOther.getCdoperacao()) || (this
						.getCdoperacao() != null
						&& castOther.getCdoperacao() != null && this
						.getCdoperacao().equals(castOther.getCdoperacao())))
				&& ((this.getQtoperadores() == castOther.getQtoperadores()) || (this
						.getQtoperadores() != null
						&& castOther.getQtoperadores() != null && this
						.getQtoperadores().equals(castOther.getQtoperadores())))
				&& ((this.getCdmolestendido() == castOther.getCdmolestendido()) || (this
						.getCdmolestendido() != null
						&& castOther.getCdmolestendido() != null && this
						.getCdmolestendido().equals(
								castOther.getCdmolestendido())))
				&& (this.getVidautil() == castOther.getVidautil())
				&& (this.getPercalevidautil() == castOther.getPercalevidautil())
				&& (this.getQttotcicexec() == castOther.getQttotcicexec())
				&& ((this.getDthrmanut() == castOther.getDthrmanut()) || (this
						.getDthrmanut() != null
						&& castOther.getDthrmanut() != null && this
						.getDthrmanut().equals(castOther.getDthrmanut())))
				&& (this.getTpmanut() == castOther.getTpmanut())
				&& ((this.getCdusuresp() == castOther.getCdusuresp()) || (this
						.getCdusuresp() != null
						&& castOther.getCdusuresp() != null && this
						.getCdusuresp().equals(castOther.getCdusuresp())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdmolde() == null ? 0 : this.getCdmolde().hashCode());
		result = 37 * result
				+ (getCdcliente() == null ? 0 : this.getCdcliente().hashCode());
		result = 37 * result
				+ (getCdorigem() == null ? 0 : this.getCdorigem().hashCode());
		result = 37
				* result
				+ (getCdfabricante() == null ? 0 : this.getCdfabricante()
						.hashCode());
		result = 37 * result
				+ (getCdglobal() == null ? 0 : this.getCdglobal().hashCode());
		result = 37
				* result
				+ (getLocalizacao() == null ? 0 : this.getLocalizacao()
						.hashCode());
		result = 37 * result
				+ (getDtcompra() == null ? 0 : this.getDtcompra().hashCode());
		result = 37 * result
				+ (getDtchegada() == null ? 0 : this.getDtchegada().hashCode());
		result = 37
				* result
				+ (getDtinstalacao() == null ? 0 : this.getDtinstalacao()
						.hashCode());
		result = 37 * result
				+ (getDtsaida() == null ? 0 : this.getDtsaida().hashCode());
		result = 37 * result
				+ (getAltura() == null ? 0 : this.getAltura().hashCode());
		result = 37
				* result
				+ (getProfundidade() == null ? 0 : this.getProfundidade()
						.hashCode());
		result = 37 * result
				+ (getLargura() == null ? 0 : this.getLargura().hashCode());
		result = 37
				* result
				+ (getTpextracao() == null ? 0 : this.getTpextracao()
						.hashCode());
		result = 37
				* result
				+ (getQtinjreset() == null ? 0 : this.getQtinjreset()
						.hashCode());
		result = 37 * result
				+ (getTpentrada() == null ? 0 : this.getTpentrada().hashCode());
		result = 37 * result
				+ (getQtinjman() == null ? 0 : this.getQtinjman().hashCode());
		result = 37 * result
				+ (getTpinjecao() == null ? 0 : this.getTpinjecao().hashCode());
		result = 37 * result
				+ (getPistoes() == null ? 0 : this.getPistoes().hashCode());
		result = 37
				* result
				+ (getQtinjecoes() == null ? 0 : this.getQtinjecoes()
						.hashCode());
		result = 37 * result + (int) this.getQtcavidades();
		result = 37 * result + (int) this.getQtcavativas();
		result = 37 * result
				+ (getDsmolde() == null ? 0 : this.getDsmolde().hashCode());
		result = 37
				* result
				+ (getFreqmanutprev() == null ? 0 : this.getFreqmanutprev()
						.hashCode());
		result = 37
				* result
				+ (getTpvalconflitoplng() == null ? 0 : this
						.getTpvalconflitoplng().hashCode());
		result = 37
				* result
				+ (getCdmaqpreferencial() == null ? 0 : this
						.getCdmaqpreferencial().hashCode());
		result = 37 * result
				+ (getStagrup() == null ? 0 : this.getStagrup().hashCode());
		result = 37
				* result
				+ (getQtciclosexecutados() == null ? 0 : this
						.getQtciclosexecutados().hashCode());
		result = 37
				* result
				+ (getCdoperacao() == null ? 0 : this.getCdoperacao()
						.hashCode());
		result = 37
				* result
				+ (getQtoperadores() == null ? 0 : this.getQtoperadores()
						.hashCode());
		result = 37
				* result
				+ (getCdmolestendido() == null ? 0 : this.getCdmolestendido()
						.hashCode());
		result = 37 * result + (int) this.getVidautil();
		result = 37 * result + (int) this.getPercalevidautil();
		result = 37 * result + (int) this.getQttotcicexec();
		result = 37 * result
				+ (getDthrmanut() == null ? 0 : this.getDthrmanut().hashCode());
		result = 37 * result + this.getTpmanut();
		result = 37 * result
				+ (getCdusuresp() == null ? 0 : this.getCdusuresp().hashCode());
		return result;
	}

}
