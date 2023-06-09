package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijtbesttab generated by hbm2java
 */
@Entity
@Table(name = "IJTBESTTAB")
public class Ijtbesttab implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 26445018241567741L;
	private IjtbesttabId id;
	private Ijtbtpdado ijtbtpdado;
	private Ijtbtab ijtbtab;
	private Ijlinguas ijlinguas;
	private String nmcoluna;
	private String dscoluna;
	private BigDecimal pkey;
	private BigDecimal tamanho;
	private BigDecimal fkey;
	private String cdtabelafkey;

	public Ijtbesttab() {
	}

	public Ijtbesttab(IjtbesttabId id, Ijtbtpdado ijtbtpdado, Ijtbtab ijtbtab,
			Ijlinguas ijlinguas, String nmcoluna, String dscoluna,
			BigDecimal pkey, BigDecimal fkey) {
		this.id = id;
		this.ijtbtpdado = ijtbtpdado;
		this.ijtbtab = ijtbtab;
		this.ijlinguas = ijlinguas;
		this.nmcoluna = nmcoluna;
		this.dscoluna = dscoluna;
		this.pkey = pkey;
		this.fkey = fkey;
	}

	public Ijtbesttab(IjtbesttabId id, Ijtbtpdado ijtbtpdado, Ijtbtab ijtbtab,
			Ijlinguas ijlinguas, String nmcoluna, String dscoluna,
			BigDecimal pkey, BigDecimal tamanho, BigDecimal fkey,
			String cdtabelafkey) {
		this.id = id;
		this.ijtbtpdado = ijtbtpdado;
		this.ijtbtab = ijtbtab;
		this.ijlinguas = ijlinguas;
		this.nmcoluna = nmcoluna;
		this.dscoluna = dscoluna;
		this.pkey = pkey;
		this.tamanho = tamanho;
		this.fkey = fkey;
		this.cdtabelafkey = cdtabelafkey;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdtabela", column = @Column(name = "CDTABELA", nullable = false, length = 6)),
			@AttributeOverride(name = "cdlingua", column = @Column(name = "CDLINGUA", nullable = false, length = 6)),
			@AttributeOverride(name = "ordemcoluna", column = @Column(name = "ORDEMCOLUNA", nullable = false, precision = 22, scale = 0)) })
	public IjtbesttabId getId() {
		return this.id;
	}

	public void setId(IjtbesttabId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDTPDADO", nullable = false)
	public Ijtbtpdado getIjtbtpdado() {
		return this.ijtbtpdado;
	}

	public void setIjtbtpdado(Ijtbtpdado ijtbtpdado) {
		this.ijtbtpdado = ijtbtpdado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDTABELA", nullable = false, insertable = false, updatable = false)
	public Ijtbtab getIjtbtab() {
		return this.ijtbtab;
	}

	public void setIjtbtab(Ijtbtab ijtbtab) {
		this.ijtbtab = ijtbtab;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDLINGUA", nullable = false, insertable = false, updatable = false)
	public Ijlinguas getIjlinguas() {
		return this.ijlinguas;
	}

	public void setIjlinguas(Ijlinguas ijlinguas) {
		this.ijlinguas = ijlinguas;
	}

	@Column(name = "NMCOLUNA", nullable = false, length = 30)
	public String getNmcoluna() {
		return this.nmcoluna;
	}

	public void setNmcoluna(String nmcoluna) {
		this.nmcoluna = nmcoluna;
	}

	@Column(name = "DSCOLUNA", nullable = false, length = 40)
	public String getDscoluna() {
		return this.dscoluna;
	}

	public void setDscoluna(String dscoluna) {
		this.dscoluna = dscoluna;
	}

	@Column(name = "PKEY", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPkey() {
		return this.pkey;
	}

	public void setPkey(BigDecimal pkey) {
		this.pkey = pkey;
	}

	@Column(name = "TAMANHO", precision = 22, scale = 0)
	public BigDecimal getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(BigDecimal tamanho) {
		this.tamanho = tamanho;
	}

	@Column(name = "FKEY", nullable = false, precision = 22, scale = 0)
	public BigDecimal getFkey() {
		return this.fkey;
	}

	public void setFkey(BigDecimal fkey) {
		this.fkey = fkey;
	}

	@Column(name = "CDTABELAFKEY", length = 6)
	public String getCdtabelafkey() {
		return this.cdtabelafkey;
	}

	public void setCdtabelafkey(String cdtabelafkey) {
		this.cdtabelafkey = cdtabelafkey;
	}

}
