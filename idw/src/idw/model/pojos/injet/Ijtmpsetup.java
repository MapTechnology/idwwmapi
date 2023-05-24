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
 * Ijtmpsetup generated by hbm2java
 */
@Entity
@Table(name = "IJTMPSETUP")
public class Ijtmpsetup implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3039075761988107628L;
	private String cdinjetora;
	private Ijop ijopByNropsaida;
	private Ijtbinj ijtbinj;
	private Ijestmol ijestmolBySysC0012982;
	private Ijop ijopByNropentrada;
	private Ijestmol ijestmolBySysC0012983;
	private Double tmpultimosetup;

	public Ijtmpsetup() {
	}

	public Ijtmpsetup(String cdinjetora, Ijtbinj ijtbinj) {
		this.cdinjetora = cdinjetora;
		this.ijtbinj = ijtbinj;
	}

	public Ijtmpsetup(String cdinjetora, Ijop ijopByNropsaida, Ijtbinj ijtbinj,
			Ijestmol ijestmolBySysC0012982, Ijop ijopByNropentrada,
			Ijestmol ijestmolBySysC0012983, Double tmpultimosetup) {
		this.cdinjetora = cdinjetora;
		this.ijopByNropsaida = ijopByNropsaida;
		this.ijtbinj = ijtbinj;
		this.ijestmolBySysC0012982 = ijestmolBySysC0012982;
		this.ijopByNropentrada = ijopByNropentrada;
		this.ijestmolBySysC0012983 = ijestmolBySysC0012983;
		this.tmpultimosetup = tmpultimosetup;
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
	public Ijop getIjopByNropsaida() {
		return this.ijopByNropsaida;
	}

	public void setIjopByNropsaida(Ijop ijopByNropsaida) {
		this.ijopByNropsaida = ijopByNropsaida;
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
			@JoinColumn(name = "CDMOLDEENTRADA", referencedColumnName = "CDMOLDE"),
			@JoinColumn(name = "CDESTRUTURAENTRADA", referencedColumnName = "CDESTRUTURA") })
	public Ijestmol getIjestmolBySysC0012982() {
		return this.ijestmolBySysC0012982;
	}

	public void setIjestmolBySysC0012982(Ijestmol ijestmolBySysC0012982) {
		this.ijestmolBySysC0012982 = ijestmolBySysC0012982;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROPENTRADA")
	public Ijop getIjopByNropentrada() {
		return this.ijopByNropentrada;
	}

	public void setIjopByNropentrada(Ijop ijopByNropentrada) {
		this.ijopByNropentrada = ijopByNropentrada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDMOLDESAIDA", referencedColumnName = "CDMOLDE"),
			@JoinColumn(name = "CDESTRUTURASAIDA", referencedColumnName = "CDESTRUTURA") })
	public Ijestmol getIjestmolBySysC0012983() {
		return this.ijestmolBySysC0012983;
	}

	public void setIjestmolBySysC0012983(Ijestmol ijestmolBySysC0012983) {
		this.ijestmolBySysC0012983 = ijestmolBySysC0012983;
	}

	@Column(name = "TMPULTIMOSETUP", precision = 126, scale = 0)
	public Double getTmpultimosetup() {
		return this.tmpultimosetup;
	}

	public void setTmpultimosetup(Double tmpultimosetup) {
		this.tmpultimosetup = tmpultimosetup;
	}

}
