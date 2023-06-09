package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Exportacao028 generated by hbm2java
 */
@Entity
@Table(name = "EXPORTACAO_028")
public class Exportacao028 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8375855299192739127L;
	private String idregistro;
	private String idplanta;
	private String idarea;
	private BigDecimal origem;
	private String nrop;
	private String nropestendido;
	private BigDecimal resqopant;
	private BigDecimal exclpar;
	private String nropimp;
	private String cdoperacao;
	private String seqmovto;
	private String cdinjetora;
	private String cdinjestendido;
	private Date dthriniperiodo;
	private Date dthrfimperiodo;
	private String cdproduto;
	private double qtdprod;
	private double qtdref;
	private double qtdrefcancel;
	private double tempoliquido;
	private double tempoparada;
	private BigDecimal fimproducao;
	private String cdoperador;
	private BigDecimal nrmaoobra;
	private BigDecimal situacao;
	private Date dthrsitexportacao;

	public Exportacao028() {
	}

	public Exportacao028(String idregistro, String idplanta, String idarea,
			BigDecimal origem, String nrop, String nropestendido,
			BigDecimal resqopant, BigDecimal exclpar, String nropimp,
			String cdoperacao, String seqmovto, String cdinjetora,
			String cdinjestendido, Date dthriniperiodo, String cdproduto,
			double qtdprod, double qtdref, double qtdrefcancel,
			double tempoliquido, double tempoparada, BigDecimal fimproducao,
			BigDecimal situacao, Date dthrsitexportacao) {
		this.idregistro = idregistro;
		this.idplanta = idplanta;
		this.idarea = idarea;
		this.origem = origem;
		this.nrop = nrop;
		this.nropestendido = nropestendido;
		this.resqopant = resqopant;
		this.exclpar = exclpar;
		this.nropimp = nropimp;
		this.cdoperacao = cdoperacao;
		this.seqmovto = seqmovto;
		this.cdinjetora = cdinjetora;
		this.cdinjestendido = cdinjestendido;
		this.dthriniperiodo = dthriniperiodo;
		this.cdproduto = cdproduto;
		this.qtdprod = qtdprod;
		this.qtdref = qtdref;
		this.qtdrefcancel = qtdrefcancel;
		this.tempoliquido = tempoliquido;
		this.tempoparada = tempoparada;
		this.fimproducao = fimproducao;
		this.situacao = situacao;
		this.dthrsitexportacao = dthrsitexportacao;
	}

	public Exportacao028(String idregistro, String idplanta, String idarea,
			BigDecimal origem, String nrop, String nropestendido,
			BigDecimal resqopant, BigDecimal exclpar, String nropimp,
			String cdoperacao, String seqmovto, String cdinjetora,
			String cdinjestendido, Date dthriniperiodo, Date dthrfimperiodo,
			String cdproduto, double qtdprod, double qtdref,
			double qtdrefcancel, double tempoliquido, double tempoparada,
			BigDecimal fimproducao, String cdoperador, BigDecimal nrmaoobra,
			BigDecimal situacao, Date dthrsitexportacao) {
		this.idregistro = idregistro;
		this.idplanta = idplanta;
		this.idarea = idarea;
		this.origem = origem;
		this.nrop = nrop;
		this.nropestendido = nropestendido;
		this.resqopant = resqopant;
		this.exclpar = exclpar;
		this.nropimp = nropimp;
		this.cdoperacao = cdoperacao;
		this.seqmovto = seqmovto;
		this.cdinjetora = cdinjetora;
		this.cdinjestendido = cdinjestendido;
		this.dthriniperiodo = dthriniperiodo;
		this.dthrfimperiodo = dthrfimperiodo;
		this.cdproduto = cdproduto;
		this.qtdprod = qtdprod;
		this.qtdref = qtdref;
		this.qtdrefcancel = qtdrefcancel;
		this.tempoliquido = tempoliquido;
		this.tempoparada = tempoparada;
		this.fimproducao = fimproducao;
		this.cdoperador = cdoperador;
		this.nrmaoobra = nrmaoobra;
		this.situacao = situacao;
		this.dthrsitexportacao = dthrsitexportacao;
	}

	@Id
	@Column(name = "IDREGISTRO", unique = true, nullable = false, length = 15)
	public String getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(String idregistro) {
		this.idregistro = idregistro;
	}

	@Column(name = "IDPLANTA", nullable = false, length = 10)
	public String getIdplanta() {
		return this.idplanta;
	}

	public void setIdplanta(String idplanta) {
		this.idplanta = idplanta;
	}

	@Column(name = "IDAREA", nullable = false, length = 10)
	public String getIdarea() {
		return this.idarea;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	@Column(name = "ORIGEM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOrigem() {
		return this.origem;
	}

	public void setOrigem(BigDecimal origem) {
		this.origem = origem;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "NROPESTENDIDO", nullable = false, length = 25)
	public String getNropestendido() {
		return this.nropestendido;
	}

	public void setNropestendido(String nropestendido) {
		this.nropestendido = nropestendido;
	}

	@Column(name = "RESQOPANT", nullable = false, precision = 22, scale = 0)
	public BigDecimal getResqopant() {
		return this.resqopant;
	}

	public void setResqopant(BigDecimal resqopant) {
		this.resqopant = resqopant;
	}

	@Column(name = "EXCLPAR", nullable = false, precision = 22, scale = 0)
	public BigDecimal getExclpar() {
		return this.exclpar;
	}

	public void setExclpar(BigDecimal exclpar) {
		this.exclpar = exclpar;
	}

	@Column(name = "NROPIMP", nullable = false, length = 10)
	public String getNropimp() {
		return this.nropimp;
	}

	public void setNropimp(String nropimp) {
		this.nropimp = nropimp;
	}

	@Column(name = "CDOPERACAO", nullable = false, length = 6)
	public String getCdoperacao() {
		return this.cdoperacao;
	}

	public void setCdoperacao(String cdoperacao) {
		this.cdoperacao = cdoperacao;
	}

	@Column(name = "SEQMOVTO", nullable = false, length = 4)
	public String getSeqmovto() {
		return this.seqmovto;
	}

	public void setSeqmovto(String seqmovto) {
		this.seqmovto = seqmovto;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDINJESTENDIDO", nullable = false, length = 8)
	public String getCdinjestendido() {
		return this.cdinjestendido;
	}

	public void setCdinjestendido(String cdinjestendido) {
		this.cdinjestendido = cdinjestendido;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRINIPERIODO", nullable = false, length = 7)
	public Date getDthriniperiodo() {
		return this.dthriniperiodo;
	}

	public void setDthriniperiodo(Date dthriniperiodo) {
		this.dthriniperiodo = dthriniperiodo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFIMPERIODO", length = 7)
	public Date getDthrfimperiodo() {
		return this.dthrfimperiodo;
	}

	public void setDthrfimperiodo(Date dthrfimperiodo) {
		this.dthrfimperiodo = dthrfimperiodo;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "QTDPROD", nullable = false, precision = 126, scale = 0)
	public double getQtdprod() {
		return this.qtdprod;
	}

	public void setQtdprod(double qtdprod) {
		this.qtdprod = qtdprod;
	}

	@Column(name = "QTDREF", nullable = false, precision = 126, scale = 0)
	public double getQtdref() {
		return this.qtdref;
	}

	public void setQtdref(double qtdref) {
		this.qtdref = qtdref;
	}

	@Column(name = "QTDREFCANCEL", nullable = false, precision = 126, scale = 0)
	public double getQtdrefcancel() {
		return this.qtdrefcancel;
	}

	public void setQtdrefcancel(double qtdrefcancel) {
		this.qtdrefcancel = qtdrefcancel;
	}

	@Column(name = "TEMPOLIQUIDO", nullable = false, precision = 126, scale = 0)
	public double getTempoliquido() {
		return this.tempoliquido;
	}

	public void setTempoliquido(double tempoliquido) {
		this.tempoliquido = tempoliquido;
	}

	@Column(name = "TEMPOPARADA", nullable = false, precision = 126, scale = 0)
	public double getTempoparada() {
		return this.tempoparada;
	}

	public void setTempoparada(double tempoparada) {
		this.tempoparada = tempoparada;
	}

	@Column(name = "FIMPRODUCAO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getFimproducao() {
		return this.fimproducao;
	}

	public void setFimproducao(BigDecimal fimproducao) {
		this.fimproducao = fimproducao;
	}

	@Column(name = "CDOPERADOR", length = 6)
	public String getCdoperador() {
		return this.cdoperador;
	}

	public void setCdoperador(String cdoperador) {
		this.cdoperador = cdoperador;
	}

	@Column(name = "NRMAOOBRA", precision = 22, scale = 0)
	public BigDecimal getNrmaoobra() {
		return this.nrmaoobra;
	}

	public void setNrmaoobra(BigDecimal nrmaoobra) {
		this.nrmaoobra = nrmaoobra;
	}

	@Column(name = "SITUACAO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getSituacao() {
		return this.situacao;
	}

	public void setSituacao(BigDecimal situacao) {
		this.situacao = situacao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRSITEXPORTACAO", nullable = false, length = 7)
	public Date getDthrsitexportacao() {
		return this.dthrsitexportacao;
	}

	public void setDthrsitexportacao(Date dthrsitexportacao) {
		this.dthrsitexportacao = dthrsitexportacao;
	}

}
