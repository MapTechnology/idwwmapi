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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijtbmodisp generated by hbm2java
 */
@Entity
@Table(name = "IJTBMODISP")
public class Ijtbmodisp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6771161085189601505L;
	private IjtbmodispId id;
	private Ijtbtur ijtbtur;
	private Ijtbusu ijtbusu;
	private BigDecimal qtdmo;
	private String motivoalteracao;
	private Date dthroperacao;

	public Ijtbmodisp() {
	}

	public Ijtbmodisp(IjtbmodispId id, Ijtbtur ijtbtur, Ijtbusu ijtbusu,
			BigDecimal qtdmo, Date dthroperacao) {
		this.id = id;
		this.ijtbtur = ijtbtur;
		this.ijtbusu = ijtbusu;
		this.qtdmo = qtdmo;
		this.dthroperacao = dthroperacao;
	}

	public Ijtbmodisp(IjtbmodispId id, Ijtbtur ijtbtur, Ijtbusu ijtbusu,
			BigDecimal qtdmo, String motivoalteracao, Date dthroperacao) {
		this.id = id;
		this.ijtbtur = ijtbtur;
		this.ijtbusu = ijtbusu;
		this.qtdmo = qtdmo;
		this.motivoalteracao = motivoalteracao;
		this.dthroperacao = dthroperacao;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dtturno", column = @Column(name = "DTTURNO", nullable = false, length = 7)),
			@AttributeOverride(name = "cdturno", column = @Column(name = "CDTURNO", nullable = false, length = 6)) })
	public IjtbmodispId getId() {
		return this.id;
	}

	public void setId(IjtbmodispId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDTURNO", nullable = false, insertable = false, updatable = false)
	public Ijtbtur getIjtbtur() {
		return this.ijtbtur;
	}

	public void setIjtbtur(Ijtbtur ijtbtur) {
		this.ijtbtur = ijtbtur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUARIO", nullable = false)
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@Column(name = "QTDMO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtdmo() {
		return this.qtdmo;
	}

	public void setQtdmo(BigDecimal qtdmo) {
		this.qtdmo = qtdmo;
	}

	@Column(name = "MOTIVOALTERACAO", length = 250)
	public String getMotivoalteracao() {
		return this.motivoalteracao;
	}

	public void setMotivoalteracao(String motivoalteracao) {
		this.motivoalteracao = motivoalteracao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHROPERACAO", nullable = false, length = 7)
	public Date getDthroperacao() {
		return this.dthroperacao;
	}

	public void setDthroperacao(Date dthroperacao) {
		this.dthroperacao = dthroperacao;
	}

}