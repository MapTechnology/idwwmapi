package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjoprotoperId generated by hbm2java
 */
@Embeddable
public class IjoprotoperId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2041313268119880174L;
	private String nrop;
	private BigDecimal sequencia;

	public IjoprotoperId() {
	}

	public IjoprotoperId(String nrop, BigDecimal sequencia) {
		this.nrop = nrop;
		this.sequencia = sequencia;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "SEQUENCIA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getSequencia() {
		return this.sequencia;
	}

	public void setSequencia(BigDecimal sequencia) {
		this.sequencia = sequencia;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjoprotoperId))
			return false;
		IjoprotoperId castOther = (IjoprotoperId) other;

		return ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
				&& castOther.getNrop() != null && this.getNrop().equals(
				castOther.getNrop())))
				&& ((this.getSequencia() == castOther.getSequencia()) || (this
						.getSequencia() != null
						&& castOther.getSequencia() != null && this
						.getSequencia().equals(castOther.getSequencia())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37 * result
				+ (getSequencia() == null ? 0 : this.getSequencia().hashCode());
		return result;
	}

}
