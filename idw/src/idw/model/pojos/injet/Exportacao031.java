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
 * Exportacao031 generated by hbm2java
 */
@Entity
@Table(name = "EXPORTACAO_031")
public class Exportacao031 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8699787830374417945L;
	private String idregistro;
	private String idplanta;
	private String idarea;
	private BigDecimal origem;
	private String nrop;
	private String nropestendido;
	private BigDecimal resqopant;
	private String cdinjetora;
	private String cdinjestendido;
	private String cdproduto;
	private String cdrefugo;
	private double qtdref;
	private double qtdrefcancel;
	private Date dthriniperiodo;
	private Date dthrfimperiodo;
	private String cdoperador;
	private BigDecimal situacao;
	private Date dthrsitexportacao;
	private BigDecimal inicioprocesso;

	public Exportacao031() {
	}

	public Exportacao031(String idregistro, String idplanta, String idarea,
			BigDecimal origem, String nrop, String nropestendido,
			BigDecimal resqopant, String cdinjetora, String cdinjestendido,
			String cdproduto, String cdrefugo, double qtdref,
			double qtdrefcancel, Date dthriniperiodo, BigDecimal situacao,
			Date dthrsitexportacao, BigDecimal inicioprocesso) {
		this.idregistro = idregistro;
		this.idplanta = idplanta;
		this.idarea = idarea;
		this.origem = origem;
		this.nrop = nrop;
		this.nropestendido = nropestendido;
		this.resqopant = resqopant;
		this.cdinjetora = cdinjetora;
		this.cdinjestendido = cdinjestendido;
		this.cdproduto = cdproduto;
		this.cdrefugo = cdrefugo;
		this.qtdref = qtdref;
		this.qtdrefcancel = qtdrefcancel;
		this.dthriniperiodo = dthriniperiodo;
		this.situacao = situacao;
		this.dthrsitexportacao = dthrsitexportacao;
		this.inicioprocesso = inicioprocesso;
	}

	public Exportacao031(String idregistro, String idplanta, String idarea,
			BigDecimal origem, String nrop, String nropestendido,
			BigDecimal resqopant, String cdinjetora, String cdinjestendido,
			String cdproduto, String cdrefugo, double qtdref,
			double qtdrefcancel, Date dthriniperiodo, Date dthrfimperiodo,
			String cdoperador, BigDecimal situacao, Date dthrsitexportacao,
			BigDecimal inicioprocesso) {
		this.idregistro = idregistro;
		this.idplanta = idplanta;
		this.idarea = idarea;
		this.origem = origem;
		this.nrop = nrop;
		this.nropestendido = nropestendido;
		this.resqopant = resqopant;
		this.cdinjetora = cdinjetora;
		this.cdinjestendido = cdinjestendido;
		this.cdproduto = cdproduto;
		this.cdrefugo = cdrefugo;
		this.qtdref = qtdref;
		this.qtdrefcancel = qtdrefcancel;
		this.dthriniperiodo = dthriniperiodo;
		this.dthrfimperiodo = dthrfimperiodo;
		this.cdoperador = cdoperador;
		this.situacao = situacao;
		this.dthrsitexportacao = dthrsitexportacao;
		this.inicioprocesso = inicioprocesso;
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

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "CDREFUGO", nullable = false, length = 6)
	public String getCdrefugo() {
		return this.cdrefugo;
	}

	public void setCdrefugo(String cdrefugo) {
		this.cdrefugo = cdrefugo;
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

	@Column(name = "CDOPERADOR", length = 6)
	public String getCdoperador() {
		return this.cdoperador;
	}

	public void setCdoperador(String cdoperador) {
		this.cdoperador = cdoperador;
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

	@Column(name = "INICIOPROCESSO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getInicioprocesso() {
		return this.inicioprocesso;
	}

	public void setInicioprocesso(BigDecimal inicioprocesso) {
		this.inicioprocesso = inicioprocesso;
	}

}
