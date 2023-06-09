package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijcelxmaq generated by hbm2java
 */
@Entity
@Table(name = "IJCELXMAQ")
public class Ijcelxmaq implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6781873139823312312L;
	private IjcelxmaqId id;
	private Ijtbinj ijtbinjByCdinjetora;
	private Ijtbinj ijtbinjByCdmaqdestino;
	private Ijcelxestagios ijcelxestagios;

	public Ijcelxmaq() {
	}

	public Ijcelxmaq(IjcelxmaqId id, Ijtbinj ijtbinjByCdinjetora,
			Ijtbinj ijtbinjByCdmaqdestino, Ijcelxestagios ijcelxestagios) {
		this.id = id;
		this.ijtbinjByCdinjetora = ijtbinjByCdinjetora;
		this.ijtbinjByCdmaqdestino = ijtbinjByCdmaqdestino;
		this.ijcelxestagios = ijcelxestagios;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdcelula", column = @Column(name = "CDCELULA", nullable = false, length = 6)),
			@AttributeOverride(name = "estagio", column = @Column(name = "ESTAGIO", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdmaqdestino", column = @Column(name = "CDMAQDESTINO", nullable = false, length = 6)) })
	public IjcelxmaqId getId() {
		return this.id;
	}

	public void setId(IjcelxmaqId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinjByCdinjetora() {
		return this.ijtbinjByCdinjetora;
	}

	public void setIjtbinjByCdinjetora(Ijtbinj ijtbinjByCdinjetora) {
		this.ijtbinjByCdinjetora = ijtbinjByCdinjetora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDMAQDESTINO", nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinjByCdmaqdestino() {
		return this.ijtbinjByCdmaqdestino;
	}

	public void setIjtbinjByCdmaqdestino(Ijtbinj ijtbinjByCdmaqdestino) {
		this.ijtbinjByCdmaqdestino = ijtbinjByCdmaqdestino;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDCELULA", referencedColumnName = "CDCELULA", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ESTAGIO", referencedColumnName = "ESTAGIO", nullable = false, insertable = false, updatable = false) })
	public Ijcelxestagios getIjcelxestagios() {
		return this.ijcelxestagios;
	}

	public void setIjcelxestagios(Ijcelxestagios ijcelxestagios) {
		this.ijcelxestagios = ijcelxestagios;
	}

}
