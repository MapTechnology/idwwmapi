package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijlogope generated by hbm2java
 */
@Entity
@Table(name = "IJLOGOPE")
public class Ijlogope implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2185849591892791630L;
	private IjlogopeId id;
	private Ijestmol ijestmol;
	private Ijtbusu ijtbusu;
	private Date dthrlogout;
	private BigDecimal quedaescravo;
	private Date dthrivalestru;
	private String nrop;
	private Character operadorauxiliar;

	public Ijlogope() {
	}

	public Ijlogope(IjlogopeId id, Ijtbusu ijtbusu) {
		this.id = id;
		this.ijtbusu = ijtbusu;
	}

	public Ijlogope(IjlogopeId id, Ijestmol ijestmol, Ijtbusu ijtbusu,
			Date dthrlogout, BigDecimal quedaescravo, Date dthrivalestru,
			String nrop, Character operadorauxiliar) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijtbusu = ijtbusu;
		this.dthrlogout = dthrlogout;
		this.quedaescravo = quedaescravo;
		this.dthrivalestru = dthrivalestru;
		this.nrop = nrop;
		this.operadorauxiliar = operadorauxiliar;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dthrlogin", column = @Column(name = "DTHRLOGIN", nullable = false, length = 7)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdusuario", column = @Column(name = "CDUSUARIO", nullable = false, length = 6)) })
	public IjlogopeId getId() {
		return this.id;
	}

	public void setId(IjlogopeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE"),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA") })
	public Ijestmol getIjestmol() {
		return this.ijestmol;
	}

	public void setIjestmol(Ijestmol ijestmol) {
		this.ijestmol = ijestmol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUARIO", nullable = false, insertable = false, updatable = false)
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRLOGOUT", length = 7)
	public Date getDthrlogout() {
		return this.dthrlogout;
	}

	public void setDthrlogout(Date dthrlogout) {
		this.dthrlogout = dthrlogout;
	}

	@Column(name = "QUEDAESCRAVO", precision = 22, scale = 0)
	public BigDecimal getQuedaescravo() {
		return this.quedaescravo;
	}

	public void setQuedaescravo(BigDecimal quedaescravo) {
		this.quedaescravo = quedaescravo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRIVALESTRU", length = 7)
	public Date getDthrivalestru() {
		return this.dthrivalestru;
	}

	public void setDthrivalestru(Date dthrivalestru) {
		this.dthrivalestru = dthrivalestru;
	}

	@Column(name = "NROP", length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "OPERADORAUXILIAR", length = 1)
	public Character getOperadorauxiliar() {
		return this.operadorauxiliar;
	}

	public void setOperadorauxiliar(Character operadorauxiliar) {
		this.operadorauxiliar = operadorauxiliar;
	}

}
