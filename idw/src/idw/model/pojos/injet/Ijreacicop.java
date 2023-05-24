package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijreacicop generated by hbm2java
 */
@Entity
@Table(name = "IJREACICOP")
public class Ijreacicop implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9118509346495344683L;
	private IjreacicopId id;
	private Ijestmol ijestmol;
	private Ijop ijop;
	private Ijtbinj ijtbinj;
	private Date dthrfciclo;
	private double tmpciclolido;
	private double tmpcicpadrao;
	private Date dthrivalestru;
	private Date dthrivalcic;
	private String nrOrdProd;
	private Double tmpcicespera;
	private Double tmpcicpadraoespera;
	private Set<Ijreacicopoprd> ijreacicopoprds = new HashSet<Ijreacicopoprd>(0);

	public Ijreacicop() {
	}

	public Ijreacicop(IjreacicopId id, Ijestmol ijestmol, Ijop ijop,
			Ijtbinj ijtbinj, Date dthrfciclo, double tmpciclolido,
			double tmpcicpadrao, Date dthrivalestru, Date dthrivalcic) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.dthrfciclo = dthrfciclo;
		this.tmpciclolido = tmpciclolido;
		this.tmpcicpadrao = tmpcicpadrao;
		this.dthrivalestru = dthrivalestru;
		this.dthrivalcic = dthrivalcic;
	}

	public Ijreacicop(IjreacicopId id, Ijestmol ijestmol, Ijop ijop,
			Ijtbinj ijtbinj, Date dthrfciclo, double tmpciclolido,
			double tmpcicpadrao, Date dthrivalestru, Date dthrivalcic,
			String nrOrdProd, Double tmpcicespera, Double tmpcicpadraoespera,
			Set<Ijreacicopoprd> ijreacicopoprds) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.dthrfciclo = dthrfciclo;
		this.tmpciclolido = tmpciclolido;
		this.tmpcicpadrao = tmpcicpadrao;
		this.dthrivalestru = dthrivalestru;
		this.dthrivalcic = dthrivalcic;
		this.nrOrdProd = nrOrdProd;
		this.tmpcicespera = tmpcicespera;
		this.tmpcicpadraoespera = tmpcicpadraoespera;
		this.ijreacicopoprds = ijreacicopoprds;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "dthriciclo", column = @Column(name = "DTHRICICLO", nullable = false, length = 7)) })
	public IjreacicopId getId() {
		return this.id;
	}

	public void setId(IjreacicopId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE", nullable = false),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA", nullable = false) })
	public Ijestmol getIjestmol() {
		return this.ijestmol;
	}

	public void setIjestmol(Ijestmol ijestmol) {
		this.ijestmol = ijestmol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROP", nullable = false, insertable = false, updatable = false)
	public Ijop getIjop() {
		return this.ijop;
	}

	public void setIjop(Ijop ijop) {
		this.ijop = ijop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", nullable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFCICLO", nullable = false, length = 7)
	public Date getDthrfciclo() {
		return this.dthrfciclo;
	}

	public void setDthrfciclo(Date dthrfciclo) {
		this.dthrfciclo = dthrfciclo;
	}

	@Column(name = "TMPCICLOLIDO", nullable = false, precision = 126, scale = 0)
	public double getTmpciclolido() {
		return this.tmpciclolido;
	}

	public void setTmpciclolido(double tmpciclolido) {
		this.tmpciclolido = tmpciclolido;
	}

	@Column(name = "TMPCICPADRAO", nullable = false, precision = 126, scale = 0)
	public double getTmpcicpadrao() {
		return this.tmpcicpadrao;
	}

	public void setTmpcicpadrao(double tmpcicpadrao) {
		this.tmpcicpadrao = tmpcicpadrao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRIVALESTRU", nullable = false, length = 7)
	public Date getDthrivalestru() {
		return this.dthrivalestru;
	}

	public void setDthrivalestru(Date dthrivalestru) {
		this.dthrivalestru = dthrivalestru;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRIVALCIC", nullable = false, length = 7)
	public Date getDthrivalcic() {
		return this.dthrivalcic;
	}

	public void setDthrivalcic(Date dthrivalcic) {
		this.dthrivalcic = dthrivalcic;
	}

	@Column(name = "NR_ORD_PROD", length = 10)
	public String getNrOrdProd() {
		return this.nrOrdProd;
	}

	public void setNrOrdProd(String nrOrdProd) {
		this.nrOrdProd = nrOrdProd;
	}

	@Column(name = "TMPCICESPERA", precision = 126, scale = 0)
	public Double getTmpcicespera() {
		return this.tmpcicespera;
	}

	public void setTmpcicespera(Double tmpcicespera) {
		this.tmpcicespera = tmpcicespera;
	}

	@Column(name = "TMPCICPADRAOESPERA", precision = 126, scale = 0)
	public Double getTmpcicpadraoespera() {
		return this.tmpcicpadraoespera;
	}

	public void setTmpcicpadraoespera(Double tmpcicpadraoespera) {
		this.tmpcicpadraoespera = tmpcicpadraoespera;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijreacicop")
	public Set<Ijreacicopoprd> getIjreacicopoprds() {
		return this.ijreacicopoprds;
	}

	public void setIjreacicopoprds(Set<Ijreacicopoprd> ijreacicopoprds) {
		this.ijreacicopoprds = ijreacicopoprds;
	}

}