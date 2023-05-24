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

/**
 * Ijkanbanlote generated by hbm2java
 */
@Entity
@Table(name = "IJKANBANLOTE")
public class Ijkanbanlote implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2881035341394740027L;
	private String nrlotekanban;
	private Ijop ijop;
	private Ijtbinj ijtbinj;
	private Ijtbpro ijtbpro;
	private Ijtbmol ijtbmol;
	private Date dthraberturalote;
	private Date dthrfechamentolote;
	private BigDecimal qtcartoeslote;
	private BigDecimal qtcartoesfechados;
	private char sitlote;
	private Date dthrsitlote;
	private String cdestrutura;
	private BigDecimal tamlotekanban;
	private Double perclotekanban;
	private Set<Ijkanbancartoes> ijkanbancartoeses = new HashSet<Ijkanbancartoes>(
			0);
	private Set<Ijkanbanidcartao> ijkanbanidcartaos = new HashSet<Ijkanbanidcartao>(
			0);

	public Ijkanbanlote() {
	}

	public Ijkanbanlote(String nrlotekanban, Ijtbpro ijtbpro, Ijtbmol ijtbmol,
			Date dthraberturalote, BigDecimal qtcartoeslote,
			BigDecimal qtcartoesfechados, char sitlote, Date dthrsitlote) {
		this.nrlotekanban = nrlotekanban;
		this.ijtbpro = ijtbpro;
		this.ijtbmol = ijtbmol;
		this.dthraberturalote = dthraberturalote;
		this.qtcartoeslote = qtcartoeslote;
		this.qtcartoesfechados = qtcartoesfechados;
		this.sitlote = sitlote;
		this.dthrsitlote = dthrsitlote;
	}

	public Ijkanbanlote(String nrlotekanban, Ijop ijop, Ijtbinj ijtbinj,
			Ijtbpro ijtbpro, Ijtbmol ijtbmol, Date dthraberturalote,
			Date dthrfechamentolote, BigDecimal qtcartoeslote,
			BigDecimal qtcartoesfechados, char sitlote, Date dthrsitlote,
			String cdestrutura, BigDecimal tamlotekanban,
			Double perclotekanban, Set<Ijkanbancartoes> ijkanbancartoeses,
			Set<Ijkanbanidcartao> ijkanbanidcartaos) {
		this.nrlotekanban = nrlotekanban;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.ijtbpro = ijtbpro;
		this.ijtbmol = ijtbmol;
		this.dthraberturalote = dthraberturalote;
		this.dthrfechamentolote = dthrfechamentolote;
		this.qtcartoeslote = qtcartoeslote;
		this.qtcartoesfechados = qtcartoesfechados;
		this.sitlote = sitlote;
		this.dthrsitlote = dthrsitlote;
		this.cdestrutura = cdestrutura;
		this.tamlotekanban = tamlotekanban;
		this.perclotekanban = perclotekanban;
		this.ijkanbancartoeses = ijkanbancartoeses;
		this.ijkanbanidcartaos = ijkanbanidcartaos;
	}

	@Id
	@Column(name = "NRLOTEKANBAN", unique = true, nullable = false, length = 12)
	public String getNrlotekanban() {
		return this.nrlotekanban;
	}

	public void setNrlotekanban(String nrlotekanban) {
		this.nrlotekanban = nrlotekanban;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROP")
	public Ijop getIjop() {
		return this.ijop;
	}

	public void setIjop(Ijop ijop) {
		this.ijop = ijop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA")
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDPRODUTO", nullable = false)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDMOLDE", nullable = false)
	public Ijtbmol getIjtbmol() {
		return this.ijtbmol;
	}

	public void setIjtbmol(Ijtbmol ijtbmol) {
		this.ijtbmol = ijtbmol;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRABERTURALOTE", nullable = false, length = 7)
	public Date getDthraberturalote() {
		return this.dthraberturalote;
	}

	public void setDthraberturalote(Date dthraberturalote) {
		this.dthraberturalote = dthraberturalote;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFECHAMENTOLOTE", length = 7)
	public Date getDthrfechamentolote() {
		return this.dthrfechamentolote;
	}

	public void setDthrfechamentolote(Date dthrfechamentolote) {
		this.dthrfechamentolote = dthrfechamentolote;
	}

	@Column(name = "QTCARTOESLOTE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtcartoeslote() {
		return this.qtcartoeslote;
	}

	public void setQtcartoeslote(BigDecimal qtcartoeslote) {
		this.qtcartoeslote = qtcartoeslote;
	}

	@Column(name = "QTCARTOESFECHADOS", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtcartoesfechados() {
		return this.qtcartoesfechados;
	}

	public void setQtcartoesfechados(BigDecimal qtcartoesfechados) {
		this.qtcartoesfechados = qtcartoesfechados;
	}

	@Column(name = "SITLOTE", nullable = false, length = 1)
	public char getSitlote() {
		return this.sitlote;
	}

	public void setSitlote(char sitlote) {
		this.sitlote = sitlote;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRSITLOTE", nullable = false, length = 7)
	public Date getDthrsitlote() {
		return this.dthrsitlote;
	}

	public void setDthrsitlote(Date dthrsitlote) {
		this.dthrsitlote = dthrsitlote;
	}

	@Column(name = "CDESTRUTURA", length = 4)
	public String getCdestrutura() {
		return this.cdestrutura;
	}

	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}

	@Column(name = "TAMLOTEKANBAN", precision = 22, scale = 0)
	public BigDecimal getTamlotekanban() {
		return this.tamlotekanban;
	}

	public void setTamlotekanban(BigDecimal tamlotekanban) {
		this.tamlotekanban = tamlotekanban;
	}

	@Column(name = "PERCLOTEKANBAN", precision = 126, scale = 0)
	public Double getPerclotekanban() {
		return this.perclotekanban;
	}

	public void setPerclotekanban(Double perclotekanban) {
		this.perclotekanban = perclotekanban;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijkanbanlote")
	public Set<Ijkanbancartoes> getIjkanbancartoeses() {
		return this.ijkanbancartoeses;
	}

	public void setIjkanbancartoeses(Set<Ijkanbancartoes> ijkanbancartoeses) {
		this.ijkanbancartoeses = ijkanbancartoeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijkanbanlote")
	public Set<Ijkanbanidcartao> getIjkanbanidcartaos() {
		return this.ijkanbanidcartaos;
	}

	public void setIjkanbanidcartaos(Set<Ijkanbanidcartao> ijkanbanidcartaos) {
		this.ijkanbanidcartaos = ijkanbanidcartaos;
	}

}