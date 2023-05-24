package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijctrliniproctemp generated by hbm2java
 */
@Entity
@Table(name = "IJCTRLINIPROCTEMP")
public class Ijctrliniproctemp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 476387603145246288L;
	private String cdinjetora;
	private Ijop ijop;
	private Ijtbinj ijtbinj;
	private Ijestmol ijestmol;

	public Ijctrliniproctemp() {
	}

	public Ijctrliniproctemp(String cdinjetora, Ijtbinj ijtbinj) {
		this.cdinjetora = cdinjetora;
		this.ijtbinj = ijtbinj;
	}

	public Ijctrliniproctemp(String cdinjetora, Ijop ijop, Ijtbinj ijtbinj,
			Ijestmol ijestmol) {
		this.cdinjetora = cdinjetora;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.ijestmol = ijestmol;
	}

	@Id
	@Column(name = "CDINJETORA", unique = true, nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROPSAIDA")
	public Ijop getIjop() {
		return this.ijop;
	}

	public void setIjop(Ijop ijop) {
		this.ijop = ijop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", unique = true, nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDMOLDESAIDA", referencedColumnName = "CDMOLDE"),
			@JoinColumn(name = "CDESTRUTURASAIDA", referencedColumnName = "CDESTRUTURA") })
	public Ijestmol getIjestmol() {
		return this.ijestmol;
	}

	public void setIjestmol(Ijestmol ijestmol) {
		this.ijestmol = ijestmol;
	}

}