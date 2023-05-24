package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjcfgmodulomanutId generated by hbm2java
 */
@Embeddable
public class IjcfgmodulomanutId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5860389998119430290L;
	private double metamanutcorr;
	private BigDecimal bloqreccomalerta;

	public IjcfgmodulomanutId() {
	}

	public IjcfgmodulomanutId(double metamanutcorr, BigDecimal bloqreccomalerta) {
		this.metamanutcorr = metamanutcorr;
		this.bloqreccomalerta = bloqreccomalerta;
	}

	@Column(name = "METAMANUTCORR", nullable = false, precision = 126, scale = 0)
	public double getMetamanutcorr() {
		return this.metamanutcorr;
	}

	public void setMetamanutcorr(double metamanutcorr) {
		this.metamanutcorr = metamanutcorr;
	}

	@Column(name = "BLOQRECCOMALERTA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getBloqreccomalerta() {
		return this.bloqreccomalerta;
	}

	public void setBloqreccomalerta(BigDecimal bloqreccomalerta) {
		this.bloqreccomalerta = bloqreccomalerta;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjcfgmodulomanutId))
			return false;
		IjcfgmodulomanutId castOther = (IjcfgmodulomanutId) other;

		return (this.getMetamanutcorr() == castOther.getMetamanutcorr())
				&& ((this.getBloqreccomalerta() == castOther
						.getBloqreccomalerta()) || (this.getBloqreccomalerta() != null
						&& castOther.getBloqreccomalerta() != null && this
						.getBloqreccomalerta().equals(
								castOther.getBloqreccomalerta())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getMetamanutcorr();
		result = 37
				* result
				+ (getBloqreccomalerta() == null ? 0 : this
						.getBloqreccomalerta().hashCode());
		return result;
	}

}