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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijdetgrafico generated by hbm2java
 */
@Entity
@Table(name = "IJDETGRAFICO")
public class Ijdetgrafico implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 650540061327164866L;
	private IjdetgraficoId id;
	private Ijgrafico ijgrafico;
	private BigDecimal intinicial;
	private BigDecimal intfinal;
	private String cdcor;
	private String descricaolegenda;
	private String operadorinicial;
	private String operadorfinal;

	public Ijdetgrafico() {
	}

	public Ijdetgrafico(IjdetgraficoId id, Ijgrafico ijgrafico,
			BigDecimal intinicial) {
		this.id = id;
		this.ijgrafico = ijgrafico;
		this.intinicial = intinicial;
	}

	public Ijdetgrafico(IjdetgraficoId id, Ijgrafico ijgrafico,
			BigDecimal intinicial, BigDecimal intfinal, String cdcor,
			String descricaolegenda, String operadorinicial,
			String operadorfinal) {
		this.id = id;
		this.ijgrafico = ijgrafico;
		this.intinicial = intinicial;
		this.intfinal = intfinal;
		this.cdcor = cdcor;
		this.descricaolegenda = descricaolegenda;
		this.operadorinicial = operadorinicial;
		this.operadorfinal = operadorfinal;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "grafico", column = @Column(name = "GRAFICO", nullable = false, length = 50)),
			@AttributeOverride(name = "cdlingua", column = @Column(name = "CDLINGUA", nullable = false, length = 6)),
			@AttributeOverride(name = "serie", column = @Column(name = "SERIE", nullable = false, precision = 22, scale = 0)) })
	public IjdetgraficoId getId() {
		return this.id;
	}

	public void setId(IjdetgraficoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "GRAFICO", referencedColumnName = "GRAFICO", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDLINGUA", referencedColumnName = "CDLINGUA", nullable = false, insertable = false, updatable = false) })
	public Ijgrafico getIjgrafico() {
		return this.ijgrafico;
	}

	public void setIjgrafico(Ijgrafico ijgrafico) {
		this.ijgrafico = ijgrafico;
	}

	@Column(name = "INTINICIAL", nullable = false, precision = 5)
	public BigDecimal getIntinicial() {
		return this.intinicial;
	}

	public void setIntinicial(BigDecimal intinicial) {
		this.intinicial = intinicial;
	}

	@Column(name = "INTFINAL", precision = 5)
	public BigDecimal getIntfinal() {
		return this.intfinal;
	}

	public void setIntfinal(BigDecimal intfinal) {
		this.intfinal = intfinal;
	}

	@Column(name = "CDCOR", length = 15)
	public String getCdcor() {
		return this.cdcor;
	}

	public void setCdcor(String cdcor) {
		this.cdcor = cdcor;
	}

	@Column(name = "DESCRICAOLEGENDA", length = 25)
	public String getDescricaolegenda() {
		return this.descricaolegenda;
	}

	public void setDescricaolegenda(String descricaolegenda) {
		this.descricaolegenda = descricaolegenda;
	}

	@Column(name = "OPERADORINICIAL", length = 2)
	public String getOperadorinicial() {
		return this.operadorinicial;
	}

	public void setOperadorinicial(String operadorinicial) {
		this.operadorinicial = operadorinicial;
	}

	@Column(name = "OPERADORFINAL", length = 2)
	public String getOperadorfinal() {
		return this.operadorfinal;
	}

	public void setOperadorfinal(String operadorfinal) {
		this.operadorfinal = operadorfinal;
	}

}
