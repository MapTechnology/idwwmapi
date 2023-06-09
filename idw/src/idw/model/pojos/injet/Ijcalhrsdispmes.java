package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijcalhrsdispmes generated by hbm2java
 */
@Entity
@Table(name = "IJCALHRSDISPMES")
public class Ijcalhrsdispmes implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5901253319061575264L;
	private IjcalhrsdispmesId id;
	private BigDecimal qtddiasuteiscal;
	private BigDecimal qtdsabadostrab;

	public Ijcalhrsdispmes() {
	}

	public Ijcalhrsdispmes(IjcalhrsdispmesId id, BigDecimal qtddiasuteiscal,
			BigDecimal qtdsabadostrab) {
		this.id = id;
		this.qtddiasuteiscal = qtddiasuteiscal;
		this.qtdsabadostrab = qtdsabadostrab;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "anocal", column = @Column(name = "ANOCAL", nullable = false, length = 4)),
			@AttributeOverride(name = "mescal", column = @Column(name = "MESCAL", nullable = false, length = 2)) })
	public IjcalhrsdispmesId getId() {
		return this.id;
	}

	public void setId(IjcalhrsdispmesId id) {
		this.id = id;
	}

	@Column(name = "QTDDIASUTEISCAL", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtddiasuteiscal() {
		return this.qtddiasuteiscal;
	}

	public void setQtddiasuteiscal(BigDecimal qtddiasuteiscal) {
		this.qtddiasuteiscal = qtddiasuteiscal;
	}

	@Column(name = "QTDSABADOSTRAB", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtdsabadostrab() {
		return this.qtdsabadostrab;
	}

	public void setQtdsabadostrab(BigDecimal qtdsabadostrab) {
		this.qtdsabadostrab = qtdsabadostrab;
	}

}
