package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.UniqueConstraint;

/**
 * Ijamostragemctrl generated by hbm2java
 */
@Entity
@Table(name = "IJAMOSTRAGEMCTRL", uniqueConstraints = @UniqueConstraint(columnNames = {
		"IDINSPECAO", "IDESPECIFIC" }))
public class Ijamostragemctrl implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5973470313631195371L;
	private double idamostctrl;
	private Ijinspecao ijinspecao;
	private String idespecific;
	private Date dthrivalespecific;
	private char tpespecific;
	private char pormedia;
	private Character vlporvariacao;
	private Double vlbase;
	private String cdproduto;
	private String dsproduto;
	private BigDecimal tamamostra;
	private BigDecimal tpentradavlr;
	private String iddriver;
	private Double liperctolerancia;
	private Double lsperctolerancia;
	private Set<Ijamostragemdetctrl> ijamostragemdetctrls = new HashSet<Ijamostragemdetctrl>(
			0);

	public Ijamostragemctrl() {
	}

	public Ijamostragemctrl(double idamostctrl, Ijinspecao ijinspecao,
			String idespecific, Date dthrivalespecific, char tpespecific,
			char pormedia, String cdproduto, String dsproduto) {
		this.idamostctrl = idamostctrl;
		this.ijinspecao = ijinspecao;
		this.idespecific = idespecific;
		this.dthrivalespecific = dthrivalespecific;
		this.tpespecific = tpespecific;
		this.pormedia = pormedia;
		this.cdproduto = cdproduto;
		this.dsproduto = dsproduto;
	}

	public Ijamostragemctrl(double idamostctrl, Ijinspecao ijinspecao,
			String idespecific, Date dthrivalespecific, char tpespecific,
			char pormedia, Character vlporvariacao, Double vlbase,
			String cdproduto, String dsproduto, BigDecimal tamamostra,
			BigDecimal tpentradavlr, String iddriver, Double liperctolerancia,
			Double lsperctolerancia,
			Set<Ijamostragemdetctrl> ijamostragemdetctrls) {
		this.idamostctrl = idamostctrl;
		this.ijinspecao = ijinspecao;
		this.idespecific = idespecific;
		this.dthrivalespecific = dthrivalespecific;
		this.tpespecific = tpespecific;
		this.pormedia = pormedia;
		this.vlporvariacao = vlporvariacao;
		this.vlbase = vlbase;
		this.cdproduto = cdproduto;
		this.dsproduto = dsproduto;
		this.tamamostra = tamamostra;
		this.tpentradavlr = tpentradavlr;
		this.iddriver = iddriver;
		this.liperctolerancia = liperctolerancia;
		this.lsperctolerancia = lsperctolerancia;
		this.ijamostragemdetctrls = ijamostragemdetctrls;
	}

	@Id
	@Column(name = "IDAMOSTCTRL", unique = true, nullable = false, precision = 126, scale = 0)
	public double getIdamostctrl() {
		return this.idamostctrl;
	}

	public void setIdamostctrl(double idamostctrl) {
		this.idamostctrl = idamostctrl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDINSPECAO", nullable = false)
	public Ijinspecao getIjinspecao() {
		return this.ijinspecao;
	}

	public void setIjinspecao(Ijinspecao ijinspecao) {
		this.ijinspecao = ijinspecao;
	}

	@Column(name = "IDESPECIFIC", nullable = false, length = 20)
	public String getIdespecific() {
		return this.idespecific;
	}

	public void setIdespecific(String idespecific) {
		this.idespecific = idespecific;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRIVALESPECIFIC", nullable = false, length = 7)
	public Date getDthrivalespecific() {
		return this.dthrivalespecific;
	}

	public void setDthrivalespecific(Date dthrivalespecific) {
		this.dthrivalespecific = dthrivalespecific;
	}

	@Column(name = "TPESPECIFIC", nullable = false, length = 1)
	public char getTpespecific() {
		return this.tpespecific;
	}

	public void setTpespecific(char tpespecific) {
		this.tpespecific = tpespecific;
	}

	@Column(name = "PORMEDIA", nullable = false, length = 1)
	public char getPormedia() {
		return this.pormedia;
	}

	public void setPormedia(char pormedia) {
		this.pormedia = pormedia;
	}

	@Column(name = "VLPORVARIACAO", length = 1)
	public Character getVlporvariacao() {
		return this.vlporvariacao;
	}

	public void setVlporvariacao(Character vlporvariacao) {
		this.vlporvariacao = vlporvariacao;
	}

	@Column(name = "VLBASE", precision = 126, scale = 0)
	public Double getVlbase() {
		return this.vlbase;
	}

	public void setVlbase(Double vlbase) {
		this.vlbase = vlbase;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "DSPRODUTO", nullable = false, length = 40)
	public String getDsproduto() {
		return this.dsproduto;
	}

	public void setDsproduto(String dsproduto) {
		this.dsproduto = dsproduto;
	}

	@Column(name = "TAMAMOSTRA", precision = 22, scale = 0)
	public BigDecimal getTamamostra() {
		return this.tamamostra;
	}

	public void setTamamostra(BigDecimal tamamostra) {
		this.tamamostra = tamamostra;
	}

	@Column(name = "TPENTRADAVLR", precision = 22, scale = 0)
	public BigDecimal getTpentradavlr() {
		return this.tpentradavlr;
	}

	public void setTpentradavlr(BigDecimal tpentradavlr) {
		this.tpentradavlr = tpentradavlr;
	}

	@Column(name = "IDDRIVER", length = 20)
	public String getIddriver() {
		return this.iddriver;
	}

	public void setIddriver(String iddriver) {
		this.iddriver = iddriver;
	}

	@Column(name = "LIPERCTOLERANCIA", precision = 126, scale = 0)
	public Double getLiperctolerancia() {
		return this.liperctolerancia;
	}

	public void setLiperctolerancia(Double liperctolerancia) {
		this.liperctolerancia = liperctolerancia;
	}

	@Column(name = "LSPERCTOLERANCIA", precision = 126, scale = 0)
	public Double getLsperctolerancia() {
		return this.lsperctolerancia;
	}

	public void setLsperctolerancia(Double lsperctolerancia) {
		this.lsperctolerancia = lsperctolerancia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijamostragemctrl")
	public Set<Ijamostragemdetctrl> getIjamostragemdetctrls() {
		return this.ijamostragemdetctrls;
	}

	public void setIjamostragemdetctrls(
			Set<Ijamostragemdetctrl> ijamostragemdetctrls) {
		this.ijamostragemdetctrls = ijamostragemdetctrls;
	}

}
